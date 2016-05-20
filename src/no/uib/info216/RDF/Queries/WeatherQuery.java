package no.uib.info216.RDF.Queries;

import no.uib.info216.Models.Weather;
import no.uib.info216.RDF.RDFHandler;
import org.apache.jena.query.QuerySolution;
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
     * Returns a week worth of date, name and temperature in Bergen.
     * @return qury
     */
    public ResultSet getAllWeather() {
        String query =
                "SELECT  ?date ?name ?temp " +
                "WHERE {" +
                " ?res a Weather:WeatherCondition ; " +
                " schema:startDate ?date ; " +
                " Weather:WeatherCondition ?name ; " +
                " Weather:Temperature ?temp. " +
                "      }" +
                "";

        return rdfh.runSparql(query);
    }

    /**
     *
     * @return
     */
    public ResultSet getWeatherAndEvent() {
        String query = "PREFIX schema: <http://schema.org/>" +
                "SELECT  ?date ?name ?weather ?temp " +
                "WHERE {" +
                " ?x schema:Event ?name" +
                " ?x schema:Weather ?weather" +
                " ?x schema:Weather ?temp" +
                " ?x Schema:Event ?date" +
                "      }" +
                "";

        return rdfh.runSparql(query);
    }

    public Weather getWeatherForDay(String date) {

        String query = "SELECT  * " +
                "WHERE {" +
                " ?uri a weather:WeatherCondition; " +
                " schema:startDate \""+date+"\"; " +
                " weather:WeatherCondition ?name; " +
                " weather:Temperature ?temp; " +
                " schema:startDate ?date. " +
                "      }" +
                "";

        ResultSet rs =  rdfh.runSparql(query);
        QuerySolution response = rs.next();
        return new Weather(response.get("temp").toString(),
                response.get("date").toString(),
                response.get("name").toString());
    }

}
