import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
/**
 * This program demonstrates how to resize an image.
 *
 * @author www.codejava.net
 *
 */
public class ImageResizer {
    File picFile;
    
    public static ImageIcon resize(File picFile){
        ImageIcon icon = new ImageIcon(picFile.toString());
        Image image = icon.getImage();
        Image image2 = image.getScaledInstance(500,350,java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(image2);
        
        return icon;
    }
}
