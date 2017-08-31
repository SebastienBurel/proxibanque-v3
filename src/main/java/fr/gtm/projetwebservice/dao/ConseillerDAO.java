package fr.gtm.projetwebservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.gtm.projetwebservice.domaine.Conseiller;

public class ConseillerDAO extends AbstractDAO {

	/**
	 * Get Conseiller from database by his id
	 * @param login String : conseiller login
	 * @return Conseiller
	 * @throws SQLException 
	 */
	public Conseiller getConseillerByLogin(String login) throws SQLException {
		Conseiller conseiller = null;
		
		Connection connection = getConnection();
		
		String selectSQL = "SELECT login, password, idconseiller FROM conseiller WHERE login = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setString(1, login);
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			
			conseiller = new Conseiller();
			conseiller.setLogin(rs.getString("login"));
			conseiller.setPassword(rs.getString("password"));
			conseiller.setId(rs.getLong("idconseiller"));
		}
		
		return conseiller;
	}
	
	

}
