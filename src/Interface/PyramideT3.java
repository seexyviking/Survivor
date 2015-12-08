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

public class PyramideT3 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public PyramideT3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInterieur = new JButton("Interieur");
		btnInterieur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean res;
				//lancer test epreuve3 "Interieur"
				res = true;
				//popup boire ou donner
				showResult(res);
				//go frame epreuve4
				goT4();
			}
		});
		btnInterieur.setBounds(66, 92, 116, 72);
		contentPane.add(btnInterieur);
		
		JButton btnExterieur = new JButton("Exterieur");
		btnExterieur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean res;
				//lancer test epreuve3 "Exterieur"
				res = true;
				//popup boire ou donner
				showResult(res);
				//go frame epreuve4
				goT4();
				
			}
		});
		btnExterieur.setBounds(241, 92, 116, 72);
		contentPane.add(btnExterieur);
		
		JLabel lblNEpreuve = new JLabel("Interieur ou Exterieur ?");
		lblNEpreuve.setBounds(169, 39, 84, 14);
		contentPane.add(lblNEpreuve);
	}
	
	private void goT4(){
		//PyramideT3 pt3 = new PyramideT3();
		//pt3.setVisible(true);
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
