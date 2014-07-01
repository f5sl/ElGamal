/**
 * 
 */
package com.Model.Persona;

import java.util.ArrayList;

/**
 * Classe che modella un registro di mittenti
 * 
 * @author Alessandro
 *
 */
public class RegistroMittenti {
	
	private ArrayList<Mittente> _mittenti = new ArrayList<Mittente>();

	
	private static RegistroMittenti _instance= null;
	
	private RegistroMittenti(){
		
	}
	
	public static RegistroMittenti getInstance(){
		if(_instance ==null){
			_instance = new RegistroMittenti();
		}
		return _instance;
	}
	
	public Mittente getMittenteDaNome(String nome){
		Mittente mittente = new Mittente();
		
		for(int i = 0; i<_mittenti.size();i++){
			if(_mittenti.get(i).get_name().equals(nome)){
				mittente = _mittenti.get(i);
			}
		}
		return mittente;
		
	}
	
	public void addMittenteAlRegistro(Mittente mittente){
		this._mittenti.add(mittente);
	}
}
