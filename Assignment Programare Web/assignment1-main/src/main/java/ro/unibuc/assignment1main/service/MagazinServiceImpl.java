package ro.unibuc.assignment1main.service;

import org.springframework.stereotype.Service;
import ro.unibuc.assignment1main.dto.magazin.CreateRequestMagazin;
import ro.unibuc.assignment1main.dto.magazin.CreateResponseMagazin;
import ro.unibuc.assignment1main.dto.magazin.ReadResponseMagazin;
import ro.unibuc.assignment1main.dto.produse.AddRequestProdus;
import ro.unibuc.assignment1main.dto.produse.AddResponseProdus;
import ro.unibuc.assignment1main.dto.produse.ProdusEntry;
import ro.unibuc.assignment1main.model.Magazin;
import ro.unibuc.assignment1main.model.Produs;
import ro.unibuc.assignment1main.repository.MagazinRepository;
import ro.unibuc.assignment1main.repository.ProdusRepository;




import java.util.Optional;

@Service
public class MagazinServiceImpl implements MagazinService {

    private final MagazinRepository magazinRepo;
    private final ProdusRepository produsRepo;


    public MagazinServiceImpl(MagazinRepository magazinRepo, ProdusRepository produsRepo) {
        this.magazinRepo = magazinRepo;
        this.produsRepo = produsRepo;
    }

    @Override
    public CreateResponseMagazin addMagazin(CreateRequestMagazin request) {
        final var magazin = new Magazin();
        magazin.setNume(request.nume());
        magazin.setOras(request.oras());

        final var inserted = magazinRepo.insert(magazin);
        return new CreateResponseMagazin(inserted.getId());
    }

    @Override
    public Optional<ReadResponseMagazin> readMagazin(String id) {
        return magazinRepo.read(id)
                .map(magazin -> {
                    final var produse = produsRepo.findByMagazinId(magazin.getId()).stream()
                            .map(play -> new ProdusEntry(play.getDenumire(), play.getCategorie(), play.getPret()))
                            .toList();
                    return new ReadResponseMagazin(magazin.getNume(), magazin.getOras(), produse);
                });
    }

    @Override
    public AddResponseProdus addProdus(String idMagazin, AddRequestProdus request) {
        if (!magazinRepo.exists(idMagazin)) {
            throw new IllegalArgumentException("No theatre for id " + idMagazin);
        }
        final var produs = new Produs();
        produs.setDenumire(request.denumire());
        produs.setCategorie(request.categorie());
        produs.setPret(request.pret());
        //produs.setId(idMagazin);

        final var inserted = produsRepo.insert(produs);
        return new AddResponseProdus(inserted.getId());
    }

    @Override
    public void removeProdus(String idMagazin, String idProdus) {
        if (!magazinRepo.exists(idMagazin)) {
            throw new IllegalArgumentException("No theatre for id " + idMagazin);
        }

        produsRepo.delete(idProdus);
    }
}
