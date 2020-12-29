import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;
import javax.swing.text.StyledEditorKit.AlignmentAction;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liams
 */
public class AlignAction implements ItemListener {
    JComboBox jComboBox3;
    
    public AlignAction(JComboBox jComboBox3) {
        this.jComboBox3 = jComboBox3;
    }
    
    public AlignAction(String alignmentStr, int newAlignment) {
    }
       
    @Override
    public void itemStateChanged(ItemEvent e) {

	if ((e.getStateChange() != ItemEvent.SELECTED) || (jComboBox3.getSelectedIndex() == 0)) {
            return;
	}
			
	String alignmentStr = (String) e.getItem();			
	int newAlignment = jComboBox3.getSelectedIndex() - 1;
	// ALIGN_LEFT 0, ALIGN_CENTER 1, ALIGN_RIGHT 2, ALIGN_JUSTIFIED 3
	jComboBox3.setAction(new AlignmentAction(alignmentStr, newAlignment));
    }
}
