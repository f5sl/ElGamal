/**
 * 
 */
package com.Main;

import java.math.BigInteger;

import com.Model.ElGamal;
import com.Model.ElGamalCypheredMessage;
import com.Model.Persona;

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
		
		int k = 6;
		
		Persona bob = new Persona("Bob");
		
		System.out.println("Chiave privata: " + bob.get_privateKey().get_value());
		System.out.println("Chiave pubblica: " + "p->" + bob.get_publicKey().get_p() +"    alpha->" + bob.get_publicKey().get_alpha() +"   beta->" + bob.get_publicKey().get_beta());
		
		BigInteger message = BigInteger.valueOf(2);
		
		ElGamal elGamal = new ElGamal();
		ElGamalCypheredMessage cypheredMessage = elGamal.cifra(bob.get_publicKey(), k, message);
		
		System.out.println("t->"+cypheredMessage.get_t() + "   r->" + cypheredMessage.get_r());
		
		BigInteger decypheredMessage = elGamal.decifra(bob.get_publicKey(), bob.get_privateKey(), cypheredMessage);
		
		System.out.println("Testo in chiaro: "+ decypheredMessage);
		//ElGamal elgamal = new ElGamal(BigInteger.valueOf(5), BigInteger.valueOf(3), BigInteger.valueOf(6),6);
		
		//ElGamalCypheredMessage  messaggioCifrato = elgamal.cifra(messaggio);
		
		//System.out.println(messaggioCifrato.get_t()+ " " + messaggioCifrato.get_r());
		
		//System.out.println("messaggio in chiaro " + elgamal.decifra(messaggioCifrato));
	}

}