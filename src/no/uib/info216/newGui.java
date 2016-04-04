package no.uib.info216;

import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

/**
 * Created by Eirik on 04.04.2016.
 */
public class newGui extends JPanel{
    public newGui() {
        super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("images/middle.gif");
        tabbedPane.setPreferredSize(new Dimension(600, 300));

        JComponent panel1 = makeTextPanel("-- micromandag-Det Akademiske Kvarter sol-11-celsius  ");
        tabbedPane.addTab("Mandag", icon, panel1, "Mandag");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JComponent panel2 = makeTextPanel("sol-12-celsius");
        tabbedPane.addTab("Tirsdag", icon, panel2, "Tirsdag");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        JComponent panel3 = makeTextPanel("50% Quiz-Det Akademiske Kvarter");
        tabbedPane.addTab("Onsdag", icon, panel3, "Onsdag");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        JComponent panel4 = makeTextPanel("0% Feministisk initiativ møte-Det Akademiske Kvarter skyet-8-celsius");
        tabbedPane.addTab("Torsdag", icon, panel4, "Torsdag");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

        JComponent panel5 = makeTextPanel("10% pysjamas party-kvarteret Regn-5-celsius");
        tabbedPane.addTab("Fredag", icon, panel5, "Fredag");
        tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);

        JComponent panel6 = makeTextPanel("80% Konsert-Verftet Skyet-9-celsius ");
        tabbedPane.addTab("Lørdag", icon, panel6, "Lørdag");
        tabbedPane.setMnemonicAt(5, KeyEvent.VK_6);

        JComponent panel7 = makeTextPanel("100% ingenting-heima kem-bryr-seg");
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
        java.net.URL imgURL = newGui.class.getResource(path);
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
        frame.add(new newGui(), BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
