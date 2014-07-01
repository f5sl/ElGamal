/**
 * 
 */
package com.View.EventListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigInteger;

import javax.swing.JOptionPane;

import com.Model.Break.Breaker;
import com.Model.ElGamalAlgorithm.ElGamalCypheredMessage;
import com.Model.ElGamalAlgorithm.PlainMessage;
import com.Model.Persona.Destinatario;
import com.Model.Persona.RegistroMittenti;
import com.View.Home;

/**
 * Classe che gestice gli eventi sul pulsante per forzare il messaggio senza ul altro messaggio in chiaro
 * @author Alessandro
 *
 */
public class ForzaMessaggioConLogaritmoDiscretoListener implements MouseListener{

	//Attributi
	
	Home _view;
	/**
	 * Costruttore
	 * @param view
	 */
	public ForzaMessaggioConLogaritmoDiscretoListener(Home view){
		_view = view;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(_view.getTxtEvelineRDue().getText().toString().length()!=0 && _view.getTxtEvelineTDue().getText().toString().length()!=0){
			//Recupero il destinatario
			Destinatario destinatario = RegistroMittenti.getInstance().getMittenteDaNome("Alice").get_destinatario();
			
			//Recupero il messaggio dall'interfaccia
			String rValue = _view.getTxtEvelineRDue().getText().toString();
			BigInteger r = new BigInteger(rValue);
			String tValue = _view.getTxtEvelineTDue().getText().toString();
			BigInteger t = new BigInteger(tValue);
			
			//Costruisco un messaggio cifrato con i dati recuperati dall'interfaccia
			ElGamalCypheredMessage messaggioCifrato = new ElGamalCypheredMessage(t,r); 
			
			//Forzo il messaggio cifrato, mediante il logaritmo discreto
			PlainMessage messaggioForzato = Breaker.forzaMessaggioConLogaritmoDiscreto(destinatario.get_publicKey(), messaggioCifrato);
			
			//Mostro il risultato della forzatura
			_view.getTxtEvelineForzatoSenzaMessaggio().setText(messaggioForzato.get_message());
		}
		else{
			//Mostro un messaggio di errore
			JOptionPane.showMessageDialog(_view.getFrame(), "Attenzione, assicurarsi che sia stato inserito un messaggio da forzare.","Informazioni mancanti", JOptionPane.ERROR_MESSAGE);
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
