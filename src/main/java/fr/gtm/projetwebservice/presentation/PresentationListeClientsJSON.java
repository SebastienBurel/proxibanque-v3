package fr.gtm.projetwebservice.presentation;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.gtm.projetwebservice.dao.ClientDAO;
import fr.gtm.projetwebservice.domaine.Client;

public class PresentationListeClientsJSON {
	
public static void main(String[] args) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		


		ObjectMapper mapper = new ObjectMapper();
		List<Client> clients = new ArrayList<Client>();

		
		ClientDAO clientDAO = new ClientDAO();
		
		clients = clientDAO.getClientsByConseillerId(1);

		System.out.println(clients);
		File resultFile = new File("src/main/webapp/json/listOfClients.json");

		mapper.writeValue(resultFile, clients);
	}

}
