package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import metier.Livre;

public class DatabaseConnectivity {

	private Connection c=null;
	Statement stmt=null;
	
	public DatabaseConnectivity() throws ClassNotFoundException, SQLException {
		
		//Chargement du pilote spécifique au pilote de BD
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Définition du contexte de la connection(URL de la connection)
		
		String url="jdbc:mysql://localhost:3306/buildstore?serverTimezone=UTC";
		
		//récupérer une référence vers la connexion à la base de données
		
		c=DriverManager.getConnection(url, "root", "root");
		
		
		if(c==null) {
			
			System.out.println("Connexion non établie");
		}
		else {
			System.out.println("Connexion  établie");
		}
		
	}
	
	public Connection getC() {
		
		return c;
	}
	

	
	
	
	
}
