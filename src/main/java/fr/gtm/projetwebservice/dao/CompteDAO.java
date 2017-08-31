package fr.gtm.projetwebservice.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.gtm.projetwebservice.domaine.Compte;
import fr.gtm.projetwebservice.domaine.Conseiller;

public class CompteDAO  extends AbstractDAO {

	/**
	 * Get Compte from database by his idClient
	 * @param idClient int : client id
	 * @return Compte
	 * @throws SQLException 
	 */
	public Compte getCompteByIdClient(int idClient) throws SQLException {
		Compte compte = null;
		
		Connection connection = getConnection();
		
		String selectSQL = "SELECT idNumber, idClient, balance FROM compte WHERE idClient = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setInt(1, idClient);
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			
			compte = new Compte();
			compte.setIdNumber(rs.getInt("idNumber"));
			compte.setIdClient(rs.getInt("idClient"));
			compte.setBalance(rs.getFloat("balance"));
		}
		
		return compte;
	}
	
	

}

