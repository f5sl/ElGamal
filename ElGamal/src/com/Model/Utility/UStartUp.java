/**
 * 
 */
package com.Model.Utility;

import com.Model.Persona.Destinatario;
import com.Model.Persona.Mittente;
import com.Model.Persona.RegistroMittenti;

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
		//Recupero il registro mittenti
		RegistroMittenti registroMittenti = RegistroMittenti.getInstance();
		//Aggiungo alice al registro mittenti
		registroMittenti.addMittenteAlRegistro(mittente);		
	}
}
