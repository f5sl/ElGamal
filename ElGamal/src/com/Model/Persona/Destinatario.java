/**
 * 
 */
package com.Model.Persona;

import com.Model.ElGamalAlgorithm.PrivateKey;
import com.Model.ElGamalAlgorithm.PublicKey;

/**
 * Classe che modella un destinatario di messaggi
 * 
 * @author Alessandro
 *
 */
public class Destinatario extends Persona{
	
	//Attributi
	private PrivateKey _privateKey;
	private PublicKey _publicKey;
	
	/**
	 * Costruttore
	 */
	public Destinatario(){}
	/**
	 * Costruttore con parametro
	 * @param nome
	 */
	public Destinatario(String nome){
		super(nome);		
	}
	
	/**
	 * @return the _privateKey
	 */
	public PrivateKey get_privateKey() {
		return _privateKey;
	}

	/**
	 * @param _privateKey the _privateKey to set
	 */
	public void set_privateKey(PrivateKey _privateKey) {
		this._privateKey = _privateKey;
	}

	/**
	 * @return the _puPublicKey
	 */
	public PublicKey get_publicKey() {
		return _publicKey;
	}

	/**
	 * @param _puPublicKey the _puPublicKey to set
	 */
	public void set_publicKey(PublicKey _publicKey) {
		this._publicKey = _publicKey;
	}

}
