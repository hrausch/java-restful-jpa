package br.com.herbertrausch.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	public BaseDAO() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			//erro de driver
			e.printStackTrace();
		} 
	}

	protected Connection getConnection() throws SQLException {
		// URL de conexão com o banco de dados
		String url = "jdbc:mysql://localhost/fadj_jdbc";
		
		// Conecta utilizando a URL, usuário e senha.
		Connection conn = DriverManager.getConnection(url, "root", "");
		return conn;
	}

}
