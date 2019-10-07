/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presenceanddeparturesystem;

import visualClasses.MainVisualComponent;
import helperclasses.ScreenSize;
import javax.swing.JFrame;

/**
 *
 * @author Abdelhalim
 */
public class MainScreen extends JFrame {

    public MainScreen() {
        this.setLocation(ScreenSize.getWidth(10), ScreenSize.getHeight(10));
        this.setSize(ScreenSize.getWidth(75), ScreenSize.getHeight(75));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.add(new MainVisualComponent());
    }
}
