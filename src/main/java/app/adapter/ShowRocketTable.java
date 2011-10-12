package app.adapter;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableModel;

import com.oozinoz.firework.Rocket;
import com.oozinoz.utility.Dollars;

/**
 * 
 * @author bostond
 * Challenge 3.5
 * 
 * 10/11/2011
 *
 */

public class ShowRocketTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		setFonts();
		JTable table = new JTable(getRocketTable());
		table.setRowHeight(36);
		JScrollPane pane = new JScrollPane(table);
		pane.setPreferredSize(new Dimension(300, 100));
		display(pane, "Rockets");

	}
	
	public static void display( Component c, String title) {
		JFrame frame = new JFrame(title);
		frame.getContentPane().add(c);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static TableModel getRocketTable() {
		Rocket rocket1 = new Rocket("Shooter", 1.0, new Dollars(3.95d), 50.0, 4.5);
		Rocket rocket2 = new Rocket("Orbit", 4.0, new Dollars(33.95d), 5000, 3.2);
		
		return new RocketTableModel( new Rocket[] { rocket1, rocket2 } );
	}
	
	private static void setFonts() {
		Font font = new Font("Dialog", Font.PLAIN, 18);
		UIManager.put("Table Font", font);
		UIManager.put("TableHeader.font", font);
	}

}
