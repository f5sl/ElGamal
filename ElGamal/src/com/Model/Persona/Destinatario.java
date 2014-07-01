/**
 * 
 */
package com.Model.Persona;

import java.util.HashMap;

import com.Model.ElGamalAlgorithm.KeyGenerator;
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
	 * Metodo che assegna una chiave al destinatario
	 */
	public void richiediChiave(){
		//Recupero il generatore di chiavi e me ne faccio restituire una coppia pubblica-privata
		HashMap<String, Object> chiavi = KeyGenerator.getInstance().generateKey();
		//Setto le chiavi
		_publicKey = (PublicKey) chiavi.get("public");
		_privateKey = (PrivateKey) chiavi.get("private");
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
