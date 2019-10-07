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
public class DefaultHours implements IdatabaseCommands {

    /**
     * declare object
     */
    CommonProcedureCall commonProcedureCall;
    /**
     * declare  variables
     */
    ResultSet resultData;

    /**
     * class constructor
     */
    public DefaultHours() {
        // initialize object
        commonProcedureCall = new CommonProcedureCall();
    }

    /**
     * return the default presence time.
     *
     * @return
     */
    public ResultSet getDefaultPresenceTime() {
        // open connection with database
        try {
            resultData = commonProcedureCall.procedureCallableReturn(
                    "CALL getDefaultPresenceTime");
            return resultData;
        } catch (Exception exception) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE,
                    null, exception);
        }
        return null;
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
