/**
 * 
 */
package com.Model.ElGamalCryptosystem.Message;

import com.Model.Client.ElGamalClient;

/**
 * @author Alessandro
 *
 */
public class ElGamalMessage {

	//Clienti del messaggio
	private ElGamalClient _mittente;
	private ElGamalClient _destinatario;
	
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
	public ElGamalMessage(ElGamalClient mittente, ElGamalClient destinatario){
		set_mittente(mittente);
		set_destinatario(destinatario);
	}	
	
	/**
	 * @return the _mittente
	 */
	public ElGamalClient get_mittente() {
		return _mittente;
	}
	/**
	 * @param _mittente the _mittente to set
	 */
	public void set_mittente(ElGamalClient _mittente) {
		this._mittente = _mittente;
	}
	/**
	 * @return the _destinatario
	 */
	public ElGamalClient get_destinatario() {
		return _destinatario;
	}
	/**
	 * @param _destinatario the _destinatario to set
	 */
	public void set_destinatario(ElGamalClient _destinatario) {
		this._destinatario = _destinatario;
	}
}
