package no.uib.info216.WeatherData;


import no.uib.info216.RDF.RDFHandler;
import no.uib.info216.RDF.Queries.WeatherQuery;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.apache.jena.rdf.model.ModelFactory.createOntologyModel;
import static org.apache.jena.shared.RandomOrderGraph.createDefaultModel;


/**
 * Created 01/03/16.
 * Class for making the RDF model and
 * printing it to a file.
 * Also initiates some sparql queries for testing.
 */
public class Weather {

    Yr yrno = new Yr();

    private ArrayList<String> dateFrom = yrno.getFromtag();
    private ArrayList<String> nameTag = yrno.getNametag();
    private ArrayList<String> nameTagEng = yrno.getNametagEng();
    private ArrayList<Integer> periodTag = yrno.getPeriodTag();
    private ArrayList<String> tempTag = yrno.getTemprature();
    private ArrayList<Integer> idTag = yrno.getIdList();

    Model model = createDefaultModel();

    int arrayLength = nameTag.size();

    /**
     * The createOntology method is what
     * speciefies all data used in the endresult of the .ttl file.
     * It takes arraylists from the yrno.java class and
     * applies the correct URI to the correct list and
     * parses it to one end-ttl-list.
     */
    public void createOntology(){

        String ontUri = "https://www.auto.tuwien.ac.at/downloads/thinkhome/ontology/WeatherOntology.owl#";

        //Property weatherProperty = model.createProperty("http://schema.org/name");
        Property weatherProperty = model.createProperty(ontUri + "WeatherCondition");
        Property weatherPropertyTemp = model.createProperty(ontUri + "Temperature");
        Property startDate = model.createProperty("http://schema.org/startDate");

        Resource weatherResource= model.createResource("http://schema.org/Weather");

        for(int i = 0; i < arrayLength; i++) {

            if (periodTag.contains(2)) {
                String itemdateFrom = this.dateFrom.get(i);
                String itemnameTag = this.nameTag.get(i);
                String itemnameTagEng = this.nameTagEng.get(i);
                String itemTempTag = this.tempTag.get(i);
                String itemTopKek = String.valueOf(this.idTag.get(i));

                Resource weatherData
                        = model.createResource("http://uib.no/info216/weather/"+itemdateFrom, weatherResource)
                        .addProperty(weatherProperty, itemnameTagEng)
                        .addProperty(weatherPropertyTemp, itemTempTag)
                        .addProperty(startDate, itemdateFrom);
            }
        }
    }

    /**
     * The writerMethod is a method for
     * writing the information made as
     * Turtle RDF format to the
     * weather.ttl file.
     */
    public void writerMethod(){
        OntModel m = createOntologyModel(OntModelSpec.OWL_MEM, model);

        FileWriter out = null;
        try {
            out = new FileWriter( "weather.ttl" );
            m.write( out, "Turtle" );
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {out.close();} catch (IOException ignore) {}
            }
        }
    }

    /**
     * The parse method sends the model used
     * to create the ontology.
     * The model is sendt on to be used to
     * querry through sparql.
     * @return model
     */
    public Model parse(){
        createOntology();
        return model;
    }


    /**
     * The main method is for testing
     * the two classes yrno.java and weather.java
     * without having to run through the whole
     * program and creating all ontologies over and over.
     * @param args
     */
    public static void main(String[] args) {
        Weather weather = new Weather();
        weather.createOntology();
        weather.writerMethod();

        RDFHandler rdfHandler = new RDFHandler();
        WeatherQuery weatherQuery = new WeatherQuery(rdfHandler);
        Model weatherModel = weather.parse();
        rdfHandler.addModel(weatherModel);

        //QUERIES
        weatherQuery.weatherWeek();

    }
}
