package com.oozinoz.businessCore;

/**
 * 
 * Challenge 8.3 (+class; +recordWipMove implementation) 
 * @author bostond
 *
 */

public class Factory {
	
	private static Factory factory;
	private static Object classLock = Factory.class;
	
	private long wipMoves;
	
	private Factory() {
		wipMoves = 0;
	}
	
	public static Factory getFactory() {
		
		synchronized (classLock) {
			if (factory == null) {
				factory = new Factory();
			}
			
			return factory;
		}
	}
	
	public void recordWipMove() {
		synchronized (classLock) {
			wipMoves++;
		}
	}
}
