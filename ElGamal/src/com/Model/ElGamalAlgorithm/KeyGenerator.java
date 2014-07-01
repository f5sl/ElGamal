/**
 * 
 */
package com.Model.ElGamalAlgorithm;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Random;

import com.Model.Utility.PrimitiveRootFinder;

/**
 * Classe che genera le chiavi
 * 
 * @author Alessandro
 *
 */
public class KeyGenerator {
	
	// Numero di bit massimo del numero primo p
	int _pLength = 32;
	//Valore massimo di a, chive privata
	int _limitForInt_a = 20;
	//elemento random che serve per generare a
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
	 * @return Mappa che contiene la coppia di chiave pubblica-privata
	 */
	public HashMap<String , Object> generateKey(){
		
		//Struttura dati in cui mettere le chiavi
		HashMap<String, Object> chiavi =  new HashMap<String, Object>();
		
		//Numero scelto per la chiave privata
		BigInteger a = BigInteger.valueOf(rnd.nextInt(_limitForInt_a));

		//Chiave privata		
		PrivateKey privateKey = new PrivateKey(a);		
		
		//Chiave pubblica
		
		//Genero un probabile primo p
		BigInteger p = BigInteger.probablePrime(_pLength, rnd);		
		//Calcolo una radice primitiva modulo p
		BigInteger alpha =PrimitiveRootFinder.findPrimitiveRoot(p);
		//Calcolo beta come alpha alla a modulo p
		BigInteger beta = (alpha.modPow(a, p));		
		
		//Istanzio una chiave pubblica con p, alpha e beta
		PublicKey publicKey = new PublicKey(p, alpha, beta);
		
		//Aggiungo le chiavi alla mappa che poi verrà restituita
		chiavi.put("private", privateKey);
		chiavi.put("public", publicKey);
		
		return chiavi;
	}
}
