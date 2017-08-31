package fr.gtm.projetwebservice.presentation;

import java.sql.SQLException;

import fr.gtm.projetwebservice.dao.CompteDAO;

public class Lanceur {

	public static void main(String[] args) throws SQLException {
		
		
		CompteDAO compteDAO = new CompteDAO();
		
		compteDAO.getCompteByIdClient(10001);
		
	}

}
