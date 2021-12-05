package ro.unibuc.assignment1main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.assignment1main.dto.magazin.CreateRequestMagazin;
import ro.unibuc.assignment1main.dto.magazin.CreateResponseMagazin;
import ro.unibuc.assignment1main.dto.magazin.ReadResponseMagazin;
import ro.unibuc.assignment1main.dto.produse.AddRequestProdus;
import ro.unibuc.assignment1main.dto.produse.AddResponseProdus;
import ro.unibuc.assignment1main.service.MagazinService;

@RequestMapping("/magazine")
@RestController
public class MagazinController {

    private final MagazinService magazinService;

    public MagazinController(MagazinService magazinService) {
        this.magazinService = magazinService;
    }

    @PostMapping
    public CreateResponseMagazin createMagazin(@RequestBody CreateRequestMagazin request){
        return magazinService.addMagazin(request);
    }

    @GetMapping("/{idMagazin}")
    public ResponseEntity<ReadResponseMagazin> readMagazin(@PathVariable("idMagazin") String idMagazin) {
        return ResponseEntity.of(magazinService.readMagazin(idMagazin));
    }

    @PostMapping("/{idMagazin}/produse")
    public AddResponseProdus addProdus(@PathVariable("idMagazin") String idMagazin, @RequestBody AddRequestProdus request){
        return magazinService.addProdus(idMagazin, request);
    }

    @DeleteMapping("/{idMagazin}/produse/{idProdus}")
    public void removeProdus(@PathVariable("idMagazin") String idMagazin, @PathVariable("idProdus") String idProdus){
        magazinService.removeProdus(idMagazin, idProdus);
    }

}
