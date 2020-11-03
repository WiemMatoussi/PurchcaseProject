package package1;


public class LigneCommande {

	private int idLigneCommande;
	private double quantiteLigne;
	Produit P;



	public LigneCommande(int idLigneCommande, double quantiteLigne, Facture f, Produit p) {
		
		this.idLigneCommande = idLigneCommande;
		this.quantiteLigne = quantiteLigne;
		this.P = p;
	}



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



	public Produit getP() {
		return P;
	}



	public void setP(Produit p) {
		P = p;
	}


    //M�thode qui permet de multiplier le prix unitaire d'un produit avec la quantit� qui lui est associ�e.
	
	public double montantLigneCommande() {
		
		return  P.getPrixUitaire()*this.getQuantiteLigne();
		
	}

	// Cette m�thode permet d'afficher chaque ligne de la facture: le prix unitaire du produit ainsi que le nom et la quantit� qui lui est associ�e.
	
	public void afficherLigneCommande() {
		System.out.println("Affichage des d�tails des lignes des commandes");
		System.out.println("Prix unitaire du produit: "+P.getPrixUitaire());
		System.out.println("Le nom du du produit: "+P.getNomProduit());
		System.out.println("Quantit� Produit: "+getQuantiteLigne());
		
		
	}
	
	
	
}