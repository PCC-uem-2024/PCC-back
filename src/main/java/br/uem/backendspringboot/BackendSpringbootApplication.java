package br.uem.backendspringboot;

import br.uem.backendspringboot.model.Usuario;
import br.uem.backendspringboot.model.enums.Role;
import br.uem.backendspringboot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class BackendSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendSpringbootApplication.class, args);
    }

    @Autowired
    UsuarioRepository repository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner init() {
        return args -> {

            // Inserindo usuario master se não existir
            Optional<Usuario> userOpt = repository.findByEmail("master@uem.br");
            if (userOpt.isEmpty()) {
                Usuario usuario = new Usuario();
                usuario.setEmail("master@uem.br");
                usuario.setSenha(passwordEncoder.encode("123456"));
                Set<Role> roles = new HashSet<>();
                roles.add(Role.ROLE_SECRETARIA);
                usuario.setRoles(roles);
                repository.save(usuario);
            }
        };
    }

}
