package package1;
import java.util.Vector;

public class Utilisateur extends Personne {

	
	int n=1;
	private Utilisateur [] Utilisateurs=new Utilisateur[n];
	
	int i=0;
	
	public Utilisateur(int id, String nom, String prenom, String email) {
		super(id, nom, prenom, email);
		
	}
	
	
	
	//M�thode qui permet d'ajouter un utilisateur (agent commercial)
	
	
	
	 public void ajouterUtilisateur(Utilisateur U){
		  
		    if(i<=n)
		    {
		        Utilisateurs[i]=U;
		        System.out.println("Utilisateur ajout� avec succ�s");
		    i++;}
		        else 
		        System.out.println("erreur");
		    
		    }
	
	public void afficherUtilisateur() {
		
		for(int i=0; i<Utilisateurs.length;i++) {
			
			System.out.println("Affichage de l'utilisateur ajout�: Id: "+Utilisateurs[i].getId()+ " Pr�nom: "+Utilisateurs[i].getPrenom()+ " Email: "+Utilisateurs[i].getEmail() );

			
		}
	}
	
	
	
	
	
	
	
	
}
