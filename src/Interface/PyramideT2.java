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

public class PyramideT2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PyramideT2 frame = new PyramideT2();
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
	public PyramideT2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlus = new JButton("Plus");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean res;
				//lancer test epreuve2 "Plus"
				res = true;
				//popup boire ou donner
				showResult(res);
				//go frame epreuve3
				goT3();
			}
		});
		btnPlus.setBounds(66, 92, 116, 72);
		contentPane.add(btnPlus);
		
		JButton btnMoins = new JButton("Moins");
		btnMoins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean res;
				//lancer test epreuve2 "Moins"
				res = true;
				//popup boire ou donner
				showResult(res);
				//go frame epreuve3
				goT3();
			}
		});
		btnMoins.setBounds(241, 92, 116, 72);
		contentPane.add(btnMoins);
		
		JLabel lblNEpreuve = new JLabel("Plus ou Moins que ?");
		lblNEpreuve.setBounds(158, 39, 127, 14);
		contentPane.add(lblNEpreuve);
	}
	
	
	private void goT3(){
		PyramideT3 pt3 = new PyramideT3();
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
