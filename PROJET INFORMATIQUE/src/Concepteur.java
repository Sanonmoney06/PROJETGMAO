import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Concepteur {

    private JFrame frmConcepteur;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JInternalFrame internalFrameAjouterClient;
    private JTable table;
    private DefaultTableModel tableModel;
    private ClientDAO clientDao;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    Concepteur window = new Concepteur();
                    window.frmConcepteur.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Concepteur() {
        clientDao = new ClientDAO();
        initialize();
        refreshTable();
    }

    private void initialize() {
        frmConcepteur = new JFrame();
        frmConcepteur.setTitle("Concepteur");
        frmConcepteur.setBounds(100, 100, 593, 456);
        frmConcepteur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmConcepteur.getContentPane().setLayout(null);

        JButton btnAjouterClient = new JButton("Ajouter client");
        btnAjouterClient.setBounds(10, 49, 107, 21);
        frmConcepteur.getContentPane().add(btnAjouterClient);

        internalFrameAjouterClient = new JInternalFrame("Ajouter client");
        internalFrameAjouterClient.setBounds(127, 0, 429, 409);
        internalFrameAjouterClient.getContentPane().setLayout(null);
        internalFrameAjouterClient.setVisible(false);
        frmConcepteur.getContentPane().add(internalFrameAjouterClient);

        JLabel lblIdClient = new JLabel("Id client");
        lblIdClient.setBounds(10, 38, 100, 20);
        internalFrameAjouterClient.getContentPane().add(lblIdClient);

        textField = new JTextField();
        textField.setBounds(164, 39, 200, 20);
        internalFrameAjouterClient.getContentPane().add(textField);

        JLabel lblNomEntreprise = new JLabel("Nom d'entreprise");
        lblNomEntreprise.setBounds(10, 96, 100, 20);
        internalFrameAjouterClient.getContentPane().add(lblNomEntreprise);

        textField_1 = new JTextField();
        textField_1.setBounds(164, 97, 200, 20);
        internalFrameAjouterClient.getContentPane().add(textField_1);

        JLabel lblNumeroIfu = new JLabel("Numero IFU");
        lblNumeroIfu.setBounds(10, 175, 100, 20);
        internalFrameAjouterClient.getContentPane().add(lblNumeroIfu);

        textField_2 = new JTextField();
        textField_2.setBounds(164, 176, 200, 20);
        internalFrameAjouterClient.getContentPane().add(textField_2);

        JLabel lblNumeroRccm = new JLabel("Numero RCCM");
        lblNumeroRccm.setBounds(10, 246, 100, 20);
        internalFrameAjouterClient.getContentPane().add(lblNumeroRccm);

        textField_3 = new JTextField();
        textField_3.setBounds(164, 247, 200, 20);
        internalFrameAjouterClient.getContentPane().add(textField_3);

        JButton btnEnregistrer = new JButton("Enregistrer");
        btnEnregistrer.setBounds(264, 344, 100, 20);
        internalFrameAjouterClient.getContentPane().add(btnEnregistrer);

        // Configuration de la JTable pour afficher la liste des clients
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(127, 0, 429, 409);
        frmConcepteur.getContentPane().add(scrollPane);

        JButton btnSupprimerClient = new JButton("Supprimer client");
        btnSupprimerClient.setBounds(10, 177, 107, 21);
        frmConcepteur.getContentPane().add(btnSupprimerClient);

        btnAjouterClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                internalFrameAjouterClient.setVisible(true);
            }
        });

        btnEnregistrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!textField.getText().isEmpty() && !textField_1.getText().isEmpty() && !textField_2.getText().isEmpty() && !textField_3.getText().isEmpty()) {
                        int idClient = Integer.parseInt(textField.getText());
                        String nomEntreprise = textField_1.getText();
                        String numeroIFU = textField_2.getText();
                        String numeroRCCM = textField_3.getText();

                        Client client = new Client(idClient, nomEntreprise, numeroIFU, numeroRCCM);
                        clientDao.addClient(client);

                        JOptionPane.showMessageDialog(frmConcepteur, "Client ajouté avec succès!");
                        internalFrameAjouterClient.setVisible(false);
                        clearTextFields();
                        refreshTable();
                    } else {
                        JOptionPane.showMessageDialog(frmConcepteur, "Veuillez remplir tous les champs!", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frmConcepteur, "Erreur lors de l'ajout du client!", "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frmConcepteur, "Veuillez saisir un ID client valide!", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnSupprimerClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int[] selectedRows = table.getSelectedRows();
                    if (selectedRows.length > 0) {
                        List<Integer> idsToDelete = new ArrayList<>();
                        for (int selectedRow : selectedRows) {
                            int idClient = (int) table.getValueAt(selectedRow, 0);
                            idsToDelete.add(idClient);
                        }
                        clientDao.deleteClient(idsToDelete);
                        refreshTable();
                        JOptionPane.showMessageDialog(frmConcepteur, "Client(s) supprimé(s) avec succès!");
                    } else {
                        JOptionPane.showMessageDialog(frmConcepteur, "Veuillez sélectionner au moins un client à supprimer!", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frmConcepteur, "Erreur lors de la suppression du(des) client(s)!", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void refreshTable() {
        try {
            List<Client> clients = clientDao.selectAllClients();
            Object[][] data = new Object[clients.size()][4];
            for (int i = 0; i < clients.size(); i++) {
                Client client = clients.get(i);
                data[i][0] = client.getIdClient();
                data[i][1] = client.getNomEntreprise();
                data[i][2] = client.getNumeroIFU();
                data[i][3] = client.getNumeroRCCM();
            }
            String[] columns = {"Id client", "Nom d'entreprise", "Numero IFU", "Numero RCCM"};
            tableModel.setDataVector(data, columns);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frmConcepteur, "Erreur lors de la récupération des clients!", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

     private void clearTextFields() {
            textField.setText("");
            textField_1.setText("");
            textField_2.setText("");
            textField_3.setText("");
        }
    }

