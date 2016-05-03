package no.uib.info216;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

/**
 * Created 04.04.2016.
 * Class for setting up the GUI and making it all visible.
 *
 */
public class GUI extends JPanel{

    private JTextArea tab1 = new JTextArea("Tab 1");
    private JTextArea tab2 = new JTextArea("Tab 2");
    private JTextArea tab3 = new JTextArea("Tab 3");
    private JTextArea tab4 = new JTextArea("Tab 4");
    private JTextArea tab5 = new JTextArea("Tab 5");
    private JTextArea tab6 = new JTextArea("Tab 6");
    private JTextArea tab7 = new JTextArea("Tab 7");

    private JTextArea tab1Qout = new JTextArea("QUERY OUT");

    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JPanel panel5 = new JPanel();
    private JPanel panel6 = new JPanel();
    private JPanel panel7 = new JPanel();

    public GUI() {

        super(new GridLayout(1, 3));

        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("images/middle.gif");
        tabbedPane.setPreferredSize(new Dimension(600, 300));

        // --------------------------- PANEL FOR TAB NR 1 -----------------------------
        //JComponent panel1 = makeTextPanel("-- micromandag-Det Akademiske Kvarter sol-11-celsius  ");
        tabbedPane.addTab("Mandag", icon, panel1, "Mandag");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        tab1Qout.setPreferredSize(new Dimension(600, 280));

        panel1.add(tab1);
        panel1.add(tab1Qout);

        // ----------------------------------------------------------------------------

        //JComponent panel2 = makeTextPanel("sol-12-celsius");
        JComponent panel2 = makeTextPanel(tab2.getText());
        tabbedPane.addTab("Tirsdag", icon, panel2, "Tirsdag");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        //JComponent panel3 = makeTextPanel("50% Quiz-Det Akademiske Kvarter");
        JComponent panel3 = makeTextPanel(tab3.getText());
        tabbedPane.addTab("Onsdag", icon, panel3, "Onsdag");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        //JComponent panel4 = makeTextPanel("0% Feministisk initiativ møte-Det Akademiske Kvarter skyet-8-celsius");
        JComponent panel4 = makeTextPanel(tab4.getText());
        tabbedPane.addTab("Torsdag", icon, panel4, "Torsdag");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

        //JComponent panel5 = makeTextPanel("10% pysjamas party-kvarteret Regn-5-celsius");
        JComponent panel5 = makeTextPanel(tab5.getText());
        tabbedPane.addTab("Fredag", icon, panel5, "Fredag");
        tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);

        //JComponent panel6 = makeTextPanel("80% Konsert-Verftet Skyet-9-celsius ");
        JComponent panel6 = makeTextPanel(tab6.getText());
        tabbedPane.addTab("Lørdag", icon, panel6, "Lørdag");
        tabbedPane.setMnemonicAt(5, KeyEvent.VK_6);

        //JComponent panel7 = makeTextPanel("100% ingenting-heima kem-bryr-seg");
        JComponent panel7 = makeTextPanel(tab7.getText());
        tabbedPane.addTab("Søndag", icon, panel7, "Søndag");
        tabbedPane.setMnemonicAt(6, KeyEvent.VK_7);

        //Add the tabbed pane to this panel.
        add(tabbedPane);

        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);


    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
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
        JFrame frame = new JFrame("( ͡° ͜ʖ ͡°)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new GUI(), BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main (String[]args){

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }
}
