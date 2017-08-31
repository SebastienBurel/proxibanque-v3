package fr.gtm.projetwebservice.presentation;

import java.sql.SQLException;

import fr.gtm.projetwebservice.dao.ConseillerDAO;
import fr.gtm.projetwebservice.domaine.Conseiller;

public class AuthentificationService {
	
	private ConseillerDAO conseillerDAO = new ConseillerDAO();
	
	/**
	 * Return true if login and password are valid
	 * @param login String : login sent by user
	 * @param pwd String : password sent by user
	 * @return true
	 */
	public boolean isAuthentificationValid(String login, String pwd) {
		
		boolean result = false;
		
		Conseiller conseiller = null;
		try {
			conseiller = conseillerDAO.getConseillerByLogin(login);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(null != conseiller) {
			if(null != conseiller.getPassword() && conseiller.getPassword().equals(pwd)) {
				result = true;
			}
		}
		
		return result;
	}

}
