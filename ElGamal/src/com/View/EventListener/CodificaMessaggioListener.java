/**
 * 
 */
package com.View.EventListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigInteger;

import com.Model.ElGamalAlgorithm.ElGamalCypheredMessage;
import com.Model.ElGamalAlgorithm.ElGamalMachine;
import com.Model.Persona.Destinatario;
import com.Model.Persona.Mittente;
import com.Model.Persona.RegistroMittenti;
import com.Model.Utility.Convertitore;
import com.View.Home;

/**
 * Classe che gestisce l'evento di click sul pulsante per cifrare un messaggio
 * @author Alessandro
 *
 */
public class CodificaMessaggioListener implements MouseListener{

	//Attributi
	
	Home _view;
	/**
	 * Costruttore
	 * @param view
	 */
	public CodificaMessaggioListener(Home view){
		_view = view;
	}
		
	@Override
	public void mouseClicked(MouseEvent e) {
		//Recupero k dall'interfaccia
		String kValue = _view.getTxtK().getText().toString(); 
		int k = Integer.parseInt(kValue);
		
		//Recupero il messaggio dall'interfaccia
		String messageValue =_view.getTxtAliceMessaggioInChiaro().getText().toString();
		BigInteger message = Convertitore.convertiStringaInBigInteger(messageValue);
		
		//Recupero il mittente
		Mittente mittente = RegistroMittenti.getInstance().getMittenteDaNome("Alice");		
		
		//Recupero il destinatario 
		Destinatario destinatario = mittente.get_destinatario();
		//Recuper la macchina di ElGamal, faccio cifrare un messaggio e lo invio al destinatario
		ElGamalMachine elGamalMachine = new ElGamalMachine();		
		ElGamalCypheredMessage cypheredMessage = elGamalMachine.cifra(destinatario, message, k);
		
		//Setto gli elementi dell'interfaccia grafica
		_view.getTxtAliceR().setText(cypheredMessage.get_r().toString());
		_view.getTxtAliceT().setText(cypheredMessage.get_t().toString());		
		_view.getTxtBobR().setText(cypheredMessage.get_r().toString());
		_view.getTxtBobT().setText(cypheredMessage.get_t().toString());
		_view.getTxtBobMessaggioDecifrato().setText("");
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
