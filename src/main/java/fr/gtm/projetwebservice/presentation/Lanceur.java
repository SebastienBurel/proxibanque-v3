package fr.gtm.projetwebservice.presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.gtm.projetwebservice.dao.CompteDAO;
import fr.gtm.projetwebservice.domaine.Compte;

public class Lanceur {

	public static void main(String[] args) throws SQLException {
		

		Compte cpt = new Compte();
		ArrayList<Compte> comptes = new ArrayList<Compte>();
//		comptes.getCompteByIdClient(10001);
		
		CompteDAO compteDAO = new CompteDAO();
		
		comptes = compteDAO.getCompteByIdClient(1);

		System.out.println(comptes);

	}
}

