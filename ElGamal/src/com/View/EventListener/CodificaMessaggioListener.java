/**
 * 
 */
package com.View.EventListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import com.Model.Client.ClienteElGamal;
import com.Model.Client.RegistroClientiElGamal;
import com.Model.ElGamalAlgorithm.ElGamalMachine;
import com.Model.ElGamalAlgorithm.Message.ElGamalCypheredMessage;
import com.Model.ElGamalAlgorithm.Message.ElGamalPlainMessage;
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
		
		//Controllo banale sull'inizializzazione
		if(_view.getTxtK().getText().toString().length() != 0 && _view.getTxtAliceMessaggioInChiaro().getText().toString().length() != 0 && _view.getTxtBobAlpha().getText().toString().length()!=0){
			
			//Recupero k dall'interfaccia
			String kValue = _view.getTxtK().getText().toString(); 
			int k = Integer.parseInt(kValue);
			
			//Recupero il messaggio dall'interfaccia
			String messageValue =_view.getTxtAliceMessaggioInChiaro().getText().toString();		
		
			//Recupero il mittente che, per questa specifica applicazione so essere alice
			ClienteElGamal mittente = RegistroClientiElGamal.getInstance().getClienteDaNome("Alice");		
			
			//Recupero il destinatario che, per questa specifica applicazione so essere bob
			ClienteElGamal destinatario = RegistroClientiElGamal.getInstance().getClienteDaNome("Bob");
			
			//Creo un messaggio in chiaro
			ElGamalPlainMessage elGamalPlainMessage = new ElGamalPlainMessage();
			elGamalPlainMessage.set_message(messageValue);
			elGamalPlainMessage.set_mittente(mittente);
			elGamalPlainMessage.set_destinatario(destinatario);
			
			//Recupero la macchina di ElGamal, faccio cifrare un messaggio e lo invio al destinatario
			ElGamalMachine elGamalMachine = new ElGamalMachine();		
			ElGamalCypheredMessage cypheredMessage = elGamalMachine.cifra(elGamalPlainMessage, k);
			cypheredMessage.set_mittente(mittente);
			cypheredMessage.set_destinatario(destinatario);
			
			//Setto gli elementi dell'interfaccia grafica
			_view.getTxtAliceR().setText(cypheredMessage.get_r().toString());
			_view.getTxtAliceT().setText(cypheredMessage.get_t().toString());		
			_view.getTxtBobR().setText(cypheredMessage.get_r().toString());
			_view.getTxtBobT().setText(cypheredMessage.get_t().toString());
			_view.getTxtBobMessaggioDecifrato().setText("");
		}
		else{
			//Mostro un messaggio di errore
			JOptionPane.showMessageDialog(_view.getFrame(), "Attenzione, assicurarsi che sia stata generata una chiave per Bob, e che Alice abbia scelto sia k che il messaggio","Informazioni mancanti", JOptionPane.ERROR_MESSAGE);
		}
			
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
