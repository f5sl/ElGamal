/**
 * 
 */
package com.Model.Client;

import java.util.HashMap;

import com.Model.ElGamalCryptosystem.Key.KeyGenerator;
import com.Model.ElGamalCryptosystem.Key.PrivateKey;
import com.Model.ElGamalCryptosystem.Key.PublicKey;

/**
 * Classe che modella un cliente del crittosistema ElGamal
 * 
 * @author Alessandro
 *
 */
public class ElGamalClient {
	
	//Attributi
	private String _name;
	
	//Attributi
	private PrivateKey _privateKey;
	private PublicKey _publicKey;

	/**
	 * Costruttore di default
	 */
	public ElGamalClient(){}
	
	/**
	 * Costruttore avanzato
	 * @param name
	 */
	public ElGamalClient(String name){
		//Setto il nome
		this.set_name(name);	
	}
	
	/**
	 * Metodo con cui il destinatario recupera una coppia di chiavi pubblica e privata
	 */
	public void richiediChiave(){
		//Recupero il generatore di chiavi e me ne faccio restituire una coppia pubblica-privata
		HashMap<String, Object> chiavi = KeyGenerator.getInstance().generateKey();
		//Setto le chiavi
		_publicKey = (PublicKey) chiavi.get("public");
		_privateKey = (PrivateKey) chiavi.get("private");
	}

	/**
	 * @return the _name
	 */
	public String get_name() {
		return _name;
	}

	/**
	 * @param _name the _name to set
	 */
	public void set_name(String _name) {
		this._name = _name;
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
