package no.uib.info216.RDF;

import org.apache.jena.query.ResultSet;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by fox on 5/3/16.
 */
public class EventQueries {
    private RDFHandler rdfHandler;

    public EventQueries(RDFHandler rdfHandler){
        this.rdfHandler = rdfHandler;
    }

    public ResultSet getEventForDay() {
        Calendar cal = Calendar.getInstance();
        String date = new SimpleDateFormat("YYYY-MM-D").format(cal.getTime());
        String query = "PREFIX schema: <http://schema.org/>" +
                "SELECT  * " +
                "WHERE {" +
                " ?uri a schema:Event ; " +
                " schema:startDate \"2016-05-14\"; " +
                " schema:name ?name; " +
                " schema:startDate ?date. " +
                "      }" +
                "";

        return rdfHandler.runSparql(query);
    }
}
