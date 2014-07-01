/**
 * 
 */
package com.Model.ElGamalAlgorithm;

import java.math.BigInteger;

import com.Model.Persona.Destinatario;
import com.Model.Utility.Convertitore;

/**
 * Classe che implementa l'algoritmo di crittografia Elgamal
 *  
 * @author Alessandro
 *
 */
public class ElGamalMachine {
	
	/**
	 * Costruttore
	 */
	public ElGamalMachine(){

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
	 * @param messaggio E' il messaggio in chiaro
	 * @param k è il k scelto da chi sta cifrando
	 * @return messaggio cifrato di ElGamal
	 */
	public ElGamalCypheredMessage cifra(Destinatario destinatario,BigInteger message,int k){
		//Recupero la chiave pubblica del destinatario
		PublicKey publicKey = destinatario.get_publicKey();
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
	 * @param destinatario Persona che ha ricevuto il messaggio cifrato
	 * @param messaggioCifrato è il messaggio da decifrare
	 * @return	Messaggio decifrato
	 */
	public PlainMessage decifra(Destinatario destinatario, ElGamalCypheredMessage messaggioCifrato){
		//Recupero le informazioni sul destinatario
		PublicKey publicKey = destinatario.get_publicKey();
		PrivateKey privateKey = destinatario.get_privateKey();
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
		
		//String md = Convertitore.convertiBigIntegerInStringa(messaggioDecifrato);
		//Creo un plainMessage da restitiure a bob
		PlainMessage messaggioTestuale =  new PlainMessage(messaggioDecifrato);

		//Restituisco il messaggio decifrato
		return messaggioTestuale;
	}
	
}
