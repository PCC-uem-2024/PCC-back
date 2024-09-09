package br.uem.backendspringboot.service;

import br.uem.backendspringboot.dto.ChangePasswordDto;
import br.uem.backendspringboot.exception.BadRequestException;
import br.uem.backendspringboot.exception.MismatchPasswordException;
import br.uem.backendspringboot.model.Usuario;
import br.uem.backendspringboot.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public Boolean matchPassword(String email, String password) {
        return usuarioRepository.findByEmail(email).filter(value -> passwordEncoder.matches(password, value.getSenha())).isPresent();
    }

    public Boolean matchNewPassword(String newPassword, String confirmPassword) {
        return newPassword.equals(confirmPassword);
    }

    public Boolean isNewPasswordEqualToOldPassword(String oldPassword, String newPassword) {
        return oldPassword.equals(newPassword);
    }

    public Boolean changePassword(ChangePasswordDto changePasswordDto) {
        Boolean matchPassword = matchPassword(changePasswordDto.getEmail(), changePasswordDto.getOldPassword());
        if (isNewPasswordEqualToOldPassword(changePasswordDto.getOldPassword(), changePasswordDto.getNewPassword())) {
            throw new MismatchPasswordException("Nova senha não pode ser igual a antiga.");
        } else if (!matchNewPassword(changePasswordDto.getNewPassword(), changePasswordDto.getConfirNewPassword())) {
            throw new MismatchPasswordException("A senha e a confirmação da senha são diferentes.");
        } else if (matchPassword) {
            Optional<Usuario> userOpt = usuarioRepository.findByEmail(changePasswordDto.getEmail());
            if (userOpt.isPresent()) {
                Usuario user = userOpt.get();
                user.setSenha(passwordEncoder.encode(changePasswordDto.getNewPassword()));
                usuarioRepository.save(user);
                return true;
            } else {
                return false;
            }
        } else {
            throw new BadRequestException("Senha incorreta");
        }
    }

    public Boolean usuarioExists(String email){
        return usuarioRepository.findByEmail(email).isPresent();
    }

    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
