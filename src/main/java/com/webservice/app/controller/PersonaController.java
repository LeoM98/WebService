package com.webservice.app.controller;

import com.webservice.app.model.Persona;
import com.webservice.app.services.PersonaServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    PersonaServiceI serviceI;

    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> listar(){
        List<Persona> personas = serviceI.finAll();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/listarId/{id}")
    public ResponseEntity<Persona> listarById(@PathVariable Long id){
        Persona personas = serviceI.getById(id);
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Persona> save(@RequestBody Persona persona){
        Persona personas = serviceI.savePersona(persona);
        return new ResponseEntity<>(personas, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        serviceI.deletePersona(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Persona> delete(@RequestBody Persona persona,@PathVariable Long id){
        Persona personaU = serviceI.update(persona, id);
        return new ResponseEntity<>(personaU,HttpStatus.OK);
    }

}
