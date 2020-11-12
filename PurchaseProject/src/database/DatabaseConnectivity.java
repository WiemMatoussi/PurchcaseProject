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
		
		//Chargement du pilote sp�cifique au pilote de BD
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//D�finition du contexte de la connection(URL de la connection)
		
		String url="jdbc:mysql://localhost:3306/buildstore?serverTimezone=UTC";
		
		//r�cup�rer une r�f�rence vers la connexion � la base de donn�es
		
		c=DriverManager.getConnection(url, "root", "root");
		
		
		if(c==null) {
			
			System.out.println("Connexion non �tablie");
		}
		else {
			System.out.println("Connexion  �tablie");
		}
		
	}
	
	public Connection getC() {
		
		return c;
	}
	

	
	
	
	
}
