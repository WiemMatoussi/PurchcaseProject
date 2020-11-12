package metier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DatabaseConnectivity;

public class Facture {

	private int idFacture;
	LigneCommande c[]=new LigneCommande[2];
	int i=0;
	
	
	
	public Facture(int idFacture) {
		
		this.idFacture = idFacture;
		
	}
	
	public int getIdFacture() {
		return idFacture;
	}
	
	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}
	

       public static void AjouterFacture (Facture f) {
		
		DatabaseConnectivity c;
		try {
			c = new DatabaseConnectivity();
			PreparedStatement  pr = c.getC().prepareStatement("INSERT INTO Facture values(?)");
			pr.setInt(1, f.getIdFacture());
			
			System.out.print("Facture ajoutée avec succcés");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Echec d'ajout de la facture");
		}
		
		
	}

		
	public void AjouterLigneCommande(LigneCommande L) {
		
		
		c[i]=L;
		i++;
		System.out.println("Ajout d'une ligne de commande effectué \n ");
	}
	
	//Cette méthode permet de générer le total des lignes de commande d'une facture.
	
	public double PrixTotalCommande() {
		double Total=0;
		for(int i=0; i<c.length; i++) {
			Total= Total+c[i].calculPrixTotal();
			
		}
		
		return Total;
	}
	
	//Méthode qui permet de retourner un objet facture correspondant à l'identifiant id
	
	public static Facture getFacture(int id) {
		
		
		   Facture facture = null;

			DatabaseConnectivity c;
			try {
				
				c = new DatabaseConnectivity();
				Statement st1=c.getC().createStatement();
				ResultSet myRs=st1.executeQuery("select * from Facture WHERE idFacture="+id+"");
			 	if(myRs.next()) {
			 		
			 		facture =new Facture(myRs.getInt(1));  
			 	

				
			 		
			 		
			 	}
			 	
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
				return facture;
			}
			
	}

	
	//Afficher la facture
		public static void AfficherFacture(int idfacture) {
			
			DatabaseConnectivity c;
			
				try {
					c = new DatabaseConnectivity();
					Statement st1=c.getC().createStatement();
					ResultSet myRs=st1.executeQuery("select * from LigneCommande WHERE referenceFacture='"+idfacture+"'");
				 	while(myRs.next()) {
				 		
				 		System.out.println("Id ligne commande: "+myRs.getInt(1)+", Reference du livre: "+ myRs.getInt(2)+", Quantité "+myRs.getInt(3)+", Référence facture: " +myRs.getInt(4));
					
				
			 	
		
		
				}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
	
	//Cette méthode permet d'afficher la commande (facture) qui permet de lister toutes les lignes de commande.
	
	public void AfficherCommande() {
		for(int i=0; i<c.length; i++) {
			    System.out.println("Lister produit de la facture");
				System.out.println("Quantité: "+c[i].getQuantiteLigne()+" Référence Produit: "+c[i].getIdLigneCommande());
		}
	}
	
	
	
}
