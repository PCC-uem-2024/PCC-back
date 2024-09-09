package br.uem.backendspringboot.controller;

import br.uem.backendspringboot.dto.request.SecretariaRequestDto;
import br.uem.backendspringboot.model.Secretaria;
import br.uem.backendspringboot.service.SecretariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/secretarias")
public class SecretariaController {

    @Autowired
    private SecretariaService secretariaService;

    @PostMapping
    public ResponseEntity<Secretaria> create(@RequestBody SecretariaRequestDto secretaria) {
        return ResponseEntity.ok(secretariaService.save(secretaria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Secretaria> findById(@PathVariable Long id) {
        return ResponseEntity.ok(secretariaService.findById(id));
    }

    @GetMapping("/email")
    public ResponseEntity<Secretaria> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok(secretariaService.findByEmail(email));
    }
}
