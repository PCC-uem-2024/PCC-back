package br.uem.backendspringboot.controller;

import br.uem.backendspringboot.dto.ChangePasswordDto;
import br.uem.backendspringboot.dto.ResponseDto;
import br.uem.backendspringboot.service.UsuarioService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping("/changePassword")
    public ResponseEntity<ResponseDto> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        Boolean matchPassword = usuarioService.matchPassword(changePasswordDto.getEmail(), changePasswordDto.getOldPassword());
        if (matchPassword) {
            Boolean changed = usuarioService.changePassword(changePasswordDto.getEmail(), changePasswordDto.getNewPassword());
            if (changed) {
                return ResponseEntity.ok(ResponseDto.builder().message("Senha alterada com sucesso!").build());
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDto.builder()
                                                            .message("Usuario e/ou senha incorreta!").build());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDto.builder().message("Senha incorreta").build());
        }
    }
}
