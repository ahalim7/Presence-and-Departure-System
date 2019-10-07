/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visualClasses;

import finalClasses.WelcomeMessages;
import javax.swing.JTabbedPane;

/**
 *
 * @author Abdelhalim
 */
public class MainVisualComponent extends JTabbedPane {

    /**
     * declare and initialize object from welcome messages to be used.
     */
    WelcomeMessages welcomeMessage = new WelcomeMessages();

    /**
     * class constructor
     */
    public MainVisualComponent() {

        // initialize tabs 
        initializeTabs();
    }

    /**
     * initialize tabs
     */
    private void initializeTabs() {

        this.addTab("Presence Employee", null,
                new CommonJPanelInterface(welcomeMessage.getPresenceMessage(),
                "Presence Employee",
                "presence",
                "jtextPresence"));
        this.addTab("Departure Employee", null,
                new CommonJPanelInterface(welcomeMessage.getDepartureMessage(),
                "Departure Employee",
                "departure",
                "jtextdeparture"));
        this.addTab("Employee Status", null, new EmployeeStatus());
        this.addTab("Settings", null, new Settings());
    }
}
