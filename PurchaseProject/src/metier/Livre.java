package metier;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import database.DatabaseConnectivity;

public class Livre extends Produit {

	String titre;
	String auteur;
	Date DateDeSortie;
	
	
	public Livre(int reference, double prixUnitaire, String nomProduit, String categorie, int quantitestock,
			String titre, String auteur, Date dateDeSortie) {
		super(reference, prixUnitaire, nomProduit, categorie, quantitestock);
		this.titre = titre;
		this.auteur = auteur;
		DateDeSortie = dateDeSortie;
	}




	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public Date getDateDeSortie() {
		return DateDeSortie;
	}


	public void setDateDeSortie(Date dateDeSortie) {
		DateDeSortie = dateDeSortie;
	}


	@Override
	public String toString() {
		return "Livre: titre=" + titre + ", auteur=" + auteur + ", DateDeSortie=" + DateDeSortie + ".";
	}
	
	
	//Cette méthode permet d'ajouter un livre dans la base donnée
	
	public static void AjouterLivre (Livre l) {
		
		DatabaseConnectivity c;
		try {
			c = new DatabaseConnectivity();
			PreparedStatement  pr = c.getC().prepareStatement("INSERT INTO Livre values(?, ?, ?, ?, ?,?,?,?)");
			pr.setInt(1, l.getReference());
			pr.setDouble(2, l.getPrixUnitaire());
			pr.setString(3,l.getNomProduit());
			pr.setString(4, l.getCategorie());
			pr.setDouble(5, l.getQuantitestock());
			pr.setString(6, l.getTitre());
			pr.setString(7, l.getAuteur());
			pr.setDate(8, l.getDateDeSortie());
			pr.executeUpdate();
			System.out.print("Livre ajouté avec succcés");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Echec d'ajout");
		}
		
		
	}
	
	public void ModifierLivre(double prixUnitaire, String nomProduit, String categorie, int quantitestock,
			String titre, String auteur, Date dateDeSortie, int ref) {
		
		DatabaseConnectivity c;
		
			
				try {
					c = new DatabaseConnectivity();
					PreparedStatement  pr = c.getC().prepareStatement("UPDATE Livre SET prixUnitaire='"+prixUnitaire+"', nomProduit='"+nomProduit+"' , categorie='"+categorie+"', quantitestock='"+quantitestock+"', titre='"+titre+"', auteur='"+auteur+"', DateDeSortie='"+DateDeSortie+"'   WHERE reference='"+ref+"'");
					pr.executeUpdate();
					if(pr.executeUpdate()!=0)
						{System.out.println("Mise à jour effectuée avec succés");}
					else 
					{System.out.println("Echec de mise à jour effectuée");}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		
		
	
	
	//Cette méthode permet d'afficher un livre à partir de la base de données
	
	public static void AfficherLivre () throws SQLException, ClassNotFoundException {
		DatabaseConnectivity c=new DatabaseConnectivity();
		Statement st1=c.getC().createStatement();
		ResultSet myRs=st1.executeQuery("select * from Livre");
	 	while(myRs.next()) {
	 		
	 		System.out.println("Référence: "+myRs.getInt(1)+", Prix: "+ myRs.getDouble(2)+", Nom du produit: "+myRs.getString(3)+", Catégorie: " +myRs.getString(4)+ ", Quantité en stock: "+myRs.getDouble(5)+", Titre du livre: "+myRs.getString(6)+", Auteur: "+myRs.getString(7)+", Date de sorite: "+myRs.getDate(8)+ "\n");
		
			
	 	}
	}
	
	public static void RechercherLivre(int ref) {
		
		
		DatabaseConnectivity c;
		try {
			c = new DatabaseConnectivity();
			Statement st1=c.getC().createStatement();
			ResultSet myRs=st1.executeQuery("select * from Livre WHERE reference= ' "+ref+"'");
		 	while(myRs.next()) {
		 		
		 		System.out.println("Affichage des informations relatives au livre de référence: "+ref);
		 		System.out.println("Référence: "+myRs.getInt(1)+", Prix: "+ myRs.getDouble(2)+", Nom du produit: "+myRs.getString(3)+", Catégorie: " +myRs.getString(4)+ ", Quantité en stock: "+myRs.getDouble(5)+", Titre du livre: "+myRs.getString(6)+", Auteur: "+myRs.getString(7)+", Date de sorite: "+myRs.getDate(8));
			
				
		 	}
		 	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public static Livre getLivre(int id) {
		
		
		   Livre livre = null;

			DatabaseConnectivity c;
			try {
				
				c = new DatabaseConnectivity();
				Statement st1=c.getC().createStatement();
				ResultSet myRs=st1.executeQuery("select * from Livre WHERE reference="+id+"");
			 	if(myRs.next()) {
			 		
			 		livre =new Livre(myRs.getInt(1), myRs.getDouble(2), myRs.getString(3), myRs.getString(4), myRs.getInt(5), myRs.getString(6), myRs.getString(7), myRs.getDate(8));  
			 	

				
			 		
			 		
			 	}
			 	
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
				return livre;
			}
			
	}

	public static void SupprimerLivre(int ref)  {
		DatabaseConnectivity c;
		try {
			c = new DatabaseConnectivity();
			Statement st2=c.getC().createStatement();
			String requete3="DELETE FROM Livre where reference='"+ref+"'";
			int nb3=st2.executeUpdate(requete3);
			if(nb3==0) {
				System.out.println("echec de suppréssion");
				
			}
			else { System.out.println("Suppréssion effectuée avec succès");}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Impossible de supprimer le livre");
		}
		
	}
	
}
