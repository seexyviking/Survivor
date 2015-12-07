package Jeu_Cartes;

public class Joueur {
	
	private String nom ;
	private ArrayList<Carte> main ;
	
	public Joueur(String nom){
		this.nom = nom ;
		this.main = new ArrayList<Carte>() ;
	}
	
	public String getNom(){
		return this.nom ;
	}
	
	public void ajouterCarte(Carte c){
		this.main.add(c);
	}
	
	public void supprimerCarte(int position){
		this.main.detete(position);
	}
	
}
