package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import database.DatabaseConnectivity;

public class LigneCommande {

	private int idLigneCommande;
	private double quantiteLigne;
	Livre l;
	Facture f;


	public LigneCommande(int idLigneCommande, double quantiteLigne, Livre l, Facture f) {
		
		this.idLigneCommande = idLigneCommande;
		this.quantiteLigne = quantiteLigne;
		this.l = l;
		this.f = f;
	}


	






	//Méthode qui permet de multiplier le prix unitaire d'un produit avec la quantité qui lui est associée.

	public int getIdLigneCommande() {
		return idLigneCommande;
	}





	public void setIdLigneCommande(int idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}





	public double getQuantiteLigne() {
		return quantiteLigne;
	}





	public void setQuantiteLigne(double quantiteLigne) {
		this.quantiteLigne = quantiteLigne;
	}





	public Livre getL() {
		return l;
	}





	public void setL(Livre l) {
		this.l = l;
	}





	public Facture getF() {
		return f;
	}





	public void setF(Facture f) {
		this.f = f;
	}

	//Cette méthode permet d'enregistrer la ligne de commande dans la base de données
    public void EnregistrerLigneCommande () {
		
		DatabaseConnectivity c;
		try {
			c = new DatabaseConnectivity();
			PreparedStatement  pr = c.getC().prepareStatement("INSERT INTO lignecommande values(?, ?, ?, ?)");
			pr.setInt(1, getIdLigneCommande());
			pr.setDouble(2, getQuantiteLigne());
			pr.setInt(3, getL().getReference());
			pr.setInt(4, getF().getIdFacture());
			
			pr.executeUpdate();
		System.out.print("Ligne de commande enregistrée avec succcés");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
    //Affichage de toutes les lignes de commandes
    
    public static void AfficherLignesCommande() {
		
		DatabaseConnectivity c;
		
			try {
				c = new DatabaseConnectivity();
				Statement st1=c.getC().createStatement();
				ResultSet myRs=st1.executeQuery("select * from LigneCommande");
			 	while(myRs.next()) {
			 		
			 		System.out.println("Id ligne commande: "+myRs.getInt(1)+", Quantité: "+ myRs.getInt(2)+", Référence livre: "+myRs.getInt(3)+", Référence facture: " +myRs.getInt(4));
				
			
		 	
	
	
			}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	//Méthode qui retourne une seule ligne de commande
	@SuppressWarnings("finally")
	public static LigneCommande getLigneCommande(int id) {
		
			
		   LigneCommande lignecommande = null;

			DatabaseConnectivity c;
			try {
				
				c = new DatabaseConnectivity();
				Statement st1=c.getC().createStatement();
				ResultSet myRs=st1.executeQuery("select * from LigneCommande WHERE idLigneCommande="+id+"");
			 	if(myRs.next()) {
			 		
			 		lignecommande =new LigneCommande(myRs.getInt(1), myRs.getInt(2), Livre.getLivre(myRs.getInt(3)), Facture.getFacture(myRs.getInt(3)));  
			 	   
			 		
			 		
			 		
			 	}
			 	
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
				return lignecommande;
			}
			
	}
	
	
	//Méthode qui permet de multiplier le prix unitaire d'un livre avec la quantité qui lui est associée.

		public double calculPrixTotal() {
			
			return  l.getPrixUnitaire()*this.getQuantiteLigne();
			
		}
	
	// Cette méthode permet d'afficher chaque ligne de la facture: le prix unitaire du produit ainsi que le nom et la quantité qui lui est associée.
	
	public void afficherLigneCommande() {
		System.out.println("Affichage des détails des lignes des commandes");
		System.out.println("Prix unitaire du produit: "+l.getPrixUnitaire());
		System.out.println("Le nom du du produit: "+l.getNomProduit());
		System.out.println("Quantité Produit: "+getQuantiteLigne());
		
		
	}
	
	
	
	
	
}