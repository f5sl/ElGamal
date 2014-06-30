package com.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JSeparator;

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
	private JTextField txtEvelineRUno;
	private JTextField txtEvelineTDue;
	private JTextField txtEvelineRDue;
	private JTextField txtEvelineForzatoConMessaggio;
	private JTextField txtEvelineForzatoSenzaMessaggio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 942, 633);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblAlice = new JLabel("Alice:");
		panel.add(lblAlice, "4, 6");
		
		JLabel lblK = new JLabel("K:");
		panel.add(lblK, "6, 10, right, default");
		
		txtK = new JTextField();
		panel.add(txtK, "8, 10, fill, default");
		txtK.setColumns(10);
		
		JButton btnCodificaConPk = new JButton("Codifica con Public Key di Bob");
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
		
		JLabel lblChiavePrivata = new JLabel("Chiave privata:");
		panel.add(lblChiavePrivata, "6, 22, right, default");
		
		txtBobChiavePrivata = new JTextField();
		panel.add(txtBobChiavePrivata, "8, 22, fill, default");
		txtBobChiavePrivata.setColumns(10);
		
		JButton btnGeneraChiavePubblica = new JButton("Genera chiave pubblica");
		panel.add(btnGeneraChiavePubblica, "12, 22");
		
		JLabel lblP = new JLabel("p:");
		panel.add(lblP, "16, 22, right, default");
		
		txtBobP = new JTextField();
		panel.add(txtBobP, "18, 22, fill, default");
		txtBobP.setColumns(10);
		
		JLabel lblAlpha = new JLabel("alpha:");
		panel.add(lblAlpha, "20, 22, right, default");
		
		txtBobAlpha = new JTextField();
		panel.add(txtBobAlpha, "22, 22, fill, default");
		txtBobAlpha.setColumns(10);
		
		JLabel lblBeta = new JLabel("beta:");
		panel.add(lblBeta, "24, 22, right, default");
		
		txtBobBeta = new JTextField();
		panel.add(txtBobBeta, "26, 22, fill, default");
		txtBobBeta.setColumns(10);
		
		JLabel lblMessaggioCifrato = new JLabel("Messaggi per Bob:");
		panel.add(lblMessaggioCifrato, "6, 26");
		
		JLabel lblMessCifrato = new JLabel("Mess. cifrato:");
		panel.add(lblMessCifrato, "6, 28, right, default");
		
		JLabel lblMessDecifrato = new JLabel("Mess. decifrato:");
		panel.add(lblMessDecifrato, "18, 28");
		
		JLabel lblT = new JLabel("t:");
		panel.add(lblT, "6, 30, right, default");
		
		txtBobT = new JTextField();
		panel.add(txtBobT, "8, 30, fill, default");
		txtBobT.setColumns(10);
		
		JButton btnDecifra = new JButton("Decifra");
		panel.add(btnDecifra, "12, 30");
		
		txtBobMessaggioDecifrato = new JTextField();
		panel.add(txtBobMessaggioDecifrato, "18, 30, fill, default");
		txtBobMessaggioDecifrato.setColumns(10);
		
		JLabel lblR = new JLabel("r:");
		panel.add(lblR, "6, 32, right, default");
		
		txtBobR = new JTextField();
		panel.add(txtBobR, "8, 32, fill, default");
		txtBobR.setColumns(10);
		
		JSeparator separatorBobEveline = new JSeparator();		
		panel.add(separatorBobEveline, "2, 38, 25, 1");
		
		JLabel lblEveline = new JLabel("Eveline:");
		panel.add(lblEveline, "4, 40");
		
		JLabel lblInserisciMessaggioM = new JLabel("M1 in chiaro:");
		panel.add(lblInserisciMessaggioM, "6, 42, right, default");
		
		JLabel label = new JLabel("");
		panel.add(label, "12, 42");
		
		JLabel lblMForzato = new JLabel("M2 forzato:");
		panel.add(lblMForzato, "18, 42");
		
		JLabel lblT_2 = new JLabel("t:");
		panel.add(lblT_2, "6, 44, right, default");
		
		txtEvelineTUno = new JTextField();
		panel.add(txtEvelineTUno, "8, 44, fill, default");
		txtEvelineTUno.setColumns(10);
		
		JButton btnForzaConMessaggio = new JButton("Forza M2 sfruttando M1");
		panel.add(btnForzaConMessaggio, "12, 44");
		
		txtEvelineForzatoConMessaggio = new JTextField();
		panel.add(txtEvelineForzatoConMessaggio, "18, 44, fill, default");
		txtEvelineForzatoConMessaggio.setColumns(10);
		
		JLabel lblR_2 = new JLabel("r:");
		panel.add(lblR_2, "6, 46, right, default");
		
		txtEvelineRUno = new JTextField();
		panel.add(txtEvelineRUno, "8, 46, fill, default");
		txtEvelineRUno.setColumns(10);
		
		JLabel lblMCifrato = new JLabel("M2 cifrato:");
		panel.add(lblMCifrato, "6, 50, right, default");
		
		JLabel lblMForzato_1 = new JLabel("M2 forzato:");
		panel.add(lblMForzato_1, "18, 50");
		
		JLabel lblNewLabel = new JLabel("t:");
		panel.add(lblNewLabel, "6, 52, right, default");
		
		txtEvelineTDue = new JTextField();
		panel.add(txtEvelineTDue, "8, 52, fill, default");
		txtEvelineTDue.setColumns(10);
		
		JButton btnForzaConLogaritmo = new JButton("Forza M2 senza M1");
		panel.add(btnForzaConLogaritmo, "12, 52");
		
		txtEvelineForzatoSenzaMessaggio = new JTextField();
		panel.add(txtEvelineForzatoSenzaMessaggio, "18, 52, fill, default");
		txtEvelineForzatoSenzaMessaggio.setColumns(10);
		
		JLabel lblR_3 = new JLabel("r:");
		panel.add(lblR_3, "6, 54, right, default");
		
		txtEvelineRDue = new JTextField();
		panel.add(txtEvelineRDue, "8, 54, fill, default");
		txtEvelineRDue.setColumns(10);
	}

}
