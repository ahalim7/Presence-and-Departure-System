/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visualClasses;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 *
 * @author Abdelhalim
 */
public class CustomizedJPanel extends JPanel{

    /**
     * declare JPanel layout and its constraints
     */
    GridBagLayout layout;
    GridBagConstraints constraints;

    public CustomizedJPanel(){
        initializeJPanelLayout();
    }
    /**
     * initialize JPanel layout and its constraints
     */
    public final void initializeJPanelLayout() {

        // initialize layout and its constraints
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();

        // set GridBagLayout to be the JPanel layout
        this.setLayout(layout);
    }
    
    public void addJPanelComponent(Component component, int column, int row, GridBagConstraints gridBagConstraints) {
        /**
         * implement here the gridx and gridy property to the constraints that
         * will applied on the passed component to be set in the JPanel
         * according to the GridBagLayout and after that we add the passed
         * component and its constraints to the JPanel.
         */
        constraints.gridx = row;
        constraints.gridy = column;
        this.add(component, gridBagConstraints);
    }
}
