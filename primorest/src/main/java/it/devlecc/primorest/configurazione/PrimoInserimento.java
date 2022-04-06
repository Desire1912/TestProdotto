package it.devlecc.primorest.configurazione;

import it.devlecc.primorest.model.Prodotto;
import it.devlecc.primorest.repository.ProdottiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class PrimoInserimento {


    private static final Logger logger = LoggerFactory.getLogger(PrimoInserimento.class);
    @Bean
    CommandLineRunner inserisciElementi(ProdottiRepository repository) {
        return args -> {
            SimpleDateFormat dataScadenza = new SimpleDateFormat("dd-MM-yyyy");
                   SimpleDateFormat dataAcquisto= new SimpleDateFormat("dd-MM-yyyy");
                         //prodotto 1
                        Date  Scadenza = dataScadenza.parse("22-05-2022");
                        Date  Acquisto = dataAcquisto.parse("21-04-2022");
                        Prodotto p1 = new Prodotto(Scadenza,Acquisto , 12 ,3,"pane");
                        logger.info( "nome : "+p1.getNome()+ " data di acquisto : "+ p1.getDatadicaquisto()+ "data di scadenza : "+ p1.getDatadiscadenza()+ "quantità :"+ p1.getQuantità() + "prezzo :"+p1.getPrezzo());
                        repository.save(p1);

                        //prodotto2
                        Scadenza = dataScadenza.parse("12-06-2022");
                        Acquisto = dataAcquisto.parse("21-04-2022");
                        Prodotto p2 = new Prodotto(Scadenza,Acquisto , 8 ,3,"pasta");
                            logger.info( "nome : "+p2.getNome()+ " data di acquisto : "+ p2.getDatadicaquisto()+ "data di scadenza : "+ p2.getDatadiscadenza()+ "quantità :"+ p2.getQuantità() + "prezzo :"+p2.getPrezzo());
                        repository.save(p2);
        };
    }
}
