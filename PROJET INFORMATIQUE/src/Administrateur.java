import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Administrateur {

    private JFrame frmAdministrateur;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JInternalFrame internalFrame;
    private JInternalFrame internalFrameAttribuerDroit;
    private JInternalFrame internalFrameAjoutResponsable;
    private JInternalFrame internalFrameListeResponsable;
    private JTable table;
    private DefaultTableModel tableModel;

    private List<Donnee_Responsable_Maintenance> responsables;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Administrateur window = new Administrateur();
                    window.frmAdministrateur.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Administrateur() {
        responsables = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        frmAdministrateur = new JFrame();
        frmAdministrateur.setTitle("Administrateur");
        frmAdministrateur.getContentPane().setBackground(new Color(255, 255, 204));
        frmAdministrateur.setBounds(100, 100, 705, 430);
        frmAdministrateur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAdministrateur.getContentPane().setLayout(null);

        JButton btnNewButton_1 = new JButton("Gestion responsable maintenance");
        btnNewButton_1.setBounds(10, 102, 112, 33);
        frmAdministrateur.getContentPane().add(btnNewButton_1);

        internalFrame = new JInternalFrame("Gestion responsable maintenance", true, true, true, true);
        internalFrame.setBounds(125, 0, 566, 393);
        frmAdministrateur.getContentPane().add(internalFrame);
        internalFrame.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("Ajouter");
        btnNewButton.setBounds(10, 10, 119, 21);
        internalFrame.getContentPane().add(btnNewButton);

        JButton btnNewButton_2 = new JButton("Liste responsable maintenance");
        btnNewButton_2.setBounds(10, 57, 119, 21);
        internalFrame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Attribuer droit");
        btnNewButton_3.setBounds(10, 112, 119, 21);
        internalFrame.getContentPane().add(btnNewButton_3);

        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAttribuerDroitInternalFrame();
            }
        });

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAjoutResponsableInternalFrame();
            }
        });

        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showListeResponsableInternalFrame();
            }
        });

        internalFrame.setVisible(true);
    }

    protected void showAttribuerDroitInternalFrame() {
        hideAllInternalFrames();
        if (internalFrameAttribuerDroit == null) {
            internalFrameAttribuerDroit = new JInternalFrame("Attribuer droit", true, true, true, true);
            internalFrameAttribuerDroit.setBounds(143, 10, 383, 362);
            internalFrameAttribuerDroit.getContentPane().setLayout(null);

            JLabel lblNewLabel_4 = new JLabel("Gérer demande de maintenance");
            lblNewLabel_4.setBounds(10, 25, 147, 13);
            internalFrameAttribuerDroit.getContentPane().add(lblNewLabel_4);

            JLabel lblNewLabel = new JLabel("Gérer Opérateur");
            lblNewLabel.setBounds(10, 61, 121, 13);
            internalFrameAttribuerDroit.getContentPane().add(lblNewLabel);

            JLabel lblNewLabel_1 = new JLabel("Gérer devis");
            lblNewLabel_1.setBounds(10, 105, 91, 13);
            internalFrameAttribuerDroit.getContentPane().add(lblNewLabel_1);

            JLabel lblNewLabel_2 = new JLabel("Supervision maintenance");
            lblNewLabel_2.setBounds(10, 149, 147, 13);
            internalFrameAttribuerDroit.getContentPane().add(lblNewLabel_2);

            JCheckBox chckbxNewCheckBox = new JCheckBox("Attribuer");
            chckbxNewCheckBox.setBounds(204, 21, 93, 21);
            internalFrameAttribuerDroit.getContentPane().add(chckbxNewCheckBox);

            JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Attribuer");
            chckbxNewCheckBox_1.setBounds(204, 57, 93, 21);
            internalFrameAttribuerDroit.getContentPane().add(chckbxNewCheckBox_1);

            JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Attribuer");
            chckbxNewCheckBox_2.setBounds(204, 101, 93, 21);
            internalFrameAttribuerDroit.getContentPane().add(chckbxNewCheckBox_2);

            JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Attribuer");
            chckbxNewCheckBox_3.setBounds(204, 145, 93, 21);
            internalFrameAttribuerDroit.getContentPane().add(chckbxNewCheckBox_3);

            JButton btnNewButton_1 = new JButton("Retour");
            btnNewButton_1.setBounds(32, 272, 85, 21);
            internalFrameAttribuerDroit.getContentPane().add(btnNewButton_1);

            JButton btnNewButton_1_1 = new JButton("Enregistrer");
            btnNewButton_1_1.setBounds(204, 272, 107, 21);
            internalFrameAttribuerDroit.getContentPane().add(btnNewButton_1_1);

            internalFrame.add(internalFrameAttribuerDroit);
        }
        internalFrameAttribuerDroit.setVisible(true);
        try {
            internalFrameAttribuerDroit.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    protected void showAjoutResponsableInternalFrame() {
        hideAllInternalFrames();
        if (internalFrameAjoutResponsable == null) {
            internalFrameAjoutResponsable = new JInternalFrame("Ajout responsable maintenance", true, true, true, true);
            internalFrameAjoutResponsable.setBounds(139, 0, 415, 364);
            internalFrameAjoutResponsable.getContentPane().setLayout(null);

            JPanel panel = new JPanel();
            panel.setBounds(0, 0, 403, 335);
            internalFrameAjoutResponsable.getContentPane().add(panel);
            panel.setLayout(null);

            JLabel lblNewLabel_1 = new JLabel("Nom");
            lblNewLabel_1.setBounds(60, 34, 45, 13);
            panel.add(lblNewLabel_1);

            JLabel lblNewLabel_2 = new JLabel("Prenom ");
            lblNewLabel_2.setBounds(49, 74, 45, 13);
            panel.add(lblNewLabel_2);

            textField = new JTextField();
            textField.setBounds(197, 31, 160, 19);
            panel.add(textField);
            textField.setColumns(10);

            textField_1 = new JTextField();
            textField_1.setBounds(197, 71, 160, 19);
            panel.add(textField_1);
            textField_1.setColumns(10);

            JButton btnNewButton_4 = new JButton("Valider");
            btnNewButton_4.setBounds(197, 276, 85, 21);
            panel.add(btnNewButton_4);
            btnNewButton_4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String nom = textField.getText();
                    String prenom = textField_1.getText();
                    String nomUtilisateur = textField_2.getText();
                    String motDePasse = textField_3.getText();
                    String confirmation = textField_4.getText();

                    if (nom.isEmpty() || prenom.isEmpty() || nomUtilisateur.isEmpty() || motDePasse.isEmpty() || confirmation.isEmpty()) {
                        JOptionPane.showMessageDialog(frmAdministrateur, "Tous les champs doivent être remplis.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (!motDePasse.equals(confirmation)) {
                        JOptionPane.showMessageDialog(frmAdministrateur, "Le mot de passe et la confirmation ne correspondent pas.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Donnee_Responsable_Maintenance nouveauResponsable = new Donnee_Responsable_Maintenance(nom, prenom, nomUtilisateur, motDePasse, confirmation);

                    // Utiliser Donnee_Responsable_MaintenanceDAO pour enregistrer l'objet dans la base de données
                    Donnee_Responsable_MaintenanceDAO responsableDAO = new Donnee_Responsable_MaintenanceDAO();
                    responsableDAO.ajouterResponsable(nouveauResponsable);

                    // Ajouter à la liste locale
                    responsables.add(nouveauResponsable);

                    // Effacer les champs après l'enregistrement
                    textField.setText("");
                    textField_1.setText("");
                    textField_2.setText("");
                    textField_3.setText("");
                    textField_4.setText("");

                    // Afficher le message de succès
                    JOptionPane.showMessageDialog(frmAdministrateur, "Responsable ajouté avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
                }
            });

            JLabel lblNewLabel_3 = new JLabel("Nom Utilisateur");
            lblNewLabel_3.setBounds(32, 117, 104, 13);
            panel.add(lblNewLabel_3);

            textField_2 = new JTextField();
            textField_2.setBounds(197, 114, 160, 19);
            panel.add(textField_2);
            textField_2.setColumns(10);

            JLabel lblNewLabel_4 = new JLabel("Mot de passe");
            lblNewLabel_4.setBounds(44, 161, 80, 13);
            panel.add(lblNewLabel_4);

            textField_3 = new JTextField();
            textField_3.setBounds(197, 158, 160, 19);
            panel.add(textField_3);
            textField_3.setColumns(10);

            JLabel lblNewLabel_5 = new JLabel("Confirmation");
            lblNewLabel_5.setBounds(44, 207, 80, 13);
            panel.add(lblNewLabel_5);

            textField_4 = new JTextField();
            textField_4.setBounds(197, 204, 160, 19);
            panel.add(textField_4);
            textField_4.setColumns(10);

            internalFrame.add(internalFrameAjoutResponsable);
        }
        internalFrameAjoutResponsable.setVisible(true);
        try {
            internalFrameAjoutResponsable.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    protected void showListeResponsableInternalFrame() {
        hideAllInternalFrames();
        if (internalFrameListeResponsable == null) {
            internalFrameListeResponsable = new JInternalFrame("Liste des responsables", true, true, true, true);
            internalFrameListeResponsable.setBounds(139, 0, 415, 364);
            internalFrameListeResponsable.getContentPane().setLayout(null);

            // Tableau des responsables
            tableModel = new DefaultTableModel(new Object[]{"Nom", "Prenom", "Nom Utilisateur"}, 0);
            table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(10, 10, 390, 300);
            internalFrameListeResponsable.getContentPane().add(scrollPane);

            // Charger les données des responsables dans le tableau
            for (Donnee_Responsable_Maintenance responsable : responsables) {
                tableModel.addRow(new Object[]{responsable.getNom(), responsable.getPrenom(), responsable.getNomUtilisateur()});
            }

            internalFrame.add(internalFrameListeResponsable);
        }
        internalFrameListeResponsable.setVisible(true);
        try {
            internalFrameListeResponsable.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    protected void hideAllInternalFrames() {
        if (internalFrameAttribuerDroit != null) {
            internalFrameAttribuerDroit.setVisible(false);
        }
        if (internalFrameAjoutResponsable != null) {
            internalFrameAjoutResponsable.setVisible(false);
        }
        if (internalFrameListeResponsable != null) {
            internalFrameListeResponsable.setVisible(false);
        }
    }
}
