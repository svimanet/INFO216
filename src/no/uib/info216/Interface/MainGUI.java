package no.uib.info216.Interface;


import no.uib.info216.Misc.WeekDates;
import no.uib.info216.Models.Weather;
import no.uib.info216.RDF.Queries.EventQueries;
import no.uib.info216.RDF.Queries.FacebookQueries;
import no.uib.info216.RDF.Queries.WeatherQuery;
import no.uib.info216.RDF.RDFHandler;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.ListIterator;



/**
 * Created 04.04.2016.
 * Class for setting up the Interface and making it all visible.
 *
 */
public class MainGUI extends JPanel{
    private int NUMBER_OF_DAYS = 7;

    private ImageIcon icon = createImageIcon("images/middle.gif");

    private ArrayList<JTextArea> tabList;
    private JTabbedPane tabbedPane = new JTabbedPane();

    private RDFHandler rdfHandler;

    // Query handler
    private EventQueries evtQueries;
    private WeatherQuery weatherQuery;
    private FacebookQueries facebookQueries;

    private ImageIcon snow = createImageIcon("Files/snow.png");
    private ImageIcon rain = createImageIcon("Files/rain.png");
    private ImageIcon cloud = createImageIcon("Files/cloud.png");
    private ImageIcon clouds = createImageIcon("Files/clouds.png");
    private ImageIcon sleet = createImageIcon("Files/sleet.png");
    private ImageIcon thunder = createImageIcon("Files/thunder.png");


    public MainGUI(RDFHandler rdfHandler) {
        super(new GridLayout(1, 3));

        this.rdfHandler = rdfHandler;
        this.evtQueries = new EventQueries(rdfHandler);
        this.weatherQuery = new WeatherQuery(rdfHandler);
        this.facebookQueries = new FacebookQueries(rdfHandler);

        //JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("Files/rain.png");
        tabbedPane.setPreferredSize(new Dimension(600, 300));

        // Generates the tab
        this.tabList = this.populateTappedPane();
        this.generateTabTextArea(this.tabList);

        //Add the tabbed pane to this panel.
        add(this.tabbedPane);

        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    private ArrayList<JTextArea> populateTappedPane() {
        ArrayList<JTextArea> retList = new ArrayList<JTextArea>();
        for(int i = this.NUMBER_OF_DAYS; i != 0; i--){
            retList.add(new JTextArea());
        }
        return retList;
    }

    private void generateTabTextArea(ArrayList<JTextArea> tabList) {
        ArrayList<ArrayList<String>> days = new WeekDates().getWeekDates(this.NUMBER_OF_DAYS);
        ListIterator<ArrayList<String>> daysItems = days.listIterator();


        for(JTextArea jtabText: tabList) {
            ArrayList<String> day = daysItems.next();

            jtabText.setText(day.get(0));

            final ArrayList<no.uib.info216.Models.Event> events = evtQueries.getEventsForDay(day.get(1));
            Weather weather = weatherQuery.getWeatherForDay(day.get(1));
            JPanel panel = new JPanel();

            String weatherImg = weather.getWeatherCondition();
            ImageIcon pic = createImageIcon("Files/sun.png");

            if (weatherImg.equals("Rain")) {
                pic = rain;
            } else if (weatherImg.equals("Sleet")) {
                pic = sleet;
            } else if (weatherImg.equals("Thunder")) {
                pic = thunder;
            } else if (weatherImg.equals("PartlyCloud")) {
                pic = cloud;
            } else if (weatherImg.equals("Cloud")) {
                pic = clouds;
            } else if (weatherImg.equals("Snow")){
                pic = snow;
            } else {
                
            }

            JLabel icon = new JLabel(pic);
            JLabel tab1 = new JLabel(weather.getWeatherCondition() +
                    "            " +
                    weather.getTemprature() + " Degrees Celsius");

            JLabel tab11 = new JLabel("");
            if(events.size() >= 1){
               tab11.setText(events.get(0).getName());

                tab11.addMouseListener(new MouseListener() {
                    public void mouseClicked(MouseEvent e) {
                        DetailsPanel dp = new DetailsPanel(events.get(0));
                        dp.getInterestsDesc().setText(events.get(0).getDescription());
                        dp.getInterestsLoc().setText(events.get(0).getLocation());
                        dp.getInterestsTime().setText(events.get(0).getDoorTime());
                        dp.getInterestsURL().setText(events.get(0).getUrl());

                        ArrayList<ArrayList<String>> scores = facebookQueries.GetFriendInterestScore();
                        for(ArrayList<String> score: scores){
                           dp.addFriend(score.get(0), score.get(1));
                        }
                    }

                    public void mousePressed(MouseEvent e) {

                    }

                    public void mouseReleased(MouseEvent e) {

                    }

                    public void mouseEntered(MouseEvent e) {

                    }

                    public void mouseExited(MouseEvent e) {

                    }
                });
            }

            JLabel tab12 = new JLabel("");
            if(events.size() >= 2){
                tab12.setText(events.get(1).getName());
                tab12.addMouseListener(new MouseListener() {
                    public void mouseClicked(MouseEvent e) {
                        DetailsPanel dp = new DetailsPanel(events.get(1));
                        dp.getInterestsDesc().setText(events.get(1).getDescription());
                        dp.getInterestsLoc().setText(events.get(1).getLocation());
                        dp.getInterestsTime().setText(events.get(1).getDoorTime());
                        dp.getInterestsURL().setText(events.get(1).getUrl());
                        ArrayList<ArrayList<String>> scores = facebookQueries.GetFriendInterestScore();
                        for(ArrayList<String> score: scores){
                            dp.addFriend(score.get(0), score.get(1));
                        }
                    }

                    public void mousePressed(MouseEvent e) {
                    }

                    public void mouseReleased(MouseEvent e) {
                    }

                    public void mouseEntered(MouseEvent e) {
                    }

                    public void mouseExited(MouseEvent e) {
                    }
                });
            }

            JLabel tab13 = new JLabel("");
            if(events.size() >= 3){
                tab13.setText(events.get(2).getName());
                tab13.addMouseListener(new MouseListener() {
                    public void mouseClicked(MouseEvent e) {
                        DetailsPanel dp = new DetailsPanel(events.get(2));
                        dp.getInterestsDesc().setText(events.get(2).getDescription());
                        dp.getInterestsLoc().setText(events.get(2).getLocation());
                        dp.getInterestsTime().setText(events.get(2).getDoorTime());
                        dp.getInterestsURL().setText(events.get(2).getUrl());
                        ArrayList<ArrayList<String>> scores = facebookQueries.GetFriendInterestScore();
                        for(ArrayList<String> score: scores){
                            dp.addFriend(score.get(0), score.get(1));
                        }
                    }

                    public void mousePressed(MouseEvent e) {

                    }

                    public void mouseReleased(MouseEvent e) {

                    }

                    public void mouseEntered(MouseEvent e) {

                    }

                    public void mouseExited(MouseEvent e) {

                    }
                });
            }

            JLabel suggested = new JLabel("<html><b><font size=+1> Suggested events: </font></b></html>");

            panel.add(icon);
            panel.add(tab1, BorderLayout.NORTH);
            panel.add(suggested, BorderLayout.NORTH);
            panel.add(tab11, BorderLayout.CENTER);
            panel.add(tab12, BorderLayout.SOUTH);
            panel.add(tab13);

            tabbedPane.addTab(day.get(0), this.icon, panel, day.get(1));

            icon.setPreferredSize(new Dimension(40, 40));
            tab1.setPreferredSize(new Dimension(550, 40));
            tab11.setPreferredSize(new Dimension(550, 40));
            tab12.setPreferredSize(new Dimension(550, 40));
            tab13.setPreferredSize(new Dimension(550, 40));
            tab11.setBorder(BorderFactory.createTitledBorder(new TitledBorder("")));
            tab12.setBorder(BorderFactory.createTitledBorder(new TitledBorder("")));
            tab13.setBorder(BorderFactory.createTitledBorder(new TitledBorder("")));
        }
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = MainGUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the Interface and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     */
    public static void createAndShowGUI(RDFHandler rdfHandler) {
        //Create and set up the window.
        JFrame frame = new JFrame("216");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new MainGUI(rdfHandler), BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}

