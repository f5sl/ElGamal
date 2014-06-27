/**
 * 
 */
package com.Model;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Random;

/**
 * Classe che genera le chiavi
 * 
 * @author Alessandro
 *
 */
public class KeyGenerator {
	
	int _pLength = 10;
	
	int _limitForInt_a = 20;
	
	Random rnd = new Random();
	
	/**
	 * Pattern Singleton
	 */
	
	private static KeyGenerator instance;
	
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private KeyGenerator(){
			
	}
	/**
	 * Metodo che ritorna l'unica istanza del generatore di chiavi - Pattern Singleton
	 * @return
	 */
	public static KeyGenerator getInstance() {
		if (instance == null){
			instance = new KeyGenerator();
		}
		return instance;		
	}
	/**
	 * Metodo che restituisce una mappa contenente la chiave privata e quella pubblica associata
	 * @return
	 */
	public HashMap<String , Object> generateKey(){
		
		//Struttura dati in cui mettere le chiavi
		HashMap<String, Object> chiavi =  new HashMap<String, Object>();
		
		//Numero scelto per la chiave privata
		//BigInteger a = BigInteger.valueOf(rnd.nextInt(_limitForInt_a));
		BigInteger  a= BigInteger.valueOf(6);
		//Chiave privata		
		PrivateKey privateKey = new PrivateKey(a);
		
		
		//BigInteger p = BigInteger.probablePrime(_pLength, rnd);
		
		//TODO sviluppare algoritmo per generare p ed alfa radice primitiva mod p
		
		BigInteger p = BigInteger.valueOf(5);
		
		BigInteger alpha = BigInteger.valueOf(3);
		
		PublicKey publicKey = new PublicKey(p, alpha, privateKey.get_value());
		
		//Aggiungo le chiavi alla mappa che poi verrà restituita
		chiavi.put("private", privateKey);
		chiavi.put("public", publicKey);
		
		return chiavi;
	}
	

}
