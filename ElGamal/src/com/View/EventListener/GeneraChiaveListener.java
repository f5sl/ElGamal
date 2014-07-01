/**
 * 
 */
package com.View.EventListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.Model.Persona.Destinatario;
import com.Model.Persona.RegistroMittenti;
import com.View.Home;

/**
 * @author Alessandro
 *
 */
public class GeneraChiaveListener implements MouseListener {

	//Attributi
	
	Home _view;
	
	/**
	 * Costruttore
	 * @param view
	 */
	public GeneraChiaveListener(Home view){
		_view = view;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		//Faccio richiedere la chiave al destinatario, che provvederà anche a settarsela
		Destinatario bob = RegistroMittenti.getInstance().getMittenteDaNome("Alice").get_destinatario();
		bob.richiediChiave();
		//Faccio il setting degli elementi della schermata
		_view.getTxtBobChiavePrivata().setText(bob.get_privateKey().get_value().toString());
		_view.getTxtBobAlpha().setText(bob.get_publicKey().get_alpha().toString());
		_view.getTxtBobBeta().setText(bob.get_publicKey().get_beta().toString());
		_view.getTxtBobP().setText(bob.get_publicKey().get_p().toString());
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
