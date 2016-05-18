package no.uib.info216.facebook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by goat on 30.04.16.
 * Created only as an example.
 */
public class FacebookGui extends JFrame{

    private JPanel controls= new JPanel();

    private JLabel nameLabel = new JLabel("Name: ");

    private DefaultTableModel eventModel = new DefaultTableModel();
    private JButton randomButton = new JButton("Random FacebookUser");
    private JTable eventTable = new JTable(eventModel);

    private JScrollPane eventPane = new JScrollPane(eventTable);


    public FacebookGui(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setupComponents();
        tableRows();
        add(eventPane, BorderLayout.EAST);
        add(randomButton, BorderLayout.CENTER);
        add(controls, BorderLayout.WEST);
        setPreferredSize(new Dimension(600, 600));
        setResizable(false);
        setVisible(true);
        pack();
    }

    public void setupComponents(){
        controls.add(nameLabel);
    }

    public void tableRows(){
        eventModel.addColumn("Events");

    }


    public void listEvents(FacebookUser user){
        eventRows();
        for(String s : user.getEvents()) {
            eventModel.addRow(new Object[]{s});
        }
    }


    public void eventRows(){
        eventModel.setRowCount(0);
    }

    public JButton getRandomButton() {
        return randomButton;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

}
