package br.uem.backendspringboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false, unique = true)
    private String token;
}
