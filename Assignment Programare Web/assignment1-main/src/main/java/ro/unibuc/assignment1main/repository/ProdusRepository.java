package ro.unibuc.assignment1main.repository;

import ro.unibuc.assignment1main.model.Produs;

import java.util.List;

public interface ProdusRepository {

    Produs insert(Produs produs);

    void delete(String idProdus);

    List<Produs> findByMagazinId(String idMagazin);

}
