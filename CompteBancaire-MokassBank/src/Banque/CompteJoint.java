/* 
 * App Gestion des comptes bancaires
 * 
 * Auteur Lionel perrine
 * Date:18/05/2020 pendant le confinement
 *
 * pour la création d'un compte joint
 * 
 * 
 */
package Banque;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

// Classe fille CompteJoint hérite de la classe mère CompteCourant
public class CompteJoint extends CompteCourant {
	private JFrame frame;
	/*
	 * Les attributs de la classe
	 */
	private long idJoint;

	public long getIdJoint() {
		return idJoint;
	}

	public void setIdJoint(long idJoint) {
		this.idJoint = idJoint;
	}

/*/
 * Methode pour creer un compte joint
 */
	public String[] creerCompte(String id, String nom, String prenom, String dob,String sexe, String adresse,
			String typeCompte, String idJoint, String solde) {

		frame = new JFrame();
		String[] split;
		String idConvert = id;
		String noCompteConvert = "000" + idConvert;
		int jj, mm, aaaa;
	    long noCompte = Long.valueOf(noCompteConvert);
		solde = "0";
		typeCompte = "JOINT";
		CompteJoint client = new CompteJoint();//instantiation de l'objet client de la classe Compte

		try {
			// Affectation des valeurs des attributs de l'objet
			client.id = Long.parseLong(id);
			client.setIdJoint(Long.parseLong(idJoint));
			client.setNoCompte(noCompte);
			client.nom = nom;
			client.prenom = prenom;
			client.adresse = adresse;
			client.sexe = sexe;
			client.setTypeCompte(typeCompte);
			client.setSolde(Double.parseDouble(solde));

			split = dob.split("/");

			jj = Integer.parseInt(split[0]);
			mm = Integer.parseInt(split[1]);
			aaaa = Integer.parseInt(split[2]);

			if (jj < 0 || mm < 0 || aaaa < 1900) {
				JOptionPane.showMessageDialog(frame,"Erreur!! la date que vous avez inséré est invalide..");
			}

			if (jj > 31 || mm > 12 || aaaa > 2100) {
				JOptionPane.showMessageDialog(frame, "Erreur!! la date que vous avez inséré est invalide..");
			}

			client.dob = dob;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Erreur de saisie..vérifiez les données saisies...");
		}

		

		String[] TabJoint = { "000" + String.valueOf(client.getNoCompte()), " ", String.valueOf(client.id), " ",
				client.nom, " ", client.prenom, " ", client.dob, " ", client.adresse, " ", client.sexe, " ",
				client.getTypeCompte(), " ", String.valueOf(client.getSolde()), " ",
				String.valueOf(client.getIdJoint()), " ", "-", "\n" };

		return TabJoint;// retourne la table avec le résultat obtenu

	}
};
