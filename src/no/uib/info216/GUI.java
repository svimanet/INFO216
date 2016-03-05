package no.uib.info216;

import com.sun.deploy.panel.JavaPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by svimanet on 05/03/16.
 */
public class GUI extends JPanel{

    public GUI(){

        JFrame spine = new JFrame();
        spine.setSize(550, 750 );
        spine.setVisible(true);
        spine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        spine.setLayout(new FlowLayout());

        JPanel monday = new JPanel();
        JPanel tuesday = new JPanel();
        JPanel wednesday = new JPanel();
        JPanel thursday = new JPanel();
        JPanel friday = new JPanel();
        JPanel saturday = new JPanel();
        JPanel sunday = new JPanel();

        JLabel txtMonday = new JLabel("monday");
        JLabel txtTuesday= new JLabel("tuesday");
        JLabel txtWednesday = new JLabel("wednesday");
        JLabel txtThursday = new JLabel("thursday");
        JLabel txtFriday = new JLabel("friday");
        JLabel txtSaturday = new JLabel("saturday");
        JLabel txtSunday = new JLabel("sunday");

        txtMonday.setPreferredSize(new Dimension(500, 50));
        txtTuesday.setPreferredSize(new Dimension(500, 50));
        txtWednesday.setPreferredSize(new Dimension(500, 50));
        txtThursday.setPreferredSize(new Dimension(500, 50));
        txtFriday.setPreferredSize(new Dimension(500, 50));
        txtSaturday.setPreferredSize(new Dimension(500, 50));
        txtSunday.setPreferredSize(new Dimension(500, 50));
                
        monday.setSize(500, 100);
        tuesday.setSize(500, 100);
        wednesday.setSize(500, 100);
        thursday.setSize(500, 100);
        friday.setSize(500, 100);
        saturday.setSize(500, 100);
        sunday.setSize(500, 100);

        spine.add(monday);
        spine.add(tuesday);
        spine.add(wednesday);
        spine.add(thursday);
        spine.add(friday);
        spine.add(saturday);
        spine.add(sunday);

        monday.add(txtFriday);
        tuesday.add(txtTuesday);
        wednesday.add(txtWednesday);
        thursday.add(txtThursday);
        friday.add(txtFriday);
        saturday.add(txtSaturday);
        sunday.add(txtSunday);
    }


    public static void main (String[] args){

        GUI gui = new GUI();

    }
}
