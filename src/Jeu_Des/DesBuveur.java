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
	
	public void lancer(){
		for(int i = 0; i< this.nbDes;i++){
			if(!etatDes[i])
			{
				des[i].lancer();
			}
		}
		System.out.println(this.getSomme());
		valider();
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
	
	public void lancer2(){
		for(int i = 0; i< this.nbDes;i++){
			if(!etatDes[i])
			{
				des[i].lancer();
			}
		}
		System.out.println(this.getSomme());
		valider();
	}
	
	public void nbCoup(){
		this.difference = 26 - this.getSomme();
		if(this.getSomme()==0){
			System.out.println("Au suivant !");
		}
		else if(this.getSomme()>0){
			System.out.println(Math.abs(difference));
		}
		else{
			System.out.println("A faire");
		}
	}
	
	public static void main(String[] args) {
		DesBuveur jeu = new DesBuveur();
		//jeu.getLancer(5);
		//jeu.DesBuveur();
		while(jeu.getNbRestant()>0){
			jeu.lancer();
		}
		jeu.nbCoup();
	}

}