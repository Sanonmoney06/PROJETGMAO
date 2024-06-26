public class Client {
    private int idClient;
    private String nomEntreprise;
    private String numeroIFU;
    private String numeroRCCM;

    // Constructeur
    public Client(int idClient, String nomEntreprise, String numeroIFU, String numeroRCCM) {
        this.idClient = idClient;
        this.nomEntreprise = nomEntreprise;
        this.numeroIFU = numeroIFU;
        this.numeroRCCM = numeroRCCM;
    }

    // Getters et Setters
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getNumeroIFU() {
        return numeroIFU;
    }

    public void setNumeroIFU(String numeroIFU) {
        this.numeroIFU = numeroIFU;
    }

    public String getNumeroRCCM() {
        return numeroRCCM;
    }

    public void setNumeroRCCM(String numeroRCCM) {
        this.numeroRCCM = numeroRCCM;
    }
}
