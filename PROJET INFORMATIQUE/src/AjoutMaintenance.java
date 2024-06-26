

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjoutMaintenance {

	private JFrame frmAjoutmaintenance;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutMaintenance window = new AjoutMaintenance();
					window.frmAjoutmaintenance.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AjoutMaintenance() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAjoutmaintenance = new JFrame();
		frmAjoutmaintenance.setTitle("Ajoutmaintenance");
		frmAjoutmaintenance.setBounds(100, 100, 612, 476);
		frmAjoutmaintenance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAjoutmaintenance.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Compte rendu ");
		btnNewButton.setBounds(116, 408, 161, 21);
		frmAjoutmaintenance.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Detail maintenance");
		btnNewButton_1.setBounds(300, 408, 130, 21);
		frmAjoutmaintenance.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Suivant");
		btnNewButton_2.setBounds(462, 408, 103, 21);
		frmAjoutmaintenance.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Exporter Pdf");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(55, 37, 103, 21);
		frmAjoutmaintenance.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_1_1 = new JButton("Envoyer Mail");
		btnNewButton_1_1.setBounds(161, 37, 95, 21);
		frmAjoutmaintenance.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Envoyer SMS");
		btnNewButton_2_1.setBounds(266, 37, 95, 21);
		frmAjoutmaintenance.getContentPane().add(btnNewButton_2_1);
		
		JLabel lblNewLabel = new JLabel("Numero");
		lblNewLabel.setBounds(22, 91, 45, 13);
		frmAjoutmaintenance.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Libellé ");
		lblNewLabel_1.setBounds(22, 131, 45, 13);
		frmAjoutmaintenance.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Début ");
		lblNewLabel_2.setBounds(22, 179, 45, 13);
		frmAjoutmaintenance.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fin estimée ");
		lblNewLabel_3.setBounds(22, 230, 84, 13);
		frmAjoutmaintenance.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Type maintenance");
		lblNewLabel_4.setBounds(22, 274, 84, 13);
		frmAjoutmaintenance.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Intervenant");
		lblNewLabel_5.setBounds(22, 314, 84, 13);
		frmAjoutmaintenance.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Progression(pourcentage)");
		lblNewLabel_6.setBounds(28, 358, 130, 13);
		frmAjoutmaintenance.getContentPane().add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(161, 88, 116, 19);
		frmAjoutmaintenance.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("                           %");
		textField_1.setBounds(161, 355, 123, 19);
		frmAjoutmaintenance.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(161, 311, 116, 19);
		frmAjoutmaintenance.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(161, 128, 116, 19);
		frmAjoutmaintenance.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(161, 175, 116, 21);
		frmAjoutmaintenance.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(161, 226, 116, 21);
		frmAjoutmaintenance.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(161, 270, 116, 21);
		frmAjoutmaintenance.getContentPane().add(comboBox_1_1);
	}

}
