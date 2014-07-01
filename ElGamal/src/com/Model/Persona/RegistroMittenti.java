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
	
	//Attributi
	private ArrayList<Mittente> _mittenti = new ArrayList<Mittente>();
	
	/**
	 * Attributo istanza - Pattern Singleton
	 */
	private static RegistroMittenti _instance= null;
	
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private RegistroMittenti(){
		
	}
	
	/**
	 * Metodo che restituisce l'unica istanza dle registro mittenti - Pattern Singleton
	 * @return Istanza del registro mittenti
	 */
	public static RegistroMittenti getInstance(){
		if(_instance ==null){
			_instance = new RegistroMittenti();
		}
		return _instance;
	}
	
	/**
	 * Metodo che restituisce un mittente dal suo nome
	 * @param nome Nome del mittente di un messaggio
	 * @return Mittente
	 */
	public Mittente getMittenteDaNome(String nome){
		//Istanzio un mittente
		Mittente mittente = new Mittente();
		//Ciclo sull'array dei mittenti
		for(int i = 0; i<_mittenti.size();i++){
			//Recupero il mittente con il nome inserito
			if(_mittenti.get(i).get_name().equals(nome)){
				mittente = _mittenti.get(i);
			}
		}
		return mittente;
		
	}
	
	/**
	 * Metodo che aggiunge un mittente al registro dei mittenti
	 * @param mittente Mittente da aggiungere al registro
	 */
	public void addMittenteAlRegistro(Mittente mittente){
		this._mittenti.add(mittente);
	}
}
