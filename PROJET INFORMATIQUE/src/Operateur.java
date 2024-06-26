 import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class Operateur {
	private JFrame frmOperateur;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Operateur window = new Operateur();
					window.frmOperateur.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Operateur() {
		initialize();
	}

	private void initialize() {
		frmOperateur = new JFrame();
		frmOperateur.setTitle("Operateur");
		frmOperateur.setBounds(100, 100, 725, 536);
		frmOperateur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOperateur.getContentPane().setLayout(null);
		JInternalFrame internalFrame = new JInternalFrame("Gestion Operateur", true, true, true, true);
		internalFrame.setBounds(134, 24, 577, 453);
		frmOperateur.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("effectuer Intervention");
		btnNewButton.setBounds(10, 50, 103, 21);
		internalFrame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Consulter fiche ");
		btnNewButton_1.setBounds(10, 114, 103, 21);
		internalFrame.getContentPane().add(btnNewButton_1);
		
		JInternalFrame internalFrame_1 = new JInternalFrame("Effectuer intervention", true, true, true, true);
		internalFrame_1.setBounds(123, 0, 442, 411);
		internalFrame.getContentPane().add(internalFrame_1);
		internalFrame_1.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Type d'intervention");
		lblNewLabel.setBounds(68, 60, 104, 13);
		internalFrame_1.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(68, 108, 45, 13);
		internalFrame_1.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Prenom");
		lblNewLabel_2.setBounds(68, 154, 45, 13);
		internalFrame_1.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Date de debut");
		lblNewLabel_3.setBounds(68, 206, 79, 13);
		internalFrame_1.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Date de fin");
		lblNewLabel_4.setBounds(68, 254, 90, 13);
		internalFrame_1.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("Retour");
		btnNewButton_3.setBounds(10, 337, 85, 21);
		internalFrame_1.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Enregistrer");
		btnNewButton_4.setBounds(289, 337, 85, 21);
		internalFrame_1.getContentPane().add(btnNewButton_4);

		JTextField textField = new JTextField();
		textField.setBounds(218, 57, 139, 19);
		internalFrame_1.getContentPane().add(textField);
		textField.setColumns(10);

		JTextField textField_1 = new JTextField();
		textField_1.setBounds(218, 105, 139, 19);
		internalFrame_1.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JTextField textField_2 = new JTextField();
		textField_2.setBounds(218, 151, 139, 19);
		internalFrame_1.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JTextField textField_3 = new JTextField();
		textField_3.setBounds(218, 204, 139, 16);
		internalFrame_1.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JTextField textField_4 = new JTextField();
		textField_4.setBounds(230, 251, 127, 19);
		internalFrame_1.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		internalFrame_1.setVisible(true);
		internalFrame.setVisible(true);
	}

}