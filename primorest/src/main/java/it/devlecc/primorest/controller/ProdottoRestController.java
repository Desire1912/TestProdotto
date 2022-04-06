package it.devlecc.primorest.controller;

import it.devlecc.primorest.avviso.ProdottoNonTrovato;
import it.devlecc.primorest.model.Prodotto;
import it.devlecc.primorest.repository.ProdottiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
public class ProdottoRestController {
    private static Logger logger = LoggerFactory.getLogger(ProdottoRestController.class);
    public ProdottiRepository repository;

    ProdottoRestController(ProdottiRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/prodotti")
    public List<Prodotto> leggiTuttiProdotti() {
        logger.info("prendo tutti gli utenti ");
        return repository.findAll();
    }

    @GetMapping("/prodotti/{id}")
    public Prodotto trovaProdottoConID(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ProdottoNonTrovato(id));
    }

    @PostMapping("/prodotto")
    public Prodotto inserisciUnNuovoProdotto(@RequestBody Prodotto nuovoProdotto) {
        return repository.save(nuovoProdotto);
    }

    @PutMapping("/prodotto/{id}")
    public Prodotto aggiornaDatiProdotto(@PathVariable Long id, @RequestBody Prodotto prodotto) {
        return repository.save(prodotto);

    }
    @DeleteMapping ("/prodotto/{id}")
    void  eliminaProdotto(@PathVariable Long id){

        repository.deleteById(id);
    }

    @GetMapping ("/prodotto/ricercatradate")
    public List <Prodotto> ricercatradate(
            @RequestParam (name = "datada") @DateTimeFormat(pattern = "dd-MM-yyyy")
                    Date datada,
            @RequestParam( name = "dataa")   @DateTimeFormat (pattern = "dd-MM-yyyy")
                    Date dataa
    ){
        return repository.findByDatadiacquistoBetween(datada,dataa);
    }
    // caricamento di un file
    @PostMapping ("/caricafile")
    public  String caricafile (@RequestParam("file") MultipartFile file){
        String infoFile =  file.getOriginalFilename() + " -" +file.getContentType();
        String conFormat = String.format( "%s-%s",file.getOriginalFilename(),file.getContentType());
        logger.info(infoFile);
        logger.warn(conFormat);
        return  conFormat;
    }

}
