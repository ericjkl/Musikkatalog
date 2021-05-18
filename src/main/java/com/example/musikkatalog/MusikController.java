package com.example.musikkatalog;

import java.util.List;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MusikController {
    private final MusikstueckRepository repository;
    
    MusikController(MusikstueckRepository repository){
        this.repository = repository;
    }


    @GetMapping("/musikstuecke")
    List<Musikstueck> all() {
        return repository.findAll();
    }

    @PostMapping(path = "/musikstuecke", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    Musikstueck newMusikstueck(Musikstueck newMusikstueck) {
        return repository.save(newMusikstueck);
    }


    @GetMapping("/musikstuecke/{id}")
    Musikstueck one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new MusikstueckNotFoundException(id));
    }

    @PutMapping("/musikstuecke/{id}")
    Musikstueck replaceMusikstueck(@RequestBody Musikstueck newMusikstueck, @PathVariable Long id) {

        return repository.findById(id)
                .map(musikstueck -> {
                    musikstueck.setDatentraeger(newMusikstueck.getDatentraeger());
                    musikstueck.setInterpret(newMusikstueck.getInterpret());
                    musikstueck.setName(newMusikstueck.getName());
                    musikstueck.setGenre(newMusikstueck.getGenre());
                    musikstueck.setErscheinungsjahr(newMusikstueck.getErscheinungsjahr());
                    return repository.save(musikstueck);
                })
                .orElseGet(() -> {
                    newMusikstueck.setId(id);
                    return repository.save(newMusikstueck);
                });
    }

    @DeleteMapping("/musikstuecke/{id}")
    void deleteMusikstueck(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
