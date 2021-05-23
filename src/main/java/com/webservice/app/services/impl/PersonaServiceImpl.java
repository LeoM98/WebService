package com.webservice.app.services.impl;

import com.webservice.app.model.Persona;
import com.webservice.app.repositorio.PersonaRepository;
import com.webservice.app.services.PersonaServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaServiceI {

    @Autowired
    PersonaRepository repository;

    @Override
    public List<Persona> finAll() {
        List<Persona> personas = repository.findAll();
        return personas;
    }

    @Override
    public Persona getById(Long id) {

        Persona persona = repository.findById(id).orElse(null);
        return persona;
    }

    @Override
    public Persona savePersona(Persona persona) {
        return repository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Persona update(Persona persona, Long id) {
        Persona personaN = repository.findById(id).orElse(null);

        personaN.setNombre(persona.getNombre());
        personaN.setApellido(persona.getApellido());
        personaN.setTelefono(persona.getTelefono());
        personaN.setDireccion(persona.getDireccion());

        repository.save(personaN);
        return personaN;
    }
}
