
public class Devis {

	
    private String description;
    private int quantite;
    private double prixUnitaire;
    private double prixTotal;
    private double totalTTC;

    public Devis(String description, int quantite, double prixUnitaire, double prixTotal, double totalTTC) {
        this.description = description;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.prixTotal = prixTotal;
        this.totalTTC = totalTTC;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public double getTotalTTC() {
        return totalTTC;
    }
}

