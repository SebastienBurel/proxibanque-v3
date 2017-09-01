package fr.gtm.projetwebservice.service;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.gtm.projetwebservice.dao.CompteDAO;
import fr.gtm.projetwebservice.dao.ConseillerDAO;
import fr.gtm.projetwebservice.domaine.Compte;
import fr.gtm.projetwebservice.domaine.Conseiller;

public class ConseillerService {

	private ConseillerDAO conseillerDAO = new ConseillerDAO();
	private CompteDAO compteDAO = new CompteDAO();

	/**
	 * Get conseiller by his login
	 * 
	 * @param login
	 *            String : conseiller login
	 * @return Conseiller
	 */
	public Conseiller getConseillerByLogin(String login) {
		Conseiller conseiller = null;
		try {
			conseiller = conseillerDAO.getConseillerByLogin(login);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conseiller;
	}

	/**
	 * Get compte by its idClient
	 * 
	 * @param idClient
	 *            client id
	 * @return compte
	 */
	public ArrayList<Compte> getCompteByIdClient(int idClient) {
		ArrayList<Compte> compte = null;
		try {
			compte = compteDAO.getCompteByIdClient(idClient);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return compte;
	}

	/**
	 * Methode de virements entre comptes
	 * @param idNumberCredit id du compte crediteur
	 * @param idNumberDebit id du compte debiteur
	 * @param amount montant de la transaction
	 * @throws SQLException
	 */
	public void moneyTransfer(int idNumberCredit, int idNumberDebit, float amount) throws SQLException {

		CompteDAO compteDAO = new CompteDAO();
		float balanceCredit = compteDAO.getBalanceByIdCompte(idNumberCredit);
		float balanceDebit = compteDAO.getBalanceByIdCompte(idNumberDebit);

		if (amount<0) {
			System.out.println("ERREUR : montant négatif");
			
			
		} else if (balanceDebit-amount<0){
			System.out.println("ERREUR : montant supérieur au solde disponible");
		}else {
			
		float newbalanceCredit = balanceCredit + amount;
		float newbalanceDebit = balanceDebit - amount;
		System.out.println(balanceCredit + " " + balanceDebit);
		System.out.println(newbalanceCredit + " " + newbalanceDebit);
		}
		
		
	
//		compteDAO.UpdateCompte(balanceCredit);
//		compteDAO.UpdateCompte(balanceDebit);

	}

}
