package fr.gtm.projetwebservice.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.gtm.projetwebservice.domaine.Compte;
import fr.gtm.projetwebservice.domaine.Conseiller;

public class CompteDAO  extends AbstractDAO {

	/**
	 * Get Compte from database by his idClient
	 * @param idClient int : client id
	 * @throws SQLException 
	 */

	public void getCompteByIdClient(int idClient) throws SQLException {

		Statement st =null;
		ResultSet rs =null;
		Compte compte = null;
		Connection connection = null;
		
		try {
		connection = getConnection();
		st = connection.createStatement();
		
//		String sql = "SELECT idNumber, idClient, balance FROM compte WHERE idClient = ? ";
		String sql = "SELECT idNumber, idClient, balance FROM compte WHERE idClient = 10001";

		rs = st.executeQuery(sql);
	
		while (rs.next()) {
			System.out.println(rs.getString("idnumber") + " " + rs.getString("balance"));
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
//		compte.setIdNumber(rs.getInt("idNumber"));
//		compte.setIdClient(rs.getInt("idClient"));
//		compte.setBalance(rs.getFloat("balance"));
		
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}finally {
//		try {
			connection.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//return compte;
		System.out.println(rs);
		}
	}
}		