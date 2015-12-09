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

public class PyramideT4 extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PyramideT4(Pyramide p) {
		p.setJoueurCourant(0);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJoueur = new JLabel(p.getJoueurs().get(p.getJoueurCourant()).getNom());
		lblJoueur.setBounds(10, 11, 414, 14);
		contentPane.add(lblJoueur);
		
		JLabel lblNEpreuve = new JLabel("Chosir symbole");
		lblNEpreuve.setBounds(169, 39, 128, 14);
		contentPane.add(lblNEpreuve);
		
		JButton btnTrefle = new JButton("Trefle");
		btnTrefle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean res;
				res = p.tour4("trefle");
				showResult(res);
				if(p.getJoueurCourant()==p.getJoueurs().size()) dispose();
				else{
					lblJoueur.setText(p.getJoueurs().get(p.getJoueurCourant()).getNom());
				}
			}
		});
		btnTrefle.setBounds(64, 64, 116, 72);
		contentPane.add(btnTrefle);
		
		JButton btnCoeur = new JButton("Coeur");
		btnCoeur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean res;
				res = p.tour4("coeur");
				showResult(res);
				if(p.getJoueurCourant()==p.getJoueurs().size()) dispose();
				else{
					lblJoueur.setText(p.getJoueurs().get(p.getJoueurCourant()).getNom());
				}
			}
		});
		btnCoeur.setBounds(232, 64, 116, 72);
		contentPane.add(btnCoeur);
		
		JButton btnPique = new JButton("Pique");
		btnPique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean res;
				res = p.tour4("pique");
				showResult(res);
				if(p.getJoueurCourant()==p.getJoueurs().size()) dispose();
				else{
					lblJoueur.setText(p.getJoueurs().get(p.getJoueurCourant()).getNom());
				}
			}
		});
		btnPique.setBounds(64, 166, 116, 72);
		contentPane.add(btnPique);
		
		JButton btnCarreau = new JButton("Carreau");
		btnCarreau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean res;
				res = p.tour4("carreau");
				showResult(res);
				if(p.getJoueurCourant()==p.getJoueurs().size()) dispose();
				else{
					lblJoueur.setText(p.getJoueurs().get(p.getJoueurCourant()).getNom());
				}
			}
		});
		btnCarreau.setBounds(232, 166, 116, 72);
		contentPane.add(btnCarreau);
		
		
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
