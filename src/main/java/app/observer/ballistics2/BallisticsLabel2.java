package app.observer.ballistics2;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.oozinoz.utility.Format;

/**
 * Challenge 9.2 (+class, +constructor, + stateChanged())
 * @author bostond
 *
 */

public class BallisticsLabel2 extends JLabel implements ChangeListener{

	private static final long serialVersionUID = -2514658174790765964L;
	private JSlider slider;
	
	public BallisticsLabel2(JSlider slider) {
		super();
		this.slider = slider;
		this.slider.addChangeListener(this);
		setText(Format.formatToNPlaces(slider.getMinimum(), 2));
	}
	
	public void stateChanged(ChangeEvent e) {
		double val = slider.getValue();
		double tp = (val - slider.getMinimum() ) / (slider.getMaximum() - slider.getMinimum());
		setText(Format.formatToNPlaces(tp, 2));
		
	}
	
	

}
