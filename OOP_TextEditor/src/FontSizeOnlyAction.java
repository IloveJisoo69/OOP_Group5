import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
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
public class FontSizeOnlyAction extends StyledEditorKit.StyledTextAction {
    private boolean accept = false;
    private final Font fonts = new Font();
    JDialog formatText;
    JComboBox fontSizeChooser;
    
    public FontSizeOnlyAction() {
        super("Font and Size");
    }
    
    @Override
    public String toString() {
        return "Font and Size";
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextPane editor = (JTextPane) getEditor(e);
        int p0 = editor.getSelectionStart();
        StyledDocument doc = getStyledDocument(editor);
        Element paragraph = doc.getCharacterElement(p0);
        AttributeSet as = paragraph.getAttributes();

        fonts.setFontFamily(StyleConstants.getFontFamily(as));
        fonts.setFontSize(StyleConstants.getFontSize(as));

        formatText = new JDialog(new JFrame(), "Font and Size", true);
        formatText.getContentPane().setLayout(new BorderLayout());

        JPanel choosers = new JPanel();
        choosers.setLayout(new GridLayout(2, 1));

        JPanel fontSizePanel = new JPanel();
        fontSizePanel.add(new JLabel("Size"));
        fontSizeChooser = new JComboBox();
        fontSizeChooser.setEditable(false);
        fontSizeChooser.addItem(4);
        fontSizeChooser.addItem(8);
        fontSizeChooser.addItem(12);
        fontSizeChooser.addItem(16);
        fontSizeChooser.addItem(20);
        fontSizeChooser.addItem(24);
        fontSizeChooser.addItem(28);
        fontSizeChooser.addItem(32);
        fontSizeChooser.addItem(36);
        fontSizeChooser.addItem(40);
        fontSizeChooser.addItem(46);
        fontSizeChooser.addItem(54);
        fontSizeChooser.addItem(60);
        fontSizeChooser.addItem(72);
        fontSizeChooser.setSelectedItem(new Float(fonts.getFontSize()));
        fontSizePanel.add(fontSizeChooser);
        choosers.add(fontSizePanel);

        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                accept = true;
                formatText.dispose();
                fonts.setFontSize(Integer.parseInt(fontSizeChooser.getSelectedItem().toString()));
            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                formatText.dispose();
            }
        });

        JPanel buttons = new JPanel();
        buttons.add(ok);
        buttons.add(cancel);
        formatText.getContentPane().add(choosers, BorderLayout.CENTER);
        formatText.getContentPane().add(buttons, BorderLayout.SOUTH);
        formatText.pack();
        formatText.setVisible(true);

        MutableAttributeSet attr = null;
        if (editor != null && accept) {
            attr = new SimpleAttributeSet();
            StyleConstants.setFontSize(attr, (int) fonts.getFontSize());
            setCharacterAttributes(editor, attr, false);
        }
    }   
    
    
    
}
