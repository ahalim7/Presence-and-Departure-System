/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasepackage.commands;

import databasepackage.DBconnection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdelhalim
 */
public class CommonProcedureCall {
    
    /**
     * Statement object and CallableStatement object
     */
    private  Statement statement;
    private  CallableStatement callableStatement;
    private  ResultSet resultSetData;
    /**
     * class constructor 
     */
    public CommonProcedureCall(){
        
    }
    
    /**
     * common implemented method
     */
    public  ResultSet procedureCallableReturn(String procedureCall){
        try {
            DBconnection.openConnection();
            callableStatement = DBconnection.getConnection().prepareCall(procedureCall);
            resultSetData = callableStatement.executeQuery();
            return resultSetData;
        } catch (Exception exception) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE,
                    null, exception);
        }
    return null;    
    }
    
    
    public  void procedureCallable(String procedureCall){
        try {
            DBconnection.openConnection();
            callableStatement = DBconnection.getConnection().prepareCall(procedureCall);
            callableStatement.executeUpdate();
        } catch (Exception exception) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE,
                    null, exception);
        }
    }
}
