package fr.gtm.projetwebservice.presentation;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.gtm.projetwebservice.dao.CompteDAO;
import fr.gtm.projetwebservice.domaine.Compte;

public class PresentationListeComptesJSON {

public static void main(String[] args) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		


		ObjectMapper mapper = new ObjectMapper();
		ArrayList<Compte> comptes = new ArrayList<Compte>();

		
		CompteDAO compteDAO = new CompteDAO();
		
		comptes = compteDAO.getCompteByIdClient(1);

		System.out.println(comptes);
		File resultFile = new File("src/main/webapp/json/comptes.json");

		mapper.writeValue(resultFile, comptes);
	
	}

}
