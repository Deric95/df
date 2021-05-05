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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class SupprimmerCompte {

	private JFrame frame;
	private JTextField txtIdclient;
	private JLabel lbl2;
	private JButton btnSupprimer;
	private JButton btnAnnnuler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupprimmerCompte window = new SupprimmerCompte();
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
	public SupprimmerCompte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 102));
		frame.setBackground(new Color(204, 204, 102));
		frame.setBounds(100, 100, 592, 379);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lbl2 = new JLabel("Supprimer un compte");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Dialog", Font.BOLD, 30));
		lbl2.setBounds(103, 11, 364, 39);
		frame.getContentPane().add(lbl2);

		txtIdclient = new JTextField();
		txtIdclient.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txtIdclient.setBounds(151, 117, 284, 33);
		frame.getContentPane().add(txtIdclient);
		txtIdclient.setColumns(10);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompteBancaire compte = new CompteBancaire();
				// Affectation des valeurs des attributs de l'objet
				compte.supprimercompte(txtIdclient.getText());
				SupprimmerCompte.this.frame.setVisible(false);
				MenuBanque.main(null);
			}
		});
		btnSupprimer.setBounds(144, 199, 291, 46);
		frame.getContentPane().add(btnSupprimer);

		btnAnnnuler = new JButton("Annuler");
		btnAnnnuler.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAnnnuler.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAnnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(frame, "Voulez-vous vraiment annuler cette opération???",
						"MoKass Bank", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					SupprimmerCompte.this.frame.setVisible(false);
					MenuBanque.main(null);
				}

			}
		});
		btnAnnnuler.setBounds(144, 265, 291, 46);
		frame.getContentPane().add(btnAnnnuler);
		
		JLabel lbl1 = new JLabel("Entrez L'id du client");
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl1.setBounds(219, 84, 156, 22);
		frame.getContentPane().add(lbl1);
	}
}
