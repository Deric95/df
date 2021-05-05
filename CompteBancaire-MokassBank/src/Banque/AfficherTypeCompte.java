/* 
 * App Gestion des comptes bancaires
 * 
 * Auteur Lionel perrine
 * Date:13/05/2020 pendant le confinement
 *
 * pour afficher tous les comptes du même type
 * 
 * 
 */
package Banque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class AfficherTypeCompte {

	private JFrame frame;
	private JButton btnRetour;
	private JScrollPane scrollPane;
	private JLabel lblAffichageDesComptes;
	@SuppressWarnings("rawtypes")
	private JComboBox typeDropdown;
	static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfficherTypeCompte window = new AfficherTypeCompte();
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
	public AfficherTypeCompte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1250, 648);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(26, 64, 1198, 470);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "No-Compte", "Id-Compte", "Nom", "Prénom",
				"DateNaissance", "Adresse", "Sexe", "Type de Compte", "Solde", "ID 2 (Cmpte-joint)", "TauxD'epargne" }));
		scrollPane.setViewportView(table);

		CompteBancaire compte = new CompteBancaire();

		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfficherTypeCompte.this.frame.setVisible(false);
				MenuBanque.main(null);
			}
		});
		btnRetour.setBounds(22, 18, 98, 42);
		frame.getContentPane().add(btnRetour);

		lblAffichageDesComptes = new JLabel("Type De Comptes");
		lblAffichageDesComptes.setFont(new Font("Dialog", Font.BOLD, 30));
		lblAffichageDesComptes.setBounds(402, 14, 295, 39);
		frame.getContentPane().add(lblAffichageDesComptes);

		typeDropdown = new JComboBox();
		typeDropdown.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				compte.affichertype(typeDropdown, table);
			}
		});
		typeDropdown.setBounds(707, 29, 178, 31);
		frame.getContentPane().add(typeDropdown);
		typeDropdown.addItem("COURANT");
		typeDropdown.addItem("JOINT");
		typeDropdown.addItem("EPARGNE");
	}
}
