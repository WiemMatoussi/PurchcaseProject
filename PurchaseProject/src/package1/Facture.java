package package1;

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
	
	public void AjouterLigneCommande(LigneCommande L) {
		
		
		c[i]=L;
		i++;
		System.out.println("Ajout d'une ligne de commande effectué \n ");
	}
	
	//Cette méthode permet de générer le total des lignes de commande d'une facture.
	
	public double PrixTotalCommande() {
		double Total=0;
		for(int i=0; i<c.length; i++) {
			Total= Total+c[i].montantLigneCommande();
			
		}
		
		return Total;
	}
	
	//Cette méthode permet d'afficher la commande (facture) qui permet de lister toutes les lignes de commande.
	
	public void AfficherCommande() {
		for(int i=0; i<c.length; i++) {
			    System.out.println("Lister produit de la facture");
				System.out.println("Quantité: "+c[i].getQuantiteLigne()+" Référence Produit: "+c[i].getIdLigneCommande());
		}
	}
	
	
	
}
