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

public class PyramideT1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PyramideT1 frame = new PyramideT1();
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
	public PyramideT1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNoir = new JButton("Noir");
		btnNoir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean res;
				//lancer test epreuve1 "Noir"
				res = true;
				//popup boire ou donner
				showResult(res);
				//go frame epreuve2
				goT2();
			}
		});
		btnNoir.setBounds(66, 92, 116, 72);
		contentPane.add(btnNoir);
		
		JButton btnRouge = new JButton("Rouge");
		btnRouge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean res;
				//lancer test epreuve1 "Rouge"
				res = true;
				//popup boire ou donner
				showResult(res);
				//go frame epreuve2
				goT2();
				
			}
		});
		btnRouge.setBounds(241, 92, 116, 72);
		contentPane.add(btnRouge);
		
		JLabel lblNEpreuve = new JLabel("Noir ou Rouge ?");
		lblNEpreuve.setBounds(169, 39, 84, 14);
		contentPane.add(lblNEpreuve);
	}
	
	private void goT2(){
		PyramideT2 pt2 = new PyramideT2();
		pt2.setVisible(true);
		dispose();
	}
	
	private void showResult(boolean res){
		ResultatDialog rd;
		if(res){
			rd = new ResultatDialog("Vous donnez 2 gorg�es !)");
		}
		else{
			rd = new ResultatDialog("Vous prenez 2 gorg�es !)");
		}
		rd.setVisible(true);
	}
	
}
