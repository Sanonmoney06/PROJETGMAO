

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Acceuil {

	private JFrame frmGmao;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil window = new Acceuil();
					window.frmGmao.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Acceuil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGmao = new JFrame();
		frmGmao.setTitle("Gestion de la Maintenance assistee par Ordinateur");
		frmGmao.getContentPane().setBackground(new Color(255, 255, 204));
		frmGmao.setBounds(100, 100, 645, 508);
		frmGmao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGmao.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Identifiant:");
		lblNewLabel.setIcon(new ImageIcon(Acceuil.class.getResource("/image/logo identifiant.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(89, 156, 177, 39);
		frmGmao.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" Mot de passe:");
		lblNewLabel_1.setIcon(new ImageIcon(Acceuil.class.getResource("/image/logo mot de passe.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(89, 255, 212, 39);
		frmGmao.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Suivant");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(461, 394, 85, 21);
		frmGmao.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quitter");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(327, 394, 85, 21);
		frmGmao.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(257, 161, 212, 31);
		frmGmao.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(268, 255, 201, 31);
		frmGmao.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(186, 53, 201, 59);
		frmGmao.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(Acceuil.class.getResource("/image/Capture d'écran 2024-06-19 144402.png")));
	}
}
