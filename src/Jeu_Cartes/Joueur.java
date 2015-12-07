package Jeu_Cartes;

import java.util.ArrayList;

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
	
	public Carte getCarte(int position){
		return this.main.get(position);
	}
	
	public void supprimerCarte(int position){
		this.main.remove(position);
	}
	
	public void trier(){
		 int n = this.main.size() - 1 ;
		 for (int i = n ; i >= 1 ; i --)
		    for (  int  j  =  2 ;  j <= i ;  j ++ ) 
			     if ( this.main.get(j-1).compare(this.main.get(j))>0){
				       Carte  temp  = this.main.get(j-1) ;
				       this.main.set(j-1,this.main.get(j)) ;
				       this.main.set(j,temp) ;
			     }
	}
	
	
}
