/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgePackage;

import databasepackage.commands.TotalMonthly;
import databasepackage.helperClasses.ConvertBetweenDataTypes;
import java.util.ArrayList;

/**
 *
 * @author Abdelhalim
 */
public class TotalMonthlyBridge {

    /**
     * declare object from TotalMonthly class
     */
    TotalMonthly totalMonthly;

    /**
     * class constructor
     */
    public TotalMonthlyBridge() {
        // initialize object
        totalMonthly = new TotalMonthly();
    }

    public int getHoursForEmployeeAtBridge(int employeeID) {

        ArrayList<String> getHoursArrayList = new ConvertBetweenDataTypes().convertResultSetIntoArrayList(
                totalMonthly.getHoursForEmployee(employeeID),
                new String[]{"totalMonthlyLatedTotalHours"});

        if (!getHoursArrayList.isEmpty()) {
            return Integer.parseInt(getHoursArrayList.get(0));
        } else {
            return 0;
        }
    }

    public boolean updateTotalMonthlyLatedAtBridge(int employeeID,
            String totalHoursLated) {
        return totalMonthly.updateTotalMonthlyLated(
                employeeID, totalHoursLated);
    }

    public boolean insertTotalMonthlyLatedAtBridge(int employeeID,
            String totalHoursLated) {
        return totalMonthly.insertTotalMonthlyLated(
                employeeID, totalHoursLated);
    }
}
