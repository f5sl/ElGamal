/**
 * 
 */
package com.Model.Utility;

import java.math.BigInteger;


/**
 * Classe responsabile di convertitore stringhe di testo, che rappresentano parole, in BigInteger e viceversa
 * 
 * @author Alessandro
 *
 */
public class Convertitore{
	/**
	 * Metodo che crea un BigInteger a partire da una stringa
	 * @param testo
	 * @return BigInteger corrispondente
	 */
	public static BigInteger convertiStringaInBigInteger(String testo){
		//Creo un biginteger a partire dalla stringa
		return new BigInteger(testo.getBytes());
		
	}
	/**
	 * Metodo che restituisce una stringa testuale a partire dal biginteger
	 * @param bigInteger
	 * @return String corrispondente
	 */
	public static String convertiBigIntegerInStringa(BigInteger bigInteger){		
		//Creo una stringa a partire dal bigInteger passato
		return new String(bigInteger.toByteArray());
		
	}

}
