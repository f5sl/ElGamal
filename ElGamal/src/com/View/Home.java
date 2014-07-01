package com.View;

import javax.swing.JFrame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import com.View.EventListener.CodificaMessaggioListener;
import com.View.EventListener.DecodificaMessaggioListener;
import com.View.EventListener.ForzaMessaggioConLogaritmoDiscretoListener;
import com.View.EventListener.ForzaMessaggioConMessaggioNotoListener;
import com.View.EventListener.GeneraChiaveListener;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Home {

	private JFrame frame;
	private JTextField txtBobChiavePrivata;
	private JTextField txtBobP;
	private JTextField txtBobAlpha;
	private JTextField txtBobBeta;
	private JTextField txtBobT;
	private JTextField txtBobR;
	private JTextField txtBobMessaggioDecifrato;
	private JTextField txtK;
	private JTextField txtAliceMessaggioInChiaro;
	private JTextField txtAliceT;
	private JTextField txtAliceR;
	private JTextField txtEvelineTUno;
	private JTextField txtEvelineMUnoChiaro;
	private JTextField txtEvelineTDue;
	private JTextField txtEvelineRDue;
	private JTextField txtEvelineForzatoConMessaggio;
	private JTextField txtEvelineForzatoSenzaMessaggio;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}
	/**
	 * Metodo per visualizzare una schemrata
	 * @param x
	 */
	public void setVisible(boolean x){
		frame.setVisible(x);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 942, 633);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setTitle("Algoritmo di ElGamal - Alessandro Ranalli - A.A. 2013/2014");
		
		ImageIcon img = new ImageIcon("./configs/ElGamal_icon.jpg");
		frame.setIconImage(img.getImage());
		
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_505260198567497");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.MIN_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblAlice = new JLabel("Alice:");
		panel.add(lblAlice, "4, 6");
		
		JLabel lblK = new JLabel("K:");
		panel.add(lblK, "6, 10, right, default");
		
		txtK = new JTextField();
		panel.add(txtK, "8, 10, fill, default");
		txtK.setColumns(10);
		
		JButton btnCodificaConPk = new JButton("Codifica con Public Key di Bob");
		btnCodificaConPk.addMouseListener(new CodificaMessaggioListener(this) {
		});
		panel.add(btnCodificaConPk, "12, 10");
		
		JLabel lblT_1 = new JLabel("t:");
		panel.add(lblT_1, "16, 10, right, default");
		
		txtAliceT = new JTextField();
		panel.add(txtAliceT, "18, 10, fill, default");
		txtAliceT.setColumns(10);
		
		JLabel lblMessChiaro = new JLabel("Mess. chiaro:");
		panel.add(lblMessChiaro, "6, 12, right, default");
		
		txtAliceMessaggioInChiaro = new JTextField();
		panel.add(txtAliceMessaggioInChiaro, "8, 12, fill, default");
		txtAliceMessaggioInChiaro.setColumns(10);
		
		JLabel lblR_1 = new JLabel("r:");
		panel.add(lblR_1, "16, 12, right, default");
		
		txtAliceR = new JTextField();
		panel.add(txtAliceR, "18, 12, fill, default");
		txtAliceR.setColumns(10);
		
		JSeparator separatorAliceBob = new JSeparator();
		panel.add(separatorAliceBob, "2, 16, 25, 1");
		
		JLabel lblBob = new JLabel("Bob:");
		panel.add(lblBob, "4, 18");
		
		JLabel lblChiaviDiBob = new JLabel("Chiavi di Bob:");
		panel.add(lblChiaviDiBob, "6, 20");
		
		JButton btnGeneraChiavePubblica = new JButton("Genera chiave");
		btnGeneraChiavePubblica.addMouseListener(new GeneraChiaveListener(this) {
			
		});
		panel.add(btnGeneraChiavePubblica, "12, 22");
		
		JLabel lblChiavePrivata = new JLabel("Chiave privata:");
		panel.add(lblChiavePrivata, "6, 26, right, default");
		
		txtBobChiavePrivata = new JTextField();
		txtBobChiavePrivata.setEditable(false);
		txtBobChiavePrivata.setEnabled(false);
		panel.add(txtBobChiavePrivata, "8, 26, fill, default");
		txtBobChiavePrivata.setColumns(10);
		txtBobChiavePrivata.setDisabledTextColor(Color.BLACK);
		
		JLabel lblChiavePubblica = new JLabel("Chiave pubblica:");
		panel.add(lblChiavePubblica, "12, 26, right, default");
		
		JLabel lblP = new JLabel("p:");
		panel.add(lblP, "16, 26, right, default");
		
		txtBobP = new JTextField();
		txtBobP.setEnabled(false);
		txtBobP.setEditable(false);
		panel.add(txtBobP, "18, 26, fill, default");
		txtBobP.setColumns(10);
		txtBobP.setDisabledTextColor(Color.BLACK);
		
		JLabel lblAlpha = new JLabel("alpha:");
		panel.add(lblAlpha, "20, 26, right, default");
		
		txtBobAlpha = new JTextField();
		txtBobAlpha.setEnabled(false);
		txtBobAlpha.setEditable(false);
		panel.add(txtBobAlpha, "22, 26, fill, default");
		txtBobAlpha.setColumns(10);
		txtBobAlpha.setDisabledTextColor(Color.BLACK);
		
		JLabel lblBeta = new JLabel("beta:");
		panel.add(lblBeta, "24, 26, right, default");
		
		txtBobBeta = new JTextField();
		txtBobBeta.setEnabled(false);
		txtBobBeta.setEditable(false);
		panel.add(txtBobBeta, "26, 26, fill, default");
		txtBobBeta.setColumns(10);
		txtBobBeta.setDisabledTextColor(Color.BLACK);
		
		JLabel lblMessaggioCifrato = new JLabel("Messaggi per Bob:");
		panel.add(lblMessaggioCifrato, "6, 30");
		
		JLabel lblMessCifrato = new JLabel("Mess. cifrato:");
		panel.add(lblMessCifrato, "6, 32, right, default");
		
		JLabel lblMessDecifrato = new JLabel("Mess. decifrato:");
		panel.add(lblMessDecifrato, "18, 32");
		
		JLabel lblT = new JLabel("t:");
		panel.add(lblT, "6, 34, right, default");
		
		txtBobT = new JTextField();
		panel.add(txtBobT, "8, 34, fill, default");
		txtBobT.setColumns(10);
		
		JButton btnDecifra = new JButton("Decifra");
		btnDecifra.addMouseListener(new DecodificaMessaggioListener(this) {
		});
		panel.add(btnDecifra, "12, 34");
		
		txtBobMessaggioDecifrato = new JTextField();
		panel.add(txtBobMessaggioDecifrato, "18, 34, fill, default");
		txtBobMessaggioDecifrato.setColumns(10);
		
		JLabel lblR = new JLabel("r:");
		panel.add(lblR, "6, 36, right, default");
		
		txtBobR = new JTextField();
		panel.add(txtBobR, "8, 36, fill, default");
		txtBobR.setColumns(10);
		
		JSeparator separatorBobEveline = new JSeparator();		
		panel.add(separatorBobEveline, "2, 42, 25, 1");
		
		JLabel lblEveline = new JLabel("Eveline:");
		panel.add(lblEveline, "4, 44");
		
		JLabel lblInserisciMessaggioM = new JLabel("M1:");
		panel.add(lblInserisciMessaggioM, "6, 46, right, default");
		
		JLabel label = new JLabel("");
		panel.add(label, "12, 46");
		
		JLabel lblMForzato = new JLabel("M2 forzato:");
		panel.add(lblMForzato, "18, 46");
		
		JLabel lblT_2 = new JLabel("t:");
		panel.add(lblT_2, "6, 48, right, default");
		
		txtEvelineTUno = new JTextField();
		panel.add(txtEvelineTUno, "8, 48, fill, default");
		txtEvelineTUno.setColumns(10);
		
		JButton btnForzaConMessaggio = new JButton("Forza M2 sfruttando M1");
		btnForzaConMessaggio.addMouseListener(new ForzaMessaggioConMessaggioNotoListener(this) {
			
		});
		panel.add(btnForzaConMessaggio, "12, 48");
		
		txtEvelineForzatoConMessaggio = new JTextField();
		panel.add(txtEvelineForzatoConMessaggio, "18, 48, fill, default");
		txtEvelineForzatoConMessaggio.setColumns(10);
		
		JLabel lblR_2 = new JLabel("M1 in chiaro:");
		panel.add(lblR_2, "6, 50, right, default");
		
		txtEvelineMUnoChiaro = new JTextField();
		panel.add(txtEvelineMUnoChiaro, "8, 50, fill, default");
		txtEvelineMUnoChiaro.setColumns(10);
		
		JLabel lblMCifrato = new JLabel("M2 cifrato:");
		panel.add(lblMCifrato, "6, 54, right, default");
		
		JLabel lblMForzato_1 = new JLabel("M2 forzato:");
		panel.add(lblMForzato_1, "18, 54");
		
		JLabel lblNewLabel = new JLabel("t:");
		panel.add(lblNewLabel, "6, 56, right, default");
		
		txtEvelineTDue = new JTextField();
		panel.add(txtEvelineTDue, "8, 56, fill, default");
		txtEvelineTDue.setColumns(10);
		
		JButton btnForzaConLogaritmo = new JButton("Forza M2 senza M1");
		btnForzaConLogaritmo.addMouseListener(new ForzaMessaggioConLogaritmoDiscretoListener(this) {
			
		});
		panel.add(btnForzaConLogaritmo, "12, 56");
		
		txtEvelineForzatoSenzaMessaggio = new JTextField();
		panel.add(txtEvelineForzatoSenzaMessaggio, "18, 56, fill, default");
		txtEvelineForzatoSenzaMessaggio.setColumns(10);
		
		JLabel lblR_3 = new JLabel("r:");
		panel.add(lblR_3, "6, 58, right, default");
		
		txtEvelineRDue = new JTextField();
		panel.add(txtEvelineRDue, "8, 58, fill, default");
		txtEvelineRDue.setColumns(10);
	}
	
	
	
	/*****************						 GETTER,  SETTER 				**************/
	
	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}
	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	/**
	 * @return the txtBobChiavePrivata
	 */
	public JTextField getTxtBobChiavePrivata() {
		return txtBobChiavePrivata;
	}
	/**
	 * @param txtBobChiavePrivata the txtBobChiavePrivata to set
	 */
	public void setTxtBobChiavePrivata(JTextField txtBobChiavePrivata) {
		this.txtBobChiavePrivata = txtBobChiavePrivata;
	}
	/**
	 * @return the txtBobP
	 */
	public JTextField getTxtBobP() {
		return txtBobP;
	}
	/**
	 * @param txtBobP the txtBobP to set
	 */
	public void setTxtBobP(JTextField txtBobP) {
		this.txtBobP = txtBobP;
	}
	/**
	 * @return the txtBobAlpha
	 */
	public JTextField getTxtBobAlpha() {
		return txtBobAlpha;
	}
	/**
	 * @param txtBobAlpha the txtBobAlpha to set
	 */
	public void setTxtBobAlpha(JTextField txtBobAlpha) {
		this.txtBobAlpha = txtBobAlpha;
	}
	/**
	 * @return the txtBobBeta
	 */
	public JTextField getTxtBobBeta() {
		return txtBobBeta;
	}
	/**
	 * @param txtBobBeta the txtBobBeta to set
	 */
	public void setTxtBobBeta(JTextField txtBobBeta) {
		this.txtBobBeta = txtBobBeta;
	}
	/**
	 * @return the txtBobT
	 */
	public JTextField getTxtBobT() {
		return txtBobT;
	}
	/**
	 * @param txtBobT the txtBobT to set
	 */
	public void setTxtBobT(JTextField txtBobT) {
		this.txtBobT = txtBobT;
	}
	/**
	 * @return the txtBobR
	 */
	public JTextField getTxtBobR() {
		return txtBobR;
	}
	/**
	 * @param txtBobR the txtBobR to set
	 */
	public void setTxtBobR(JTextField txtBobR) {
		this.txtBobR = txtBobR;
	}
	/**
	 * @return the txtBobMessaggioDecifrato
	 */
	public JTextField getTxtBobMessaggioDecifrato() {
		return txtBobMessaggioDecifrato;
	}
	/**
	 * @param txtBobMessaggioDecifrato the txtBobMessaggioDecifrato to set
	 */
	public void setTxtBobMessaggioDecifrato(JTextField txtBobMessaggioDecifrato) {
		this.txtBobMessaggioDecifrato = txtBobMessaggioDecifrato;
	}
	/**
	 * @return the txtK
	 */
	public JTextField getTxtK() {
		return txtK;
	}
	/**
	 * @param txtK the txtK to set
	 */
	public void setTxtK(JTextField txtK) {
		this.txtK = txtK;
	}
	/**
	 * @return the txtAliceMessaggioInChiaro
	 */
	public JTextField getTxtAliceMessaggioInChiaro() {
		return txtAliceMessaggioInChiaro;
	}
	/**
	 * @param txtAliceMessaggioInChiaro the txtAliceMessaggioInChiaro to set
	 */
	public void setTxtAliceMessaggioInChiaro(JTextField txtAliceMessaggioInChiaro) {
		this.txtAliceMessaggioInChiaro = txtAliceMessaggioInChiaro;
	}
	/**
	 * @return the txtAliceT
	 */
	public JTextField getTxtAliceT() {
		return txtAliceT;
	}
	/**
	 * @param txtAliceT the txtAliceT to set
	 */
	public void setTxtAliceT(JTextField txtAliceT) {
		this.txtAliceT = txtAliceT;
	}
	/**
	 * @return the txtAliceR
	 */
	public JTextField getTxtAliceR() {
		return txtAliceR;
	}
	/**
	 * @param txtAliceR the txtAliceR to set
	 */
	public void setTxtAliceR(JTextField txtAliceR) {
		this.txtAliceR = txtAliceR;
	}
	/**
	 * @return the txtEvelineTUno
	 */
	public JTextField getTxtEvelineTUno() {
		return txtEvelineTUno;
	}
	/**
	 * @param txtEvelineTUno the txtEvelineTUno to set
	 */
	public void setTxtEvelineTUno(JTextField txtEvelineTUno) {
		this.txtEvelineTUno = txtEvelineTUno;
	}
	/**
	 * @return the txtEvelineRUno
	 */
	public JTextField getTxtEvelineMUno() {
		return txtEvelineMUnoChiaro;
	}
	/**
	 * @param txtEvelineRUno the txtEvelineRUno to set
	 */
	public void setTxtEvelineMUno(JTextField txtEvelineMUno) {
		this.txtEvelineMUnoChiaro = txtEvelineMUno;
	}
	/**
	 * @return the txtEvelineTDue
	 */
	public JTextField getTxtEvelineTDue() {
		return txtEvelineTDue;
	}
	/**
	 * @param txtEvelineTDue the txtEvelineTDue to set
	 */
	public void setTxtEvelineTDue(JTextField txtEvelineTDue) {
		this.txtEvelineTDue = txtEvelineTDue;
	}
	/**
	 * @return the txtEvelineRDue
	 */
	public JTextField getTxtEvelineRDue() {
		return txtEvelineRDue;
	}
	/**
	 * @param txtEvelineRDue the txtEvelineRDue to set
	 */
	public void setTxtEvelineRDue(JTextField txtEvelineRDue) {
		this.txtEvelineRDue = txtEvelineRDue;
	}
	/**
	 * @return the txtEvelineForzatoConMessaggio
	 */
	public JTextField getTxtEvelineForzatoConMessaggio() {
		return txtEvelineForzatoConMessaggio;
	}
	/**
	 * @param txtEvelineForzatoConMessaggio the txtEvelineForzatoConMessaggio to set
	 */
	public void setTxtEvelineForzatoConMessaggio(
			JTextField txtEvelineForzatoConMessaggio) {
		this.txtEvelineForzatoConMessaggio = txtEvelineForzatoConMessaggio;
	}
	/**
	 * @return the txtEvelineForzatoSenzaMessaggio
	 */
	public JTextField getTxtEvelineForzatoSenzaMessaggio() {
		return txtEvelineForzatoSenzaMessaggio;
	}
	/**
	 * @param txtEvelineForzatoSenzaMessaggio the txtEvelineForzatoSenzaMessaggio to set
	 */
	public void setTxtEvelineForzatoSenzaMessaggio(
			JTextField txtEvelineForzatoSenzaMessaggio) {
		this.txtEvelineForzatoSenzaMessaggio = txtEvelineForzatoSenzaMessaggio;
	}

}
