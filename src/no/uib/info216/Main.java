package no.uib.info216;

import no.uib.info216.Events.EventParser;
import no.uib.info216.Misc.WeekDates;
import no.uib.info216.RDF.Queries.EventQueries;
import no.uib.info216.RDF.Queries.FacebookQueries;
import no.uib.info216.RDF.RDFHandler;
import no.uib.info216.RDF.REPL;
import no.uib.info216.WeatherData.Weather;
import no.uib.info216.facebook.CreateModels;
import no.uib.info216.facebook.User;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;

/**
 * Created by fox on 2/22/16.
 */
public class Main {
    private static GUI newgui = new GUI();

    public static void main(String[] args) {

//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                UIManager.put("swing.boldMetal", Boolean.FALSE);
//                newgui.createAndShowGUI();
//            }
//        });


        RDFHandler rdfHandler = new RDFHandler();
        EventParser events = new EventParser();
        Model eventModel = events.parse();
        rdfHandler.addModel(eventModel);

        CreateModels cm = new CreateModels();
        Model friendsModel = cm.parse();
        rdfHandler.addModel(friendsModel);

        Weather weather = new Weather();
        Model weatherModel = weather.parse();
        rdfHandler.addModel(weatherModel);

        EventQueries evt = new EventQueries(rdfHandler);
        FacebookQueries fq = new FacebookQueries(rdfHandler);

        User user = new User(cm, fq);


        rdfHandler.saveModel("FacebookFiles/FacebookModel.ttl", friendsModel);
        //fq.UserKnowns();


        //evt.getEventForDay();
        new WeekDates().getWeekDates(0);
        REPL repl = new REPL(rdfHandler);
        repl.REPL();

    }
}
