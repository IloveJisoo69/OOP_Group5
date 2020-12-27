/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.*;

/**
 *
 * @author Ignacio
 */
public class FontAndSizeAction extends StyledEditorKit.StyledTextAction {
  private static final long serialVersionUID = 584531387732416339L;

  private String family;

  private float fontSize;

  JDialog formatText;

  private boolean accept = false;

  JComboBox fontFamilyChooser;

  JComboBox fontSizeChooser;

  public FontAndSizeAction() {
    super("Font and Size");
  }

  public String toString() {
    return "Font and Size";
  }

  public void actionPerformed(ActionEvent e) {
    System.out.println(e);
    JTextPane editor = (JTextPane) getEditor(e);
    System.out.println(editor);
    int p0 = editor.getSelectionStart();
    StyledDocument doc = getStyledDocument(editor);
    Element paragraph = doc.getCharacterElement(p0);
    AttributeSet as = paragraph.getAttributes();

    family = StyleConstants.getFontFamily(as);
    fontSize = StyleConstants.getFontSize(as);

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
    fontFamilyChooser.setSelectedItem(family);
    fontFamilyPanel.add(fontFamilyChooser);
    choosers.add(fontFamilyPanel);

    JPanel fontSizePanel = new JPanel();
    fontSizePanel.add(new JLabel("Size"));
    fontSizeChooser = new JComboBox();
    fontSizeChooser.setEditable(true);
    fontSizeChooser.addItem(new Float(4));
    fontSizeChooser.addItem(new Float(8));
    fontSizeChooser.addItem(new Float(12));
    fontSizeChooser.addItem(new Float(16));
    fontSizeChooser.addItem(new Float(20));
    fontSizeChooser.addItem(new Float(24));
    fontSizeChooser.setSelectedItem(new Float(fontSize));
    fontSizePanel.add(fontSizeChooser);
    choosers.add(fontSizePanel);

    JButton ok = new JButton("OK");
    ok.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        accept = true;
        formatText.dispose();
        family = (String) fontFamilyChooser.getSelectedItem();
        fontSize = Float.parseFloat(fontSizeChooser.getSelectedItem().toString());
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
      StyleConstants.setFontFamily(attr, family);
      StyleConstants.setFontSize(attr, (int) fontSize);
      setCharacterAttributes(editor, attr, false);
    }

  }
}
