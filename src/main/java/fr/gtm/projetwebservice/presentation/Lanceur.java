package fr.gtm.projetwebservice.presentation;

import fr.gtm.projetwebservice.dao.CompteDAO;

public class Lanceur {

	public static void main(String[] args) {
		
		
		CompteDAO compteDAO = new CompteDAO();
		
		compteDAO.getCompteByIdClient(idClient);
		
	}

}
