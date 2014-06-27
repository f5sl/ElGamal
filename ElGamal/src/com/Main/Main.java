/**
 * 
 */
package com.Main;

import java.math.BigInteger;

import com.Model.ElGamal;
import com.Model.ElGamalCypheredMessage;

/**
 * 
 * @author Alessandro
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger messaggio = BigInteger.valueOf(2);
		ElGamal elgamal = new ElGamal(BigInteger.valueOf(5), BigInteger.valueOf(3), BigInteger.valueOf(6),6);
		
		ElGamalCypheredMessage  messaggioCifrato = elgamal.cifra(messaggio);
		
		System.out.print(messaggioCifrato.get_t()+ " " + messaggioCifrato.get_r());
	}

}
