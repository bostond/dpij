package app.observer.ballistics3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.oozinoz.ballistics.Ballistics;
import com.oozinoz.ui.SwingFacade;

/**
 * Challenge 9.5 +class refactoring from ShowBallistics2, + get/setPeak(), + new Listener in slider(), 
 *    mod getLabel() getPanels() to register as Observers ) 
 * @author bostond
 *
 */

public class ShowBallistics3 {
    
	
	private BallisticsPanel burnPanel;
	private BallisticsPanel thrustPanel;
	private JSlider slider;
	private JLabel valueLabel;
	private int sliderMin;
	private int sliderMax;
	private Tpeak peak;
	
    public Tpeak getPeak() {
    	if (peak == null) {
    		peak = new Tpeak(0.0);
    	}
		return peak;
	}

	public void setPeak(Tpeak peak) {
		this.peak = peak;
	}

	protected BallisticsPanel burnPanel() {
        if (burnPanel == null) {
            burnPanel = new BallisticsPanel(Ballistics.rate());
            burnPanel.setPreferredSize(new Dimension(300, 200));
            Tpeak peak = getPeak();
            peak.addObserver(burnPanel);
        }
        return burnPanel;
    }

    protected BallisticsPanel thrustPanel() {
        if (thrustPanel == null) {
            thrustPanel = new BallisticsPanel(Ballistics.thrust());
            thrustPanel.setPreferredSize(new Dimension(300, 200));
            Tpeak peak = getPeak();
            peak.addObserver(thrustPanel);
        }
        return thrustPanel;
    }
	
	public JSlider slider() {
		if (slider == null) {
			slider = new JSlider();
			sliderMin = slider.getMinimum();
			sliderMax = slider.getMaximum();
			
			slider.addChangeListener( new ChangeListener() {
				
				public void stateChanged(ChangeEvent e) {
					double val = slider.getValue();
					double tp = (val - sliderMin ) / (sliderMax - sliderMin);
					Tpeak p = getPeak();
					p.setValue(tp);
					
					
					// bug here. Not updating....
				}
			});
			
			slider.setValue(sliderMin);
		}
		
		return slider;
	}
	
	private JLabel valueLabel() {
		if (this.valueLabel == null) {
			valueLabel = new BallisticsLabel();
			valueLabel.setFont(SwingFacade.getStandardFont());
			valueLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
            valueLabel.setForeground(java.awt.Color.black);
            
            peak.addObserver((BallisticsLabel) valueLabel);
		}
		return this.valueLabel;
	}
	
	
    /** Provided by text author **/
	
	/**
     * Show the standard burn rate and thrust equations.
     */
    public static void main(String[] args) {
        SwingFacade.launch(new ShowBallistics3().mainPanel(),
                "Effects of tPeak");
    }
    
    /*
     * The main panel -- the one that actually gets displayed.
     */
    protected JPanel mainPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(curvePanel(), "Center");
        p.add(sliderBox(), "South");
        return p;
    }
    
    /*
     * The box that holds the slider plus a textual label and a changing label
     * that shows the value of the slider.
     */
    protected Box sliderBox() {
        Box b = Box.createHorizontalBox();
        JLabel label = new JLabel("tPeak");
        label.setFont(SwingFacade.getStandardFont());
        label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        label.setForeground(java.awt.Color.black);
        b.add(label);
        b.add(valueLabel());
        b.add(slider());
        return b;
    }
    
    /*
     * A panel to contain the two plots.
     */
    protected JPanel curvePanel() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 2));
        p.add(SwingFacade.createTitledPanel("Burn Rate", burnPanel()));
        p.add(SwingFacade.createTitledPanel("Thrust", thrustPanel()));
        return p;
    }

}
