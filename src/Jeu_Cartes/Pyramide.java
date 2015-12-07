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
						if(t1.equals("plus") && c.compare(j.getCarte(0))>0){
							System.out.println("Gagné");
						}
						else if(t1.equals("moins") && c.compare(j.getCarte(0))<0){
							System.out.println("Gagné");
						}
						else{
							System.out.println("Perdu");
						}
						j.ajouterCarte(c);
						j.trier();
					}
					if(tour == 3){
						System.out.println("Entre "+j.getCarte(0).getValeur()+" et " + j.getCarte(1).getValeur()+ " ou à l'extérieur ?");
						String t1 = s.next();
						if(t1.equals("interieur") && c.compare(j.getCarte(0))>0 && c.compare(j.getCarte(1))<0){
							System.out.println("Gagné");
						}
						else if(t1.equals("exterieur") && (c.compare(j.getCarte(0))<0 || c.compare(j.getCarte(1))>0)){
							System.out.println("Gagné");
						}
						else{
							System.out.println("Perdu");
						}
						j.ajouterCarte(c);
					}
					if(tour == 4){
						System.out.println("Symbole ?");
						String t1 = s.next();
						if(t1.equals("pique") && c.getSymbole().equals(SYMBOLE.Pique)){
							System.out.println("Gagné");
						}
						else if(t1.equals("coeur") && c.getSymbole().equals(SYMBOLE.Coeur)){
							System.out.println("Gagné");
						}
						else if(t1.equals("carreau") && c.getSymbole().equals(SYMBOLE.Carreau)){
							System.out.println("Gagné");
						}
						else if(t1.equals("trefle") && c.getSymbole().equals(SYMBOLE.Trefle)){
							System.out.println("Gagné");
						}
						else{
							System.out.println("Perdu");
						}
						j.ajouterCarte(c);
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
		Pyramide p = new Pyramide(listeJ);
		p.jouer();
	}

}
