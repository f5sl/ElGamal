/**
 * 
 */
package com.Model.Utility;

import java.math.BigInteger;


/**Classe responsabile di convertitore stringhe, interi e BigInteger
 * @author Alessandro
 *
 */
public class Convertitore {
	/**
	 * 
	 * @param stringa
	 * @return
	 */
	public String convertiTestoInStringaInteri(String stringa){
		int n;
		String stringaNumerica ="";
		n =stringa.length();
		char[] arrayCaratteri = new char[n];
		Integer[] arrayNumeri = new Integer[n];
		for (int i =0; i<4;i++){
			arrayCaratteri[i] = stringa.charAt(i);
			arrayNumeri[i]  = (int) Character.getNumericValue(arrayCaratteri[i]);
			stringaNumerica = stringaNumerica + String.valueOf(arrayNumeri[i]);
		}
		
		return stringaNumerica;
		
	}
	/**
	 * 
	 * @param stringaNumerica
	 * @return
	 */
	public String convertiStringaInteriInTesto(String stringaNumerica){
		
		String stringa="";

		return stringa;
	}
	/**
	 * 
	 * @param stringa
	 * @return
	 */
	public BigInteger convertiStringaInBigInteger(String stringa){
		
		BigInteger bigInteger = new BigInteger(convertiTestoInStringaInteri(stringa));
		
		return bigInteger;
		
	}
	/**
	 * 
	 * @param bigInteger
	 * @return
	 */
	public String convertiBigIntegerInStringa(BigInteger bigInteger){
		
		String stringa ="";
		
		String stringaBigInteger = bigInteger.toString();
		
		
		
		return stringa;
		
	}

}
