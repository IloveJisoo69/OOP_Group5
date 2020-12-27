/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.*;

/**
 *
 * @author Ignacio
 */
public class ForegroundAction extends StyledEditorKit.StyledTextAction {
  private static final long serialVersionUID = 6384632651737400352L;

  JColorChooser colorChooser = new JColorChooser();

  JDialog dialog = new JDialog();

  boolean noChange = false;

  boolean cancelled = false;

  public ForegroundAction() {
    super("foreground");

  }

  public void actionPerformed(ActionEvent e) {
    JTextPane editor = (JTextPane) getEditor(e);

    if (editor == null) {
      JOptionPane.showMessageDialog(null,
          "You need to select the editor pane before you can change the color.", "Error",
          JOptionPane.ERROR_MESSAGE);
      return;
    }
    int p0 = editor.getSelectionStart();
    StyledDocument doc = getStyledDocument(editor);
    Element paragraph = doc.getCharacterElement(p0);
    AttributeSet as = paragraph.getAttributes();
    fg = StyleConstants.getForeground(as);
    if (fg == null) {
      fg = Color.BLACK;
    }
    colorChooser.setColor(fg);

    JButton accept = new JButton("OK");
    accept.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        fg = colorChooser.getColor();
        dialog.dispose();
      }
    });

    JButton cancel = new JButton("Cancel");
    cancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        cancelled = true;
        dialog.dispose();
      }
    });

    JButton none = new JButton("None");
    none.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        noChange = true;
        dialog.dispose();
      }
    });

    JPanel buttons = new JPanel();
    buttons.add(accept);
    buttons.add(none);
    buttons.add(cancel);

    dialog.getContentPane().setLayout(new BorderLayout());
    dialog.getContentPane().add(colorChooser, BorderLayout.CENTER);
    dialog.getContentPane().add(buttons, BorderLayout.SOUTH);
    dialog.setModal(true);
    dialog.pack();
    dialog.setVisible(true);

    if (!cancelled) {

      MutableAttributeSet attr = null;
      if (editor != null) {
        if (fg != null && !noChange) {
          attr = new SimpleAttributeSet();
          StyleConstants.setForeground(attr, fg);
          setCharacterAttributes(editor, attr, false);
        }
      }
    }// end if color != null
    noChange = false;
    cancelled = false;
  }

  private Color fg;
}
