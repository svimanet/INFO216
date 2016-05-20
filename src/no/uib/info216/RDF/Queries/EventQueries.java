package no.uib.info216.RDF.Queries;

import no.uib.info216.Models.Event;
import no.uib.info216.RDF.RDFHandler;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

import java.util.ArrayList;

/**
 * Created by fox on 5/3/16.
 */
public class EventQueries {
    private RDFHandler rdfHandler;

    public EventQueries(RDFHandler rdfHandler){
        this.rdfHandler = rdfHandler;
    }


    public ArrayList<Event> getEventsForDay(String date) {
        String query = "PREFIX schema: <http://schema.org/>" +
                "SELECT  * " +
                "WHERE {" +
                " ?uri a schema:Event ; " +
                " schema:startDate \""+date+"\"; " +
                " schema:name ?name; " +
                " schema:location ?location; " +
                " schema:description ?description; " +
                " schema:url ?url; " +
                " schema:doorTime ?doorTime; " +
                " schema:category ?category; " +
                " schema:startDate ?date. " +
                "      }" +
                "";

        ResultSet rs = rdfHandler.runSparql(query);
        ArrayList<Event> events = new ArrayList<Event>();
        while(rs.hasNext()){
            QuerySolution row = rs.next();
            Event event = new Event(row.get("name").toString(),
                                    row.get("location").toString(),
                                    row.get("description").toString(),
                                    row.get("category").toString(),
                                    row.get("url").toString(),
                                    row.get("doorTime").toString(),
                                    row.get("date").toString());
            events.add(event);

        }
        return events;
    }
}
