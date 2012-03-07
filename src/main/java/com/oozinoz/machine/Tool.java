package com.oozinoz.machine;

/**
 * Challenge 12.3 (+class)
 * @author bostond
 *
 */

public class Tool implements VisualizationItem {

	private ToolCart cart;

	/**
	 * @return the cart
	 */
	public ToolCart getCart() {
		return cart;
	}

	/**
	 * @param cart the cart to set
	 */
	public void setCart(ToolCart cart) {
		this.cart = cart;
	}

	public Engineer getResponsible() {
		return cart.getResponsible();
	}

	
	
}
