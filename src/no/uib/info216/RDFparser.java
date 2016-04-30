package no.uib.info216;


import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;

import java.io.*;
import java.util.*;

import static org.apache.jena.rdf.model.ModelFactory.createOntologyModel;
import static org.apache.jena.shared.RandomOrderGraph.createDefaultModel;


/**
 * Created by svimanet on 01/03/16.
 */
public class RDFparser {

    JenaTest jt = new JenaTest();

    private ArrayList<String> dateFrom = jt.getFromtag();
    private ArrayList<String> nameTag = jt.getNametag();

    Model model = createDefaultModel();



    int arrayLength = nameTag.size();

    public void createOntology(){

        for(int i = 0; i < arrayLength; i++){

            String itemdateFrom = this.dateFrom.get(i);
            String itemnameTag = this.nameTag.get(i);

            Resource weatherData
                    = model.createResource(itemdateFrom)
                    .addProperty(DCTerms.abstract_, itemnameTag);
        }
    }

    public void writerMethod(){
        OntModel m = createOntologyModel(OntModelSpec.OWL_MEM, model);

        FileWriter out = null;
        try {
            out = new FileWriter( "rdfOut.ttl" );
            m.write( out, "Turtle" );
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {out.close();} catch (IOException ignore) {}
            }
        }
    }

    public RDFparser(){

        createOntology();
        writerMethod();

    }
}
