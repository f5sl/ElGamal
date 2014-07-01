/**
 * 
 */
package com.Model.ElGamalAlgorithm;

import java.math.BigInteger;

import com.Model.Persona.Mittente;

/**
 * Classe che implementa l'algoritmo di crittografia Elgamal
 *  
 * @author Alessandro
 *
 */
public class ElGamalMachine {
	
	//Attributi
	
	Mittente _utente;
	
	/**
	 * Pattern Singleton
	 */
	
	private static ElGamalMachine instance =null;
	
	/**
	 * Costruttore privato
	 */
	private ElGamalMachine(){

	}
	/**
	 * Metodo che restituisce l'unica istanza della macchina di ElGamal
	 * @return
	 */
	public static ElGamalMachine getInstance(){
		if(instance ==null){
			instance = new ElGamalMachine();
		}
		return instance;
	}	
		
	/**
	 * Calcola R
	 * @param publicKey
	 * @param k
	 * @return r
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
	 * @return t
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
	public ElGamalCypheredMessage cifra(PublicKey publicKey, BigInteger message,int k){
		//Calcolo r
		BigInteger r = calcolaR(publicKey, k);
		//calcolo t
		BigInteger t = calcolaT(publicKey, message,k);
		//creo il messaggio cifrato
		ElGamalCypheredMessage cifrato = new ElGamalCypheredMessage(t, r);
		//Restituisco il messaggio cifratp
		return cifrato;
	}
	/**
	 * Metodo che decifra un messaggio cifrato con ElGamal
	 * @param publicKey Chiave pubblica con cui è stato cifrato il messaggio
	 * @param privateKey Chiave privata con cui decifrare, associata alla chiave pubblica
	 * @param messaggioCifrato	Messaggio da decifrare
	 * @return	Messaggio decifrato
	 */
	public BigInteger decifra(PublicKey publicKey,PrivateKey privateKey, ElGamalCypheredMessage messaggioCifrato){
		//Recupero t ed r dal messaggio cifrato
		BigInteger t = messaggioCifrato.get_t();		
		BigInteger r = messaggioCifrato.get_r();
		//Recupero p dalla chiave pubblica
		BigInteger p = publicKey.get_p();
		//Recupero a dalla chiave privata
		BigInteger a= privateKey.get_value();
		//L'esponente è calcolato come (p-1-a)
		BigInteger exponent = p.subtract(BigInteger.valueOf(1)).subtract(a);
		//Calcolo r alla -a
		BigInteger rToExp = r.modPow(exponent, p); 
		//moltiplico per t ed ottengo il messaggio in chiaro
		BigInteger messaggioDecifrato = t.multiply(rToExp).mod(p);
		//Restituisco il messaggio decifrato
		return messaggioDecifrato;
	}
	/**
	 * @return the _utente
	 */
	public Mittente get_utente() {
		return _utente;
	}
	/**
	 * @param _utente the _utente to set
	 */
	public void set_utente(Mittente _utente) {
		this._utente = _utente;
	}
	
}
