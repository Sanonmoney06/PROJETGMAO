import javax.swing.*;

import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class GestionComptable {

    private JFrame frmGestionComptable;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTable table;
    private DefaultTableModel tableModel;
    private JComboBox<String> devisComboBox;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GestionComptable window = new GestionComptable();
                    window.frmGestionComptable.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GestionComptable() {
        initialize();
    }

    private void initialize() {
        frmGestionComptable = new JFrame();
        frmGestionComptable.setTitle("Gestion Comptable");
        frmGestionComptable.setBounds(100, 100, 800, 600);
        frmGestionComptable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmGestionComptable.getContentPane().setLayout(null);

        JInternalFrame internalFrame = new JInternalFrame("Operations");
        internalFrame.setBounds(10, 10, 764, 540);
        frmGestionComptable.getContentPane().add(internalFrame);
        internalFrame.getContentPane().setLayout(null);
        internalFrame.setVisible(true);

        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Devis", "Quantité", "Prix Unitaire", "Total TTC"});
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 500, 200);
        internalFrame.getContentPane().add(scrollPane);

        JButton btnSurcout = new JButton("Surcoût");
        btnSurcout.setBounds(520, 10, 150, 23);
        internalFrame.getContentPane().add(btnSurcout);
        btnSurcout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addSurcoutComponents(internalFrame);
            }
        });

        JButton btnSuiviReglement = new JButton("Suivi règlement");
        btnSuiviReglement.setBounds(520, 44, 150, 23);
        internalFrame.getContentPane().add(btnSuiviReglement);
        btnSuiviReglement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addSuiviReglementComponents(internalFrame);
            }
        });

        JButton btnClotureDossier = new JButton("Clôture dossier");
        btnClotureDossier.setBounds(520, 78, 150, 23);
        internalFrame.getContentPane().add(btnClotureDossier);
        btnClotureDossier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addClotureDossierComponents(internalFrame);
            }
        });

        JButton btnEditionRapport = new JButton("Édition rapport");
        btnEditionRapport.setBounds(520, 112, 150, 23);
        internalFrame.getContentPane().add(btnEditionRapport);
        btnEditionRapport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addEditionRapportComponents(internalFrame);
            }
        });

        JButton btnNewButton = new JButton("Ajouter élément");
        btnNewButton.setBounds(520, 200, 150, 23);
        internalFrame.getContentPane().add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateInputs()) {
                    Object[] row = {devisComboBox.getSelectedItem(), textField_1.getText(), textField_2.getText(), textField_3.getText()};
                    tableModel.addRow(row);
                    textField_1.setText("");
                    textField_2.setText("");
                    textField_3.setText("");
                } else {
                    JOptionPane.showMessageDialog(frmGestionComptable, "Veuillez remplir tous les champs correctement.");
                }
            }
        });

        devisComboBox = new JComboBox<>(getDevisList());
        devisComboBox.setBounds(10, 230, 150, 20);
        internalFrame.getContentPane().add(devisComboBox);

        textField_1 = new JTextField();
        textField_1.setBounds(170, 230, 86, 20);
        internalFrame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(270, 230, 86, 20);
        internalFrame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(370, 230, 86, 20);
        internalFrame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        addNumberValidation(textField_1);
        addNumberValidation(textField_2);
        addNumberValidation(textField_3);
    }

    private void addNumberValidation(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    e.consume(); // Ignore the event if it's not a digit or a dot
                }
            }
        });
    }

    private boolean validateInputs() {
        try {
            Integer.parseInt(textField_1.getText());
            Double.parseDouble(textField_2.getText());
            Double.parseDouble(textField_3.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void addSurcoutComponents(JInternalFrame internalFrame) {
        internalFrame.getContentPane().removeAll();
        internalFrame.getContentPane().setLayout(null);

        JLabel lblDevisSelection = new JLabel("Sélectionner un devis");
        lblDevisSelection.setBounds(10, 20, 200, 13);
        internalFrame.getContentPane().add(lblDevisSelection);

        JComboBox<String> devisSelectionComboBox = new JComboBox<>(getDevisList());
        devisSelectionComboBox.setBounds(150, 16, 257, 21);
        internalFrame.getContentPane().add(devisSelectionComboBox);

        JLabel lblDescription = new JLabel("Description du surcoût");
        lblDescription.setBounds(10, 70, 200, 13);
        internalFrame.getContentPane().add(lblDescription);

        JTextField txtDescription = new JTextField();
        txtDescription.setBounds(150, 67, 257, 19);
        internalFrame.getContentPane().add(txtDescription);
        txtDescription.setColumns(10);

        JLabel lblMontant = new JLabel("Montant");
        lblMontant.setBounds(10, 120, 100, 13);
        internalFrame.getContentPane().add(lblMontant);

        JTextField txtMontant = new JTextField();
        txtMontant.setBounds(150, 117, 257, 19);
        internalFrame.getContentPane().add(txtMontant);
        txtMontant.setColumns(10);

        addNumberValidation(txtMontant);

        JButton btnAjouterSurcout = new JButton("Ajouter Surcoût");
        btnAjouterSurcout.setBounds(150, 170, 150, 21);
        internalFrame.getContentPane().add(btnAjouterSurcout);

        btnAjouterSurcout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (devisSelectionComboBox.getSelectedItem() != null && !txtDescription.getText().isEmpty() && !txtMontant.getText().isEmpty()) {
                    // Ajout logique du surcoût ici
                    JOptionPane.showMessageDialog(frmGestionComptable, "Surcoût ajouté avec succès.");
                    txtDescription.setText("");
                    txtMontant.setText("");
                } else {
                    JOptionPane.showMessageDialog(frmGestionComptable, "Veuillez remplir tous les champs.");
                }
            }
        });

        internalFrame.setVisible(true);
        internalFrame.repaint();
    }

    private void addSuiviReglementComponents(JInternalFrame internalFrame) {
        internalFrame.getContentPane().removeAll();
        internalFrame.getContentPane().setLayout(null);

        JLabel lblDevisSelection = new JLabel("Sélectionner un devis");
        lblDevisSelection.setBounds(10, 20, 200, 13);
        internalFrame.getContentPane().add(lblDevisSelection);

        JComboBox<String> devisSelectionComboBox = new JComboBox<>(getDevisList());
        devisSelectionComboBox.setBounds(150, 16, 257, 21);
        internalFrame.getContentPane().add(devisSelectionComboBox);

        JLabel lblDescription = new JLabel("Description du règlement");
        lblDescription.setBounds(10, 70, 200, 13);
        internalFrame.getContentPane().add(lblDescription);

        JTextField txtDescription = new JTextField();
        txtDescription.setBounds(150, 67, 257, 19);
        internalFrame.getContentPane().add(txtDescription);
        txtDescription.setColumns(10);

        JLabel lblMontant = new JLabel("Montant");
        lblMontant.setBounds(10, 120, 100, 13);
        internalFrame.getContentPane().add(lblMontant);

        JTextField txtMontant = new JTextField();
        txtMontant.setBounds(150, 117, 257, 19);
        internalFrame.getContentPane().add(txtMontant);
        txtMontant.setColumns(10);

        addNumberValidation(txtMontant);

        JButton btnAjouterReglement = new JButton("Ajouter Règlement");
        btnAjouterReglement.setBounds(150, 170, 150, 21);
        internalFrame.getContentPane().add(btnAjouterReglement);

        btnAjouterReglement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (devisSelectionComboBox.getSelectedItem() != null && !txtDescription.getText().isEmpty() && !txtMontant.getText().isEmpty()) {
                    // Ajout logique du règlement ici
                    JOptionPane.showMessageDialog(frmGestionComptable, "Règlement ajouté avec succès.");
                    txtDescription.setText("");
                    txtMontant.setText("");
                } else {
                    JOptionPane.showMessageDialog(frmGestionComptable, "Veuillez remplir tous les champs.");
                }
            }
        });

        internalFrame.setVisible(true);
        internalFrame.repaint();
    }

    private void addClotureDossierComponents(JInternalFrame internalFrame) {
        internalFrame.getContentPane().removeAll();
        internalFrame.getContentPane().setLayout(null);

        JLabel lblDevisSelection = new JLabel("Sélectionner un devis à clôturer");
        lblDevisSelection.setBounds(10, 20, 200, 13);
        internalFrame.getContentPane().add(lblDevisSelection);

        JComboBox<String> devisSelectionComboBox = new JComboBox<>(getDevisList());
        devisSelectionComboBox.setBounds(220, 16, 257, 21);
        internalFrame.getContentPane().add(devisSelectionComboBox);

        JButton btnCloturerDossier = new JButton("Clôturer Dossier");
        btnCloturerDossier.setBounds(220, 60, 150, 21);
        internalFrame.getContentPane().add(btnCloturerDossier);

        btnCloturerDossier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (devisSelectionComboBox.getSelectedItem() != null) {
                    // Ajout logique de la clôture ici
                    JOptionPane.showMessageDialog(frmGestionComptable, "Dossier clôturé avec succès.");
                } else {
                    JOptionPane.showMessageDialog(frmGestionComptable, "Veuillez sélectionner un devis.");
                }
            }
        });

        internalFrame.setVisible(true);
        internalFrame.repaint();
    }

    private void addEditionRapportComponents(JInternalFrame internalFrame) {
        internalFrame.getContentPane().removeAll();
        internalFrame.getContentPane().setLayout(null);

        JLabel lblSelectionDevis = new JLabel("Sélectionner un devis pour édition de rapport");
        lblSelectionDevis.setBounds(10, 20, 300, 13);
        internalFrame.getContentPane().add(lblSelectionDevis);

        JComboBox<String> devisSelectionComboBox = new JComboBox<>(getDevisList());
        devisSelectionComboBox.setBounds(10, 50, 300, 21);
        internalFrame.getContentPane().add(devisSelectionComboBox);

        JButton btnGenererRapport = new JButton("Générer Rapport");
        btnGenererRapport.setBounds(10, 90, 150, 21);
        internalFrame.getContentPane().add(btnGenererRapport);

        btnGenererRapport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (devisSelectionComboBox.getSelectedItem() != null) {
                    // Ajout logique de la génération du rapport ici
                    JOptionPane.showMessageDialog(frmGestionComptable, "Rapport généré avec succès.");
                } else {
                    JOptionPane.showMessageDialog(frmGestionComptable, "Veuillez sélectionner un devis.");
                }
            }
        });

        internalFrame.setVisible(true);
        internalFrame.repaint();
    }

    private String[] getDevisList() {
        // Cette méthode devrait retourner une liste de devis disponibles
        // Pour l'instant, on retourne une liste statique pour l'exemple
        return new String[]{"Devis 1", "Devis 2", "Devis 3"};
    }
}
