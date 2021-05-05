
package Banque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;

/*
 * Classe pour la création de compte
 */
public class AjouterCompte {

	private JFrame frame;
	private JLabel lblID1;
	private JTextField txtId;

	private JButton btnEffacerChamps;
	private JButton btnCreation;
	private JButton btnAnnlerOp;
	private JLabel lblNom;
	private JTextField txtNom;
	private JLabel lblPrenom;
	private JTextField txtPrenom;
	private JLabel lblDateNaissance;
	private JTextField txtDOB;
	private JLabel lblSexe;
	private JLabel lblAdresse;
	private JTextField txtAdresse;
	private JLabel lblTypeCompte;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbType;
	private JLabel lblIDJoint;
	private JTextField txtIdJoint;
	private JLabel lblTaux;
	private JTextField txtTaux;
	private JLabel lbl1;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbSexe;
	private final JLayeredPane layeredPane = new JLayeredPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterCompte window = new AjouterCompte();
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
	public AjouterCompte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 127, 80));
		frame.getContentPane().setLayout(null);

		lblID1 = new JLabel("ID 1");
		lblID1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblID1.setBounds(12, 60, 78, 16);
		frame.getContentPane().add(lblID1);

		txtId = new JTextField();
		txtId.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtId.setHorizontalAlignment(SwingConstants.LEFT);
		txtId.setColumns(10);
		txtId.setBounds(217, 60, 143, 25);
		frame.getContentPane().add(txtId);

		lblNom = new JLabel("Nom ");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNom.setBounds(12, 104, 63, 16);
		frame.getContentPane().add(lblNom);

		txtNom = new JTextField();
		txtNom.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNom.setHorizontalAlignment(SwingConstants.LEFT);
		txtNom.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtNom.setColumns(10);
		txtNom.setBounds(215, 103, 210, 25);
		frame.getContentPane().add(txtNom);

		lblPrenom = new JLabel("Pr\u00E9nom");
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrenom.setBounds(12, 144, 84, 16);
		frame.getContentPane().add(lblPrenom);

		txtPrenom = new JTextField();
		txtPrenom.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		txtPrenom.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(217, 143, 210, 25);
		frame.getContentPane().add(txtPrenom);

		lblDateNaissance = new JLabel("Date de naissance (JJ/MM/AAAA) ");
		lblDateNaissance.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateNaissance.setBounds(12, 189, 210, 16);
		frame.getContentPane().add(lblDateNaissance);

		txtDOB = new JTextField();
		txtDOB.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtDOB.setHorizontalAlignment(SwingConstants.LEFT);
		txtDOB.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtDOB.setColumns(10);
		txtDOB.setBounds(217, 188, 127, 25);
		frame.getContentPane().add(txtDOB);

		lblSexe = new JLabel("Sexe");
		lblSexe.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSexe.setBounds(12, 233, 37, 16);
		frame.getContentPane().add(lblSexe);

		lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAdresse.setBounds(12, 277, 63, 16);
		frame.getContentPane().add(lblAdresse);

		txtAdresse = new JTextField();
		txtAdresse.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		txtAdresse.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtAdresse.setColumns(10);
		txtAdresse.setBounds(219, 276, 221, 25);
		frame.getContentPane().add(txtAdresse);

		lblTypeCompte = new JLabel("Type de compte");
		lblTypeCompte.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTypeCompte.setBounds(12, 321, 174, 16);
		frame.getContentPane().add(lblTypeCompte);

		cmbType = new JComboBox();
		cmbType.setModel(new DefaultComboBoxModel(new String[] {"", "COURANT", "EPARGNE", "JOINT"}));
		cmbType.setBounds(217, 321, 127, 25);
		frame.getContentPane().add(cmbType);
		cmbType.addItem("COURANT");
		cmbType.addItem("EPARGNE");
		cmbType.addItem("JOINT");

		lblIDJoint = new JLabel("ID 2 (Compte Joint)");
		lblIDJoint.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIDJoint.setBounds(12, 365, 174, 16);
		frame.getContentPane().add(lblIDJoint);

		txtIdJoint = new JTextField();
		txtIdJoint.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtIdJoint.setColumns(10);
		txtIdJoint.setBounds(217, 362, 187, 25);
		frame.getContentPane().add(txtIdJoint);

		lblTaux = new JLabel("Taux d'\u00E9pargne");
		lblTaux.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTaux.setBounds(12, 409, 197, 16);
		frame.getContentPane().add(lblTaux);

		txtTaux = new JTextField();
		txtTaux.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtTaux.setHorizontalAlignment(SwingConstants.LEFT);
		txtTaux.setColumns(10);
		txtTaux.setBounds(215, 409, 210, 25);
		frame.getContentPane().add(txtTaux);

		

		lbl1 = new JLabel("Cr\u00E9ation de compte");
		lbl1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Dialog", Font.BOLD, 24));
		lbl1.setBounds(258, 8, 280, 36);
		frame.getContentPane().add(lbl1);
		layeredPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		layeredPane.setBounds(578, 60, 159, 304);
		frame.getContentPane().add(layeredPane);
						
			btnEffacerChamps = new JButton("Effacer champs");
			btnEffacerChamps.setBounds(10, 211, 139, 54);
			layeredPane.add(btnEffacerChamps);
			btnEffacerChamps.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtId.setText("");
					txtNom.setText("");
					txtPrenom.setText("");
					txtDOB.setText("");
					txtAdresse.setText("");
					cmbSexe.setSelectedIndex(0);
				    txtIdJoint.setText("");
					txtTaux.setText("");
									}
			    });
				btnEffacerChamps.setFont(new Font("Dialog", Font.BOLD, 11));
				btnCreation = new JButton("Cr\u00E9er compte");
				btnCreation.setBounds(10, 11, 139, 48);
				layeredPane.add(btnCreation);
				btnCreation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Instantiation de l'objet de la classe mère CompteBancaire
					CompteBancaire compte = new CompteBancaire();
					JFrame frameConfirm = new JFrame();
					String[] array = {};
					//Ajouter compte
					compte.creerCompte(frame, frameConfirm, cmbType, txtId, txtNom, txtPrenom, txtDOB, cmbSexe, txtAdresse, txtIdJoint,txtTaux, array);
				}
				});
				btnCreation.setFont(new Font("Dialog", Font.BOLD, 11));
								
				btnAnnlerOp = new JButton("Annuler cr\u00E9ation");
				btnAnnlerOp.setBounds(10, 114, 139, 48);
				layeredPane.add(btnAnnlerOp);
				btnAnnlerOp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					  frame = new JFrame("annuler");
						if (JOptionPane.showConfirmDialog(frame, "Voulez-vous vraiment Annuler?", "MoKass",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
							AjouterCompte.this.frame.setVisible(false);
						    MenuBanque.main(null);
						}
					}
					});
					btnAnnlerOp.setFont(new Font("Dialog", Font.BOLD, 11));
										
					cmbSexe = new JComboBox();
					cmbSexe.setModel(new DefaultComboBoxModel(new String[] {"", "Homme", "Femme"}));
					cmbSexe.setBounds(217, 233, 208, 25);
				    frame.getContentPane().add(cmbSexe);
		frame.setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(100, 100, 763, 490);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}
