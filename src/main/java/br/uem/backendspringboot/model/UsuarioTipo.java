package br.uem.backendspringboot.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioTipo implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuario_tipo_id")
    private Long id;
    private String nome;
    private String descricao;

    @Override
    public String getAuthority() {
        return nome;
    }
}
