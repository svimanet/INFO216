package no.uib.info216;

import no.uib.info216.WeatherData.RDFparser;

import javax.swing.*;

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

        RDFparser weatherData = new RDFparser();

    }
}
