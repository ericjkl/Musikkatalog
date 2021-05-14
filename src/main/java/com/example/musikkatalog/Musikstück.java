package com.example.musikkatalog;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Musikstueck {

    private @Id @GeneratedValue Long id;
    private String datentraeger;
    private String interpret;
    private String name;
    private String genre;
    private Integer erscheinungsjahr;

    Musikstueck(String datentraeger,
               String interpret,
               String name,
               String genre,
               Integer erscheinungsjahr) {

        this.datentraeger = datentraeger;
        this.interpret = interpret;
        this.name = name;
        this.genre = genre;
        this.erscheinungsjahr = erscheinungsjahr;
    }

    Musikstueck () {}

    public Long getId() {
        return id;
    }

    public String getDatentraeger() {
        return datentraeger;
    }

    public String getInterpret() {
        return interpret;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDatentraeger(String datentraeger) {
        this.datentraeger = datentraeger;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setErscheinungsjahr(Integer erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }
}
