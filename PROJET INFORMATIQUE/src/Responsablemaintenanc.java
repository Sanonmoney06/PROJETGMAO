import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Responsablemaintenanc {
    JFrame frmResponableMaintenance;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTable tableDevis;
    private DefaultTableModel model; // Modèle de tableau global

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Responsablemaintenanc window = new Responsablemaintenanc();
                    window.frmResponableMaintenance.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Responsablemaintenanc() {
        initialize();
    }

    private void initialize() {
        frmResponableMaintenance = new JFrame();
        frmResponableMaintenance.setFont(new Font("Dialog", Font.ITALIC, 12));
        frmResponableMaintenance.setTitle("Responsable Maintenance");
        frmResponableMaintenance.getContentPane().setBackground(new Color(255, 255, 204));
        frmResponableMaintenance.setBounds(100, 100, 741, 514);
        frmResponableMaintenance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmResponableMaintenance.getContentPane().setLayout(null);

        JDesktopPane desktopPane_1 = new JDesktopPane();
        desktopPane_1.setBackground(new Color(255, 255, 204));
        desktopPane_1.setBounds(0, 10, 129, 467);
        frmResponableMaintenance.getContentPane().add(desktopPane_1);
        desktopPane_1.setLayout(null);

        JDesktopPane desktopPane_2 = new JDesktopPane();
        desktopPane_2.setBackground(new Color(255, 255, 255));
        desktopPane_2.setBounds(134, 24, 593, 453);
        frmResponableMaintenance.getContentPane().add(desktopPane_2);
        desktopPane_2.setLayout(null);

        JButton btnGestionMaintenance = new JButton("Gestion maintenance");
        btnGestionMaintenance.setBounds(0, 60, 129, 21);
        desktopPane_1.add(btnGestionMaintenance);

        JButton btnGestionOperateur = new JButton("Gestion Operateur");
        btnGestionOperateur.setBounds(0, 104, 129, 21);
        desktopPane_1.add(btnGestionOperateur);

        JButton btnSuperviser = new JButton("Gérer Devis");
        btnSuperviser.setBounds(0, 145, 119, 21);
        desktopPane_1.add(btnSuperviser);
        
        

        // Create JInternalFrame for "Gestion de maintenance"
        JInternalFrame internalFrame = new JInternalFrame("Gestion de maintenance", true, true, true, true);
        internalFrame.setBounds(0, 0, 593, 453);
        internalFrame.getContentPane().setLayout(null);
        internalFrame.setVisible(false);
        desktopPane_2.add(internalFrame);

        JButton btnCreerDemande = new JButton("Créer une demande");
        btnCreerDemande.setBounds(10, 47, 113, 21);
        internalFrame.getContentPane().add(btnCreerDemande);

        JButton btnAjouterMaintenance = new JButton("Ajouter Maintenance");
        btnAjouterMaintenance.setBounds(10, 105, 113, 21);
        internalFrame.getContentPane().add(btnAjouterMaintenance);

        JButton btnAfficherListe = new JButton("Afficher liste");
        btnAfficherListe.setBounds(10, 166, 95, 21);
        internalFrame.getContentPane().add(btnAfficherListe);

        // Create JInternalFrame for "Demande de maintenance"
        JInternalFrame internalFrame_1 = new JInternalFrame("Demande de maintenance", true, true, true, true);
        internalFrame_1.setBounds(161, 10, 420, 413);
        internalFrame.getContentPane().add(internalFrame_1);
        internalFrame_1.getContentPane().setLayout(null);
        internalFrame_1.setVisible(false); // initially hidden

        JLabel lblTypeMachine = new JLabel("Type de machine");
        lblTypeMachine.setBounds(30, 33, 85, 13);
        internalFrame_1.getContentPane().add(lblTypeMachine);

        JLabel lblPanne = new JLabel("Panne");
        lblPanne.setBounds(30, 77, 45, 13);
        internalFrame_1.getContentPane().add(lblPanne);

        JLabel lblIntervenant = new JLabel("Intervenant");
        lblIntervenant.setBounds(30, 121, 72, 13);
        internalFrame_1.getContentPane().add(lblIntervenant);

        JLabel lblClassification = new JLabel("Classification");
        lblClassification.setBounds(30, 152, 72, 13);
        internalFrame_1.getContentPane().add(lblClassification);

        JLabel lblLocalisation = new JLabel("Localisation");
        lblLocalisation.setBounds(30, 187, 66, 13);
        internalFrame_1.getContentPane().add(lblLocalisation);

        JLabel lblDescription = new JLabel("Description");
        lblDescription.setBounds(30, 219, 66, 13);
        internalFrame_1.getContentPane().add(lblDescription);

        JLabel lblEtat = new JLabel("État");
        lblEtat.setBounds(30, 257, 66, 19);
        internalFrame_1.getContentPane().add(lblEtat);

        textField = new JTextField();
        textField.setBounds(136, 30, 96, 19);
        internalFrame_1.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(136, 74, 96, 19);
        internalFrame_1.getContentPane().add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(136, 118, 96, 19);
        internalFrame_1.getContentPane().add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(136, 149, 96, 19);
        internalFrame_1.getContentPane().add(textField_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(136, 216, 96, 19);
        internalFrame_1.getContentPane().add(textField_4);

        JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(30, 332, 85, 21);
        internalFrame_1.getContentPane().add(btnRetour);

        JButton btnEnregistrer = new JButton("Enregistrer");
        btnEnregistrer.setBounds(327, 332, 85, 21);
        internalFrame_1.getContentPane().add(btnEnregistrer);

        textField_10 = new JTextField();
        textField_10.setBounds(136, 184, 96, 19);
        internalFrame_1.getContentPane().add(textField_10);
        textField_10.setColumns(10);

        textField_11 = new JTextField();
        textField_11.setBounds(136, 256, 96, 19);
        internalFrame_1.getContentPane().add(textField_11);
        textField_11.setColumns(10);

        // Action listeners for buttons in "Gestion de maintenance"
        btnCreerDemande.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                internalFrame_1.setVisible(true);
            }
        });

        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                internalFrame_1.setVisible(false);
            }
        });

        btnEnregistrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic to save the maintenance request
                JOptionPane.showMessageDialog(frmResponableMaintenance, "Demande enregistrée avec succès");
            }
        });

        // Create JInternalFrame for "Gestion d'opérateurs"
        JInternalFrame internalFrame_2 = new JInternalFrame("Gestion d'opérateurs", true, true, true, true);
        internalFrame_2.setBounds(0, 0, 593, 453);
        internalFrame_2.getContentPane().setLayout(null);
        internalFrame_2.setVisible(false);
        desktopPane_2.add(internalFrame_2);

        JLabel lblNom = new JLabel("Nom");
        lblNom.setBounds(20, 10, 45, 13);
        internalFrame_2.getContentPane().add(lblNom);

        JLabel lblPrenom = new JLabel("Prénom");
        lblPrenom.setBounds(20, 51, 45, 13);
        internalFrame_2.getContentPane().add(lblPrenom);

        JLabel lblPoste = new JLabel("Poste");
        lblPoste.setBounds(20, 98, 45, 13);
        internalFrame_2.getContentPane().add(lblPoste);

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setBounds(20, 142, 45, 13);
        internalFrame_2.getContentPane().add(lblLogin);

        JLabel lblMotDePasse = new JLabel("Mot de passe");
        lblMotDePasse.setBounds(10, 187, 70, 13);
        internalFrame_2.getContentPane().add(lblMotDePasse);

        JTextField textFieldNom = new JTextField();
        textFieldNom.setBounds(86, 7, 96, 19);
        internalFrame_2.getContentPane().add(textFieldNom);
        textFieldNom.setColumns(10);

        JTextField textFieldPrenom = new JTextField();
        textFieldPrenom.setColumns(10);
        textFieldPrenom.setBounds(86, 48, 96, 19);
        internalFrame_2.getContentPane().add(textFieldPrenom);

        JTextField textFieldPoste = new JTextField();
        textFieldPoste.setColumns(10);
        textFieldPoste.setBounds(86, 95, 96, 19);
        internalFrame_2.getContentPane().add(textFieldPoste);

        JTextField textFieldLogin = new JTextField();
        textFieldLogin.setColumns(10);
        textFieldLogin.setBounds(86, 139, 96, 19);
        internalFrame_2.getContentPane().add(textFieldLogin);

        JTextField textFieldMotDePasse = new JTextField();
        textFieldMotDePasse.setColumns(10);
        textFieldMotDePasse.setBounds(86, 184, 96, 19);
        internalFrame_2.getContentPane().add(textFieldMotDePasse);

        JButton btnLoadDevis = new JButton("Charger les devis");
        btnLoadDevis.setBounds(20, 227, 130, 21);
        internalFrame_2.getContentPane().add(btnLoadDevis);

        // Action listeners for buttons in "Gestion d'opérateurs"
        btnLoadDevis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic to load the list of operators
                JOptionPane.showMessageDialog(frmResponableMaintenance, "Liste des opérateurs chargée avec succès");
            }
        });

        // Create JInternalFrame for "Gestion de devis"
        JInternalFrame internalFrame_3 = new JInternalFrame("Gestion de devis", true, true, true, true);
        internalFrame_3.setBounds(0, 0, 593, 453);
        internalFrame_3.getContentPane().setLayout(null);
        internalFrame_3.setVisible(false);
        desktopPane_2.add(internalFrame_3);

        JScrollPane scrollPaneDevis = new JScrollPane();
        scrollPaneDevis.setBounds(10, 11, 573, 381);
        internalFrame_3.getContentPane().add(scrollPaneDevis);

        tableDevis = new JTable();
        model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID Devis", "Client", "Date", "Montant", "Statut"}
        );
        tableDevis.setModel(model);
        scrollPaneDevis.setViewportView(tableDevis);

        // Initially hide the scroll pane (and thus the table)
        scrollPaneDevis.setVisible(false);

        JButton btnCreerDevis = new JButton("Créer Devis");
        btnCreerDevis.setBounds(153, 403, 133, 21);
        internalFrame_3.getContentPane().add(btnCreerDevis);

        JButton btnModifierDevis = new JButton("Modifier Devis");
        btnModifierDevis.setBounds(296, 403, 133, 21);
        internalFrame_3.getContentPane().add(btnModifierDevis);

        // Action listeners for buttons in "Gestion de devis"
        btnCreerDevis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic to create a new quote
                JOptionPane.showMessageDialog(frmResponableMaintenance, "Créer Devis - fonctionnalité à implémenter");
            }
        });

        btnModifierDevis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show the table when the button is clicked
                scrollPaneDevis.setVisible(true);
                JOptionPane.showMessageDialog(frmResponableMaintenance, "Liste des devis chargée avec succès");
            }
        });

        // Action listeners for main buttons to display JInternalFrames
        btnGestionMaintenance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                internalFrame.setVisible(true);
                internalFrame_2.setVisible(false);
                internalFrame_3.setVisible(false);
            }
        });

        btnGestionOperateur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                internalFrame.setVisible(false);
                internalFrame_2.setVisible(true);
                internalFrame_3.setVisible(false);
            }
        });

        btnSuperviser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                internalFrame.setVisible(false);
                internalFrame_2.setVisible(false);
                internalFrame_3.setVisible(true);
            }
        });
   

        // Logout button
        JButton btnDeconnexion = new JButton("Déconnexion");
        btnDeconnexion.setBounds(10, 420, 109, 21);
        desktopPane_1.add(btnDeconnexion);

        btnDeconnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic to handle logout
                frmResponableMaintenance.dispose();
                JOptionPane.showMessageDialog(null, "Déconnexion réussie");
            }
        });
    }
}
