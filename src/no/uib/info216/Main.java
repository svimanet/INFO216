package no.uib.info216;

import no.uib.info216.Events.EventParser;
import no.uib.info216.RDF.Queries.EventQueries;
import no.uib.info216.RDF.Queries.WeatherQuery;
import no.uib.info216.RDF.RDFHandler;
import no.uib.info216.WeatherData.WeatherModel;
import no.uib.info216.facebook.CreateModels;
import org.apache.jena.rdf.model.Model;

import javax.swing.*;

/**
 * Created by fox on 2/22/16.
 */
public class Main {

    public static void main(String[] args) {


        final RDFHandler rdfHandler = new RDFHandler();

        EventParser events = new EventParser();
        Model eventModel = events.parse();
        rdfHandler.addModel(eventModel);

        CreateModels cm = new CreateModels();
        Model friendsModel = cm.parse();
        rdfHandler.addModel(friendsModel);

        WeatherModel weather = new WeatherModel();
        Model weatherModel = weather.parse();
        rdfHandler.addModel(weatherModel);

        EventQueries evt = new EventQueries(rdfHandler);
        WeatherQuery wth = new WeatherQuery(rdfHandler);
        String date = "2016-05-19";

        wth.getWeatherForDay(date);
        evt.getEventsForDay(date);

        final GUI newgui = new GUI(rdfHandler);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                newgui.createAndShowGUI(rdfHandler);
            }
        });

        //evt.getEventForDay();
        //REPL repl = new REPL(rdfHandler);
        //repl.REPL();


    }
}
