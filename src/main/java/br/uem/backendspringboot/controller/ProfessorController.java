package br.uem.backendspringboot.controller;

import br.uem.backendspringboot.dto.request.ProfessorRequestDto;
import br.uem.backendspringboot.model.Professor;
import br.uem.backendspringboot.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<Professor> create(@RequestBody ProfessorRequestDto professor) {
        return ResponseEntity.ok(professorService.save(professor));
    }

    @GetMapping("/prefixo")
    public ResponseEntity<List<Professor>> findByNomeContains(@RequestParam String prefixo) {
        return ResponseEntity.ok(professorService.findByNomeContains(prefixo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Long id) {
        return ResponseEntity.ok(professorService.findById(id));
    }

    @GetMapping("/email")
    public ResponseEntity<Professor> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok(professorService.findByEmail(email));
    }
}
