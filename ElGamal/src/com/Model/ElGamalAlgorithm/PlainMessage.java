/**
 * 
 */
package com.Model.ElGamalAlgorithm;

/**
 * Classe che modella un messaggio in chiaro
 * @author Alessandro
 *
 */
public class PlainMessage {
	
	//Attributi
	private String _message;
	
	/**
	 * Costruttore di default
	 */
	public PlainMessage(){}
	
	/**
	 * Costruttore con parametro
	 * @param message
	 */
	public PlainMessage(String message){
		this.set_message(message);
	}

	/**
	 * @return the _message
	 */
	public String get_message() {
		return _message;
	}

	/**
	 * @param _message the _message to set
	 */
	public void set_message(String _message) {
		this._message = _message;
	}
	
	

}
