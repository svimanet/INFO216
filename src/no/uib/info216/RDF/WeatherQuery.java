package no.uib.info216.RDF;

import no.uib.info216.WeatherData.Weather;
import org.apache.jena.query.ResultSet;

/**
 * Created by svimanet on 03/05/16.
 */
public class WeatherQuery {

    private RDFHandler rdfh;

    public WeatherQuery(RDFHandler rdfh){
        this.rdfh = rdfh;
    }

    public ResultSet weatherWeek(){
        String query = "PREFIX schema: <http://schema.org/>" +
                "SELECT  * WHERE { ?o ?p ?s } ORDER BY ASC(?o)";
        return rdfh.runSparql(query);
    }

    public ResultSet rainyDays(){
        String query = "PREFIX schema: <http://schema.org/>" +
                "SELECT  * WHERE { ?o ?p \"Regn\" } ORDER BY ASC(?o)";
        return rdfh.runSparql(query);
    }
}
