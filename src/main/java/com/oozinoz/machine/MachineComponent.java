package com.oozinoz.machine;

import java.util.HashSet;
import java.util.Set;

/**
 * Challenge 5.2 (+class; + getMachineCount())
 * Challenge 5.3 (+isMachineUp(), +stopAll(), + getOwners())
 * Challenge 5.5 (+isTree(), +isTree(set:Set))
 * Challenge 12.3 (+get/setParent(), +get/setResponsible())
 * @author bostond
 *
 */

public abstract class MachineComponent implements VisualizationItem {
	
	protected int id;
	protected MachineComponent parent;
	protected Engineer responsible;
	
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

	/**
	 * @return the parent
	 */
	public MachineComponent getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(MachineComponent parent) {
		this.parent = parent;
	}

	/**
	 * @return the responsible
	 */
	public Engineer getResponsible() {
		if (this.responsible != null) {
			return responsible;
		} else if (getParent() != null) {
			return getParent().getResponsible();
		} else {
			return null;
		}
	}

	/**
	 * @param responsible the responsible to set
	 */
	public void setResponsible(Engineer responsible) {
		this.responsible = responsible;
	}
	
	
	
	
}
