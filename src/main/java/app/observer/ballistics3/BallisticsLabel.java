package app.observer.ballistics3;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import com.oozinoz.utility.Format;

/**
 * Challenge 9.5 (Refactor from BallisticsLabel2: - stateChanged(), + Observer, + update();
 * @author bostond
 *
 */

public class BallisticsLabel extends JLabel implements Observer {

	private static final long serialVersionUID = 2114291615177029238L;

	public BallisticsLabel() {
		super();
		setText(Format.formatToNPlaces(0, 2));
	}

	public void update(Observable o, Object arg) {
		
		if (o instanceof Tpeak) {
			Tpeak peak = (Tpeak) o;
		
			setText(Format.formatToNPlaces(peak.getValue(), 2));
		} 
		
	}
	
	
	
	

}
