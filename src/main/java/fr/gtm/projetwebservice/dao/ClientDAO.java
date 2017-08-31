package fr.gtm.projetwebservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gtm.projetwebservice.domaine.Client;

public class ClientDAO extends AbstractDAO {

	/**
	 * Get all clients of conseiller
	 * @param conseillerId conseiller id 
	 * @return list of clients
	 * @throws SQLException e
	 */
	public List<Client> getClientByConseillerId(long conseillerId) throws SQLException {
		List<Client> clients = new ArrayList<Client>();
		
		Connection connection = getConnection();
		
		String selectSQL = "select name, surname, email, address, idconseiller from client where idconseiller = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setLong(1, conseillerId);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			
			Client client = new Client();
			client.setName(rs.getString("name"));
			
			clients.add(client);
		}
		
		return clients;
	}
}
