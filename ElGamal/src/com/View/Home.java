package com.View;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Home {

	private JFrame frmAlgoritmoElgamal;
	private JTextField textChiavePrivata;
	private JTextField txt_P;
	private JTextField txt_Alpha;
	private JTextField txt_Beta;
	private JTextField txt_MessaggioCifrato;
	private JTextField txt_MessaggioDecifrato;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmAlgoritmoElgamal.setVisible(true);
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
		frmAlgoritmoElgamal = new JFrame();
		frmAlgoritmoElgamal.setTitle("Algoritmo ElGamal");
		frmAlgoritmoElgamal.setBounds(100, 100, 600, 400);
		frmAlgoritmoElgamal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlgoritmoElgamal.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmAlgoritmoElgamal.getContentPane().add(panel, "name_425590417668138");
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JSeparator separatorMiddle = new JSeparator();
		separatorMiddle.setForeground(Color.DARK_GRAY);
		separatorMiddle.setBackground(Color.DARK_GRAY);
		separatorMiddle.setOrientation(SwingConstants.VERTICAL);
		separatorMiddle.setPreferredSize(new Dimension(10, 3));
		
		GridBagConstraints gbc_separatorMiddle = new GridBagConstraints();
		gbc_separatorMiddle.fill = GridBagConstraints.VERTICAL;
		gbc_separatorMiddle.weighty = 1;
		gbc_separatorMiddle.gridheight = 15;
		gbc_separatorMiddle.insets = new Insets(2, 2, 2, 5);
		gbc_separatorMiddle.gridx = 8;
		gbc_separatorMiddle.gridy = 0;
		panel.add(separatorMiddle, gbc_separatorMiddle);
		
		JSeparator separatorLeft = new JSeparator();
		separatorLeft.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_separatorLeft = new GridBagConstraints();
		gbc_separatorLeft.gridheight = 15;
		gbc_separatorLeft.insets = new Insets(20, 5, 25, 5);
		gbc_separatorLeft.gridx = 3;
		gbc_separatorLeft.gridy = 0;
		panel.add(separatorLeft, gbc_separatorLeft);
		
		JLabel label = new JLabel("Bob:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(30, 0, 5, 5);
		gbc_label.gridx = 4;
		gbc_label.gridy = 1;
		panel.add(label, gbc_label);
		
		JLabel lblNewLabel = new JLabel("Inserisci chiave privata di Bob:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridx = 6;
		gbc_lblNewLabel.gridy = 3;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.gridheight = 10;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 10;
		gbc_separator_1.gridy = 3;
		panel.add(separator_1, gbc_separator_1);
		
		JLabel lblInserisciMessaggioDa = new JLabel("Inserisci messaggio da decifrare:");
		GridBagConstraints gbc_lblInserisciMessaggioDa = new GridBagConstraints();
		gbc_lblInserisciMessaggioDa.insets = new Insets(0, 0, 5, 5);
		gbc_lblInserisciMessaggioDa.gridx = 12;
		gbc_lblInserisciMessaggioDa.gridy = 3;
		panel.add(lblInserisciMessaggioDa, gbc_lblInserisciMessaggioDa);
		
		textChiavePrivata = new JTextField();
		GridBagConstraints gbc_textChiavePrivata = new GridBagConstraints();
		gbc_textChiavePrivata.insets = new Insets(0, 0, 5, 5);
		gbc_textChiavePrivata.fill = GridBagConstraints.HORIZONTAL;
		gbc_textChiavePrivata.gridx = 6;
		gbc_textChiavePrivata.gridy = 4;
		panel.add(textChiavePrivata, gbc_textChiavePrivata);
		textChiavePrivata.setColumns(10);
		
		txt_MessaggioCifrato = new JTextField();
		GridBagConstraints gbc_txt_MessaggioCifrato = new GridBagConstraints();
		gbc_txt_MessaggioCifrato.insets = new Insets(0, 0, 5, 5);
		gbc_txt_MessaggioCifrato.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_MessaggioCifrato.gridx = 12;
		gbc_txt_MessaggioCifrato.gridy = 4;
		panel.add(txt_MessaggioCifrato, gbc_txt_MessaggioCifrato);
		txt_MessaggioCifrato.setColumns(10);
		
		JButton btnNewButton = new JButton("Genera chiave pubblica");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 5;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnDecifraMessaggio = new JButton("Decifra messaggio");
		GridBagConstraints gbc_btnDecifraMessaggio = new GridBagConstraints();
		gbc_btnDecifraMessaggio.insets = new Insets(0, 0, 5, 5);
		gbc_btnDecifraMessaggio.gridx = 12;
		gbc_btnDecifraMessaggio.gridy = 5;
		panel.add(btnDecifraMessaggio, gbc_btnDecifraMessaggio);
		
		JLabel lblChiavePubblicaDi = new JLabel("Chiave pubblica di Bob:");
		GridBagConstraints gbc_lblChiavePubblicaDi = new GridBagConstraints();
		gbc_lblChiavePubblicaDi.insets = new Insets(0, 0, 5, 5);
		gbc_lblChiavePubblicaDi.gridx = 6;
		gbc_lblChiavePubblicaDi.gridy = 7;
		panel.add(lblChiavePubblicaDi, gbc_lblChiavePubblicaDi);
		
		JLabel lblMessaggioDecifrato = new JLabel("Messaggio decifrato:");
		GridBagConstraints gbc_lblMessaggioDecifrato = new GridBagConstraints();
		gbc_lblMessaggioDecifrato.insets = new Insets(0, 0, 5, 5);
		gbc_lblMessaggioDecifrato.gridx = 12;
		gbc_lblMessaggioDecifrato.gridy = 7;
		panel.add(lblMessaggioDecifrato, gbc_lblMessaggioDecifrato);
		
		JLabel lblP = new JLabel("p:");
		GridBagConstraints gbc_lblP = new GridBagConstraints();
		gbc_lblP.insets = new Insets(0, 0, 5, 5);
		gbc_lblP.gridx = 4;
		gbc_lblP.gridy = 8;
		panel.add(lblP, gbc_lblP);
		
		txt_P = new JTextField();
		txt_P.setEnabled(false);
		txt_P.setEditable(false);
		GridBagConstraints gbc_txt_P = new GridBagConstraints();
		gbc_txt_P.insets = new Insets(0, 0, 5, 5);
		gbc_txt_P.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_P.gridx = 6;
		gbc_txt_P.gridy = 8;
		panel.add(txt_P, gbc_txt_P);
		txt_P.setColumns(10);
		
		txt_MessaggioDecifrato = new JTextField();
		txt_MessaggioDecifrato.setEditable(false);
		txt_MessaggioDecifrato.setEnabled(false);
		GridBagConstraints gbc_txt_MessaggioDecifrato = new GridBagConstraints();
		gbc_txt_MessaggioDecifrato.insets = new Insets(0, 0, 5, 5);
		gbc_txt_MessaggioDecifrato.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_MessaggioDecifrato.gridx = 12;
		gbc_txt_MessaggioDecifrato.gridy = 8;
		panel.add(txt_MessaggioDecifrato, gbc_txt_MessaggioDecifrato);
		txt_MessaggioDecifrato.setColumns(10);
		
		JLabel lblAlpha = new JLabel("alpha:");
		GridBagConstraints gbc_lblAlpha = new GridBagConstraints();
		gbc_lblAlpha.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlpha.gridx = 4;
		gbc_lblAlpha.gridy = 9;
		panel.add(lblAlpha, gbc_lblAlpha);
		
		txt_Alpha = new JTextField();
		txt_Alpha.setEnabled(false);
		txt_Alpha.setEditable(false);
		GridBagConstraints gbc_txt_Alpha = new GridBagConstraints();
		gbc_txt_Alpha.insets = new Insets(0, 0, 5, 5);
		gbc_txt_Alpha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_Alpha.gridx = 6;
		gbc_txt_Alpha.gridy = 9;
		panel.add(txt_Alpha, gbc_txt_Alpha);
		txt_Alpha.setColumns(10);
		
		JLabel lblBeta = new JLabel("beta:");
		GridBagConstraints gbc_lblBeta = new GridBagConstraints();
		gbc_lblBeta.insets = new Insets(0, 0, 5, 5);
		gbc_lblBeta.gridx = 4;
		gbc_lblBeta.gridy = 10;
		panel.add(lblBeta, gbc_lblBeta);
		
		txt_Beta = new JTextField();
		txt_Beta.setEnabled(false);
		txt_Beta.setEditable(false);
		GridBagConstraints gbc_txt_Beta = new GridBagConstraints();
		gbc_txt_Beta.insets = new Insets(0, 0, 5, 5);
		gbc_txt_Beta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_Beta.gridx = 6;
		gbc_txt_Beta.gridy = 10;
		panel.add(txt_Beta, gbc_txt_Beta);
		txt_Beta.setColumns(10);
		
		JButton button = new JButton("<- Indietro");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(30, 7, 5, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 12;
		panel.add(button, gbc_button);
	}

}
