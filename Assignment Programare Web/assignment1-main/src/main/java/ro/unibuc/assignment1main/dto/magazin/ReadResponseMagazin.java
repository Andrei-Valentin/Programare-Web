package ro.unibuc.assignment1main.dto.magazin;

import ro.unibuc.assignment1main.dto.produse.ProdusEntry;
import java.util.Collection;

public record ReadResponseMagazin(String nume, String oras, Collection<ProdusEntry> produse) {
}
