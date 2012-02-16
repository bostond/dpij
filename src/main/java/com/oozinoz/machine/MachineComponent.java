package com.oozinoz.machine;

import java.util.HashSet;
import java.util.Set;

/**
 * Challenge 5.2 (+class; + getMachineCount())
 * Challenge 5.3 (+isMachineUp(), +stopAll(), + getOwners())
 * Challenge 5.5 (+isTree(), +isTree(set:Set))
 * @author damien
 *
 */

public abstract class MachineComponent {
	
	protected int id;
	
	public MachineComponent() {
		
	}
	
	public MachineComponent(int id) {
		this.id = id;
	}
	
	
	public abstract int getMachineCount();
	public abstract boolean isMachineUp();
	public abstract void stopAll();
	public abstract Set<Engineer> getOwners();
	public abstract boolean isTree(Set<MachineComponent> visited);
	
	public boolean isTree() {
		return isTree(new HashSet<MachineComponent>());
	}
	
}
