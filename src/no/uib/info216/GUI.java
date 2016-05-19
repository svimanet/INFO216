package no.uib.info216;

import no.uib.info216.Misc.WeekDates;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created 04.04.2016.
 * Class for setting up the GUI and making it all visible.
 *
 */
public class GUI extends JPanel{
    private int NUMBER_OF_DAYS = 7;

    private ImageIcon icon = createImageIcon("images/middle.gif");

    private ArrayList<JTextArea> tabList;
    private JTabbedPane tabbedPane = new JTabbedPane();

    private ArrayList<JPanel> panelList;




    public GUI() {

        super(new GridLayout(1, 3));

        this.tabbedPane.setPreferredSize(new Dimension(600, 300));

        // Generates the tab
        this.tabList = this.populateTappedPane();
        this.generateTabTextArea(this.tabList);

        //this.panelList = this.populatePanelList();

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
            JComponent panel = makeTextPanel(day);
            tabbedPane.addTab(day.get(0), this.icon, panel, day.get(1));
        }
    }

    protected JComponent makeTextPanel(ArrayList<String> day) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(day.get(0));
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = GUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("216");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new GUI(), BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public JLabel getTab1() {
        return tab1;
    }

    public JLabel getTab11() {
        return tab11;
    }

    public JLabel getTab12() {
        return tab12;
    }

    public JLabel getTab13() {
        return tab13;
    }
}
