package Jeu_Des;

import java.util.Scanner;

public class DesBuveur {
	
	private static int nbDes = 5;
	private static int nbFaces = 6;
	private int nbDesRestant;
	private De[] des;
	private boolean[] etatDes; 
	private Scanner sc;
	private int difference;
	
	public DesBuveur(){
		this.des = new De[this.nbDes];
		this.etatDes = new boolean[this.nbDes];
		this.nbDesRestant = this.nbDes;
		for(int i = 0; i<this.nbDes; i++){
			des[i] = new De(this.nbFaces);
			etatDes[i] = false;
		}
		this.sc = new Scanner(System.in);
		this.difference = 0;
	}
	
	public void jouer(){
		this.nbDesRestant = this.nbDes;
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
	public void lancer(){
		for(int i = 0; i< this.nbDes;i++){
			if(!etatDes[i])
			{
				des[i].lancer();
			}
		}
		System.out.println(this.getSomme());
	}
	
	public void valider(){
		boolean conserver = false;
		System.out.println("Validation :");
		for(int j = 0; j< this.nbDes;j++){
			if(!etatDes[j])
			System.out.println(des[j].getValeur());
		}
		for(int i = 0; i< this.nbDes;i++){
			if(!etatDes[i])
			{
				System.out.println("Valeur à conserver : " + des[i].getValeur());
				System.out.println("Voulez vous le concerver (true/false)");
				boolean res = false;
				if(conserver == false && i == this.nbDesRestant - 1)
					res = true;
				else
					res = sc.nextBoolean();
				if(res){
					this.etatDes[i]=true;
					conserver = true;
					this.nbDesRestant = this.nbDesRestant - 1;
				}
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
			etatDes[i] = false;
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
		for(int j = 0; j< this.nbDes;j++){
			if(!etatDes[j])
				System.out.println(des[j].getValeur());
		}
		boolean rejouer = false;
		for(int i = 0; i< this.nbDes;i++){
			if(!etatDes[i])
			{
				if(this.des[i].getValeur() == this.difference){
					this.etatDes[i] = true;
					rejouer = true;
				}
					
			}
		}
		return rejouer;
	}
	
	public void resultat(){
		this.difference = 26 - this.getSomme();
		System.out.println(this.difference);
	}
	
	public static void main(String[] args) {
		DesBuveur jeu = new DesBuveur();
		//jeu.getLancer(5);
		//jeu.DesBuveur();
		jeu.jouer();
	}

}