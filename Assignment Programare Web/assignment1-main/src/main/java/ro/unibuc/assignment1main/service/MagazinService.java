package ro.unibuc.assignment1main.service;

import ro.unibuc.assignment1main.dto.magazin.CreateRequestMagazin;
import ro.unibuc.assignment1main.dto.magazin.CreateResponseMagazin;
import ro.unibuc.assignment1main.dto.magazin.ReadResponseMagazin;
import ro.unibuc.assignment1main.dto.produse.AddRequestProdus;
import ro.unibuc.assignment1main.dto.produse.AddResponseProdus;
import java.util.Optional;

public interface MagazinService {

    CreateResponseMagazin addMagazin(CreateRequestMagazin request);

    Optional<ReadResponseMagazin> readMagazin(String id);

    AddResponseProdus addProdus(String idMagazin, AddRequestProdus request);

    void removeProdus(String idMagazin, String idProdus);
}
