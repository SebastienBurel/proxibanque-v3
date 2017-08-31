package fr.gtm.projetwebservice.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDAO {
	
	private final static String CLASS_NAME = "com.mysql.jdbc.Driver";
	private final static String HOSTNAME = "localhost";
	private final static int PORT = 3306;
	private final static String DBNAME = "proxybanquev3";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "root";
	
	/**
	 * Get sql connection to database
	 * @return Connection
	 */
	public Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName(CLASS_NAME);
			connection = DriverManager.getConnection("jdbc:mysql://"+HOSTNAME+":"+PORT+"/"+DBNAME, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
