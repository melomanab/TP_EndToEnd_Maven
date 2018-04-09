package dao;

import java.sql.Connection;
// import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domaine.Client;

public class DaoClient {
	
	ConnexionMySql con;
	Connection maConexion;
	
	public DaoClient() {
		super();
		this.con = new ConnexionMySql();
		this.maConexion =con.getConnexionMySQL("bddtomcat");
	}

	// -------------------------------------------------
	// --- Methode (1) - Create
	// -------------------------------------------------
	// Rajoute (INSERT) un enregistrement dans la table 'client' de la BDD 'bdd'
	// A partir de l'objet Client c

	public boolean createClient(Client c) {
		boolean clientCree = false;
		
		// 3-- Requete "INSERT"
		Statement stmt;
		try {
			stmt = maConexion.createStatement();

			// Recuperer propriet�s de client
			String sql = "INSERT INTO client ( `nom`, `prenom`, `age`, `idConseiller`) VALUES('"  + c.getNom() + "', '" + c.getPrenom()
					+ "', " + c.getAge() + ", " + c.getIdConseiller() + ")";

			System.out.println("--- Requete SQL: " + sql);
			// 4-- Executer
			int numLignes = stmt.executeUpdate(sql);
			// System.out.println("Nombre lignes cr��es:" + numLignes);

			if (numLignes == 1) {
				clientCree = true;
			}

		} catch (SQLException e) {
			System.out.println("Exception au niveau du chemin du driver");
			e.printStackTrace();
		}

		return clientCree;
	}

	// -------------------------------------------------
	// --- Methode (2) - Retrieve/Get
	// -------------------------------------------------
	// Obtient un enregistrement dans la table 'client' de la BDD 'bdd'
	// et en cr�e un objet Client c

	public Client getClient(int id) {

		Client c = new Client();
		try {
			// 3--Requete SELECT
			Statement stmt = maConexion.createStatement();

			// Recuperer propriet�s de client
			String sql = "SELECT * FROM client WHERE idClient=" + id;
			System.out.println("--- Requete SQL: " + sql);
			// 4-- Executer
			ResultSet resSet = stmt.executeQuery(sql);

			// 5-- Exploiter requete
			// Creer objet 'client' � partir d'enregistrement
			resSet.next();
			int idClient = resSet.getInt("idClient");
			String nom = resSet.getString("nom");
			String prenom = resSet.getString("prenom");
			int age = resSet.getInt("age");
			int idCons = resSet.getInt("idConseiller");

			c.setIdClient(idClient);
			c.setNom(nom);
			c.setPrenom(prenom);
			c.setAge(age);
			c.setIdConseiller(idCons);

		} catch (SQLException e) {
			System.out.println("Exception au niveau de la connexion avec SQL");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// -------------------------------------------------------------------------
		return c;
	}

	// -------------------------------------------------
	// --- Methode (3) - Update
	// -------------------------------------------------
	public boolean updateClient(Client c) {
		boolean clientMisAjour = false;
	
		try {
			
			// 3 -Requete UPDATE
			// TODO completer avec les autres proprietes
			Statement stmt = maConexion.createStatement();
			String sql = "UPDATE client SET " + "nom='" + c.getNom() + "' " + "WHERE idClient=" + c.getIdClient();


			System.out.println("--- Requete SQL: " + sql);
			// 4-- Executer
			int numUpdates = stmt.executeUpdate(sql);
			if (numUpdates > 0) {
				clientMisAjour = true;
			}


		} catch (SQLException e) {
			System.out.println("Exception au niveau de la connexion avec SQL");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// -------------------------------------------------------------------------
		return clientMisAjour;
	}
	// -------------------------------------------------
	// --- Methode (4) - Delete
	// -------------------------------------------------
	public boolean deleteClient(Client c) {
		boolean clientEfface = false;
		try {		
			// 3 -Requete DELETE
			Statement stmt = maConexion.createStatement();
			String sql = "DELETE FROM client WHERE idClient=" + c.getIdClient();

			System.out.println("--- Requete SQL: " + sql);
			// 4-- Executer
			int numUpdates = stmt.executeUpdate(sql);
			if (numUpdates > 0) {
				clientEfface = true;
			}

		} catch (SQLException e) {
			System.out.println("Exception au niveau de la connexion avec SQL");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clientEfface;
	}

	// -------------------------------------------------
	// --- Methode (5) - getAll
	// -------------------------------------------------
	public ArrayList<Client> getAllClients() {
		ArrayList<Client> mesClients = new ArrayList<Client>();
	
		try {
			
			// 3 -Requete SELECT ALL
			Statement stmt = maConexion.createStatement();
			String sql = "SELECT * FROM client";
			System.out.println("--- Requete SQL: " + sql);

			// 4 --Exe requete
			ResultSet resSet = stmt.executeQuery(sql);

			// 5 --Exploit resSet
			// Parcourir ligne apr�s ligne (1 ligne= 1 enregistrement)
			while (resSet.next()) {

				int currentIDClient = resSet.getInt("idClient");
				String currentNom = resSet.getString("nom");
				String currentPrenom = resSet.getString("prenom");
				int currentAge = resSet.getInt("age");
				int currentIDConseiller = resSet.getInt("idConseiller");

				Client currClient = new Client(currentIDClient, currentNom, currentPrenom, currentAge,
						currentIDConseiller);
				mesClients.add(currClient);
			}
	
		} catch (SQLException e) {
			System.out.println("Exception au niveau de la connexion avec SQL");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mesClients;
	}


}
