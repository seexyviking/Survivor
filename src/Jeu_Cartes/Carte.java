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
		
	}
	
}
