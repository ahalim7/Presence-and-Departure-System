/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helperclasses;
import java.awt.Toolkit;
/**
 *
 * @author Abdelhalim
 */
public class ScreenSize {
    
    static Toolkit toolkit = Toolkit.getDefaultToolkit();
    
    public static int getWidth(int percentage){
        return ((int)toolkit.getScreenSize().getWidth() * percentage / 100);
    }
    
    public static int getHeight(int percentage){
        return ((int) toolkit.getScreenSize().getHeight() * percentage / 100);
    }
}
