/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visualClasses;

import commonInterfaces.IMethodsForGridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Abdelhalim
 */
public class Settings extends CustomizedJPanel implements ActionListener,
        IMethodsForGridBagLayout {

    /**
     * declare JPanel components
     */
    JLabel jLabeldefaultPresenceTime;
    JLabel jLabeldefaultDepartrueTime;
    JTextField jTextFieldInputPresenceTime;
    JTextField jTextFieldInputDepartureTime;
    JButton jButtonConfirm;

    /**
     * class constructor
     */
    public Settings() {
        
        initializeComponents();
    }

    @Override
    public final void initializeComponents() {
        // initialize JPanel components
        jLabeldefaultPresenceTime = new JLabel("Default Presence Time :");
        jLabeldefaultDepartrueTime = new JLabel("Default Departure Time :");
        jTextFieldInputPresenceTime = new JTextField();
        jTextFieldInputDepartureTime = new JTextField();
        jButtonConfirm = new JButton("Confirm");

        // set components action
        jButtonConfirm.addActionListener(this);
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
        constraints.insets = new Insets(10, 5, 10, 5);
        addJPanelComponent(jLabeldefaultPresenceTime, 0, 0, constraints);
        constraints.weightx=0.3;
        addJPanelComponent(jTextFieldInputPresenceTime, 0, 1, constraints); 
        addJPanelComponent(jLabeldefaultDepartrueTime, 0, 2, constraints);
        addJPanelComponent(jTextFieldInputDepartureTime, 0, 3, constraints);  
        addJPanelComponent(jButtonConfirm, 1, 0, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Confirmed");
    }
}