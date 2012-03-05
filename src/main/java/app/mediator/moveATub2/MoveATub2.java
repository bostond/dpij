package app.mediator.moveATub2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.oozinoz.ui.SwingFacade;
import com.oozinoz.ui.UI;

/**
 * Refactored from MoveATub. Challenges 10.1 and 10.2 we exercised on what would
 * change, but didn't ask for an implementation.
 * @author bostond
 *
 */

public class MoveATub2 extends JPanel {

	private static final long serialVersionUID = 8462238486128857207L;

	private JButton assignButton;
	
	private JList boxList;
	private JList tubList;
	private JList machineList; 
	
    private UI ui = UI.NORMAL;
	
    private NameBase data = new NameBase();
    private MoveATubMediator mediator;
    
    public static void main(String[] args) {
        JFrame frame = SwingFacade.launch(new MoveATub2(), "Move a Tub2");
        frame.setSize(600, 250);
        frame.validate();
    }

    public MoveATub2() {
        super(new GridLayout(1, 4));
        setFont(ui.getFont());
        
        this.mediator = new MoveATubMediator(this, data);

        this.add(labeledPanel("From Machine...", boxList()));
        this.add(labeledPanel("Move Tub...", tubList()));
        this.add(labeledPanel("To Machine...", machineList()));
        this.add(buttonPanel(assignButton()));
    }
    
    private Component buttonPanel(JButton button) {
        JPanel result = new JPanel(new GridLayout(3, 1));
        result.add(new JLabel(" "));

        JPanel innerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        innerPanel.add(button);
        result.add(innerPanel);

        result.add(new JLabel(" "));
        return result;
    }

    private Component labeledPanel(String label, JList list) {
        JPanel result = new JPanel(new BorderLayout());
        result.add(new JLabel(label), BorderLayout.NORTH);
        result.add(new JScrollPane(list), BorderLayout.CENTER);

        int borderWidth = 15;
        result.setBorder(BorderFactory.createEmptyBorder(borderWidth, borderWidth, borderWidth, borderWidth));

        return result;
    }
    
	public JButton assignButton() {
		if (assignButton == null) {
            assignButton = new JButton("Do it!");
            assignButton.setEnabled(false);
        }
        return assignButton;
	}
	
	public JList boxList() {
        if (boxList == null) {
            boxList = ui.createList(data.boxes());
        }
        return boxList;
	}
	
	public JList machineList() {
        if (machineList == null) {
        	machineList = ui.createList(data.boxes());
        }
        return machineList;
	}
	
    public JList tubList() {
        if (tubList == null) {
            tubList = ui.createList(new String[] {});
        }
        return tubList;
    }
	
}
