/**
 * 
 */
package com.View.EventListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigInteger;

import javax.swing.JOptionPane;

import com.Model.Break.Breaker;
import com.Model.ElGamalAlgorithm.PlainMessage;
import com.Model.Persona.Destinatario;
import com.Model.Persona.RegistroMittenti;
import com.View.Home;

/**Classe che gestisce gli eventi sul bottone per forzare un messaggio conoscendone un altro
 * @author Alessandro
 *
 */
public class ForzaMessaggioConMessaggioNotoListener implements MouseListener {

	//Attributi
	
	Home _view;
	/**
	 * Costruttore
	 * @param view
	 */
	public ForzaMessaggioConMessaggioNotoListener(Home view){
		_view = view;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		//Controllo banale sull'inizializzazione
		if(_view.getTxtEvelineTUno().getText().toString().length()!=0 && _view.getTxtEvelineMUno().getText().toString().length()!=0 &&
				_view.getTxtEvelineTDue().getText().toString().length()!=0){
			//Recupero il destinatario
			Destinatario  destinatario = RegistroMittenti.getInstance().getMittenteDaNome("Alice").get_destinatario();
			//Recupero le informazioni utili dei messaggi uno e due dall'interfaccia
			//T1
			String tUnoValue = _view.getTxtEvelineTUno().getText().toString();
			BigInteger tUno = new BigInteger(tUnoValue);
			//M1
			String mUnoValue = _view.getTxtEvelineMUno().getText().toString();
			PlainMessage messaggioUnoInChiaro = new PlainMessage(mUnoValue);
			//T2
			String tDueValue = _view.getTxtEvelineTDue().getText().toString();
			BigInteger tDue = new BigInteger(tDueValue);
			
			//Utilizzo il braker per forzare il messaggio
			PlainMessage messaggioForzato =Breaker.forzaMessaggioDaMessaggioNoto(destinatario.get_publicKey(), tUno, tDue, messaggioUnoInChiaro);
			//Visualizzo il messaggio forzato
			_view.getTxtEvelineForzatoConMessaggio().setText(messaggioForzato.get_message());
		}
		else{
			//Mostro un messaggio di errore
			JOptionPane.showMessageDialog(_view.getFrame(), "Attenzione, assicurarsi che sia stato inserito un messaggio da forzare e che sia presente un messaggio in chiaro.","Informazioni mancanti", JOptionPane.ERROR_MESSAGE);
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
