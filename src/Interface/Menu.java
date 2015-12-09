package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Jeu_Cartes.Joueur;
import Jeu_Cartes.Pyramide;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnPyramide = new JButton("Pyramide");
		btnPyramide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Joueur> listeJ = new ArrayList<Joueur>();
				listeJ.add(new Joueur("Mario"));
				listeJ.add(new Joueur("Damien"));
				listeJ.add(new Joueur("Jonathan"));
				Pyramide p = new Pyramide(listeJ);
				PyramideT1 pt1 = new PyramideT1(p);
				pt1.setVisible(true);
			}
		});
		btnPyramide.setBounds(169, 110, 89, 23);
		frame.getContentPane().add(btnPyramide);
		
	}

}
