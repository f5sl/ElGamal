/**
 * 
 */
package com.Model.ElGamalAlgorithm.Message;

import com.Model.Client.ClienteElGamal;

/**
 * @author Alessandro
 *
 */
public class ElGamalMessage {

	//Clienti del messaggio
	private ClienteElGamal _mittente;
	private ClienteElGamal _destinatario;
	
	/**
	 * Costruttore 
	 */
	public ElGamalMessage(){
		
	}
	
	/**
	 * Costruttore con parametri
	 * @param mittente Mittente del messaggio
	 * @param destinatario Destinatario del messaggio
	 */
	public ElGamalMessage(ClienteElGamal mittente, ClienteElGamal destinatario){
		set_mittente(mittente);
		set_destinatario(destinatario);
	}	
	
	/**
	 * @return the _mittente
	 */
	public ClienteElGamal get_mittente() {
		return _mittente;
	}
	/**
	 * @param _mittente the _mittente to set
	 */
	public void set_mittente(ClienteElGamal _mittente) {
		this._mittente = _mittente;
	}
	/**
	 * @return the _destinatario
	 */
	public ClienteElGamal get_destinatario() {
		return _destinatario;
	}
	/**
	 * @param _destinatario the _destinatario to set
	 */
	public void set_destinatario(ClienteElGamal _destinatario) {
		this._destinatario = _destinatario;
	}
}
