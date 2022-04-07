package it.devlecc.primorest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Prodotto {
    @Id
    @GeneratedValue
    private Long id;
    private Date datadiscadenza,datadiacquisto;
    private Float prezzo,quantità;
    private String nome;

    public Prodotto(){
    }

    public Prodotto(Date  datadiscadenza, Date datadicaquisto, float prezzo, float quantità, String nome) {
        this.datadiscadenza = datadiscadenza;
        this.datadiacquisto = datadicaquisto;
        this.prezzo = prezzo;
        this.quantità = quantità;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatadiscadenza() {
        return datadiscadenza;
    }

    public void setDatadiscadenza(Date datadiscadenza) {
        this.datadiscadenza= datadiscadenza;
    }

    public Date getDatadicaquisto() {
        return datadiacquisto;
    }

    public void setDatadicaquisto(Date datadicaquisto) {
        this.datadiacquisto = datadicaquisto;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public float getQuantità() {
        return quantità;
    }

    public void setQuantità(float quantità) {
        this.quantità = quantità;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
