package no.uib.info216;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Created by svimanet on 05/03/16.
 */
public class Listener {


    public Listener(){

        GUI gui = new GUI();

        gui.getMonday().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println(" fuckin mondays, man ");
            }
        });

        gui.getTuesday().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println(" fuckin tuesdays, man ");
            }
        });

        gui.getWednesday().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println(" fuckin wednesday, man ");
            }
        });

        gui.getThursday().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println(" fuckin thursday, man ");
            }
        });

        gui.getFriday().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println(" fuckin fridays, man ");
            }
        });

        gui.getSaturday().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println(" fuckin saturtdasd, man ");
            }
        });

        gui.getSunday().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println(" fuckin SUNDAYs, man ");
            }
        });
    }
}
