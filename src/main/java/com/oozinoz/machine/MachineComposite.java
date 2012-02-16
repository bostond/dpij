package com.oozinoz.machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  Challenge 5.2 (+class; + getMachineCount())
 *  Challenge 5.3 (+isMachineUp(), +stopAll(), + getOwners())
 *  Challenge 5.5 (+isTree(set:Set))
 *  
 * @author damien
 *
 */

public class MachineComposite extends MachineComponent {

	private List<MachineComponent> components; 
	
	public MachineComposite(int id) {
		super(id);
		this.components = new ArrayList<MachineComponent>();
	}

	/*
	 * (non-Javadoc)
	 * @see com.oozinoz.machine.MachineComponent#getMachineCount()
	 */
	@Override
	public int getMachineCount() {
		int count = 0;
		
		for (MachineComponent component: components) {
			count += component.getMachineCount();
		}
		
		return count;			
	}

	/* (non-Javadoc)
	 * @see com.oozinoz.machine.MachineComponent#isMachineUp()
	 */
	@Override
	public boolean isMachineUp() {
		for (MachineComponent component: components) {
			if (! component.isMachineUp()) {
				return false;
			}
		}
		
		return true;
	}

	/* (non-Javadoc)
	 * @see com.oozinoz.machine.MachineComponent#stopAll()
	 */
	@Override
	public void stopAll() {
		for (MachineComponent component: components) {
			component.stopAll();
		}
		
	}

	/* (non-Javadoc)
	 * @see com.oozinoz.machine.MachineComponent#getOwners()
	 */
	@Override
	public Set<Engineer> getOwners() {
		Set<Engineer> engineers = new HashSet<Engineer>();
		for (MachineComponent component: components) {
			engineers.addAll(component.getOwners());
		}
		
		return Collections.unmodifiableSet(engineers);
	}
	
	/* (non-Javadoc)
	 * @see com.oozinoz.machine.MachineComponent#isTree(java.util.Set)
	 */
	@Override
	public boolean isTree(Set<MachineComponent> visited) {
		visited.add(this);
		
		for (MachineComponent component: components) {
			if (visited.contains( component ) || ! isTree(visited)) {
				return false;
			}
		}
		
		return true;
	}

	
	
}
