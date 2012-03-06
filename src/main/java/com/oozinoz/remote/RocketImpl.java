package com.oozinoz.remote;

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



import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * This class demonstrates how to implement an RMI interface.
 * @author Steven J. Metsker
 */

public class RocketImpl extends UnicastRemoteObject implements Rocket {

	private static final long serialVersionUID = -2167075272445692070L;
	private double price;
	private double apogee;
	
	public RocketImpl(double price, double apogee) throws RemoteException {
		
		this.price = price;
		this.apogee = apogee;
		
	}


	public void boost(double factor) throws RemoteException {
		apogee *= factor;
		
	}

	public double getApogee() throws RemoteException {
		return apogee;
	}

	public double getPrice() throws RemoteException {
		return price;
	}

}
