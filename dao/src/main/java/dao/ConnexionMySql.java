package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionMySql {

	public Connection getConnexionMySQL (String nomBdd) {	
		Connection maConexion = null;
		// 1-- Charger driver
		try {
			Class.forName("com.mysql.jdbc.Driver"); // new Driver();

			// 2--Connexion avec la BDD
			String urlBDD = "jdbc:mysql://localhost:3306/" + nomBdd;
			String user = "root";
			String password = "";

			maConexion = DriverManager.getConnection(urlBDD, user, password);
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception au niveau du chemin du driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Exception au niveau de la connexion avec SQL");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return maConexion;
	}
}
