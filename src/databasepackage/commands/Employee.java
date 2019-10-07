/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasepackage.commands;

import databasepackage.interfaces.IdatabaseCommands;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdelhalim
 */
public class Employee implements IdatabaseCommands {

   /**
     * declare object
     */
    CommonProcedureCall commonProcedureCall;
    
    /**
     * class constructor
     */
    public Employee() {
        // initialize object
        commonProcedureCall = new CommonProcedureCall();
    }

    /**
     * implement method for update time
     */
    public boolean updateEmployeeTime(int employeeID,
            String dateOfDay,
            String presenceTime,
            String departureTime) {
        // open connection with database
        try {
            commonProcedureCall.procedureCallable(
                    "CALL updateEmployeeNewDay(" + employeeID + ",'" + dateOfDay + "','" + presenceTime + "','" + departureTime + "')");
            return true;
        } catch (Exception exception) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE,
                    null, exception);
        }
        return false;
    }

    @Override
    public boolean insertRecord() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteRecord() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean updateRecord() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
