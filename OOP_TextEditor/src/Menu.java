import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.io.File;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liams
 */
abstract class Menu extends javax.swing.JFrame {
    JFrame frame__;
    JTextPane editor__;
    File file__;
    
    public Menu() {
    }
    
    public Menu(JFrame frame__) {
        this.frame__ = frame__;
    }
    
    public abstract void openItem(JTextPane editor__);
    public abstract void saveItem(JTextPane editor__);
    public abstract void exitItem();
    public  abstract File chooseFile();
}
