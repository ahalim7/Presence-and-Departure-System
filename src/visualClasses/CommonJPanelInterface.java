/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visualClasses;

import bridgePackage.DefaultHoursBridge;
import bridgePackage.EmployeeBridge;
import bridgePackage.TotalMonthlyBridge;
import commonInterfaces.IMethodsForGridBagLayout;
import helperclasses.MachineDateAndTime;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.omg.CORBA.INTERNAL;

/**
 *
 * @author Abdelhalim
 */
public class CommonJPanelInterface extends CustomizedJPanel implements
        ActionListener,
        IMethodsForGridBagLayout {

    /**
     * declare JPanel components
     */
    JLabel jLabelWelcomeMessage;
    JLabel jLabelEmployeeID;
    JTextField jTextFieldEmployeeID;
    JButton jButtonAction;

    /**
     * class constructor
     */
    public CommonJPanelInterface(String jLabelContent, String jButtonContent,
            String jButtonName, String jTextFieldName) {
        // initialize all the JPanel components
        initializeComponents();
        // set passed parameter in its suitable target
        this.jLabelWelcomeMessage.setText(jLabelContent);
        this.jButtonAction.setText(jButtonContent);
        this.jTextFieldEmployeeID.setName(jTextFieldName);
        this.jButtonAction.setName(jButtonName);
    }

    /**
     * initialize JPanel components
     */
    @Override
    public final void initializeComponents() {
        // initialize components
        jLabelWelcomeMessage = new JLabel();
        jLabelEmployeeID = new JLabel("Employee Number : ");
        jTextFieldEmployeeID = new JTextField();
        jTextFieldEmployeeID.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 27));
        jButtonAction = new JButton();

        // set components action
        jButtonAction.addActionListener(this);
        // add components to JPanel
        setComponentLocation();
    }

    @Override
    public void setComponentLocation() {
        /**
         * assign constant values to the layout constraints that will be applied
         * on all the JPanel components.
         */
        constraints.fill = GridBagConstraints.BOTH;

        /**
         * call this method to set the location for each component will be
         * exists on the JPanel and here we pass the component and its row and
         * column to the method addComponent.
         */
        constraints.insets = new Insets(30, 30, 60, 30);
        constraints.gridwidth = 2;
        constraints.weighty = 0.001;
        addJPanelComponent(jLabelWelcomeMessage, 0, 0, constraints);
        constraints.gridwidth = GridBagConstraints.RELATIVE;
        constraints.insets = new Insets(60, 30, 20, 30);
        addJPanelComponent(jLabelEmployeeID, 1, 0, constraints);
        addJPanelComponent(jTextFieldEmployeeID, 1, 1, constraints);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        addJPanelComponent(jButtonAction, 2, 0, constraints);
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * this is a common interface which we should determine which button
         * fire the action performed from different places.
         *
         */
        TotalMonthlyBridge totalMonthlyBridge = new TotalMonthlyBridge();
        DefaultHoursBridge defaultHoursBridge = new DefaultHoursBridge();
        MachineDateAndTime dateAndTime = new MachineDateAndTime();
        int employeeID;
        int totalHoursForEmployee;
        int[] timeIntoHourAndMinute;
        JTextField jTextFieldTemp;
        JButton jButtonClicked = (JButton) e.getSource();
        switch (jButtonClicked.getName()) {
            case "presence":
                jTextFieldTemp = getComponentFromParent("jtextPresence");
                employeeID = Integer.parseInt(jTextFieldTemp.getText());

                timeIntoHourAndMinute = MachineDateAndTime.timeIntoHourMinute(
                        dateAndTime.getCompleteTime());
                /**
                 * comparison between the current time and the default presence
                 * time
                 */
                int[] employeeHoursAndMinutes = checkForDefaultHourAndMinute(
                        timeIntoHourAndMinute, defaultHoursBridge);

                /**
                 * update the current employee presence time.
                 */
                new EmployeeBridge().updateEmployeeTimeAtBridge(
                        employeeID,
                        dateAndTime.getCompleteDate(),
                        ("" + timeIntoHourAndMinute[0] + ":" + timeIntoHourAndMinute[1]),
                        dateAndTime.getCompleteTime());

                // check if the current employee ID exist in montly table
                totalHoursForEmployee =
                        totalMonthlyBridge.getHoursForEmployeeAtBridge(
                        employeeID);
                if (totalHoursForEmployee != 0) {
                    /**
                     * true, so we will summation the past and the present time
                     * together and update the monthly table with the new total
                     * hours.
                     */
                    totalMonthlyBridge.updateTotalMonthlyLatedAtBridge(
                            employeeID, "" + totalHoursForEmployee);
                } else {
                    /**
                     * false, so this employee ID doesn't exist in the monthly
                     * table so we will insert new record for it.
                     */
                    totalMonthlyBridge.insertTotalMonthlyLatedAtBridge(
                            employeeID, "" + totalHoursForEmployee);
                }
                break;
            case "departure":
                jTextFieldTemp = getComponentFromParent("jtextdeparture");
                break;
        }
    }

    /**
     * check for Time Hours Values
     *
     * @param hours will take timeIntoHourAndMinute[0].
     * @return
     */
    private int[] checkForDefaultHourAndMinute(int[] hoursAndminutes,
            DefaultHoursBridge defaultHoursBridge) {

        int[] returnedHours = new int[2];

        // comparison between Hours.
        if (defaultHoursBridge.getPresenceHour()
                == hoursAndminutes[0]) {
            /**
             * Employee comes at the exactly time which mean there is no lated
             * hour time.
             */
            returnedHours[0] = 0;
        } else if (defaultHoursBridge.getPresenceHour()
                > hoursAndminutes[0]) {
            /**
             * Employee comes before the presence time, which mean there is an
             * additional time that will be added to employee in case he/she
             * will lated later. And this additional value will added in
             * positive values
             */
            returnedHours[0] =
                    defaultHoursBridge.getPresenceHour()
                    - hoursAndminutes[0];

        } else if (defaultHoursBridge.getPresenceHour()
                < hoursAndminutes[0]) {
            /**
             * Employee comes after the presence time, which mean there is an
             * additional time that will be added to employee represent that
             * employee was lated. And this additional values will be added in
             * negative values.
             */
            returnedHours[0] = hoursAndminutes[0]
                    - defaultHoursBridge.getPresenceHour();
        }
        /**
         * check for minute value.
         */
        returnedHours[1] = checkForDefaultMinute(hoursAndminutes[1],
                defaultHoursBridge);
        return returnedHours;
    }

    /**
     * check for Time Hours Values
     *
     * @param minutes will take timeIntoHourAndMinute[1].
     * @return
     */
    private int checkForDefaultMinute(int minutes,
            DefaultHoursBridge defaultHoursBridge) {

        if(minutes == 0) return 0;
        
        int returnedMinutes = 0;
        // comparison between Minutes.
        if (defaultHoursBridge.getPresenceMinute()
                == minutes) {
            /**
             * Employee comes at the exactly minute.
             */
            returnedMinutes = 0;

        } else if (defaultHoursBridge.getPresenceMinute()
                > minutes) {
            /**
             * Employee comes before the presence minute, which mean there is an
             * addition minute that will be added to employee in positive
             * values.
             */
        } else if (defaultHoursBridge.getPresenceMinute()
                < minutes) {
            /**
             * Employee comes after the presence minute, which mean there is an
             * additional minute that will be added to employee in negative
             * values.
             */
        }
        return returnedMinutes;
    }

    /**
     * implement to differ between JTextField from common interface
     */
    private JTextField getComponentFromParent(String jTextFieldName) {
        for (Component component : this.getComponents()) {
            String stringComponentName = component.getName();
            if (stringComponentName == null) {
                continue;
            }
            if (stringComponentName.equals(jTextFieldName)) {
                return (JTextField) component;
            }
        }
        return null;
    }
}
