package com.oozinoz.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * Challenge 11.4 (+class)
 * @author bostond
 *
 */

public interface Rocket extends Remote {

	void boost(double factor) throws RemoteException;
	double getApogee() throws RemoteException;
	double getPrice() throws RemoteException;
	
}
