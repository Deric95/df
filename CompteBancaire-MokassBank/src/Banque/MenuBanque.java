/* 
 * App Gestion des comptes bancaires
 * 
 * Auteur Lionel perrine
 * Date:07/05/2020 pendant le confinement
 *
 * Le Menu
 * 
 * 
 */
package Banque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.border.BevelBorder;

public class MenuBanque {

	JFrame frame;
	private JPanel panel;
	private JButton btnQuitter;
	private JButton btnAjouter;
	private JButton btnAfficher;
	private JButton btnSupprimer;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuBanque window = new MenuBanque();
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
	public MenuBanque() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBackground(new Color(0, 255, 127));
		frame.setBounds(100, 100, 878, 518);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		panel = new JPanel();
		panel.setBackground(new Color(0, 250, 154));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		btnQuitter = new JButton("Quitter");
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQuitter.setBackground(new Color(173, 255, 47));
		btnQuitter.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnQuitter.setBounds(730, 11, 109, 35);
		panel.add(btnQuitter);
		layeredPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		layeredPane.setBounds(197, 187, 476, 246);
		panel.add(layeredPane);
		btnAjouter = new JButton("Cr\u00E9er un nouveau compte");
		btnAjouter.setBackground(new Color(175, 238, 238));
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAjouter.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAjouter.setBounds(20, 11, 415, 38);
		layeredPane.add(btnAjouter);
		btnSupprimer = new JButton("Supprimer un compte");
		btnSupprimer.setBackground(new Color(64, 224, 208));
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSupprimer.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSupprimer.setBounds(20, 70, 415, 38);
		layeredPane.add(btnSupprimer);
		btnAfficher = new JButton("Afficher tous les comptes");
		btnAfficher.setBackground(new Color(0, 255, 255));
		btnAfficher.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAfficher.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAfficher.setBounds(20, 134, 415, 37);
		layeredPane.add(btnAfficher);
		
		JButton btnAfficherType = new JButton("Afficher tous les comptes du m\u00EAme type");
		btnAfficherType.setBackground(new Color(192, 192, 192));
		btnAfficherType.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAfficherType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuBanque.this.frame.setVisible(false);
				AfficherTypeCompte.main(null);
			}
		});
		btnAfficherType.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAfficherType.setBounds(20, 182, 415, 38);
		layeredPane.add(btnAfficherType);
		
		JLabel lblNewLabel = new JLabel("Banque MoKass");
		lblNewLabel.setForeground(new Color(75, 0, 130));
		lblNewLabel.setBackground(new Color(176, 196, 222));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(354, 7, 207, 35);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Ou lavenir asire avek MoKass");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(354, 44, 222, 50);
		panel.add(lblNewLabel_1);
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuBanque.this.frame.setVisible(false);
				AfficherTousComptes.main(null);
			}
		});
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuBanque.this.frame.setVisible(false);
				SupprimmerCompte.main(null);
			}
		});
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuBanque.this.frame.setVisible(false);
				AjouterCompte.main(null);
			}
		});
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(frame, "voulez-vous vraiment quitter le programme", "MoKass Bank",
						
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					JOptionPane.showMessageDialog(frame, "Bye! revenez bientot!");

					System.exit(1);
				}
			}
		});
	}
}
