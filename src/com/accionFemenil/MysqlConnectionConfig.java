package com.accionFemenil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlConnectionConfig {
	Connection con = null;
	private final String HOST = "localhost:3306";
	private final String DB = "accionFemenil";
	private final String USER = "k3nsh1n";
	private final String PWD = "k0rn82...";
	private final String SERVER = "serverTimezone=UTC";
	private final String URL = String.format("jdbc:mysql://%s/%s?user=%s&password=%s/%s", HOST, DB, USER, PWD, SERVER);
	
	public MysqlConnectionConfig() throws ClassNotFoundException {
		MysqlConnection();
	}
	
	
	public Connection MysqlConnection() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL);
			if(con.isValid(5000)) {
				System.out.println("Conexión Establecida");
			}else System.out.println("Conexión no establecida");
			return con;
		}catch(SQLException sqlerror) {
			System.out.println(sqlerror.getMessage());
		}
		return null;
	}


	
	
	
	
}
