package app.observer.ballistics3;

import java.util.Observable;

/**
 * Challenge 9.4 (+class)
 * @author bostond
 *
 */

public class Tpeak extends Observable {
	
	private double value;
	
	public Tpeak( double value ) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
		setChanged();
		notifyObservers();
	}
 
	
	
	

}
