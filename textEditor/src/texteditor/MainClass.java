/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.awt.BorderLayout;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.swing.text.StyledEditorKit.ItalicAction;

/**
 *
 * @author Ignacio
 */
public class MainClass {
    public MainClass() {
    JFrame frame = new JFrame();
    JTextPane textPane = new JTextPane();
    JScrollPane scrollPane = new JScrollPane(textPane);

    JPanel north = new JPanel();

    JMenuBar menu = new JMenuBar();
    JMenu styleMenu = new JMenu();
    styleMenu.setText("Style");

    Action boldAction = new BoldAction();
    boldAction.putValue(Action.NAME, "Bold");
    styleMenu.add(boldAction);

    Action italicAction = new ItalicAction();
    italicAction.putValue(Action.NAME, "Italic");
    styleMenu.add(italicAction);

    Action foregroundAction = new ForegroundAction();
    foregroundAction.putValue(Action.NAME, "Color");
    styleMenu.add(foregroundAction);

    Action formatTextAction = new FontAndSizeAction();
    formatTextAction.putValue(Action.NAME, "Font and Size");
    styleMenu.add(formatTextAction);

    menu.add(styleMenu);

    north.add(menu);
    frame.getContentPane().setLayout(new BorderLayout());
    frame.getContentPane().add(north, BorderLayout.NORTH);
    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    frame.setSize(800, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
