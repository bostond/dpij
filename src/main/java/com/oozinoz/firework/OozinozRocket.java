package com.oozinoz.firework;

import com.oozinoz.simulation.RocketSim;

/**
 * 
 * @author bostond
 * Challenge 3.2
 * 
 * 10/6/2011
 *
 */

public class OozinozRocket extends PhysicalRocket implements RocketSim{
	
	private double time;
	
	public OozinozRocket(double burnArea, double burnRate, double fuelMass,
			double totalMass) {
		super(burnArea, burnRate, fuelMass, totalMass);
	}

	/* (non-Javadoc)
	 * @see com.oozinoz.simulation.RocketSim#getMass()
	 */
	public double getMass() {
		return super.getMass(time);
	}

	/* (non-Javadoc)
	 * @see com.oozinoz.simulation.RocketSim#getThrust()
	 */
	public double getThrust() {
		return super.getThrust(time);
	}

	/* (non-Javadoc)
	 * @see com.oozinoz.simulation.RocketSim#setSimTime(double)
	 */
	public void setSimTime(double t) {
		this.time = t;
	}
	
	

}
