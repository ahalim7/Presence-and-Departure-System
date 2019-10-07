/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasepackage.commands;

import databasepackage.interfaces.IdatabaseCommands;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdelhalim
 */
public class TotalMonthly implements IdatabaseCommands {

    /**
     * declare object
     */
    CommonProcedureCall commonProcedureCall;
    /**
     * declare variables
     */
    ResultSet resultData;

    /**
     * class constructor
     */
    public TotalMonthly() {
        // initialize object
        commonProcedureCall = new CommonProcedureCall();
    }

    public ResultSet getHoursForEmployee(int employeeID) {
        // open connection with database
        try {
            resultData = commonProcedureCall.procedureCallableReturn(
                    "CALL getHoursForEmployee(" + employeeID + ")");
            return resultData;
        } catch (Exception exception) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE,
                    null, exception);
        }
        return null;
    }

    public boolean updateTotalMonthlyLated(int employeeID, String totalHoursLated) {
        try {
            commonProcedureCall.procedureCallable(
                    "CALL updateTotalMonthlyLated(" + employeeID + ",'" + totalHoursLated + "')");
            return true;
        } catch (Exception exception) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE,
                    null, exception);
        }
        return false;
    }

    public boolean insertTotalMonthlyLated(int employeeID, String totalHoursLated) {
        try {
            commonProcedureCall.procedureCallable(
                    "CALL insertTotalMonthlyLated(" + employeeID + ",'" + totalHoursLated + "')");
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
