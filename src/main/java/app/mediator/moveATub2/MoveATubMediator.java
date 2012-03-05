package app.mediator.moveATub2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Refactored from MoveATub. Challenges 10.1 and 10.2 we exercised on what would
 * change, but didn't ask for an implementation.
 * @author bostond
 *
 */

public class MoveATubMediator implements ActionListener, ListSelectionListener {

	private MoveATub2 gui =null;
	private NameBase data = null;
	
	private Object selectedMachine = null;
	private Object selectedTub = null;
	
	
	
	public MoveATubMediator(MoveATub2 gui, NameBase data) {
		this.gui = gui;
		
		gui.assignButton().addActionListener(this);
		gui.boxList().addListSelectionListener(this);
		gui.machineList().addListSelectionListener(this);
		gui.tubList().addListSelectionListener(this);
		
		this.data = data;
	}

	/**
	 * Upon notification of UI change: if the list changed is the 
	 * source machine list, update the tub list with the selected machine's
	 * tubs, and set the selected machine value; if the list selected is the tub list, 
	 * set the selected tub value; if the list is the destination machine
	 * list, update the selected destination machine value 
	 */
	public void valueChanged(ListSelectionEvent e) {
		JList sender = (JList) e.getSource();

		if (!sender.isSelectionEmpty()) {
			if (sender.equals(gui.boxList())) {
				updateTubList(sender.getSelectedValue().toString());
				updateMachineList(sender.getSelectedValue().toString()); // don't include the source machine in the destination machine list
			}

			if (sender.equals(gui.machineList())) 
				selectedMachine = sender.getSelectedValue();

			if (sender.equals(gui.tubList())) 
				selectedTub = sender.getSelectedValue();
		}

		gui.assignButton().setEnabled(
				!gui.tubList().isSelectionEmpty() && !gui.machineList().isSelectionEmpty());
	}

	/**
	 * Make selected changes - move tub across machines, then update GUI to 
	 * reflect that the tub is now gone from the selected machine, then
	 * disable move button.
	 */
	public void actionPerformed(ActionEvent e) {
		if (selectedMachine == null || selectedTub == null) return;
		String tubName = selectedTub.toString();
		String fromMachineName = data.getMachineContaining(tubName);
		String toMachineName = selectedMachine.toString();
		data.put(tubName, toMachineName);
		
		updateTubList(fromMachineName);
		
		gui.assignButton().setEnabled(false);
	}
	
	public void updateTubList(String machinename) {
		gui.tubList().setListData(data.tubNames(machinename));
	}
	
	public void updateMachineList(String machinename) {
		Object[] targets = data.boxes();
		Object[] selectableBoxes = new Object[targets.length - 1];
		int position = 0;
		for (Object o : targets) {
			if (! o.equals(machinename)) {
				selectableBoxes[position++] = o;
			}
		}
		gui.machineList().setListData(selectableBoxes);
	}
	
	
	
}
