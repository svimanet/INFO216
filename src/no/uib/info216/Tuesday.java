package no.uib.info216;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Eirik on 04.04.2016.
 */
public class Tuesday extends JPanel{

    private JPanel spine = new JPanel();
    private JTextField text = new JTextField();

    public void placeComponents(JPanel spine){


        add(spine);
        spine.setPreferredSize(new Dimension(100, 100));

        text.setText("test");

        spine.add(text);
    }

    public Tuesday(){
        placeComponents(spine);
    }

}
