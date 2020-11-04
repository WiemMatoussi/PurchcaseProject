package package1;

import java.util.Scanner;


public class Main {

	
	public static void main(String[] args) {
		 int session;
 		 Administrateur administareur=new Administrateur(1, "Wiem", "Matoussi", "WiemMatoussi@gmail.com");

		  
		    System.out.println("|   MENU SELECTION                                             |");
		    System.out.println("| Authentification:                                            |");
		    System.out.println("|   1. Se connecter en tant que adminisatrateur                |");
		    System.out.println("|   2. Se connecter en tant que utilisateur (Agent Commercial) |");
		    System.out.println("|   3. Exit                                                    |");
		    Scanner sc=new Scanner (System.in);
		    
		    session = sc.nextInt();

		    // Switch construct
		    switch (session) {
		    	case 1:
		    		System.out.println("Session Administrateur \n \n");
		   
			 
		    		System.out.println("Ajouter Produits et Utilisateurs \n \n");
		    		//Ces instructions permettent d'ajouter un utilisateur
		    		System.out.println("Entrer Id Utilisateur");
		    		int id=sc.nextInt();
		    		System.out.println("Entrer le nom utilisateur");
		    		
		    		System.out.println("Entrer le prenom utilisateur");
		    		String nom1=sc.nextLine();
		    		String prenom1=sc.nextLine();
		    		System.out.println("Entrer l'email utilisateur");
		    		String email1=sc.nextLine();
		     
		    		Utilisateur Agent=new Utilisateur(id ,nom1, prenom1, email1);
		    		Agent.ajouterUtilisateur(Agent);
		    		Agent.afficherUtilisateur();
		  	
		    		
		    		//Ces instructions permettent d'ajouter un produit
		    		System.out.println("\n \n Veuillez ajouter un produit");

		    		System.out.println("Entrer référence produit");
		    		int ref=sc.nextInt();
		    		System.out.println("Entrer le prix unitaire");
		    		double prixP=sc.nextDouble();
		    		System.out.println("Entrer le nom de produit");
		    		String nomP=sc.nextLine();
		    		System.out.println("Entrer la catégorie de produit");
		    		String cat=sc.nextLine();
		    		System.out.println("Entrer le stock de produit");
		    		int stock=sc.nextInt();
		     
		    		Produit P= new Produit(ref, prixP, nomP, cat, stock);
		    		P.ajouterProduit(P);
		    		P.afficherProduit();
		    		

		    		break;
		      
		      
		    	case 2:
		    		//On a testé pour un seul utilisateur
		    		System.out.println("Session Utilisateur (Agent commercial) \n \n");
		    		//Instantiation d'une facture (Commande)
		    		Facture F= new Facture(1);
		    		//Enregistrer une ligne de commande
		    		System.out.println("Enregistrer une ligne commande:");
		    		System.out.println("Entrer la référence produit");
		    		int r=sc.nextInt();
		    		System.out.println("Entrer le prix de produit");
		    		int prix=sc.nextInt();
		    		Produit P1= new Produit(r, prix, "CD", "Art", 5);
		  	
		    		System.out.println("Entrer la quantité de produit");
		    		int qte=sc.nextInt();
		    		System.out.println("Entrer la référence du deuxième produit");
		    		int r1=sc.nextInt();
		  	
		    		System.out.println("Entrer le prix du deuxième produit");
		    		int prix1=sc.nextInt();
		    		Produit P2= new Produit(r1,  prix1, "Livre", "Littérature", 5);

		    		LigneCommande L= new LigneCommande(1, qte, P1);
		    		System.out.println("Entrer la quantité du deuxième produit");
		    		int qt=sc.nextInt();

		    		LigneCommande L1= new LigneCommande(1, qt, P2);
		    		
		    		//Le résultat du prix total d'une quantité donnée
		    		double q=L.montantLigneCommande();
		    		double q1=L1.montantLigneCommande();
		  	
		    		//Ajout et affichage d'une ligne de commande
		    		F.AjouterLigneCommande(L);
		    		F.AjouterLigneCommande(L1);
		    		System.out.println(q+" $ est le résultat du prix total de la ligne de commande/facture numéro 1");
		  			System.out.println(q1+" $ est le résultat du prix total de la ligne de commande/facture numéro 2");
		  			
		  			// Calcul du prix total d'une commande (facture)
		  			double T=F.PrixTotalCommande();
		  			System.out.println("Le Prix total de la commande "+T +"$ \n \n");
		  			
		  			//Affichage des lignes de commandes
		  			L.afficherLigneCommande();
		  			L1.afficherLigneCommande();
		  			
		  			//Affichage de la (commande) facture entière
		  			F.AfficherCommande();
		  	
		  			break;
		    	case 3:
		    		System.out.println("Exit selected");
		    		break;
		    	default:
		    		System.out.println("Invalid selection \n");
		    		break; 
		    	}
		  
	
		    }
	
	
}
