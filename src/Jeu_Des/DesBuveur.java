package Jeu_Des;

import java.util.ArrayList;
import java.util.Scanner;

public class DesBuveur {
	
	private final int nbDes = 5;
	private final int nbFaces = 6;
	private int nbDesRestant;
	private De[] des; 
	private Scanner sc;
	private int difference;
	private ArrayList<Joueur> joueurs ;
	
	public DesBuveur(ArrayList<Joueur> joueurs){
		this.des = new De[this.nbDes];
		this.nbDesRestant = this.nbDes;
		for(int i = 0; i<this.nbDes; i++){
			des[i] = new De(this.nbFaces);
			this.des[i].conserver = false;
		}
		this.sc = new Scanner(System.in);
		this.difference = 0;
		this.joueurs = joueurs;
	}

	public void jouer(){
		//ListJoueurs(this.joueurs);
		for(int j = 0; j<this.joueurs.size(); j++){
			for(De de : this.des){
				de.conserver = false ;
			}
			this.nbDesRestant = this.nbDes;
			System.out.println(this.joueurs.get(j).getNom() + " : c'est votre tour!");
			while(this.nbDesRestant>0){
				lancer();
				valider();
			}
			resultat();
			if(this.difference == 0){
				System.out.println("Au suivant !");
			}
			else if(this.difference > 0){
				System.out.println("Vous devez prendre " + this.difference + " gorgée(s)");
			}
			else{
				attaquer();
				getGorgee();
				System.out.println("Vous devez donner " + getGorgee() + " gorgée(s)");
			}
		}
	}	
	
	public void lancer(){
		for(int i = 0; i< this.nbDes;i++){
			if(!this.des[i].conserver)
			{
				des[i].lancer();
			}
		}
	}
	
	public void valider(){
		boolean conserver = false;
		System.out.println("Validation :");
		for(int j = 0; j< this.nbDes;j++){
			if(!this.des[j].conserver)
			System.out.println(des[j].getValeur());
		}
		System.out.println("La somme de vos dés vaut : " + this.getSomme());
		int positionDeRestant = 0;
		for(int i = 0; i< this.nbDes;i++){
			if(!this.des[i].conserver)
			{
				System.out.println("Voulez-vous concerver la valeur " + des[i].getValeur() + " : (true/false)");
				boolean res = false;
				if(conserver == false && positionDeRestant == this.nbDesRestant - 1){
					res = true;
				}
				else
					res = sc.nextBoolean();
				if(res){
					this.des[i].conserver=true;
					conserver = true;
					this.nbDesRestant = this.nbDesRestant - 1;
				}
				positionDeRestant++;
			}
		}
	}
	
	public int getSomme(){
		int res= 0;
		for(int i = 0; i< this.nbDes;i++){
			res += des[i].getValeur();
		}
		return res; 
	}
	
	public int getNbRestant(){
		return this.nbDesRestant; 
	}
	
	public void attaquer(){
		this.difference = this.difference*-1;
		for(int i = 0; i< this.nbDes;i++){
			this.des[i].conserver = false;
		}
		System.out.println("Vous attaquez au " + this.difference);
		boolean attaquer = true;
		do{
			lancer();
			attaquer = validerAttaque();
		}	
		while(attaquer);
	}
	
	public int getGorgee()
	{
		int res = 0;
		for(int j = 0; j< this.nbDes;j++){
			if(this.des[j].getValeur() == this.difference)
				res += this.difference;
		}
		return res;
	}
	
	public boolean validerAttaque(){
		System.out.println("Résultat lancer : ");
		for(int j = 0; j< this.nbDes;j++){
			if(!this.des[j].conserver)
				System.out.println(des[j].getValeur());
		}
		boolean rejouer = false; 
		for(int i = 0; i< this.nbDes;i++){
			if(!this.des[i].conserver)
			{
				if(this.des[i].getValeur() == this.difference){
					this.des[i].conserver = true;
					rejouer = true;
				}	
			}
		}
		return rejouer;
	}
	
	public void resultat(){
		this.difference = 24 - this.getSomme();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Joueur> listeJ = new ArrayList<Joueur>();
		System.out.println("Combien de joueurs : ");
		int nbJoueurs = sc.nextInt();
		for(int i = 0; i<nbJoueurs; i++){
			String nomJoueur;
			System.out.println("Nom du joueur " + (i+1) + ": ");
			listeJ.add(new Joueur(nomJoueur = sc.next()));
		}
		DesBuveur jeu = new DesBuveur(listeJ);
		jeu.jouer();
		sc.close();
	}

}