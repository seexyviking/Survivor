package Jeu_Cartes;

import java.util.ArrayList;
import java.util.Collections;

public class JeuCarte {

	private ArrayList<Carte> listeCartes ;
	private int taillePaquet ;
	
	public JeuCarte(int taillePaquet){
		this.taillePaquet = taillePaquet ; 
		if(taillePaquet == 52){
			for(SYMBOLE s : SYMBOLE.values()){
				if(s.equals(SYMBOLE.Carreau) || s.equals(SYMBOLE.Coeur)){
					for(VALEUR v:  VALEUR.values()){
						this.listeCartes.add(new Carte(s, v, COULEUR.Rouge));
					}
				}
				else {
					for(VALEUR v:  VALEUR.values()){
						this.listeCartes.add(new Carte(s, v, COULEUR.Noir));
					}
				}
				
			}
		}
		else if(taillePaquet == 32){
			for(SYMBOLE s : SYMBOLE.values()){
				if(s.equals(SYMBOLE.Carreau) || s.equals(SYMBOLE.Coeur)){
					for(VALEUR v:  VALEUR.values()){
						if(v.equals(VALEUR.As) ||v.equals(VALEUR.Sept) ||v.equals(VALEUR.Huit) ||v.equals(VALEUR.Neuf) ||v.equals(VALEUR.Dix) ||v.equals(VALEUR.Valet) ||v.equals(VALEUR.Dame) ||v.equals(VALEUR.Roi)){
							this.listeCartes.add(new Carte(s, v, COULEUR.Rouge));
						}
					}
				}
				else {
					for(VALEUR v:  VALEUR.values()){
						if(v.equals(VALEUR.As) ||v.equals(VALEUR.Sept) ||v.equals(VALEUR.Huit) ||v.equals(VALEUR.Neuf) ||v.equals(VALEUR.Dix) ||v.equals(VALEUR.Valet) ||v.equals(VALEUR.Dame) ||v.equals(VALEUR.Roi)){
							this.listeCartes.add(new Carte(s, v, COULEUR.Noir));
						}
					}
				}
				
			}
		}
	}
	

	public ArrayList<Carte> getListeCartes() {
		return listeCartes;
	}

	public int getTaillePaquet() {
		return taillePaquet;
	}
	
	public void melanger(){
		Collections.shuffle(this.listeCartes);
	}
	
	public Carte piocher() throws Exception {
			if(this.listeCartes.size()<=0) throw new Exception("Plus de cartes dans le paquet");
			Carte c = this.listeCartes.get(this.listeCartes.size()-1);
			this.listeCartes.remove(this.listeCartes.size()-1);
			return c ;
	}
	
}
