/**
 * 
 */
package com.Model.Utility;

import java.math.BigInteger;

/**
 * Classe di utilità che raccoglie funzioni di utilità generale
 * @author Alessandro
 *
 */
public class Utility {
	
	/**
	 * Costruttore
	 */
	public Utility(){		
	}
	
	/**
	 * Metodo che trova la radice quadrata di un numero n
	 * @param n Numero di cui si vuole trovare la radice quadrata
	 * @return Radice quadrata del numero
	 */
	public BigInteger sqrt(BigInteger n) {
		BigInteger a = BigInteger.ONE;
		BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
		while(b.compareTo(a) >= 0) {
			BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
			if(mid.multiply(mid).compareTo(n) > 0) b = mid.subtract(BigInteger.ONE);
			else a = mid.add(BigInteger.ONE);
		}
		return a.subtract(BigInteger.ONE);
	}

}
