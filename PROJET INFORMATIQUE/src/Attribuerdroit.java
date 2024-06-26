import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class Attribuerdroit {

	private JFrame frmAttribuerDroit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Attribuerdroit window = new Attribuerdroit();
					window.frmAttribuerDroit.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Attribuerdroit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAttribuerDroit = new JFrame();
		frmAttribuerDroit.setTitle("Attribuer droit");
		frmAttribuerDroit.setBounds(100, 100, 550, 419);
		frmAttribuerDroit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAttribuerDroit.getContentPane().setLayout(null);
		
		JInternalFrame internalFrame = new JInternalFrame("Attribuer droit");
		internalFrame.setBounds(143, 10, 383, 362);
		frmAttribuerDroit.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Gerer demande de maintenance");
		lblNewLabel_4.setBounds(10, 25, 147, 13);
		internalFrame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Gerer Operateur");
		lblNewLabel.setBounds(10, 61, 121, 13);
		internalFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gerer devis");
		lblNewLabel_1.setBounds(10, 105, 91, 13);
		internalFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Supervision  maintenance");
		lblNewLabel_2.setBounds(10, 149, 147, 13);
		internalFrame.getContentPane().add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Attribuer");
		chckbxNewCheckBox.setBounds(204, 21, 93, 21);
		internalFrame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Attribuer");
		chckbxNewCheckBox_1.setBounds(204, 57, 93, 21);
		internalFrame.getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Attribuer");
		chckbxNewCheckBox_2.setBounds(204, 101, 93, 21);
		internalFrame.getContentPane().add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Attribuer");
		chckbxNewCheckBox_3.setBounds(204, 145, 93, 21);
		internalFrame.getContentPane().add(chckbxNewCheckBox_3);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.setBounds(32, 272, 85, 21);
		internalFrame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Enregistrer");
		btnNewButton_1_1.setBounds(204, 272, 107, 21);
		internalFrame.getContentPane().add(btnNewButton_1_1);
		internalFrame.setVisible(true);
	}
}
