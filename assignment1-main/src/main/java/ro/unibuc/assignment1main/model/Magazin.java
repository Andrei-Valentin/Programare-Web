package ro.unibuc.assignment1main.model;

import java.util.Objects;

public final class Magazin {

    private String id;
    private String nume;
    private String oras;


    public Magazin() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazin magazin = (Magazin) o;
        return Objects.equals(id, magazin.id) && Objects.equals(nume, magazin.nume) && Objects.equals(oras, magazin.oras);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume, oras);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    @Override
    public String toString() {
        return "Magazin{" +
                "id='" + id + '\'' +
                ", nume='" + nume + '\'' +
                ", oras='" + oras + '\'' +
                '}';
    }
}
