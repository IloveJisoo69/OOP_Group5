import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.LineBorder;
import java.util.Random;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liams
 */
public class PictureAction extends ImageResizer implements ActionListener{
    JTextPane editor__;
    JFrame frame__;
    
    public PictureAction(JTextPane editor__, JFrame frame__) {
        this.editor__ = editor__;
        this.frame__ = frame__;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
		
	File pictureFile = choosePictureFile();
			
	if (pictureFile == null) {
		editor__.requestFocusInWindow();
		return;
	}
			
	ImageIcon icon = ImageResizer.resize(pictureFile);
	JButton picButton = new JButton(icon);
	picButton.setBorder(new LineBorder(Color.WHITE));
	picButton.setMargin(new Insets(0,0,0,0));
	picButton.setAlignmentY(.9f);
	picButton.setAlignmentX(.9f);
	picButton.setName("PICTURE_ID_" + new Random().nextInt());
	editor__.insertComponent(picButton);
	editor__.requestFocusInWindow();
    }
		
    private File choosePictureFile() {
	JFileChooser chooser = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG, JPG & GIF Images", "png", "jpg", "gif");
	chooser.setFileFilter(filter);
			
	if (chooser.showOpenDialog(frame__) == JFileChooser.APPROVE_OPTION) {
		return chooser.getSelectedFile();
	}
	else {
		return null;
	}
    }
}
