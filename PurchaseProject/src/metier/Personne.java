package metier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DatabaseConnectivity;

public class Personne {

	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String session;
	
	
	
	
	
	public Personne(int id, String nom, String prenom, String email, String session) {
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.session = session;
	}
	
	
	
	
    public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getPrenom() {
		return prenom;
	}




	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getSession() {
		return session;
	}




	public void setSession(String session) {
		this.session = session;
	}




	public static void AjouterUtilisateur (Personne P) {
		
		DatabaseConnectivity c;
		try {
			c = new DatabaseConnectivity();
			PreparedStatement  pr = c.getC().prepareStatement("INSERT INTO Personne values(?, ?, ?, ?, ?)");
			pr.setInt(1, P.getId());
			pr.setString(2, P.getNom());
			pr.setString(3, P.getPrenom());
			pr.setString(4, P.getEmail());
			pr.setString(5, P.getSession());
			
			
			pr.executeUpdate();
			System.out.print("Utilisateur ajouté");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Echec d'ajout d'un utilisateur");
		}
		
		
	}


     public static void AfficherUtilisateur() {
    	 DatabaseConnectivity c;
		try {
			c = new DatabaseConnectivity();
			Statement st1=c.getC().createStatement();
	 		ResultSet myRs=st1.executeQuery("select * from Personne");
	 	 	while(myRs.next()) {
	 	 		
	 	 	System.out.println("id: "+myRs.getInt(1)+", Nom: "+ myRs.getString(2)+", Prénom: "+myRs.getString(3)+", Email: " +myRs.getString(4));
	 		
		}} 
	 	 	
	 	 	catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
 		
 		
	
}
