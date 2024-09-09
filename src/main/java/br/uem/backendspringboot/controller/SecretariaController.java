package br.uem.backendspringboot.controller;

import br.uem.backendspringboot.dto.NewSecretariaDto;
import br.uem.backendspringboot.dto.ResponseDto;
import br.uem.backendspringboot.dto.response.SecretariaDto;
import br.uem.backendspringboot.model.Secretaria;
import br.uem.backendspringboot.service.SecretariaService;
import br.uem.backendspringboot.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/secretarias")
public class SecretariaController {

    @Autowired
    private SecretariaService secretariaService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<ResponseDto> create(@RequestBody NewSecretariaDto secretaria) {
        Boolean secretariaExists =  usuarioService.usuarioExists(secretaria.getEmail());

        if(secretariaExists){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDto.builder()
                    .message("Ja existe um usuario cadastrado com esse email").build());
        } else {
            secretariaService.save(secretaria);
            return ResponseEntity.ok(ResponseDto.builder()
                    .message("Usuario cadastrado com sucesso").build());
        }
    }

    @GetMapping("/consulta_id")
    public ResponseEntity<SecretariaDto> findById(@RequestParam Long id){
        SecretariaDto professor = secretariaService.findById(id);
        return ResponseEntity.ok(professor);
    }

    @GetMapping("/consulta_email")
    public ResponseEntity<SecretariaDto> findByEmail(@RequestParam String email){
        SecretariaDto professor = secretariaService.findByEmail(email);
        return ResponseEntity.ok(professor);
    }
}
