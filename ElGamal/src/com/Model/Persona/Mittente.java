/**
 * 
 */
package com.Model.Persona;

/**
 * Classe che modella un mittente di messaggi
 * 
 * @author Alessandro
 *
 */
public class Mittente extends Persona {
	
	//Attributi
	private Destinatario _destinatario;
	
	/**
	 * Costruttore
	 */
	public Mittente(){}
	
	/**
	 * Costruttore con parametro
	 * @param name
	 */
	public Mittente(String name){
		super(name);
	}

	/**
	 * @return the _destinatario
	 */
	public Destinatario get_destinatario() {
		return _destinatario;
	}

	/**
	 * @param _destinatario the _destinatario to set
	 */
	public void set_destinatario(Destinatario _destinatario) {
		this._destinatario = _destinatario;
	}

}
