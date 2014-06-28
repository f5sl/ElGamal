/**
 * 
 */
package com.Main;

import java.math.BigInteger;

import com.Model.Utility.PrimitiveRootFinder;

/**
 * @author Alessandro
 *
 */
public class MainPrimitiveRoot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		BigInteger p = BigInteger.valueOf(11);
		
		BigInteger primitiveRoot = PrimitiveRootFinder.findPrimitiveRoot(p);
		
		//System.out.print(primitiveRoot);

	}

}
