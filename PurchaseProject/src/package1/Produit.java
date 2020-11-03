package package1;

import java.util.Vector;

public class Produit {

	
	
	private int reference;
	private double prixUitaire;
	private String nomProduit;
	private String categorie;
	private double quantitestock;
	int max=1;
	private Produit [] Pr =new Produit[max];
	int i=0;
	
	public Produit(int reference, double prixUitaire, String nomProduit, String categorie, int quantitestock) {
		
		this.reference = reference;
		this.prixUitaire = prixUitaire;
		this.nomProduit = nomProduit;
		this.categorie = categorie;
		this.quantitestock = quantitestock;
		
	}
	
	
	public double getReference() {
		return reference;
	}
	public void setReference(int reference) {
		this.reference = reference;
	}
	public double getPrixUitaire() {
		return prixUitaire;
	}
	public void setPrixUitaire(double prixUitaire) {
		this.prixUitaire = prixUitaire;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		categorie = categorie;
	}
	public double getQuantitestock() {
		return quantitestock;
	}
	public void setQuantitestock(double quantitestock) {
		this.quantitestock = quantitestock;
	}
	
	
	public void ajouterProduit(Produit P) {
		
		
		Pr[i]=P;
		i++;
		System.out.println("Produit ajouté avec succés \n ");
		
	}
	
	
	//Méthode qui affiche le produit
	public void afficherProduit() {
		
		for(int i=0; i<Pr.length;i++) {
			
			System.out.println("Affichage de produit ajouté: Réference: "+Pr[i].reference+", prix Uitaire: "+prixUitaire+", Catégorie: "+categorie+ ", Quantité en stock: "+quantitestock );
			
		}
	
	}
	
	

	
	
	
}
