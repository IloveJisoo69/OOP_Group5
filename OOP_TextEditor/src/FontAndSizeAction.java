import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
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
public class FontAndSizeAction extends StyledEditorKit.StyledTextAction {
    private boolean accept = false;
    private TextEditor option; 
    private Font fonts = new Font();
    JDialog formatText;
    JComboBox fontFamilyChooser;
    JComboBox fontSizeChooser;
    
    public FontAndSizeAction() {
        super("Font and Size");
    }
    
    @Override
    public String toString() {
        return "Font and Size";
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        JTextPane editor = (JTextPane) getEditor(e);
//        System.out.print(editor);
//        int p0 = editor.getSelectionStart();
//        StyledDocument doc = getStyledDocument(editor);
//        Element paragraph = doc.getCharacterElement(p0);
//        AttributeSet as = paragraph.getAttributes();
//        
//        fonts.setFontFamily(StyleConstants.getFontFamily(as));
//        fonts.setFontSize(StyleConstants.getFontSize(as));
//        
//        if (e.getSource().equals(option.getComboBox1())) {
//            accept = true;
//            fonts.setFontSize((option.getComboBox1().getSelectedItem()));
//        } else if (e.getSource().equals(option.getComboBox2())) {
//            accept = true;
//            fonts.setFontFamily((option.getComboBox2().getSelectedItem()));
//        }
//
//        MutableAttributeSet attr = null;
//        if (editor != null && accept) {
//            attr = new SimpleAttributeSet();
//            StyleConstants.setFontFamily(attr, fonts.getFontFamily());
//            StyleConstants.setFontSize(attr, fonts.getFontSize());
//            setCharacterAttributes(editor, attr, false);
//        }


        JTextPane editor = (JTextPane) getEditor(e);
        System.out.println(editor);
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

        JPanel fontFamilyPanel = new JPanel();
        fontFamilyPanel.add(new JLabel("Font"));

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = ge.getAvailableFontFamilyNames();

        fontFamilyChooser = new JComboBox();
        for (int i = 0; i < fontNames.length; i++) {
          fontFamilyChooser.addItem(fontNames[i]);
        }
        fontFamilyChooser.setSelectedItem(fonts.getFontFamily());
        fontFamilyPanel.add(fontFamilyChooser);
        choosers.add(fontFamilyPanel);

        JPanel fontSizePanel = new JPanel();
        fontSizePanel.add(new JLabel("Size"));
        fontSizeChooser = new JComboBox();
        fontSizeChooser.setEditable(true);
        fontSizeChooser.addItem(4);
        fontSizeChooser.addItem(8);
        fontSizeChooser.addItem(12);
        fontSizeChooser.addItem(16);
        fontSizeChooser.addItem(20);
        fontSizeChooser.addItem(24);
        fontSizeChooser.setSelectedItem(new Float(fonts.getFontSize()));
        fontSizePanel.add(fontSizeChooser);
        choosers.add(fontSizePanel);

        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent ae) {
            accept = true;
            formatText.dispose();
            fonts.setFontFamily((String) fontFamilyChooser.getSelectedItem());
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
          StyleConstants.setFontFamily(attr, fonts.getFontFamily());
          StyleConstants.setFontSize(attr, (int) fonts.getFontSize());
          setCharacterAttributes(editor, attr, false);
        }

    }   
}
