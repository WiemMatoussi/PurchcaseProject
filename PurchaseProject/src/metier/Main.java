package metier;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import database.DatabaseConnectivity;


public class Main {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		// Dans ce scéanrio, on utilise seulement la session d'adminimistarteur
		 int choix;


		    System.out.println("Session Administrateur: ");
		    System.out.println("|   MENU ADMINISTRATEUR                                        |");
		    System.out.println("|   Veuillez taper votre choix:                                |");
		    System.out.println("|   1. Ajouter Utillisateur                                    |");
		    System.out.println("|   2. Afficher Utilisateur                                    |");
 		    System.out.println("|   3. Ajouter Livre                                           |");
		    System.out.println("|   4. Modifier Livre                                          |");
		    System.out.println("|   5. Supprimer Livre                                         |");
		    System.out.println("|   6. Rechercher un Livre                                     |");
		    System.out.println("|   7. Afficher les livres                                     |");
		    System.out.println("|   8. Ajouter une facture                                     |");
		    System.out.println("|   9. Passer une commande                                     |");
		    System.out.println("|   10. Afficher les détails d'une facture                     |");
		    System.out.println("|   11. Calculer le prix total de la commande                  |");
 		    Scanner sc=new Scanner (System.in);
 		    
 		    choix = sc.nextInt();
 
 		   //Switch construct
		    switch (choix) {
		    	case 1: 
		    		
		    		
		    		
		    		
		    		System.out.println("Ajouter un utilisateur \n \n");
		    		System.out.println("Entrer Id Utilisateur");
		    		int id=sc.nextInt();
		    		System.out.println("Entrer le nom utilisateur");
		    		String nom1=sc.next();
		    		System.out.println("Entrer le prenom utilisateur");
		    		
 		    		String prenom1=sc.next();
  		    		System.out.println("Entrer l'email utilisateur");
 	    		    String email1=sc.next();
  		     
 		    		
		    		Personne P=new Personne(id,nom1, prenom1, email1, "utilisateur");
		    	    Personne.AjouterUtilisateur(P);
		    	    break;
		    	case 2: 
		    		Personne.AfficherUtilisateur();
		    		break;
		    		
		    	case 3:
		    		
		    		
		    		System.out.println("\n \n Veuillez ajouter un livre");
		    		System.out.println("Entrer référence Livre");
            		int ref=sc.nextInt();
                    System.out.println("Entrer le prix unitaire");
            		double prixL=sc.nextDouble();
                   
                 	System.out.println("Entrer la catégorie de livre");
                	String cat=sc.next();
    	    		System.out.println("Entrer quantité en stock");
            		int stock=sc.nextInt();
            		System.out.println("Entrer le titre de livre");
             		String titre=sc.next();
             		System.out.println("Entrer le nom de l'auteur");
            		String auteur=sc.next();
             		System.out.println("Entrez la date au format aaaa-mm-jj");
             		
             		String str=sc.next(); 
             		Date date=Date.valueOf(str);
//             		int j=sc.nextInt();
//             		int m=sc.nextInt();
//             		int a=sc.nextInt();
//           		   Date d=new Date (a-m-j);
                    Livre L= new Livre(ref, prixL, "Livre", cat, stock, titre, auteur, date);
                     Livre.AjouterLivre(L);
                     break;
                     
		    	case 4:
		    		Livre.AfficherLivre();
		    		Date D1=new Date(2020-11-11);
		    		Livre L4= new Livre(1, 2, "Livre", "at", 5, "titre", "auteur", D1);
		    		System.out.println("Entrer la référence du Livre à modifier");
            		int refm=sc.nextInt();
            		System.out.println("Entrer le prix unitaire");
            		double prixM=sc.nextDouble();
                   
                 	System.out.println("Entrer la catégorie de livre");
                	String catM=sc.next();
    	    		System.out.println("Entrer quantité en stock");
            		int stockM=sc.nextInt();
            		System.out.println("Entrer le titre de livre");
             		String titreM=sc.next();
             		System.out.println("Entrer le nom de l'auteur");
            		String auteurM=sc.next();
            		System.out.println("Entrez la date au format aaaa-mm-jj");
             		
             		String strM=sc.next(); 
             		Date dm=Date.valueOf(strM);
           		    //Puisque la classe de livre hérite de la classe de produit, la catégorie du livre sera par défaut "livre"
		    		L4.ModifierLivre(prixM,  "livre", catM, stockM, titreM, auteurM, dm,refm);
		    		break;
		    		
		    	case 5:
		    		
		    		Livre.AfficherLivre();
		    		
		    		System.out.println("\n Entrer la référence du Livre à supprimer");
            		int refsupp=sc.nextInt();
		    		Livre.SupprimerLivre(refsupp);
		    		break;
		    	case 6:
		    		
		    		System.out.println("Entrer la référence du Livre");
		    		int rechRef=sc.nextInt();
		    		Livre.RechercherLivre(rechRef);
		    		break;
		    		
		    	case 7:
		    	
		    		Livre.AfficherLivre();
		    		break;
		    		
		    	case 8:
		    		System.out.println("Entrer la reference de la facture");
		    		int idfacture=sc.nextInt();
		    		Facture F= new Facture(idfacture);
		    		Facture.AjouterFacture(F);
		    		break;
		    		
		    	case 9:
		    		
		    		
		    		System.out.println("Entrer la reference de la ligne de commande");
		    		int idlc=sc.nextInt();
		    		
		    		Livre.AfficherLivre();
		    		
		    		System.out.println("Entrer la reference du livre");
		    		int idlivre=sc.nextInt();
		    		
		    		
		    		
		    		
		    		Livre L7=new Livre (idlivre,7 ,""," ", 7, "", "",null );
		    	   
		    		
		    		System.out.println("Entrer la reference de la facture");
		    		int idfacture1=sc.nextInt();
		    		Facture F1= new Facture(idfacture1);
		    		
		    		System.out.println("Entrer la quantité");
		    		Double qte=sc.nextDouble();
		    		
		    		LigneCommande lc=  new LigneCommande(idlc, qte, L7, F1);
		    		
//		    		
		    		lc.EnregistrerLigneCommande();
		    		
		    		//Le résultat du prix total d'une quantité donnée
					//LigneCommande.calculmontantLigneCommande(121);
					
					//System.out.println(q+" $ est le résultat du prix total de la ligne de commande/facture numéro 1");
					
		    		break;
		    		
		    
		    
		    case 10: 
		    	
		    	
		    	System.out.println("Entrer la reference de la facture à afficher");
	    		int idfacture2=sc.nextInt();
			
				//Facture F8= new Facture(idfacture1);
				
				Facture.AfficherFacture(idfacture2);
		    	break;
		    
		    case 11: 
		    	LigneCommande.AfficherLignesCommande();
		    	System.out.println("\n Entrer l'identifiant de la ligne de commande de la ligne de commande dont vous voulez calculer le prix total");
		    	int idligne=sc.nextInt();
		    	LigneCommande lignecommande=LigneCommande.getLigneCommande(idligne);
	    		
	    		double q=lignecommande.calculPrixTotal();
	    		System.out.println(q+"$ est le prix total de cette ligne de commande");
	    		break;
		    case 12:
 	    		System.out.println("Exit selected");
 	    		break;
 	    	default:
 	    		System.out.println("Invalid selection \n");
	    		break; 
	    		
	    		
		    }}}
		    
//	