package fr.gtm.projetwebservice.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;

import fr.gtm.projetwebservice.domaine.Compte;
//import fr.gtm.projetwebservice.domaine.Conseiller;

public class CompteDAO  extends AbstractDAO {

	public ArrayList<Compte> getCompteByIdClient(int idClient) throws SQLException {

//		Statement st =null;
		PreparedStatement st = null;
		ResultSet rs =null;
		Compte cpt = new Compte();
		ArrayList<Compte> comptes = new ArrayList<Compte>();
		Connection connection = null;
		
		try {
		connection = getConnection();
//		st = connection.createStatement();

		String sql = "SELECT idNumber, idClient, balance FROM compte WHERE idClient = ?" ;
		st = connection.prepareStatement(sql);
		st.setLong(1, idClient);		
//		String sql = "SELECT idNumber, idClient, balance FROM compte WHERE idClient = 10001";

		rs = st.executeQuery();
	
		while (rs.next()) {
			cpt = new Compte();
			System.out.println(rs.getInt("idnumber") + " " + rs.getFloat("balance"));
			cpt.setIdNumber(rs.getInt("idNumber"));
			cpt.setIdClient(rs.getInt("idClient"));
			cpt.setBalance(rs.getFloat("balance"));
			comptes.add(cpt);

		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			connection.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		for(int i=0; i<comptes.size();i++) {
			System.out.println("la donnée associée à l'indice "+ i + " est " + comptes.get(i));
		}	
		return comptes;
	}
	
	public float getBalanceByIdCompte(int idNumber) throws SQLException {

//		Statement st =null;
		PreparedStatement st = null;
		ResultSet rs =null;
		Compte cpt = new Compte();
		float balance = 0;
		Connection connection = null;
		
		try {
		connection = getConnection();
//		st = connection.createStatement();

		String sql = "SELECT idNumber, idClient, balance FROM compte WHERE idNumber = ?" ;
		st = connection.prepareStatement(sql);
		st.setLong(1, idNumber);		
//		String sql = "SELECT idNumber, idClient, balance FROM compte WHERE idClient = 10001";

		rs = st.executeQuery();
	
		
		while (rs.next()) {
		//System.out.println(rs.getInt("idnumber") + " " + rs.getFloat("balance"));
			cpt.setIdNumber(rs.getInt("idNumber"));
			cpt.setIdClient(rs.getInt("idClient"));
			cpt.setBalance(rs.getFloat("balance"));
		}
			

		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			connection.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		return cpt.getBalance();
	}
	}
