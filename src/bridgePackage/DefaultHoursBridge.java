/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgePackage;

import databasepackage.commands.DefaultHours;
import databasepackage.helperClasses.ConvertBetweenDataTypes;
import helperclasses.MachineDateAndTime;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Abdelhalim
 */
public class DefaultHoursBridge {

    /**
     * declare object
     */
    DefaultHours defaultHours;
    /**
     * declare variable
     */
    ArrayList<String> resultList;
    private int presenceHour;
    private int presenceMinute;

    /**
     * class constructor
     */
    public DefaultHoursBridge() {
        // initialize object
        defaultHours = new DefaultHours();
        getDefaultPresenceTimeAtBridge();
    }

    public final void getDefaultPresenceTimeAtBridge() {

        resultList = new ConvertBetweenDataTypes().convertResultSetIntoArrayList(
                defaultHours.getDefaultPresenceTime(), new String[]{"presenceHour"});
        
        String tempdefaultHour = resultList.get(0);
        int[] timeIntoHourAndMinute = MachineDateAndTime.timeIntoHourMinute(tempdefaultHour);
        
        setPresenceHour(timeIntoHourAndMinute[0]);
        setPresenceMinute(timeIntoHourAndMinute[1]);
    }
    
    public int getPresenceHour(){
        return presenceHour;
    }
    
    public void setPresenceHour(int presenceHour){
        this.presenceHour = presenceHour;
    }
    
    public int getPresenceMinute(){
        return presenceMinute;
    }
    
    public void setPresenceMinute(int presenceMinute){
        this.presenceMinute = presenceMinute;
    }
}
