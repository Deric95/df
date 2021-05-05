
package Banque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//Classe mère 
public class CompteBancaire {
	/**
	 * Attributs de la classe mère
	 */
	private long noCompte;
	/**
	 * 
	 */
	private String TypeCompte;

	/**
	 * 
	 */
	private double solde;

	@SuppressWarnings("rawtypes")
	public void creerCompte(JFrame frame, JFrame frameConfirm, JComboBox cmbType, JTextField txtId,
			JTextField txtNom, JTextField txtPrenom,JTextField txtDOB, JComboBox cmbSexe, JTextField txtAdresse,
			JTextField txtIDJoint, JTextField txtTaux, String[] array) {
		String compte = cmbType.getSelectedItem().toString().toUpperCase();
		int i = 0;

		try {
			File banque = new File("banque.dat");
			if (!banque.exists()) {
				banque.createNewFile();
			}
			switch (compte) {
			case "JOINT":
				CompteJoint joint = new CompteJoint();
				array = (joint.creerCompte(txtId.getText(), txtNom.getText(), txtPrenom.getText(),
						txtDOB.getText(), cmbSexe.getSelectedItem().toString(), txtAdresse.getText(), cmbType.getSelectedItem().toString(),
						txtIDJoint.getText(), "0"));

				FileWriter fileWritterjoint = new FileWriter(banque.getName(), true);
				BufferedWriter bwjoint = new BufferedWriter(fileWritterjoint);
				for (i = 0; i < array.length; i++) {
					bwjoint.write(array[i]);
				}
				bwjoint.close();

				JOptionPane.showMessageDialog(frameConfirm,"Compte Joint Créer avec succès!!");
				frame.setVisible(false);
				MenuBanque.main(null);
				break;

			case "COURANT":
				CompteCourant courant = new CompteCourant();
				array = (courant.creerCompte(txtId.getText(), txtNom.getText(), txtPrenom.getText(),
						txtDOB.getText(), cmbSexe.getSelectedItem().toString(), txtAdresse.getText(), cmbType.getSelectedItem().toString(),
						txtIDJoint.getText()));
				FileWriter fileWrittercourant = new FileWriter(banque.getName(), true);
				BufferedWriter bwcourant = new BufferedWriter(fileWrittercourant);
				for (i = 0; i < array.length; i++) {
					bwcourant.write(array[i]);
				}
				bwcourant.close();

				JOptionPane.showMessageDialog(frameConfirm, "Compte Courant Créer avec succès!!");
				frame.setVisible(false);
				MenuBanque.main(null);
				break;

			case "EPARGNE":
				CompteEpargne epargne = new CompteEpargne();
				array = (epargne.creerCompte(txtId.getText(), txtNom.getText(), txtPrenom.getText(),
						txtDOB.getText(), cmbSexe.getSelectedItem().toString(), txtAdresse.getText(), cmbType.getSelectedItem().toString(),
						txtTaux.getText(), "0"));

				FileWriter fileWritterepargne = new FileWriter(banque.getName(), true);
				BufferedWriter bwepargne = new BufferedWriter(fileWritterepargne);
				for (i = 0; i < array.length; i++) {
					bwepargne.write(array[i]);
				}
				bwepargne.close();

				JOptionPane.showMessageDialog(frameConfirm, "Compte Epargne Créer avec succès!!");
				frame.setVisible(false);
				MenuBanque.main(null);
				break;

			default:
				JOptionPane.showMessageDialog(frameConfirm, "Vérifier vos données insérées.. Erreur de saisies....");
			}
		} catch (IOException e1) {
			e1.printStackTrace();

		}

	}

	@SuppressWarnings("resource")
	public void affichercompte() {

		String filePath = "banque.dat";
		File file = new File(filePath);

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			DefaultTableModel model = (DefaultTableModel) AfficherTousComptes.table.getModel();
			Object[] lines = br.lines().toArray();

			for (int i = 0; i < lines.length; i++) {
				String[] row = lines[i].toString().split(" ");
				model.addRow(row);
			}

		} catch (FileNotFoundException ex) {

		}

	}

	@SuppressWarnings({ "resource", "rawtypes" })
	public void affichertype(JComboBox Type, JTable table) {
		File writter = new File("rechercher.dat");
		try {
			if (writter.exists()) {
				writter.delete();
				writter.createNewFile();
			}

			if (!writter.exists()) {
				writter.createNewFile();
			}

			FileWriter fileWritter = new FileWriter(writter.getName(), false);
			File verificator = new File("banque.dat");
			Scanner in = null;
			in = new Scanner(verificator);
			while (in.hasNext()) {
				String line = in.nextLine();
				if (line.contains(Type.getSelectedItem().toString().toUpperCase())) {
					fileWritter.write(line);
					fileWritter.write("\n");
				}

			}
			fileWritter.close();
		} catch (Exception f) {
			f.printStackTrace();
		}

		String filePath = "rechercher.dat";
		File file = new File(filePath);

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			Object[] lines = br.lines().toArray();

			for (int i = 0; i < lines.length; i++) {
			}

			for (int i = 0; i < lines.length; i++) {
				String[] row = lines[i].toString().split(" ");
				model.addRow(row);
			}

		} catch (FileNotFoundException ex) {

		}
	}

	@SuppressWarnings({ "resource" })
	void supprimercompte(String string) {
		JFrame frame = new JFrame("Supprimer");
		File writter = new File("temp.dat");
		try {
			if (writter.exists()) {
				writter.delete();
				writter.createNewFile();
			}

			if (!writter.exists()) {
				writter.createNewFile();
			}

			FileWriter fileWritter = new FileWriter(writter.getName(), false);
			File read = new File("banque.dat");
			Scanner scan = null;
			scan = new Scanner(read);
			while (scan.hasNext()) {
				String line = scan.nextLine();
				if (!line.contains(string)) {
					fileWritter.write(line);
					fileWritter.write("\n");
				}

			}
			fileWritter.close();

			PrintWriter banque = new PrintWriter("banque.dat");
			banque.print("");
			banque.close();

		} catch (Exception f) {
			f.printStackTrace();
		}

		File modify = new File("banque.dat");
		try {
			if (modify.exists()) {
				modify.delete();
				modify.createNewFile();
			}

			if (!modify.exists()) {
				modify.createNewFile();
			}
			FileWriter filereWritter = new FileWriter(modify.getName(), false);
			File readagain = new File("temp.dat");
			Scanner rescan = null;
			rescan = new Scanner(readagain);
			while (rescan.hasNext()) {
				String reline = rescan.nextLine();
				filereWritter.write(reline);
				filereWritter.write("\n");

			}
			filereWritter.close();

		} catch (Exception f) {
			f.printStackTrace();
		}

		JOptionPane.showMessageDialog(frame, "Compte Supprimmé!!");
	}
/*
 * Méthode get and set pour gérer les variables privées
 */
	public long getNoCompte() {
		return noCompte;
	}

	public void setNoCompte(long noCompte) {
		this.noCompte = noCompte;
	}

	public String getTypeCompte() {
		return TypeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		TypeCompte = typeCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
}
