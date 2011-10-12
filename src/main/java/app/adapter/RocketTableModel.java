package app.adapter;

import javax.swing.table.AbstractTableModel;

import com.oozinoz.firework.Rocket;

/**
 * 
 * @author bostond
 * Challenge 3.2
 * 
 * 10/11/2011
 *
 */

public class RocketTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 357198610501471105L;
	protected Rocket[] rockets;
	protected String[] columnNames = { "Name", "Price", "Apogee" };
	
	public RocketTableModel( Rocket[] rockets) {
		this.rockets = rockets;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	public int getColumnCount() {
		if (columnNames == null) {
			return 0;
		} else {
			return columnNames.length;
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	public int getRowCount() {
		if (rockets == null) {
			return 0;
		} else {
			return rockets.length;
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {

		switch (columnIndex) {
			case 0: 
				return rockets[rowIndex].getName();
			case 1: 
				return rockets[rowIndex].getPrice();
			case 2: 
				return rockets[rowIndex].getApogee();
			default: 
				return null;
		}
	
	}
	
	
	
}