package it.devlecc.primorest.repository;

import it.devlecc.primorest.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottiRepository extends JpaRepository<Prodotto, Long> {
}
