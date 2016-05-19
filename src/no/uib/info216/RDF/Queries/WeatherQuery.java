package no.uib.info216.RDF.Queries;

import no.uib.info216.RDF.RDFHandler;
import org.apache.jena.query.ResultSet;

/**
 * Created 03/05/16.
 * Method for standard weather queries.
 * Activated in weather.java class.
 *
 * WONT WORK PROPERLY WITHOUT A PROPER ONTOLOGY
 * All queries return the same result atm.
 * They all return * .
 */
public class WeatherQuery {

    private RDFHandler rdfh;

    public WeatherQuery(RDFHandler rdfh){
        this.rdfh = rdfh;
    }

    /**
     * Sparql query that lets you
     * get all teh data in the speciefied table.
     *
     * @return query
     */
    public ResultSet weatherWeek(){
        String query = "PREFIX schema: <http://schema.org/>" +
                "SELECT  * WHERE { ?o ?p ?s } ORDER BY ASC(?o)";
        return rdfh.runSparql(query);
    }

    /**
     * Sparql query that lets you get all
     * the days where it is raining.
     * @return query
     */
    public ResultSet rainyDays(){
        String query = "PREFIX schema: <http://schema.org/>" +
                "SELECT  * WHERE { ?o ?p \"Regn \" } ORDER BY ASC(?o)";
        return rdfh.runSparql(query);
    }

    /**
     * Sparql query that lets you get all
     * the sunny days of the week
     * (Usually returns nothing).
     * @return query
     */
    public ResultSet sunnyDays(){
        String query = "PREFIX schema: <http://schema.org/>" +
                "SELECT  * WHERE { ?o ?p \"Sol\" } ORDER BY ASC(?o)";
        return rdfh.runSparql(query);
    }

    /**
     * Sparql query that lets you get all
     * the cloudy days of the week.
     * (might as well ask for * ).
     * @return
     */
    public ResultSet cloudyDays(){
        String query = "PREFIX schema: <http://schema.org/>" +
                "SELECT  * WHERE { ?o ?p \"Skyet\" } ORDER BY ASC(?o)";
        return rdfh.runSparql(query);
    }

    public ResultSet getAllWeather() {
        String query = "PREFIX schema: <http://schema.org/>" +
                "SELECT  ?name ?date " +
                "WHERE {" +
                " ?res a schema:Weather ; " +
                " schema:startDate ?date ; " +
                " schema:name ?name. " +
                "      }" +
                "";

        return rdfh.runSparql(query);
    }
}
