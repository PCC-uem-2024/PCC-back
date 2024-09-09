package br.uem.backendspringboot.model;

import br.uem.backendspringboot.model.enums.Modo;
import br.uem.backendspringboot.model.enums.TipoDefesa;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Defesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private LocalDateTime data;
    @Enumerated(EnumType.STRING)
    private Modo modo;
    private String localFisico;
    private String linkMeet;
    private TipoDefesa tipo;
    @OneToMany(mappedBy = "defesa")
    @Fetch(FetchMode.JOIN)
    private Set<Anexo> anexos = new HashSet<>();
    @OneToMany(mappedBy = "defesa")
    @Fetch(FetchMode.JOIN)
    private Set<MembroInterno> membrosInternos = new HashSet<>();
    @OneToMany(mappedBy = "defesa")
    @Fetch(FetchMode.JOIN)
    private Set<MembroExterno> membrosExternos = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;
}
