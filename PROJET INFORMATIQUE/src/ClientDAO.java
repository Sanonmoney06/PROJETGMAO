import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
    private String jdbcUsername = "Magloire";
    private String jdbcPassword = "juveniste";

    private static final String INSERT_CLIENT_SQL = "INSERT INTO client (Id_client, Nom_entreprise, Numero_IFU, Numero_RCCM) VALUES (?, ?, ?, ?)";
    private static final String SELECT_CLIENT_BY_ID = "SELECT Id_client, Nom_entreprise, Numero_IFU, Numero_RCCM FROM client WHERE Id_client = ?";
    private static final String SELECT_ALL_CLIENTS = "SELECT * FROM client";
    private static final String DELETE_CLIENT_SQL = "DELETE FROM client WHERE Id_client = ?";
    private static final String UPDATE_CLIENT_SQL = "UPDATE client SET Nom_entreprise = ?, Numero_IFU = ?, Numero_RCCM = ? WHERE Id_client = ?";

    public ClientDAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void addClient(Client client) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_SQL)) {
            preparedStatement.setInt(1, client.getIdClient());
            preparedStatement.setString(2, client.getNomEntreprise());
            preparedStatement.setString(3, client.getNumeroIFU());
            preparedStatement.setString(4, client.getNumeroRCCM());
            preparedStatement.executeUpdate();
        }
    }

    public boolean deleteClient(List<Integer> ids) throws SQLException {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CLIENT_SQL)) {
            for (Integer id : ids) {
                statement.setInt(1, id);
                rowDeleted = statement.executeUpdate() > 0;
            }
        }
        return rowDeleted;
    }

    public List<Client> selectAllClients() throws SQLException {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLIENTS);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("Id_client");
                String nomEntreprise = resultSet.getString("Nom_entreprise");
                String numeroIFU = resultSet.getString("Numero_IFU");
                String numeroRCCM = resultSet.getString("Numero_RCCM");
                clients.add(new Client(id, nomEntreprise, numeroIFU, numeroRCCM));
            }
        }
        return clients;
    }
}
