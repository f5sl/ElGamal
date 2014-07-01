/**
 * 
 */
package com.Main;

import com.Model.Utility.UStartUp;
import com.View.Home;

/**
 * Classe Main
 * @author Alessandro
 *
 */
public class MainFinale {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Inizializzo lo strato di dominio, con la macchina di ElGamal e gli utenti
		UStartUp.inizializza();
		//Istanzio la home e la visualizzo
		Home window = new Home();
		window.setVisible(true);
	}

}
