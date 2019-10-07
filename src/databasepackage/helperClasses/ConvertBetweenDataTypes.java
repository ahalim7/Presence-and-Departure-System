/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasepackage.helperClasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Abdelhalim
 */
public class ConvertBetweenDataTypes {

    /**
     * declare ArrayList
     */
    ArrayList<String> arrayListTemper;

    /**
     * class constructor
     */
    public ConvertBetweenDataTypes() {
    }

    /**
     * convert between ResultSet to ArrayList
     */
    public ArrayList<String> convertResultSetIntoArrayList(ResultSet resultSetPassing,
            String[] columnTitles) {
        arrayListTemper = new ArrayList<>();
        try {
            for (int columnCounter = 0; columnCounter < columnTitles.length; columnCounter++) {
                int arrayIndex = 0;
                while (resultSetPassing.next()) {
                    arrayListTemper.add(resultSetPassing.getString(columnTitles[columnCounter]));
                    arrayIndex += 1;
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return arrayListTemper;
    }
}
