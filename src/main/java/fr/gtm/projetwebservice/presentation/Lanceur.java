package fr.gtm.projetwebservice.presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSeparatorUI;

import fr.gtm.projetwebservice.dao.CompteDAO;
import fr.gtm.projetwebservice.dao.exceptions.AccountNotFoundDaoException;
import fr.gtm.projetwebservice.domaine.Compte;
import fr.gtm.projetwebservice.service.ConseillerService;

public class Lanceur {

	public static void main(String[] args) throws SQLException, AccountNotFoundDaoException {
		

		//Compte cpt = new Compte();
		//ArrayList<Compte> comptes = new ArrayList<Compte>();
//		comptes.getCompteByIdClient(10001);
		
		CompteDAO compteDAO = new CompteDAO();
		
		//comptes = compteDAO.getCompteByIdClient(1);

		//System.out.println(comptes);
		
		
		
		
		float balance = compteDAO.getBalanceByIdCompte(10054890);
		System.out.println(balance);
		
		//test methode dans conseiller
		
		ConseillerService conseillerService = new ConseillerService();
		conseillerService.moneyTransfer(10054890, 10054894, 500);
		

	}
}

