package no.uib.info216.RDF;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by fox on 4/30/16.
 */
public class RDFHandler {
    private Model model = ModelFactory.createDefaultModel();


    public void addModel(Model model){
        this.model.add(model);
    }

    public ResultSet runSparql(String queryString){

        if(queryString.equals("all")) {
            queryString =
                    "SELECT ?o ?p ?s " +
                            "WHERE {" +
                            "       ?o ?p ?s " +
                            "      }";
        }
        queryString = "PREFIX schema: <http://schema.org/> " + queryString;
        System.out.println(queryString);

        Query query = null;
        try {
            query = QueryFactory.create(queryString);
        }catch (Exception e){
            System.out.println("Error!");
            System.out.println(e.toString());
            return null;
        }

        QueryExecution qe = QueryExecutionFactory.create(query, model);
        ResultSet results = qe.execSelect();

        ResultSetFormatter.out(System.out, results, query);

        qe.close();
        return results;
    }

    public void REPL(JTextField text){
        while(true){
            Scanner scan = new Scanner(text.getText());
            text.setText("> ");
            //System.out.print("> ");
            String line = scan.nextLine();
            this.runSparql(line);
        }
    }


    public void saveModel(String name, Model model){
        FileWriter out = null;
        try {
            out = new FileWriter(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.write(out, "TURTLE");
    }
}
