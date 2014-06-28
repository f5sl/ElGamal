/**
 * 
 */
package com.Main;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

import com.Model.Factorization.Factorizator;
import com.Utility.AlgoritmoDiOrdinamento;

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
		
		/*int k = 6;
		
		Persona bob = new Persona("Bob");
		
		System.out.println("Chiave privata: " + bob.get_privateKey().get_value());
		System.out.println("Chiave pubblica: " + "p->" + bob.get_publicKey().get_p() +"    alpha->" + bob.get_publicKey().get_alpha() +"   beta->" + bob.get_publicKey().get_beta());
		
		BigInteger message = BigInteger.valueOf(2);
		
		ElGamal elGamal = new ElGamal();
		ElGamalCypheredMessage cypheredMessage = elGamal.cifra(bob.get_publicKey(), k, message);
		
		System.out.println("t->"+cypheredMessage.get_t() + "   r->" + cypheredMessage.get_r());
		
		BigInteger decypheredMessage = elGamal.decifra(bob.get_publicKey(), bob.get_privateKey(), cypheredMessage);
		
		System.out.println("Testo in chiaro: "+ decypheredMessage);*/
		//ElGamal elgamal = new ElGamal(BigInteger.valueOf(5), BigInteger.valueOf(3), BigInteger.valueOf(6),6);
		
		//ElGamalCypheredMessage  messaggioCifrato = elgamal.cifra(messaggio);
		
		//System.out.println(messaggioCifrato.get_t()+ " " + messaggioCifrato.get_r());
		
		//System.out.println("messaggio in chiaro " + elgamal.decifra(messaggioCifrato));
		
		
		Factorizator fattorizzatore = new Factorizator();
		
		ArrayList<BigInteger> divisori = fattorizzatore.divisoriNumeroAvanzato(BigInteger.valueOf(1024));
		
		for (Iterator<BigInteger> iterator = divisori.iterator(); iterator.hasNext();) {
			BigInteger bigInteger = (BigInteger) iterator.next();
			System.out.println(bigInteger);
		}
		
		divisori =AlgoritmoDiOrdinamento.ordinaSenzaDuplicati(divisori);
		System.out.println("BELLAAAAAAA");
		for (Iterator<BigInteger> iterator = divisori.iterator(); iterator.hasNext();) {
			BigInteger bigInteger = (BigInteger) iterator.next();
			System.out.println(bigInteger);
		}
		System.out.println(divisori.size());
		
		/*ArrayList<BigInteger> fattori =fattorizzatore.fattorizza(BigInteger.valueOf(840));
		System.out.println("Elenco fattori primi:");
		for (Iterator<BigInteger> iterator = fattori.iterator(); iterator.hasNext();) {
			BigInteger fattore = (BigInteger) iterator.next();
			
			System.out.println("fattore:  "+fattore);
		}
		
		ArrayList<BigInteger> appoggio = fattorizzatore.calcolaDivisoriDiUnNumeroDaFattori(fattori);
		
		
		

		
		
		
		
		appoggio.add(BigInteger.valueOf(1));
		
		for (Iterator<BigInteger> iterator = appoggio.iterator(); iterator.hasNext();) {
			BigInteger bigInteger = (BigInteger) iterator.next();
			System.out.println(bigInteger);
		}
		
		appoggio = AlgoritmoDiOrdinamento.ordina(appoggio);
		
		System.out.println("Array ordinato:");
		for (Iterator<BigInteger> iterator = appoggio.iterator(); iterator.hasNext();) {
			BigInteger bigInteger = (BigInteger) iterator.next();
			
			System.out.println(bigInteger);
		}
		
		appoggio = AlgoritmoDiOrdinamento.ordinaSenzaDuplicati(appoggio);
		System.out.println("Array senza duplicati:");
		for (Iterator<BigInteger> iterator = appoggio.iterator(); iterator.hasNext();) {
			BigInteger bigInteger = (BigInteger) iterator.next();
			
			System.out.println(bigInteger);
		}
		
		
		System.out.println("dimensione array = "+appoggio.size());
		
	 

		*/

		
		
		
		
	}

}