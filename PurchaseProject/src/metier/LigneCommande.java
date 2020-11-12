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


	






	//M�thode qui permet de multiplier le prix unitaire d'un produit avec la quantit� qui lui est associ�e.

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

	//Cette m�thode permet d'enregistrer la ligne de commande dans la base de donn�es
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
		System.out.print("Ligne de commande enregistr�e avec succc�s");
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
			 		
			 		System.out.println("Id ligne commande: "+myRs.getInt(1)+", Quantit�: "+ myRs.getInt(2)+", R�f�rence livre: "+myRs.getInt(3)+", R�f�rence facture: " +myRs.getInt(4));
				
			
		 	
	
	
			}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	//M�thode qui retourne une seule ligne de commande
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
	
	
	//M�thode qui permet de multiplier le prix unitaire d'un livre avec la quantit� qui lui est associ�e.

		public double calculPrixTotal() {
			
			return  l.getPrixUnitaire()*this.getQuantiteLigne();
			
		}
	
	// Cette m�thode permet d'afficher chaque ligne de la facture: le prix unitaire du produit ainsi que le nom et la quantit� qui lui est associ�e.
	
	public void afficherLigneCommande() {
		System.out.println("Affichage des d�tails des lignes des commandes");
		System.out.println("Prix unitaire du produit: "+l.getPrixUnitaire());
		System.out.println("Le nom du du produit: "+l.getNomProduit());
		System.out.println("Quantit� Produit: "+getQuantiteLigne());
		
		
	}
	
	
	
	
	
}