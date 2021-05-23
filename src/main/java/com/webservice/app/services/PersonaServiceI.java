package com.webservice.app.services;

import com.webservice.app.model.Persona;

import java.util.List;

public interface PersonaServiceI {

    List<Persona> finAll();
    Persona getById(Long id);
    Persona savePersona(Persona persona);
    void deletePersona(Long id);
    Persona update(Persona persona, Long id);

}
