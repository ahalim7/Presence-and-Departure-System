/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finalClasses;

/**
 *
 * @author Abdelhalim
 */
public final class WelcomeMessages {

    /**
     * declare private properties
     */
    private String presenceMessage;
    private String departureMessage;

    /**
     * class constructor
     */
    public WelcomeMessages() {

        // initialize messages
        initializeMessages();
    }

    /**
     * Set the value of presenceMessage
     *
     * @param presenceMessage new value of presenceMessage
     */
    public void setPresenceMessage(String presenceMessage) {
        this.presenceMessage = presenceMessage;
    }

    /**
     * Get the value of presenceMessage
     *
     * @return the value of presenceMessage
     */
    public String getPresenceMessage() {
        return presenceMessage;
    }

    /**
     * Set the value of departureMessage
     *
     * @param departureMessage new value of departureMessage
     */
    public void setDepartureMessage(String departureMessage) {
        this.departureMessage = departureMessage;
    }

    /**
     * Get the value of departureMessage
     *
     * @return the value of departureMessage
     */
    public String getDepartureMessage() {
        return departureMessage;
    }

    /**
     * Method that initialize presence and departure messages
     */
    private void initializeMessages() {
        this.presenceMessage = "Welcome, Good Morning     " + 
                "we will store your presence time according to the machine system, "
                + "so be sure that the time is correct.";
        this.departureMessage = "Welcome, Good Aftrnoon   " + 
                "we will store your departure time according to the machine system,"
                + "so be sure that the time is correct.";
    }
}
