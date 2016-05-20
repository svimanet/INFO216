package no.uib.info216;

import no.uib.info216.Events.EventParser;
import no.uib.info216.Interface.MainGUI;
import no.uib.info216.RDF.RDFHandler;
import no.uib.info216.WeatherData.WeatherModel;
import no.uib.info216.facebook.CreateModels;
import org.apache.jena.rdf.model.Model;

public class Main {

    public static void main(String[] args) {


        RDFHandler rdfHandler = new RDFHandler();

        EventParser events = new EventParser();
        Model eventModel = events.parse();
        rdfHandler.addModel(eventModel);

        CreateModels cm = new CreateModels();
        Model friendsModel = cm.parse();
        rdfHandler.addModel(friendsModel);

        WeatherModel weather = new WeatherModel();
        Model weatherModel = weather.parse();
        rdfHandler.addModel(weatherModel);


        //FacebookQueries fbQ = new FacebookQueries(rdfHandler);

        //fbQ.GetFriendInterestScore();

        MainGUI.createAndShowGUI(rdfHandler);

        //evt.getEventForDay();
        //REPL repl = new REPL(rdfHandler);
        //repl.REPL();


    }
}
