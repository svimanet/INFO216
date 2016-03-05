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
        spine.setSize(550, 500 );
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

        JPanel monday1 = new JPanel();
        JPanel tuesday1 = new JPanel();
        JPanel wednesday1 = new JPanel();
        JPanel thursday1 = new JPanel();
        JPanel friday1 = new JPanel();
        JPanel saturday1 = new JPanel();
        JPanel sunday1 = new JPanel();

        JPanel monday2 = new JPanel();
        JPanel tuesday2 = new JPanel();
        JPanel wednesday2 = new JPanel();
        JPanel thursday2 = new JPanel();
        JPanel friday2 = new JPanel();
        JPanel saturday2 = new JPanel();
        JPanel sunday2 = new JPanel();

        JPanel monday3 = new JPanel();
        JPanel tuesday3 = new JPanel();
        JPanel wednesday3 = new JPanel();
        JPanel thursday3 = new JPanel();
        JPanel friday3 = new JPanel();
        JPanel saturday3 = new JPanel();
        JPanel sunday3 = new JPanel();

        JLabel txtMonday = new JLabel("monday");
        JLabel txtTuesday= new JLabel("tuesday");
        JLabel txtWednesday = new JLabel("wednesday");
        JLabel txtThursday = new JLabel("thursday");
        JLabel txtFriday = new JLabel("friday");
        JLabel txtSaturday = new JLabel("saturday");
        JLabel txtSunday = new JLabel("sunday");

        JLabel montxtWeather = new JLabel("weather");
        JLabel tuetxtWeather = new JLabel("weather");
        JLabel wedtxtWeather = new JLabel("weather");
        JLabel thutxtWeather = new JLabel("weather");
        JLabel fritxtWeather = new JLabel("weather");
        JLabel sattxtWeather = new JLabel("weather");
        JLabel suntxtWeather = new JLabel("weather");

        JLabel montxtEvent = new JLabel("event");
        JLabel tuetxtEvent = new JLabel("event");
        JLabel wedtxtEvent = new JLabel("event");
        JLabel thutxtEvent = new JLabel("event");
        JLabel fritxtEvent = new JLabel("event");
        JLabel sattxtEvent = new JLabel("event");
        JLabel suntxtEvent = new JLabel("event");

        txtMonday.setPreferredSize(new Dimension(100, 50));
        txtTuesday.setPreferredSize(new Dimension(100, 50));
        txtWednesday.setPreferredSize(new Dimension(100, 50));
        txtThursday.setPreferredSize(new Dimension(100, 50));
        txtFriday.setPreferredSize(new Dimension(100, 50));
        txtSaturday.setPreferredSize(new Dimension(100, 50));
        txtSunday.setPreferredSize(new Dimension(100, 50));

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

        monday.add(monday1);
        monday.add(monday2);
        monday.add(monday3);
        monday1.add(txtMonday);
        monday2.add(montxtEvent);
        monday3.add(montxtWeather);

        tuesday.add(tuesday1);
        tuesday.add(tuesday2);
        tuesday.add(tuesday3);
        tuesday1.add(txtMonday);
        tuesday2.add(tuetxtEvent);
        tuesday3.add(tuetxtWeather);

        wednesday.add(wednesday1);
        wednesday.add(wednesday2);
        wednesday.add(wednesday3);
        wednesday1.add(txtMonday);
        wednesday2.add(wedtxtEvent);
        wednesday3.add(wedtxtWeather);

        thursday.add(thursday1);
        thursday.add(thursday2);
        thursday.add(thursday3);
        thursday1.add(txtMonday);
        thursday2.add(thutxtEvent);
        thursday3.add(thutxtWeather);

        friday.add(friday1);
        friday.add(friday2);
        friday.add(friday3);
        friday1.add(txtMonday);
        friday2.add(fritxtEvent);
        friday3.add(fritxtWeather);

        saturday.add(saturday1);
        saturday.add(saturday2);
        saturday.add(saturday3);
        saturday1.add(txtMonday);
        saturday2.add(sattxtEvent);
        saturday3.add(sattxtWeather);

        sunday.add(sunday1);
        sunday.add(sunday2);
        sunday.add(sunday3);
        sunday1.add(txtMonday);
        sunday2.add(suntxtEvent);
        sunday3.add(suntxtWeather);

    }


    public static void main (String[] args){

        GUI gui = new GUI();

    }
}
