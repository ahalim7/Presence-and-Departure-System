/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgePackage;

import databasepackage.commands.Employee;

/**
 *
 * @author Abdelhalim
 */
public class EmployeeBridge {
    
    /**
     * class constructor
     */
    public EmployeeBridge(){
        
    }
    
    public boolean updateEmployeeTimeAtBridge(int employeeID,
            String dateOfDay,
            String presenceTime,
            String departureTime){
        return new Employee().updateEmployeeTime(employeeID,
                dateOfDay, 
                presenceTime, 
                departureTime);
    }
}
