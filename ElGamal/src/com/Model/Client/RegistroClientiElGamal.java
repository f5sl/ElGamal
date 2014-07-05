/**
 * 
 */
package com.Model.Client;

import java.util.ArrayList;

/**
 * Classe che modella un registro di clienti ElGamal
 * 
 * @author Alessandro
 *
 */
public class RegistroClientiElGamal {
	
	//Attributi
	private ArrayList<ElGamalClient> _clientiElGamal = new ArrayList<ElGamalClient>();
	
	
	/**
	 * Attributo istanza - Pattern Singleton
	 */
	private static RegistroClientiElGamal _instance= null;
	
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private RegistroClientiElGamal(){
		
	}
	
	/**
	 * Metodo che restituisce l'unica istanza del registro clienti - Pattern Singleton
	 * @return Istanza del registro mittenti
	 */
	public static RegistroClientiElGamal getInstance(){
		if(_instance ==null){
			_instance = new RegistroClientiElGamal();
		}
		return _instance;
	}
	
	/**
	 * Metodo che restituisce un cliente dal suo nome
	 * @param nome Nome del cliente ElGamal di un messaggio
	 * @return Cliente ElGamal
	 */
	public ElGamalClient getClienteDaNome(String nome){
		//Istanzio un mittente
		ElGamalClient cliente = new ElGamalClient();
		//Ciclo sull'array dei mittenti
		for(int i = 0; i<_clientiElGamal.size();i++){
			//Recupero il mittente con il nome inserito
			if(_clientiElGamal.get(i).get_name().equals(nome)){
				cliente = _clientiElGamal.get(i);
			}
		}
		return cliente;		
	}
	
	/**
	 * Metodo che aggiunge un cliente ElGamal al registro dei clienti
	 * @param mittente cliente da aggiungere al registro
	 */
	public void addClienteElGamalAlRegistro(ElGamalClient cliente){
		this._clientiElGamal.add(cliente);
	}
	
}
