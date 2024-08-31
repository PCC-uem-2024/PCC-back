package br.uem.backendspringboot;

import br.uem.backendspringboot.model.Usuario;
import br.uem.backendspringboot.model.UsuarioTipo;
import br.uem.backendspringboot.repository.UsuarioRepository;
import br.uem.backendspringboot.repository.UsuariotipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class BackendSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendSpringbootApplication.class, args);
    }

    @Autowired
    UsuarioRepository repository;

    @Autowired
    UsuariotipoRepository usuariotipoRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner init() {
        return args -> {
            // Inserindo os tipos de usuario
            long tipos = usuariotipoRepository.count();
            if (tipos == 0) {
                UsuarioTipo secretaria = new UsuarioTipo();
                secretaria.setNome("Secretaria");
                secretaria.setDescricao("Secretaria");

                UsuarioTipo aluno = new UsuarioTipo();
                aluno.setNome("Aluno");
                aluno.setDescricao("Aluno");

                UsuarioTipo professor = new UsuarioTipo();
                professor.setNome("Professor");
                professor.setDescricao("Professor");

                usuariotipoRepository.save(secretaria);
                usuariotipoRepository.save(aluno);
                usuariotipoRepository.save(professor);
            }

            // Inserindo usuario master se não existir
            Optional<Usuario> userOpt = repository.findByEmail("master@uem.br");
            if (userOpt.isEmpty()) {
              Usuario usuario = new Usuario();
              usuario.setEmail("master@uem.br");
              usuario.setSenha(passwordEncoder.encode("123456"));
              Optional<UsuarioTipo> tipo = usuariotipoRepository.findById(1L);
              tipo.ifPresent(usuario::setUsuarioTipo);
              repository.save(usuario);
            }
        };
    }

}
