package no.uib.info216.RDF;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by fox on 4/30/16.
 */
public class RDFHandler {
    private Model model = ModelFactory.createDefaultModel();


    public void addModel(Model model){
        this.model.add(model);
    }

    public ResultSet runSparql(String queryString){

        queryString = "PREFIX schema: <http://schema.org/> " + queryString;
        queryString = "PREFIX foaf: <http://xmlns.com/foaf/0.1/> " + queryString;
        queryString = "PREFIX uib: <http://uib.no/info216/> " + queryString;
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


    public static void saveModel(String name, Model model){
        FileWriter out = null;
        try {
            out = new FileWriter(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.write(out, "TURTLE");
    }
}
