package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Jeu_Cartes.Pyramide;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class PyramideT3 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PyramideT3 frame = new PyramideT3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public PyramideT3(Pyramide p) {
		p.setJoueurCourant(0);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNEpreuve = new JLabel("Entre "+p.getJoueurs().get(p.getJoueurCourant()).getCarte(0).getValeur()+ " et " + p.getJoueurs().get(p.getJoueurCourant()).getCarte(1).getValeur() + " ou à l'extérieur ?");
		lblNEpreuve.setBounds(169, 39, 255, 14);
		contentPane.add(lblNEpreuve);
		
		JLabel lblJoueur = new JLabel(p.getJoueurs().get(p.getJoueurCourant()).getNom());
		lblJoueur.setBounds(10, 11, 387, 14);
		contentPane.add(lblJoueur);
		
		JButton btnInterieur = new JButton("Interieur");
		btnInterieur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean res;
				res = p.tour3("interieur");
				showResult(res);
				if(p.getJoueurCourant()==p.getJoueurs().size()) goT4(p);
				else{
					lblJoueur.setText(p.getJoueurs().get(p.getJoueurCourant()).getNom());
					lblNEpreuve.setText("Entre "+p.getJoueurs().get(p.getJoueurCourant()).getCarte(0).getValeur()+ " et " + p.getJoueurs().get(p.getJoueurCourant()).getCarte(1).getValeur() + " ou à l'extérieur ?");
				}
			}
		});
		btnInterieur.setBounds(66, 92, 116, 72);
		contentPane.add(btnInterieur);
		
		JButton btnExterieur = new JButton("Exterieur");
		btnExterieur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean res;
				res = p.tour3("exterieur");
				showResult(res);
				if(p.getJoueurCourant()==p.getJoueurs().size()) goT4(p);
				else{
					lblJoueur.setText(p.getJoueurs().get(p.getJoueurCourant()).getNom());
					lblNEpreuve.setText("Entre "+p.getJoueurs().get(p.getJoueurCourant()).getCarte(0).getValeur()+ " et " + p.getJoueurs().get(p.getJoueurCourant()).getCarte(1).getValeur() + " ou à l'extérieur ?");
				}
			}
		});
		btnExterieur.setBounds(241, 92, 116, 72);
		contentPane.add(btnExterieur);
	}
	
	private void goT4(Pyramide p ){
		PyramideT4 pt4 = new PyramideT4(p);
		pt4.setVisible(true);
		dispose();
	}
	
	private void showResult(boolean res){
		ResultatDialog rd;
		if(res){
			rd = new ResultatDialog("Vous donnez 2 gorgées !)");
		}
		else{
			rd = new ResultatDialog("Vous prenez 2 gorgées !)");
		}
		rd.setVisible(true);
	}
	
}
