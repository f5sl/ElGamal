/**
 * 
 */
package com.Model.Persona;

/**
 * Classe che modella una persona
 * 
 * @author Alessandro
 *
 */
public class Persona {
	
	//Attributi
	private String _name;	
	
	/**
	 * Costruttore di default
	 */
	public Persona(){}
	
	/**
	 * Costruttore avanzato
	 * @param name
	 */
	public Persona(String name){
		//Setto il nome
		this.set_name(name);	
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

}
