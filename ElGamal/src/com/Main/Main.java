/**
 * 
 */
package com.Main;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.Model.ElGamal;
import com.Model.ElGamalCypheredMessage;
import com.Model.Persona;
import com.Model.Utility.AlgoritmoDiOrdinamento;
import com.Model.Utility.Factorizator;

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
		
		int k = 20;
		
		/*Persona bob = new Persona("Bob");
		
		System.out.println("Chiave privata: " + bob.get_privateKey().get_value());
		System.out.println("Chiave pubblica: " + "p->" + bob.get_publicKey().get_p() +"    alpha->" + bob.get_publicKey().get_alpha() +"   beta->" + bob.get_publicKey().get_beta());
		
		BigInteger message = BigInteger.valueOf(1500);
		
		ElGamal elGamal = new ElGamal();
		ElGamalCypheredMessage cypheredMessage = elGamal.cifra(bob.get_publicKey(), k, message);
		
		System.out.println("t->"+cypheredMessage.get_t() + "   r->" + cypheredMessage.get_r());
		
		BigInteger decypheredMessage = elGamal.decifra(bob.get_publicKey(), bob.get_privateKey(), cypheredMessage);
		
		System.out.println("Testo in chiaro: "+ decypheredMessage);
		
		*/
		
		String parola = "ciao";
		String parolaNumerica="";
		int n;
		n =parola.length();
		char[] arrayCaratteri = new char[n];
		Integer[] arrayNumeri = new Integer[n];
		for (int i =0; i<4;i++){
			arrayCaratteri[i] = parola.charAt(i);
			arrayNumeri[i]  = (int) Character.getNumericValue(arrayCaratteri[i]);
			parolaNumerica = parolaNumerica + String.valueOf(arrayNumeri[i]);
		}
		
		for (int j = 0; j<n;j++){
			
		}
		
		//int bella = Integer.getInteger(a);
		//a =String.valueOf(bella);
		
		BigInteger lol = new BigInteger(parolaNumerica);
		System.out.println(lol);
		//System.out.println(bella);
		System.out.println(parolaNumerica);
		
		//ElGamal elgamal = new ElGamal(BigInteger.valueOf(5), BigInteger.valueOf(3), BigInteger.valueOf(6),6);
		
		//ElGamalCypheredMessage  messaggioCifrato = elgamal.cifra(messaggio);
		
		//System.out.println(messaggioCifrato.get_t()+ " " + messaggioCifrato.get_r());
		
		//System.out.println("messaggio in chiaro " + elgamal.decifra(messaggioCifrato));
		
		
		
		
	}

}