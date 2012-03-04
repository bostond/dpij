package app.observer.ballistics2;

/*
 * Copyright (c) 2001, 2005. Steven J. Metsker.
 * 
 * Steve Metsker makes no representations or warranties about
 * the fitness of this software for any particular purpose, 
 * including the implied warranty of merchantability.
 *
 * Please use this software as you wish with the sole
 * restriction that you may not claim that you wrote it.
 */

import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.oozinoz.ballistics.BallisticsFunction;

/**
 * Challenge 9.2 (+class refactoring from Ballistics Panel, + mod constructor, + stateChanged())
 * @author bostond
 *
 */


public class BallisticsPanel2 extends JPanel implements ChangeListener{

	private static final long serialVersionUID = -5362245076385084847L;

	protected BallisticsFunction func;

    protected int nPoint = 101;

    protected double tPeak = 0.0;

    protected int[] x = new int[nPoint];

    protected int[] y = new int[nPoint];
    
    JSlider slider;

    /**
     * Create a panel that can display the provided function.
     * 
     * @param func
     *            the ballistics function to plot. Ballistics functions vary
     *            with time and with the time of peak burn area.
     */
    public BallisticsPanel2(BallisticsFunction func, JSlider slider) {
        this.func = func;
        this.slider = slider;
        slider.addChangeListener(this);
    }

    /**
     * Set the time at which the peak burn area is reached.
     * 
     * @param tPeak
     *            the time at which the peak burn area is reached
     */
    public void setTPeak(double tPeak) {
        this.tPeak = tPeak;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // paint the background
        for (int i = 0; i < nPoint; i++) {
            double t = ((double) i) / (nPoint - 1);
            x[i] = (int) (t * getWidth());
            y[i] = (int) (getHeight() * (1 - func.function(t, tPeak)));
        }
        g.drawPolyline(x, y, nPoint);
    }

	public void stateChanged(ChangeEvent e) {
		double val = slider.getValue();
		double tp = (val - slider.getMinimum() ) / (slider.getMaximum() - slider.getMinimum());
		setTPeak(tp);
		
	}
    
    
}