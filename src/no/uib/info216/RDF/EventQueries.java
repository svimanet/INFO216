package no.uib.info216.RDF;

import org.apache.jena.query.ResultSet;

/**
 * Created by fox on 5/3/16.
 */
public class EventQueries {
    private RDFHandler rdfHandler;

    public EventQueries(RDFHandler rdfHandler){
        this.rdfHandler = rdfHandler;
    }

    public ResultSet getEventForDay() {
        String query = "PREFIX schema: <http://schema.org/>" +
                "SELECT  * " +
                "WHERE {" +
                " ?res a schema:Event ; " +
                " schema:startDate ?date ; " +
                " schema:name ?name. " +
                "      }" +
                "";

        return rdfHandler.runSparql(query);
    }
}
