package it.devlecc.primorest.repository;

import it.devlecc.primorest.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProdottiRepository extends JpaRepository<Prodotto, Long> {
    List<Prodotto> findByDatadiacquistoBetween(Date datada, Date dataa);
}
