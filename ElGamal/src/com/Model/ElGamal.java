/**
 * 
 */
package com.Model;

import java.math.BigInteger;

/**
 * Classe che implementa l'algoritmo di crittografia Elgamal
 *  
 * @author Alessandro
 *
 */
public class ElGamal {
	

	public ElGamal(){

	}
		
	/**
	 * Calcola R
	 * @param publicKey
	 * @param k
	 * @return
	 */
	private BigInteger calcolaR(PublicKey publicKey, int k){
		//Prendo alpha e p dalla chiave pubblica
		BigInteger alpha = publicKey.get_alpha();
		BigInteger p = publicKey.get_p();
		//Restituisco alpha elevato k modulo p
		return alpha.modPow(BigInteger.valueOf(k), p);
	}
	/**
	 * Calcola t
	 * @param publicKey
	 * @param messaggio
	 * @param k
	 * @return
	 */
	
	private BigInteger calcolaT(PublicKey publicKey, BigInteger messaggio, int k){
		//Recupero beta e p dalla chiave publica
		BigInteger beta = publicKey.get_beta();
		BigInteger p = publicKey.get_p();
		//calcolo t come beta alla alpha per m tutto modulo p
		return (beta.modPow(BigInteger.valueOf(k), p)).abs().multiply(messaggio).mod(p);
	}
	
	/**
	 * Metodo che restituisce il messaggio cifrato con l'algoritmo di ElGamal a partire da 
	 * un messaggio in chiaro
	 * 
	 * @param publicKey è la chiave pubblica con cui cifrare
	 * @param messaggio E' il messaggio in chiaro
	 * @param k è il k scelto da chi sta cifrando
	 * @return messaggio cifrato di ElGamal
	 */
	public ElGamalCypheredMessage cifra(PublicKey publicKey,int k, BigInteger message){
		BigInteger r = calcolaR(publicKey, k);
		BigInteger t = calcolaT(publicKey, message,k);
		ElGamalCypheredMessage cifrato = new ElGamalCypheredMessage(t, r);
		
		return cifrato;
	}
	/**
	 * 
	 * @param publicKey
	 * @param privateKey
	 * @param messaggioCifrato
	 * @return
	 */
	public BigInteger decifra(PublicKey publicKey,PrivateKey privateKey, ElGamalCypheredMessage messaggioCifrato){
		
		BigInteger t = messaggioCifrato.get_t();
		
		BigInteger r = messaggioCifrato.get_r();
		
		BigInteger p = publicKey.get_p();
		
		BigInteger a= privateKey.get_value();
		
		BigInteger exponent = p.subtract(BigInteger.valueOf(1)).subtract(a);
		
		BigInteger rToExp = r.modPow(exponent, p); 
		
		BigInteger messaggioDecifrato = t.multiply(rToExp).mod(p);
		
		return messaggioDecifrato;
	}
	
}
