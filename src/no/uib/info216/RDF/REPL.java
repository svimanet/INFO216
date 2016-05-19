package no.uib.info216.RDF;

import no.uib.info216.RDF.Queries.EventQueries;
import no.uib.info216.RDF.Queries.FacebookQueries;
import no.uib.info216.RDF.Queries.WeatherQuery;

import java.util.Scanner;

/**
 * Created by fox on 5/3/16.
 */
public class REPL {

    private final RDFHandler rdfHandler;
    private final EventQueries eventQ;
    private final FacebookQueries facebookQ;
    private final WeatherQuery weatherQ;

    public REPL(RDFHandler rdfHandler){
        this.rdfHandler = rdfHandler;
        this.eventQ = new EventQueries(rdfHandler);
        this.facebookQ = new FacebookQueries(rdfHandler);
        this.weatherQ = new WeatherQuery(rdfHandler);
    }

    public void REPL(){
        while(true){
            Scanner scan=new Scanner(System.in);
            System.out.print("> ");
            String line = scan.nextLine();
            if(line.equals("all")) {
                line =
                        "SELECT ?o ?p ?s " +
                                "WHERE {" +
                                "       ?o ?p ?s " +
                                "      }";
                this.rdfHandler.runSparql(line);
            }else if(line.equals("events")) {
                eventQ.getEventForDay();
            }else if(line.equals("friends")) {
                facebookQ.AllUsers();
            }else if(line.equals("weather")) {
                weatherQ.getAllWeather();
            }else{
                this.rdfHandler.runSparql(line);
            }
        }
    }
}
