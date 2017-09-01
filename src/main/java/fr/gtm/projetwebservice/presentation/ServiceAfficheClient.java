/**package fr.gtm.projetwebservice.presentation;

import java.util.ArrayList;
import java.util.List;

import fr.gtm.projetwebservice.dao.ClientDAO;
import fr.gtm.projetwebservice.dao.exceptions.AccountNotFoundDaoException;
import fr.gtm.projetwebservice.domaine.Client;


public class ServiceAfficheClient {
	
	public List<Client> retourClient(int idConseiller) {
		try {
			ClientDAO clientDAO = new ClientDAO();
			
			List<Client> clients = new ArrayList<Client>();
			clients = clientDAO.getClientsByConseillerId(idConseiller);
			
			if (idConseiller.equals(client.getIdConseiller())
					return clients;
			
					else
						return null;
		} catch (AccountNotFoundDaoException e) {
			System.out.println(e.getMessage());
			return null;
			
				
			
			
		}
	}

}**/
