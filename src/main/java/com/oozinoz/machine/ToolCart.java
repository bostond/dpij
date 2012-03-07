package com.oozinoz.machine;

/**
 * Challenge 12.3 (+class)
 * @author bostond
 *
 */

public class ToolCart implements VisualizationItem {

	private Engineer responsible;
		
	/**
	 * @param responsible the responsible to set
	 */
	public void setResponsible(Engineer responsible) {
		this.responsible = responsible;
	}

	public Engineer getResponsible() {
		return responsible;
	}
	

}
