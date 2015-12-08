package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class PyramideT4 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PyramideT4 frame = new PyramideT4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PyramideT4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTrefle = new JButton("Trefle");
		btnTrefle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean res;
				//lancer test epreuve4 "Trefle"
				res = true;
				//popup boire ou donner
				showResult(res);
				//fin epreuve
				dispose();
			}
		});
		btnTrefle.setBounds(64, 64, 116, 72);
		contentPane.add(btnTrefle);
		
		JButton btnCoeur = new JButton("Coeur");
		btnCoeur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean res;
				//lancer test epreuve4 "Coeur"
				res = true;
				//popup boire ou donner
				showResult(res);
				//fin epreuve
				dispose();
			}
		});
		btnCoeur.setBounds(232, 64, 116, 72);
		contentPane.add(btnCoeur);
		
		JLabel lblNEpreuve = new JLabel("Chosir symbole");
		lblNEpreuve.setBounds(169, 39, 84, 14);
		contentPane.add(lblNEpreuve);
		
		JButton btnPique = new JButton("Pique");
		btnPique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean res;
				//lancer test epreuve4 "Pique"
				res = true;
				//popup boire ou donner
				showResult(res);
				//fin epreuve
				dispose();
			}
		});
		btnPique.setBounds(64, 166, 116, 72);
		contentPane.add(btnPique);
		
		JButton btnCarreau = new JButton("Carreau");
		btnCarreau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean res;
				//lancer test epreuve4 "Carreau"
				res = true;
				//popup boire ou donner
				showResult(res);
				//fin epreuve
				dispose();
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
