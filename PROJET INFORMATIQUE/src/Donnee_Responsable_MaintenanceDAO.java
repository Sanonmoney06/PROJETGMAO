import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Donnee_Responsable_MaintenanceDAO {

    private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
    private String jdbcUsername = "Magloire";
    private String jdbcPassword = "juveniste";

    private static final String INSERT_RESPONSABLE_SQL = "INSERT INTO Donnee_Responsable_Maintenance (nom, prenom, nom_utilisateur, mot_de_passe, confirmation) VALUES (?, ?, ?, ?, ?)";

    public Donnee_Responsable_MaintenanceDAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void ajouterResponsable(Donnee_Responsable_Maintenance responsable) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_RESPONSABLE_SQL)) {
            ps.setString(1, responsable.getNom());
            ps.setString(2, responsable.getPrenom());
            ps.setString(3, responsable.getNomUtilisateur());
            ps.setString(4, responsable.getMotDePasse());
            ps.setString(5, responsable.getConfirmation());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
