package no.uib.info216;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by fox on 2/22/16.
 */
public class Main {
    private static GUI newgui = new GUI();

    public static void main(String[] args) {

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                newgui.createAndShowGUI();
            }
        });

        GUI gui = new GUI();
    }
}
