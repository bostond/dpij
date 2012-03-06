package com.oozinoz.remote;

import java.rmi.Naming;

/**
 * Challenge 11.4 (+class)
 * @author bostond
 *
 */

public class RegisterRocket {
	
	public static void main(String[] args) {
		
		try {
			Rocket biggie = new RocketImpl(29.95, 820);
			Naming.bind("rmi://localhost:5000/Biggie", biggie);
			System.out.println("Registered biggie");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
