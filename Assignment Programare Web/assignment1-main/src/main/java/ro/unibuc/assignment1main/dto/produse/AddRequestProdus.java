package ro.unibuc.assignment1main.dto.produse;

import ro.unibuc.assignment1main.model.Categorie;

public record AddRequestProdus(String denumire, Categorie categorie, Integer pret) {
}