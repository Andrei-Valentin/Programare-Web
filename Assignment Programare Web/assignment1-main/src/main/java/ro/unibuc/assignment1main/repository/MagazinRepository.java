package ro.unibuc.assignment1main.repository;

import ro.unibuc.assignment1main.model.Magazin;

import java.util.Optional;

public interface MagazinRepository {

    Magazin insert(Magazin magazin);

    boolean exists(String idMagazin);

    Optional<Magazin> read(String idMagazin);
}
