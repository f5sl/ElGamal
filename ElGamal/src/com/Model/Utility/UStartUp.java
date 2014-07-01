/**
 * 
 */
package com.Model.Utility;

import com.Model.ElGamalAlgorithm.ElGamalMachine;
import com.Model.Persona.Destinatario;
import com.Model.Persona.Mittente;

/**
 * Classe che ha il compito di inizializzare gli oggetti sw del sistema, al suo avvio
 * @author Alessandro
 *
 */
public class UStartUp {
	
	/**
	 * Metodo che inizializza gli oggetti dello strato di dominio
	 */
	public static void inizializza(){
		//Creo il destinatario
		Destinatario destinatario = new Destinatario("Bob");
		//Creo il mittente
		Mittente mittente = new Mittente("Alice");
		//Setto il destinatario al mittente, perchè un mittente deve conoscere colui a cui vuole mandare un messaggio
		mittente.set_destinatario(destinatario);
		
		//Recupero l'unica istanza della macchina di elgamal
		ElGamalMachine elgamal = ElGamalMachine.getInstance();
		//Setto il mittente come utente della macchina
		elgamal.set_utente(mittente);
		
	}

}
