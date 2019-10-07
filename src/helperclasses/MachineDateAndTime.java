/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helperclasses;

import java.util.Date;

/**
 *
 * @author Abdelhalim
 */
public class MachineDateAndTime {

    /**
     * declare date and time variable
     */
    Date date = new Date();
    String completeDate,
            completeTime;

    /**
     * class constructor
     */
    public MachineDateAndTime() {

        // initialize the complete date and time variable 
        completeDate = "" + date.getDate() + "-"
                + (date.getMonth() + 1) + "-"
                + (date.getYear() + 1900);

        completeTime = "" + date.getHours() + ":"
                + date.getMinutes() + ":"
                + date.getSeconds();
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    /**
     * implemented method to convert String time into 
     * dependant Integer Hour, and Integer Minute
     * @param time
     * @return 
     */
    public static int[] timeIntoHourMinute(String time) {

        int[] timeHourMinute = new int[2];
        int index = time.indexOf(':');
        String hour = time.substring(0, index);
        String minute = time.substring(index + 1, time.length());
        timeHourMinute[0] = Integer.parseInt(hour);
        timeHourMinute[1] = Integer.parseInt(minute);
        return timeHourMinute;
    }
}
