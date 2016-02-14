package br.com.herbertrausch.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnection {

	public SimpleConnection() {
		try {
			
			//define qual driver será utilizado
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} 
	}

	protected Connection getConnection() throws SQLException {

		//string jdbc de conexão
		String url = "jdbc:mysql://localhost/fadj_jdbc";
		
		//realiza a conexão com o banco de dados
		Connection conn = DriverManager.getConnection(url, "root", "");

		return conn;
	}

}
