/**
 * 
 */
package com.Model.Utility;

import com.Model.Client.ClienteElGamal;
import com.Model.Client.RegistroClientiElGamal;

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
		//Creo due clienti
		ClienteElGamal bob = new ClienteElGamal("Bob");
		ClienteElGamal alice = new ClienteElGamal("Alice");
		//Recupero il registro clienti
		RegistroClientiElGamal registroClientiElGamal = RegistroClientiElGamal.getInstance();
		//Aggiungo alice e bob al registro clienti
		registroClientiElGamal.addClienteElGamalAlRegistro(alice);
		registroClientiElGamal.addClienteElGamalAlRegistro(bob);	
	}
}
