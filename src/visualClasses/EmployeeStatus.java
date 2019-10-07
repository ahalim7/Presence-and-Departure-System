/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visualClasses;

import commonInterfaces.IMethodsForGridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Abdelhalim
 */
public class EmployeeStatus extends CustomizedJPanel implements ActionListener,
        IMethodsForGridBagLayout {

    /**
     * declare class components
     */
    JScrollPane jScrollPaneForTable;
    JTable jTableStatusView;
    CustomizedJPanel jPanelSearching;

    /**
     * class constructor
     */
    public EmployeeStatus() {
        initializeComponents();
    }

    @Override
    public final void initializeComponents() {
        // initialize components 
        jTableStatusView = new JTable(new String[][]{new String[]{
                        "2013444555",
                        "Hani Maged",
                        "01000000000",
                        "27-10-2012",
                        "9:00",
                        "6:00",
                        "sales",
                        "120",
                        "100",
                        "20"}
                },
                new String[]{
                    "Employee ID",
                    "Employee Name",
                    "Employee Mobile",
                    "Date",
                    "Presence Time",
                    "Departure Time",
                    "Department",
                    "Total Hrs.",
                    "Total Work Hrs.",
                    "Total Late Hrs."});
        jScrollPaneForTable = new JScrollPane(jTableStatusView);
        jPanelSearching = new CustomizedJPanel();
        createSearchingPanel();
        setComponentLocation();
    }

    private void createSearchingPanel() {
        // initialize searching components
        JLabel jLabelEmployeeID = new JLabel("Employee ID :");
        JTextField jTextFieldEmployeeID = new JTextField();
        JButton jButtonSearch = new JButton("Search");
        JComboBox<String> jComboBoxSearchArea = new JComboBox<>(new String[]{
                    "Today Coming",
                    "Today Lated",
                    "All Lated Employee",
                    "All Employee Status"});

        // set component location to the search JPanel
        jPanelSearching.constraints.weightx = GridBagConstraints.BOTH;
        jPanelSearching.addJPanelComponent(jLabelEmployeeID, 0, 0,
                jPanelSearching.constraints);
        jPanelSearching.constraints.fill = GridBagConstraints.BOTH;
        jPanelSearching.addJPanelComponent(jTextFieldEmployeeID, 0, 1,
                jPanelSearching.constraints);
        jPanelSearching.constraints.fill = GridBagConstraints.NONE;
        jPanelSearching.addJPanelComponent(jButtonSearch, 0, 3,
                jPanelSearching.constraints);
        jPanelSearching.addJPanelComponent(jComboBoxSearchArea, 0, 4,
                jPanelSearching.constraints);

        // add action listener to the components
        jButtonSearch.addActionListener(this);
    }

    @Override
    public void setComponentLocation() {
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        addJPanelComponent(jPanelSearching, 0, 0, constraints);
        addJPanelComponent(jScrollPaneForTable, 1, 0, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
