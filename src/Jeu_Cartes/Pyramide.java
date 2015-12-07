package Jeu_Cartes;
import java.util.ArrayList;
import java.util.Scanner;

public class Pyramide {

	private JeuCarte tas ;
	private ArrayList<Joueur> joueurs ;
	private Scanner s;
	
	public Pyramide(ArrayList<Joueur> joueurs){
		this.tas = new JeuCarte(52);
		this.joueurs = joueurs ;
		s =  new Scanner(System.in) ;
	}
	
	public void jouer(){
		for(int tour = 1 ; tour <= 4 ; tour++){
			for(Joueur j : this.joueurs){
				System.out.println(j.getNom());
				Carte c;
				try{
					 c = tas.piocher() ;
					if(tour == 1){
						System.out.println("Noir ou rouge ?");
						String t1 = s.next();
						if(t1.equals("noir") && c.getCouleur() == COULEUR.Noir){
							System.out.println("Gagné");
						}
						else if(t1.equals("rouge") && c.getCouleur() == COULEUR.Rouge){
							System.out.println("Gagné");
						}
						else{
							System.out.println("Perdu");
						}
						j.ajouterCarte(c);
					}
					if(tour == 2){
						System.out.println("Plus ou moins que " + j.getCarte(0).getValeur() + " ?");
						String t1 = s.next();
						if(t1.equals("plus") && c.getCouleur() == COULEUR.Noir){
							System.out.println("Gagné");
						}
						else if(t1.equals("moins") && c.getCouleur() == COULEUR.Rouge){
							System.out.println("Gagné");
						}
						else{
							System.out.println("Perdu");
						}
						j.ajouterCarte(c);
					}
					if(tour == 3){
						System.out.println("Intérieur ou extérieur ?");
						
					}
					if(tour == 4){
						System.out.println("Symbole ?");
						
					}
				}
				catch(Exception e){
					System.out.println("Le tas est vide");
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		ArrayList<Joueur> listeJ = new ArrayList<Joueur>();
		listeJ.add(new Joueur("Damien"));
		listeJ.add(new Joueur("Mario"));
		Pyramide p = new Pyramide(listeJ);
		p.jouer();
	}

}
