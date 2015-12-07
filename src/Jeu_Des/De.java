package Jeu_Des;

public class De {

	private int nbFace;
	private int valeur;
	
	public De(){
		this.nbFace = 6;
	}
	
	public De(int nbFace){
		this.nbFace = nbFace;
	}
	
	public int getValeur(){
		return this.valeur;
	}
	
	public void lancer(){
		this.valeur = 1 + (int)(Math.random()*this.nbFace);
	}
	
	public static void main(String[] args) {
		De de = new De(6);
		de.lancer();
		System.out.println(de.getValeur());
	}

}
