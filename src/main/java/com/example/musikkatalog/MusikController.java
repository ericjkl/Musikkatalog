package com.example.musikkatalog;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/musikstuecke")
    Musikstueck newMusikstueck(@RequestBody Musikstueck newMusikstueck) {
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
