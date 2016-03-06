package no.uib.info216;

import com.sun.deploy.panel.JavaPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by svimanet on 05/03/16.
 */
public class GUI extends JPanel{

    private JPanel monday;
    private JPanel tuesday;
    private JPanel wednesday;
    private JPanel thursday;
    private JPanel friday;
    private JPanel saturday;
    private JPanel sunday;

    public GUI(){

        JFrame spine = new JFrame();
        spine.setSize(530, 500);
        spine.setVisible(true);
        spine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        spine.setLayout(new FlowLayout());

        monday = new JPanel();
        tuesday = new JPanel();
        wednesday = new JPanel();
        thursday = new JPanel();
        friday = new JPanel();
        saturday = new JPanel();
        sunday = new JPanel();

        JPanel monday1 = new JPanel();
        monday1.setSize(250, 50);
        monday1.setBackground(Color.gray);

        JLabel txtMonday = new JLabel("monday");
        JLabel txtTuesday= new JLabel("tuesday");
        JLabel txtWednesday = new JLabel("wednesday");
        JLabel txtThursday = new JLabel("thursday");
        JLabel txtFriday = new JLabel("friday");
        JLabel txtSaturday = new JLabel("saturday");
        JLabel txtSunday = new JLabel("sunday");

        monday.setBackground(Color.black);
        tuesday.setBackground(Color.LIGHT_GRAY);
        wednesday.setBackground(Color.blue);
        thursday.setBackground(Color.black.red);
        friday.setBackground(Color.cyan);
        saturday.setBackground(Color.gray);
        sunday.setBackground(Color.lightGray);

        txtMonday.setPreferredSize(new Dimension(500, 50));
        txtTuesday.setPreferredSize(new Dimension(500, 50));
        txtWednesday.setPreferredSize(new Dimension(500, 50));
        txtThursday.setPreferredSize(new Dimension(500, 50));
        txtFriday.setPreferredSize(new Dimension(500, 50));
        txtSaturday.setPreferredSize(new Dimension(500, 50));
        txtSunday.setPreferredSize(new Dimension(500, 50));

        monday.setSize(500, 50);
        tuesday.setSize(500, 50);
        wednesday.setSize(500, 50);
        thursday.setSize(500, 50);
        friday.setSize(500, 50);
        saturday.setSize(500, 50);
        sunday.setSize(500, 50);

        spine.add(monday);
        spine.add(tuesday);
        spine.add(wednesday);
        spine.add(thursday);
        spine.add(friday);
        spine.add(saturday);
        spine.add(sunday);

        monday.add(txtMonday);
        tuesday.add(txtTuesday);
        wednesday.add(txtWednesday);
        thursday.add(txtThursday);
        friday.add(txtFriday);
        saturday.add(txtSaturday);
        sunday.add(txtSunday);
    }

    public JPanel getMonday() {
        return monday;
    }

    public JPanel getTuesday() {
        return tuesday;
    }

    public JPanel getWednesday() {
        return wednesday;
    }

    public JPanel getThursday() {
        return thursday;
    }

    public JPanel getFriday() {
        return friday;
    }

    public JPanel getSaturday() {
        return saturday;
    }

    public JPanel getSunday() {
        return sunday;
    }
//
//    public static void main (String[] args){
//
//        GUI gui = new GUI();
//
//    }
}
