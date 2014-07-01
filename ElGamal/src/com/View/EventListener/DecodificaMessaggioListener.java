/**
 * 
 */
package com.View.EventListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigInteger;

import javax.swing.JOptionPane;

import com.Model.ElGamalAlgorithm.ElGamalCypheredMessage;
import com.Model.ElGamalAlgorithm.ElGamalMachine;
import com.Model.ElGamalAlgorithm.PlainMessage;
import com.Model.Persona.Destinatario;
import com.Model.Persona.RegistroMittenti;
import com.View.Home;

/**
 * Classe che gestisce gli eventi sul pulsante decifra
 * @author Alessandro
 *
 */
public class DecodificaMessaggioListener implements MouseListener{

	//Attributi
	
	Home _view;
	/**
	 * Costruttore
	 * @param view
	 */
	public DecodificaMessaggioListener(Home view){
		_view = view;
	}
		
	@Override
	public void mouseClicked(MouseEvent e) {
		
		//Controllo banale sull'inizializzazione
		if(_view.getTxtBobR().getText().toString().length() != 0 && _view.getTxtBobT().getText().toString().length()!=0){
			//Recupero il destinatario
			Destinatario  destinatario = RegistroMittenti.getInstance().getMittenteDaNome("Alice").get_destinatario();
			//Recupero il messaggio dall'interfaccia
			String rValue = _view.getTxtBobR().getText().toString();
			BigInteger r = new BigInteger(rValue);
			String tValue = _view.getTxtBobT().getText().toString();
			BigInteger t = new BigInteger(tValue);
			
			//Costruisco u messaggio cifrato con i dati recuperati dall'interfaccia
			ElGamalCypheredMessage messaggioCifrato = new ElGamalCypheredMessage(t, r);
			//Istanzio una macchina di ElGamal
			ElGamalMachine elGamalMachine = new ElGamalMachine();
			//Faccio decifrare il messaggio
			PlainMessage messaggioInChiaro = elGamalMachine.decifra(destinatario, messaggioCifrato);
			//Mostro il messaggio decifrato
			_view.getTxtBobMessaggioDecifrato().setText(messaggioInChiaro.get_message().toString());
		}
		else{
			//Mostro un messaggio di errore
			JOptionPane.showMessageDialog(_view.getFrame(), "Attenzione, assicurarsi che sia stato inviato un messaggio a Bob e riprovare.","Informazioni mancanti", JOptionPane.ERROR_MESSAGE);
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
