import java.awt.Color;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class Menu {
    public Menu() {
    }
    
    public void openItem(javax.swing.JTextArea textArea){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.setFileFilter(filter);

        int response = fileChooser.showOpenDialog(null);

        if(response == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            Scanner fileIn = null;

            try {
                fileIn = new Scanner(file);
                if(file.isFile()) {
                    while(fileIn.hasNextLine()) {
                        String line = fileIn.nextLine()+"\n";
                        textArea.append(line);
                    }
                }
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            finally {
                fileIn.close();
            }
        }
    }
    
    public void saveItem(javax.swing.JTextArea textArea){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        int response = fileChooser.showSaveDialog(null);

        if(response == JFileChooser.APPROVE_OPTION) {
            File file;
            PrintWriter fileOut = null;

            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try {
                fileOut = new PrintWriter(file+".txt");
                fileOut.println(textArea.getText());
            } 
            catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            finally {
                fileOut.close();
            }   
        }
    }
    
    public void chooseFontColor(javax.swing.JTextArea textArea, javax.swing.JButton fontColorButton){
        JColorChooser colorChooser = new JColorChooser();

        Color color = colorChooser.showDialog(null, "Choose a color", Color.black);

        textArea.setForeground(color);
    }
}
