package Jeu_Des;

public class De {

	private int nbFace;
	private int valeur;
	public boolean conserver;
	
	public De(){
		this.nbFace = 6;
		this.conserver = false;
	}
	
	public De(int nbFace){
		this.nbFace = nbFace;
		this.conserver = false;
	}
	
	public int getValeur(){
		return this.valeur;
	}
	
	public void lancer(){
		this.valeur = 1 + (int)(Math.random()*this.nbFace);
	}

}
