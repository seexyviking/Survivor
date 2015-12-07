package Jeu_Cartes;

public class Carte {

	private COULEUR couleur ;
	private VALEUR valeur ;
	private SYMBOLE symbole ;
	
	public Carte(SYMBOLE symbole, VALEUR valeur, COULEUR couleur){
		this.couleur = couleur ;
		this.valeur = valeur ;
		this.symbole = symbole ;
	}

	public COULEUR getCouleur() {
		return couleur;
	}

	public VALEUR getValeur() {
		return valeur;
	}

	public SYMBOLE getSymbole() {
		return symbole;
	}
	
	public int compare(Carte c){
		int pos1 = 0;
		int pos2 = 0 ;
		int cpt = 0 ;
		 for(VALEUR v : VALEUR.values()){
			 if(v.equals(this.valeur)) pos1 = cpt ;
			 if(v.equals(c.valeur)) pos2 = cpt ;
					 cpt++ ;
		 }
		 return pos1-pos2 ;
	}
	
}
