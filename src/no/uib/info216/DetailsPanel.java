package no.uib.info216;

import no.uib.info216.Models.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by svimanet on 19/05/16.
 */
public class DetailsPanel extends JFrame{

    private JPanel spine;
    private JPanel panel1 = new JPanel();

    private no.uib.info216.Models.Event event;

    private JLabel interests = new JLabel("<html><b><font size=+1> EVENT DESCRIPTION </font></b></html>");
    private JLabel interestsDesc = new JLabel(" Livestreaming PlayBoy-TV with Goat as host.");
    private JLabel interestsLoc = new JLabel(" LOCATION: SOME URL OR SOME SHIT HERE   ");
    private JLabel interestsTime = new JLabel(" KLOKKEN 2 i natt .");
    private JLabel interestsURL = new JLabel(" No home page. ");
    private JLabel friends = new JLabel("<html><b><font size=+1> FRIENDS: </font></b></html>");
    private JLabel friends1 = new JLabel(" PEOPLE + /n MORE PEOPLE");

    public DetailsPanel(no.uib.info216.Models.Event event){
        this.event = event;
        spine = new JPanel();
        setContentPane(spine);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(600, 400));
        setupPanels();
        pack();

    }

    public void setupPanels(){

        spine.add(interests, BorderLayout.NORTH);
        spine.add(interestsDesc);
        spine.add(interestsLoc);
        spine.add(interestsTime);
        spine.add(interestsURL);

        spine.add(friends, BorderLayout.CENTER);
        spine.add(friends1, BorderLayout.SOUTH);

        friends1.setBorder(BorderFactory.createTitledBorder(new TitledBorder("")));

        interestsURL.setPreferredSize(new Dimension(550, 40));
        interests.setPreferredSize(new Dimension(550, 40));
        interestsDesc.setPreferredSize(new Dimension(550, 40));
        interestsLoc.setPreferredSize(new Dimension(550, 40));
        interestsTime.setPreferredSize(new Dimension(550, 40));
        friends.setPreferredSize(new Dimension(550, 40));
        friends1.setPreferredSize(new Dimension(550, 40));

    }

    public no.uib.info216.Models.Event getEvent() {
        return event;
    }

    public JLabel getInterests() {
        return interests;
    }

    public JLabel getInterestsDesc() {
        return interestsDesc;
    }

    public JLabel getInterestsLoc() {
        return interestsLoc;
    }

    public JLabel getInterestsTime() {
        return interestsTime;
    }

    public JLabel getFriends() {
        return friends;
    }

    public JLabel getFriends1() {
        return friends1;
    }

    public JLabel getInterestsURL() {
        return interestsURL;
    }
}
