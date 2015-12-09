package Jeu_Cartes;
import java.util.ArrayList;
import java.util.Scanner;

public class Pyramide {

	private JeuCarte tas ;
	private ArrayList<Joueur> joueurs ;
	private int joueurCourant ;
	
	public Pyramide(ArrayList<Joueur> joueurs){
		this.tas = new JeuCarte(52);
		this.joueurs = joueurs ;
		this.joueurCourant = 0;
	}
	
	/*public void jouer(){
		for(int tour = 1 ; tour <= 4 ; tour++){
			for(Joueur j : this.joueurs){
				this.joueurCourant = j ;
				System.out.println(j.getNom());
				Carte c;
				try{
					c = tas.piocher() ;
					if(tour == 1){
						System.out.println("Noir ou rouge ?");
						String t1 = s.next();
						tour1(t1,c);
					}
					if(tour == 2){
						System.out.println("Plus ou moins que " + j.getCarte(0).getValeur() + " ?");
						String t2 = s.next();
						tour2(t2,c);
					}
					if(tour == 3){
						System.out.println("Entre "+j.getCarte(0).getValeur()+" et " + j.getCarte(1).getValeur()+ " ou � l'ext�rieur ?");
						String t3 = s.next();
						tour3(t3,c);
					}
					if(tour == 4){
						System.out.println("Symbole ?");
						String t4 = s.next();
						tour4(t4,c);
					}
				}
				catch(Exception e){
					System.out.println("Le tas est vide");
				}
			}
		}
	}*/
	
	public boolean tour1(String choix){
		boolean res = true ;
		try{
			Carte c = tas.piocher() ;
			if(choix.equals("noir") && c.getCouleur() == COULEUR.Noir){
				System.out.println("Gagn�");
			}
			else if(choix.equals("rouge") && c.getCouleur() == COULEUR.Rouge){
				System.out.println("Gagn�");
			}
			else{
				System.out.println("Perdu");
				res = false ;
			}
			this.joueurs.get(this.joueurCourant).ajouterCarte(c);
			this.joueurCourant++ ;
		}
		catch(Exception e){}
		return res ;
	}
	
	public boolean tour2(String choix){
		boolean res = true ;
		try{
			Carte c = tas.piocher() ;
			if(choix.equals("plus") && c.compare(this.joueurs.get(this.joueurCourant).getCarte(0))>0){
				System.out.println("Gagn�");
			}
			else if(choix.equals("moins") && c.compare(this.joueurs.get(this.joueurCourant).getCarte(0))<0){
				System.out.println("Gagn�");
			}
			else{
				System.out.println("Perdu");
				res = false ;
			}
			this.joueurs.get(this.joueurCourant).ajouterCarte(c);
			this.joueurCourant++ ;
		}
		catch(Exception e){}
		return res ;
	}
	
	public boolean tour3(String choix){
		boolean res = true ;
		try{
			Carte c = tas.piocher() ;
			if(choix.equals("interieur") && c.compare(this.joueurs.get(this.joueurCourant).getCarte(0))>0 && c.compare(this.joueurs.get(this.joueurCourant).getCarte(1))<0){
				System.out.println("Gagn�");
			}
			else if(choix.equals("exterieur") && (c.compare(this.joueurs.get(this.joueurCourant).getCarte(0))<0 || c.compare(this.joueurs.get(this.joueurCourant).getCarte(1))>0)){
				System.out.println("Gagn�");
			}
			else{
				System.out.println("Perdu");
				res = false ;
			}
			this.joueurs.get(this.joueurCourant).ajouterCarte(c);
			this.joueurCourant++ ;
		}
		catch(Exception e){}
		return res ;
	}
	
	public boolean tour4(String choix){
		boolean res = true ;
		try{
			Carte c = tas.piocher() ;
			if(choix.equals("pique") && c.getSymbole().equals(SYMBOLE.Pique)){
				System.out.println("Gagn�");
			}
			else if(choix.equals("coeur") && c.getSymbole().equals(SYMBOLE.Coeur)){
				System.out.println("Gagn�");
			}
			else if(choix.equals("carreau") && c.getSymbole().equals(SYMBOLE.Carreau)){
				System.out.println("Gagn�");
			}
			else if(choix.equals("trefle") && c.getSymbole().equals(SYMBOLE.Trefle)){
				System.out.println("Gagn�");
			}
			else{
				System.out.println("Perdu");
				res = false ;
			}
			this.joueurs.get(this.joueurCourant).ajouterCarte(c);
			System.out.println(c.getSymbole());
			this.joueurCourant++ ;
		}
		catch(Exception e){}
		return res ;
	}
	
	
	public int getJoueurCourant() {
		return joueurCourant;
	}

	public void setJoueurCourant(int joueurCourant) {
		this.joueurCourant = joueurCourant;
	}

	public ArrayList<Joueur> getJoueurs(){
		return joueurs;
	}

	//A supprimer
	public static void main(String[] args) {
		ArrayList<Joueur> listeJ = new ArrayList<Joueur>();
		listeJ.add(new Joueur("Mario"));
		listeJ.add(new Joueur("Damien"));
		Pyramide p = new Pyramide(listeJ);
	}

}