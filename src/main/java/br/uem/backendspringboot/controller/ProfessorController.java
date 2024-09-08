package br.uem.backendspringboot.controller;

import br.uem.backendspringboot.dto.NewProfessorDto;
import br.uem.backendspringboot.dto.ResponseDto;
import br.uem.backendspringboot.dto.response.ProfessorDto;
import br.uem.backendspringboot.model.Professor;
import br.uem.backendspringboot.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping("/cadastro")
    public ResponseEntity<ResponseDto> create(@RequestBody NewProfessorDto professor) {
        Boolean professorExists = professorService.professorExists(professor.getEmail());

        if(professorExists){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDto.builder()
                    .message("Ja existe um usuario cadastrado com esse email").build());
        } else {
            professorService.save(professor);
            return ResponseEntity.ok(ResponseDto.builder()
                    .message("Usuario cadastrado com sucesso").build());
        }
    }

    @GetMapping("/consulta_prefixo")
    public ResponseEntity<List<ProfessorDto>> findByNomeStartsWith(@RequestParam String prefixo){
        List<ProfessorDto> listProfessor = professorService.findByNomeStartsWith(prefixo);
        return ResponseEntity.ok(listProfessor);
    }

    @GetMapping("/consulta_id")
    public ResponseEntity<ProfessorDto> findById(@RequestParam Long id){
        ProfessorDto professor = professorService.findById(id);
        return ResponseEntity.ok(professor);
    }

    @GetMapping("/consulta_email")
    public ResponseEntity<ProfessorDto> findByEmail(@RequestParam String email){
        ProfessorDto professor = professorService.findByEmail(email);
        return ResponseEntity.ok(professor);
    }
}
