package br.uem.backendspringboot.controller;

import br.uem.backendspringboot.dto.request.AlunoRequestDto;
import br.uem.backendspringboot.model.Aluno;
import br.uem.backendspringboot.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> create(@RequestBody AlunoRequestDto aluno) {
        return ResponseEntity.ok(alunoService.save(aluno));
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll() {
        return ResponseEntity.ok(alunoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getById(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.findById(id));
    }

    @GetMapping("/consulta_email")
    public ResponseEntity<Aluno> getByEmail(@RequestParam String email) {
        return ResponseEntity.ok(alunoService.findByEmail(email));
    }

}
