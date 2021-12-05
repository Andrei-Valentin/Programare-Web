package ro.unibuc.assignment1main.model;

import java.util.Objects;

public final class Produs {

    private String id;
    private String denumire;
    private Categorie categorie;
    private Integer pret;
    private String MagazinId;

    public Produs() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produs produs = (Produs) o;
        return Objects.equals(id, produs.id) && Objects.equals(denumire, produs.denumire) && categorie == produs.categorie && Objects.equals(pret, produs.pret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, denumire, categorie, pret, MagazinId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Integer getPret() {
        return pret;
    }

    public void setPret(Integer pret) {
        this.pret = pret;
    }

    public String getMagazinId() {
        return MagazinId;
    }

    public void setMagazinId(String magazinId) {
        MagazinId = magazinId;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "id='" + id + '\'' +
                ", denumire='" + denumire + '\'' +
                ", categorie=" + categorie +
                ", pret=" + pret +
                ", MagazinId='" + MagazinId + '\'' +
                '}';
    }
}
