package it.devlecc.primorest.controller;

import it.devlecc.primorest.avviso.ProdottoNonTrovato;
import it.devlecc.primorest.model.Prodotto;
import it.devlecc.primorest.repository.ProdottiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdottoRestController {
    private static Logger logger = LoggerFactory.getLogger(ProdottoRestController.class);
    public ProdottiRepository repository;

    ProdottoRestController(ProdottiRepository repository) {
        this.repository= repository;
    }
    @GetMapping("/prodotti")
    public List<Prodotto> leggiTuttiProdotti (){
        logger.info("prendo tutti gli utenti ");
        return repository.findAll();
    }
    @GetMapping ("/prodotti/{id}")
    public Prodotto trovaProdottoConID(@PathVariable Long id) {
        return  repository.findById(id).orElseThrow(
                () -> new ProdottoNonTrovato(id));
    }


}
