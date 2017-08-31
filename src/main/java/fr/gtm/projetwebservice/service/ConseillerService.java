package fr.gtm.projetwebservice.service;

import java.sql.SQLException;

import fr.gtm.projetwebservice.dao.CompteDAO;
import fr.gtm.projetwebservice.dao.ConseillerDAO;
import fr.gtm.projetwebservice.domaine.Compte;
import fr.gtm.projetwebservice.domaine.Conseiller;

public class ConseillerService {

	private ConseillerDAO conseillerDAO = new ConseillerDAO();
	private CompteDAO compteDAO = new CompteDAO();
	
	/**
	 * Get conseiller by his login
	 * @param login String : conseiller login
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
	 * @param idClient client id
	 * @return compte
	 */
	public Compte getCompteByIdClient(int idClient) {
		Compte compte = null;
		try {
			compte = compteDAO.getCompteByIdClient(idClient);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return compte;
	}
		
		
	}
	

