/* 
 * App Gestion des comptes bancaires
 * 
 * Auteur Lionel perrine
 * Date:18/05/2020 pendant le confinement
 *
 * 
 * 
 * 
 */
package Banque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

public class AfficherTousComptes {

	private JFrame frame;
	private JButton btnRetour;
	private JScrollPane scrollPane;
	private JLabel lblAffichageDesComptes;
	private JButton btnAfficherType;
	static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfficherTousComptes window = new AfficherTousComptes();
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
	public AfficherTousComptes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Menu.selectionBackground"));
		frame.setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(100, 100, 1200, 648);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(102, 204, 102));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBackground(new Color(102, 255, 0));
		scrollPane.setVerifyInputWhenFocusTarget(false);
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 3));
		scrollPane.setBounds(56, 102, 1013, 470);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "NoCompte", "Id", "Nom", "Prenom",
				"D.O.B", "Adresse", "Sexe", "Type de Compte", "Solde", "ID 2 (C.joint)", "Taux(C.epargne)" }));
		scrollPane.setViewportView(table);

		CompteBancaire compte = new CompteBancaire();
		compte.affichercompte();
		
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfficherTousComptes.this.frame.setVisible(false);
				MenuBanque.main(null);
			}
		});
		btnRetour.setBounds(10, 11, 74, 39);
		frame.getContentPane().add(btnRetour);
		
		lblAffichageDesComptes = new JLabel("Tous les comptes");
		lblAffichageDesComptes.setFont(new Font("Dialog", Font.BOLD, 30));
		lblAffichageDesComptes.setBounds(434, 3, 500, 39);
		frame.getContentPane().add(lblAffichageDesComptes);
		
		btnAfficherType = new JButton("Afficher Un Type De compte");
		btnAfficherType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfficherTousComptes.this.frame.setVisible(false);
				AfficherTypeCompte.main(null);
			}
		});
		btnAfficherType.setBounds(56, 61, 341, 39);
		frame.getContentPane().add(btnAfficherType);
	}
}
