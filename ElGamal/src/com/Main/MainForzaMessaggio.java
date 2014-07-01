/**
 * 
 */
package com.Main;

import java.math.BigInteger;

import javax.swing.text.AbstractDocument.BranchElement;

import com.Model.Break.Breaker;
import com.Model.ElGamalAlgorithm.ElGamalCypheredMessage;
import com.Model.ElGamalAlgorithm.ElGamalMachine;
import com.Model.ElGamalAlgorithm.PlainMessage;
import com.Model.Persona.Persona;

/**
 * @author Alessandro
 *
 */
public class MainForzaMessaggio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*int k = 20;
		
		Persona bob = new Persona("Bob");
		
		System.out.println("Chiave privata: " + bob.get_privateKey().get_value());
		System.out.println("Chiave pubblica: " + "p->" + bob.get_publicKey().get_p() +"    alpha->" + bob.get_publicKey().get_alpha() +"   beta->" + bob.get_publicKey().get_beta());
		
		BigInteger message1 = BigInteger.valueOf(500);
		
		PlainMessage messaggio2testuale = new PlainMessage("a");
		
		BigInteger message2 = new BigInteger(messaggio2testuale.get_message().getBytes());
		
		System.out.println("messaggio 2 testuale =" + new String(message2.toByteArray()));
		
		ElGamalMachine elGamalMachine = new ElGamalMachine();
		ElGamalCypheredMessage cypheredMessage1 = elGamalMachine.cifra(bob.get_publicKey(), message1,k);
		
		ElGamalCypheredMessage cypheredMessage2 = elGamalMachine.cifra(bob.get_publicKey(), message2,k);
		
		System.out.println("t->"+cypheredMessage1.get_t() + "   r->" + cypheredMessage1.get_r());
		
		System.out.println("t->"+cypheredMessage2.get_t() + "   r->" + cypheredMessage2.get_r());
		
		//BigInteger decypheredMessage = elGamal.decifra(bob.get_publicKey(), bob.get_privateKey(), cypheredMessage1);
		
		//System.out.println("Testo in chiaro: "+ decypheredMessage);
		
		PlainMessage messaggioDecifrato1 = new PlainMessage(new String(message1.toByteArray()));
		
		PlainMessage messaggioForzato2 = Breaker.forzaMessaggioDaMessaggioNoto(bob.get_publicKey(), cypheredMessage1, cypheredMessage2, messaggioDecifrato1);
		
		System.out.print(messaggioForzato2.get_message());*/
		
		
		int k = 20;
		Persona bob = new Persona("Bob");
		
		System.out.println("Chiave privata: " + bob.get_privateKey().get_value());
		System.out.println("Chiave pubblica: " + "p->" + bob.get_publicKey().get_p() +"    alpha->" + bob.get_publicKey().get_alpha() +"   beta->" + bob.get_publicKey().get_beta());
		
		PlainMessage messaggio2testuale = new PlainMessage("CIAO");
		
		BigInteger message2 = new BigInteger(messaggio2testuale.get_message().getBytes());
		
		ElGamalMachine elGamalMachine = new ElGamalMachine();
		
		ElGamalCypheredMessage cypheredMessage2 = elGamalMachine.cifra(bob.get_publicKey(), message2,k);
		
		System.out.println("t->"+cypheredMessage2.get_t() + "   r->" + cypheredMessage2.get_r());
		
		PlainMessage messaggioForzato = Breaker.forzaMessaggioConLogaritmoDiscreto(bob.get_publicKey(), cypheredMessage2);
		
		System.out.print(messaggioForzato.get_message());
		
	}

}
