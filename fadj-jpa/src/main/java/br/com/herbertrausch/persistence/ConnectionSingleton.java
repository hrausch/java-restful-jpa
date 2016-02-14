package br.com.herbertrausch.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import br.com.herbertrausch.util.PropertiesUtilSingleton;

public class ConnectionSingleton {

	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static ConnectionSingleton instance;
	private Connection conn = null;

	private String HOST = "";
	private String DB_NAME = "";
	private String USER = "";
	private String PASS = "";
	private String DB_URL = "";

	private ConnectionSingleton() {

	}

	public static synchronized ConnectionSingleton getInstance()
			throws ClassNotFoundException, SQLException {

		if (instance == null)
			instance = new ConnectionSingleton();

		return instance;
	}

	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		
		Class.forName(JDBC_DRIVER);
		try {

			getProperties();

			DB_URL = "jdbc:mysql://" + HOST + "/" + DB_NAME;
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.toString());

		}
		return this.conn;
	}

	public void closeConnection() throws SQLException {
		this.conn.close();
	}

	private void getProperties() throws IOException {
		Properties prop = PropertiesUtilSingleton.getInstance().getProp();
		DB_NAME = prop.getProperty("server.database");
		HOST = prop.getProperty("server.host");
		USER = prop.getProperty("server.user");
		PASS = prop.getProperty("server.pwd");
	}
}
