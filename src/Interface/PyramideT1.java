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

public class PyramideT1 extends JFrame {

	
	
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PyramideT1(Pyramide p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJoueur = new JLabel(p.getJoueurs().get(p.getJoueurCourant()).getNom());
		lblJoueur.setBounds(10, 11, 389, 14);
		contentPane.add(lblJoueur);
		
		//Button click noir
		JButton btnNoir = new JButton("Noir");
		btnNoir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean res;
				res = p.tour1("noir");
				showResult(res);
				if(p.getJoueurCourant()==p.getJoueurs().size()) goT2(p);
				else lblJoueur.setText(p.getJoueurs().get(p.getJoueurCourant()).getNom());
			}
		});
		btnNoir.setBounds(66, 92, 116, 72);
		contentPane.add(btnNoir);
		
		//Button click rouge
		JButton btnRouge = new JButton("Rouge");
		btnRouge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean res;
				res = p.tour1("rouge");
				showResult(res);
				if(p.getJoueurCourant()==p.getJoueurs().size()) goT2(p);
				else lblJoueur.setText(p.getJoueurs().get(p.getJoueurCourant()).getNom());
			}
		});
		btnRouge.setBounds(241, 92, 116, 72);
		contentPane.add(btnRouge);
		
		JLabel lblNEpreuve = new JLabel("Noir ou Rouge ?");
		lblNEpreuve.setBounds(169, 39, 140, 14);
		contentPane.add(lblNEpreuve);
		
		
	}
	
	private void goT2(Pyramide p){
		PyramideT2 pt2 = new PyramideT2(p);
		pt2.setVisible(true);
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
