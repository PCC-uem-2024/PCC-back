package br.uem.backendspringboot.model;

import br.uem.backendspringboot.model.enums.Modo;
import br.uem.backendspringboot.model.enums.TipoDefesa;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
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
    private LocalDate data;
    private LocalTime hora;
    @Enumerated(EnumType.ORDINAL)
    private Modo modo;
    private String localFisico;
    private String linkMeet;
    private TipoDefesa tipo;
    @OneToMany(mappedBy = "defesa")
    private Set<Anexo> anexos;
    @OneToMany(mappedBy = "defesa")
    private Set<MembroInterno> membrosInternos;
    @OneToMany(mappedBy = "defesa")
    private Set<SuplementeInterno> suplentesInternos;
    @ManyToMany
    @JoinTable(
            name = "defesa_membro_externo",
            joinColumns = @JoinColumn(name = "defesa_id"),
            inverseJoinColumns = @JoinColumn(name = "membro_externo_id")
    )
    private Set<Externo> membrosExternos;
    @ManyToMany
    @JoinTable(
            name = "defesa_suplente_externo",
            joinColumns = @JoinColumn(name = "defesa_id"),
            inverseJoinColumns = @JoinColumn(name = "suplente_externo_id")
    )
    private Set<Externo> suplentesExternos;

}
