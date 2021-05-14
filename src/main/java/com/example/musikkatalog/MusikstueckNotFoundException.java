package com.example.musikkatalog;

class MusikstueckNotFoundException extends RuntimeException{
    MusikstueckNotFoundException(Long id) {
        super("Could not find Musikstueck " + id);
    }
}
