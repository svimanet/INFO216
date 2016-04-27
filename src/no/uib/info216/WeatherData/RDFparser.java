package no.uib.info216.WeatherData;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.vocabulary.DCTerms;
import no.uib.info216.WeatherData.JenaTest;

import java.io.*;
import java.util.*;

/**
 * Created by svimanet on 01/03/16.
 */
public class RDFparser {

    JenaTest jt = new JenaTest();

    private ArrayList<String> dateFrom = jt.getFromtag();
    private ArrayList<String> nameTag = jt.getNametag();
    private ArrayList<String> windTag = jt.getWindSpeedName();

    Model model = ModelFactory.createDefaultModel();
    int arrayLength = nameTag.size();

    public void createOntology(){

        for(int i = 0; i < arrayLength; i++){

            String itemdateFrom = this.dateFrom.get(i);
            String itemnameTag = this.nameTag.get(i);
//            String itemwindTag = this.windTag.get(i);

            Resource weatherData
                    = model.createResource(itemdateFrom)
                    .addProperty(DCTerms.abstract_, itemnameTag);
//                    .addProperty(DCTerms.abstract_, itemwindTag);
        }


    }

    public void writerMethod(){
        OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM, model);

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
