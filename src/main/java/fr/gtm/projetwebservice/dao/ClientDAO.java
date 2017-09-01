package fr.gtm.projetwebservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gtm.projetwebservice.dao.exceptions.AccountNotFoundDaoException;
import fr.gtm.projetwebservice.domaine.Client;
import fr.gtm.projetwebservice.domaine.Compte;

public class ClientDAO extends AbstractDAO {

	/**
	 * Get all clients of conseiller
	 * @param conseillerId conseiller id 
	 * @return list of clients
	 * @throws SQLException e
	 */
	public List<Client> getClientsByConseillerId(long idConseiller) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs =null;
		Client client = new Client();
		List<Client> clients = new ArrayList<Client>();
		Connection connection = null;
		
		try {
			connection = getConnection();
			String selectSQL = "select surname, name, email , adress from client where idConseiller = ?";
			st = connection.prepareStatement(selectSQL);
			st.setLong(1, idConseiller);
			
			rs = st.executeQuery();
			
			
		while (rs.next()) {
			
			client = new Client();
			client.setSurname(rs.getString("surname"));
			client.setName(rs.getString("name"));
			client.setEmail(rs.getString("email"));
			client.setAdress(rs.getString("adress"));
			
			clients.add(client);
		  }
			return clients;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
			for(int i=0; i<clients.size();i++) {
				System.out.println("la donnée associée à l'indice "+ i + " est " + clients.get(i));
			}
			return clients;		
		
	}
	
	public static void main(String[] args) throws SQLException, AccountNotFoundDaoException {
		Client cl = new Client();
		List<Client> cls = new ArrayList<Client>();
		System.out.println(cl);
	}
}
