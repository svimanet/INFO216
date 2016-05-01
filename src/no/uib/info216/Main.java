package no.uib.info216;

import no.uib.info216.Events.EventParser;
import no.uib.info216.RDF.RDFHandler;
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

        //RDFparser weatherData = new RDFparser();

        RDFHandler rdfHandler = new RDFHandler();


        EventParser events = new EventParser();
        Model eventModel = events.parse();
        rdfHandler.addModel(eventModel);

    }
}
