package fr.gtm.projetwebservice.presentation;

import java.sql.SQLException;

import fr.gtm.projetwebservice.dao.ConseillerDAO;
import fr.gtm.projetwebservice.domaine.Conseiller;

public class ConseillerService {

	private ConseillerDAO conseillerDAO = new ConseillerDAO();
	
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
}
