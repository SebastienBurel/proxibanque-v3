package fr.gtm.projetwebservice.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;

import fr.gtm.projetwebservice.dao.exceptions.AccountNotFoundDaoException;
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
	
public void updateAccount(Compte compte) throws SQLException, AccountNotFoundDaoException {
		
		PreparedStatement stmt = null;
		Connection connection = null;

		try {
			// 1 - Chargement de driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2 - Creation d'une connection
			String url = "jdbc:mysql://localhost:3306/proxidb?useSSL=true&useLegacyDatetimeCode=false&serverTimezone=America/New_York";
			String login = "root";
			String password = "root";
			connection = DriverManager.getConnection(url, login, password);
			// 3 - preparation de la requete
			String requete = "update compte set balance = ? where idNumber = ?";
			stmt = connection.prepareStatement(requete);
			
			stmt.setFloat(1, compte.getBalance());
			stmt.setInt(2, compte.getIdNumber());
			
			// 4 - Execution de la requete
			int nombre = stmt.executeUpdate();
			if (nombre == 0) {
				throw new AccountNotFoundDaoException("Erreur : Le compte de numero " + compte.getIdNumber() + " n existe pas dans la bdd");
			}
			// 5 - Traitement du resultat

		} catch (Exception e) {
			throw new SQLException("Erreur1 " + e.getMessage());

		} finally {
			// 6 - Liberation des ressources
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				throw new SQLException("Erreur2 " + e.getMessage());
			}
		}
	}
	
	
	
	
	}
