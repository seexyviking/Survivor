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

public class PyramideT2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PyramideT2(Pyramide p) {
		p.setJoueurCourant(0);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJoueur = new JLabel(p.getJoueurs().get(p.getJoueurCourant()).getNom());
		lblJoueur.setBounds(10, 11, 371, 14);
		contentPane.add(lblJoueur);
		
		JLabel lblNEpreuve = new JLabel("Plus ou Moins que "+p.getJoueurs().get(p.getJoueurCourant()).getCarte(0).getValeur()+ " ?");
		lblNEpreuve.setBounds(158, 39, 209, 14);
		contentPane.add(lblNEpreuve);
		
		JButton btnPlus = new JButton("Plus");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean res;
				res = p.tour2("plus");
				p.getJoueurs().get(p.getJoueurCourant()-1).trier();
				showResult(res);
				if(p.getJoueurCourant()==p.getJoueurs().size()) goT3(p);
				else{
					lblJoueur.setText(p.getJoueurs().get(p.getJoueurCourant()).getNom());
					lblNEpreuve.setText("Plus ou Moins que "+p.getJoueurs().get(p.getJoueurCourant()).getCarte(0).getValeur()+ " ?");
				}
			}
		});
		btnPlus.setBounds(66, 92, 116, 72);
		contentPane.add(btnPlus);
		
		JButton btnMoins = new JButton("Moins");
		btnMoins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean res;
				res = p.tour2("moins");
				p.getJoueurs().get(p.getJoueurCourant()-1).trier();
				showResult(res);
				if(p.getJoueurCourant()==p.getJoueurs().size()) goT3(p);
				else{
					lblJoueur.setText(p.getJoueurs().get(p.getJoueurCourant()).getNom());
					lblNEpreuve.setText("Plus ou Moins que "+p.getJoueurs().get(p.getJoueurCourant()).getCarte(0).getValeur()+ " ?");
				}
			}
		});
		btnMoins.setBounds(241, 92, 116, 72);
		contentPane.add(btnMoins);
		
	}
	
	
	private void goT3(Pyramide p){
		PyramideT3 pt3 = new PyramideT3(p);
		pt3.setVisible(true);
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
