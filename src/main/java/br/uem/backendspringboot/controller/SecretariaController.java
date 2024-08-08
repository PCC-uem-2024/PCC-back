package br.uem.backendspringboot.controller;

import br.uem.backendspringboot.model.Secretaria;
import br.uem.backendspringboot.service.SecretariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secretarias")
public class SecretariaController {

    @Autowired
    private SecretariaService secretariaService;

    @PostMapping
    public ResponseEntity<Secretaria> create(@RequestBody Secretaria secretaria) {
        return ResponseEntity.ok(secretariaService.save(secretaria));
    }
}
