import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.Action;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liams
 */
public class TextEditor extends javax.swing.JFrame implements ActionListener,Menu {
    /**
     * Creates new form NewJFrame
     */
    public TextEditor() {
        initComponents();
             
        this.setTitle("Group 5: Text Editor");
        jTextPane1.setMargin(new Insets(10,10,10,10));
        
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>());
        jComboBox1.setEditable(true);
        jComboBox1.addItem(6);
        jComboBox1.addItem(7);
        jComboBox1.addItem(8);
        jComboBox1.addItem(9);
        jComboBox1.addItem(10);
        jComboBox1.addItem(10.5);
        jComboBox1.addItem(11);
        jComboBox1.addItem(12);
        jComboBox1.addItem(13);
        jComboBox1.addItem(14);
        jComboBox1.addItem(15);
        jComboBox1.addItem(16);
        jComboBox1.addItem(18);
        jComboBox1.addItem(20);
        jComboBox1.addItem(22);
        jComboBox1.addItem(24);
        jComboBox1.addItem(26);
        jComboBox1.addItem(28);
        jComboBox1.addItem(32);
        jComboBox1.addItem(36);
        jComboBox1.addItem(40);
        jComboBox1.addItem(44);
        jComboBox1.addItem(48);
        jComboBox1.addItem(54);
        jComboBox1.addItem(60);
        jComboBox1.addItem(66);
        jComboBox1.addItem(72);
        
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(fonts));
        jComboBox2.setSelectedItem("Times New Roman");
     
        jComboBox1.addActionListener(this);
        jComboBox2.addActionListener(this);  
    }
    
    public javax.swing.JComboBox getComboBox1() {
        return jComboBox1;
    }
    
    public javax.swing.JComboBox getComboBox2() {
        return jComboBox2;
    }
    
    public javax.swing.JTextPane getTextPane() {
        return jTextPane1;
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        Action font = new FontAndSizeAction();
        if (evt.getSource().equals(jComboBox1)) {
            font.actionPerformed(evt);
        } else if (evt.getSource().equals(jComboBox2)) {
            font.actionPerformed(evt);
        }
    }
    
    @Override
    public void openItem(javax.swing.JTextPane textArea){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.setFileFilter(filter);
        
        int response = fileChooser.showOpenDialog(null);

        if(response == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

            try {
                FileReader fr = new FileReader(file);
                while(fr.read() != -1){
                    textArea.read(fr, null);
                }
                fr.close();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
    
    @Override
    public void saveItem(javax.swing.JTextPane textArea){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        int response = fileChooser.showSaveDialog(null);

        if(response == JFileChooser.APPROVE_OPTION) {
            File file;
            PrintWriter fileOut = null;

            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try {
                fileOut = new PrintWriter(file);
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
    
    @Override
    public void exitItem(){
        System.exit(0);
    }
    
    @Override
    public void chooseFontColor(javax.swing.JTextPane textArea, javax.swing.JButton fontColorButton){
        JColorChooser colorChooser = new JColorChooser();

        Color color = colorChooser.showDialog(null, "Choose a color", Color.black);

        textArea.setForeground(color);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jCheckBox1 = new javax.swing.JCheckBox();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        openFile = new javax.swing.JMenuItem();
        saveFile = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenuItem1.setText("jMenuItem1");

        jMenuItem3.setText("jMenuItem3");

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Font size: ");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Font:");

        jButton1.setText("Color");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPane1);

        jButton2.setText("Bold");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Italicize");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton4.setText("FontChange");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jMenuBar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jMenu3.setBackground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("File");
        jMenu3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        openFile.setText("Open");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        jMenu3.add(openFile);

        saveFile.setText("Save");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        jMenu3.add(saveFile);

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu3.add(exit);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(82, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButton4))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        openItem(jTextPane1);
    }//GEN-LAST:event_openFileActionPerformed
     
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        exitItem();
    }//GEN-LAST:event_exitActionPerformed

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        saveItem(jTextPane1);
    }//GEN-LAST:event_saveFileActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        chooseFontColor(jTextPane1, jButton1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Action boldAction = new BoldAction();
        boldAction.actionPerformed(evt);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Action italicAction = new ItalicAction();
        italicAction.actionPerformed(evt);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Action font = new FontAndSizeAction();
        font.actionPerformed(evt);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextEditor().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JMenuItem saveFile;
    // End of variables declaration//GEN-END:variables
}
