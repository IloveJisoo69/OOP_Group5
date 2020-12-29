import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ignacio
 */
public class FontFamilyOnlyAction implements ItemListener {
    private JComboBox jComboBox;
    private Font font;
    private JTextPane jTextPane;
    
    public FontFamilyOnlyAction(Font font, JComboBox jComboBox, JTextPane jTextPane) {
        this.jComboBox = jComboBox;
        this.font = font;
        this.jTextPane = jTextPane;
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if ((e.getStateChange() != ItemEvent.SELECTED)) {
                return;
        }
        font.setFontFamily((String) e.getItem());
        jComboBox.setAction(new StyledEditorKit.FontFamilyAction(font.getFontFamily(), font.getFontFamily()));	
        jTextPane.requestFocusInWindow();
    }
}
