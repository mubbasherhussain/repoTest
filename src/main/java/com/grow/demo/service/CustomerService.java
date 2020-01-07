package com.grow.demo.service;

public class CustomerService {
	public static double getMultiplication(double i,double j) {
		try {
		validateInputs(i,j);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (i*j);
	}
	public static double getSubtraction(double i,double j) {
		try {
			validateInputs(i,j);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return (i-j);
	}
	public static boolean checkEqual(double i,double j) {
		try {
			validateInputs(i,j);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		if (i==j)
			return true;
		else
			return false;		
	}
	private static void validateInputs(double i,double j) throws Exception {
		if ((i==0.0)||(j==0.0))
		throw new Exception("Value cannot be 0 or null...");
	}
}
