package com.oozinoz.machine;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Challenge 5.2 (+class; + getMachineCount())
 * Challenge 5.3 (+isMachineUp(), +stopAll(), + getOwners())
 * Challenge 5.5 (+isTree(set:Set))
 * @author damien
 *
 */

public class Machine  extends MachineComponent {

	private boolean up;
	private Set<Engineer> engineers;
	
	public Machine(int id) {
		super(id);
		this.up = true;
		this.engineers = new HashSet<Engineer>();
	}
	
	/* (non-Javadoc)
	 * @see com.oozinoz.machine.MachineComponent#getMachineCount()
	 */
	@Override
	public int getMachineCount() {
		return 1;
	}

	/* (non-Javadoc)
	 * @see com.oozinoz.machine.MachineComponent#isMachineUp()
	 */
	@Override
	public boolean isMachineUp() {
		return this.up;
	}

	/* (non-Javadoc)
	 * @see com.oozinoz.machine.MachineComponent#stopAll()
	 */
	@Override
	public void stopAll() {
		this.up = false;
		
	}

	/* (non-Javadoc)
	 * @see com.oozinoz.machine.MachineComponent#getOwners()
	 */
	@Override
	public Set<Engineer> getOwners() {
		return Collections.unmodifiableSet(this.engineers);
	}

	/* (non-Javadoc)
	 * @see com.oozinoz.machine.MachineComponent#isTree(java.util.Set)
	 */
	@Override
	public boolean isTree(Set<MachineComponent> visited) {
		visited.add(this);
		return true;
	}

	
	
	
}
