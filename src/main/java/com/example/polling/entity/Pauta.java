package com.example.polling.entity;
import com.example.polling.commons.JpaUtil;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pauta {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String descricao;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    private LocalDateTime dataAberturaSessao;

    private LocalDateTime dataEncerramentoSessao;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Voto> votos;

    /**
     * Atributos utilizados na apuração
     */
    @Transient
    private long votosPositivos;

    @Transient
    private long votosNegativos;

    @Transient
    private long totalVotos;

    @Transient
    private String resultado;

    @PostLoad
    private void apurar() {
        totalVotos = votos.size();
        votosPositivos = votos.stream().filter(Voto::getVotoSimNao).count();
        votosNegativos = totalVotos - votosPositivos;
        if (dataEncerramentoSessao != null && dataEncerramentoSessao.isBefore(LocalDateTime.now())) {
            resultado = votosPositivos == votosNegativos ? "Empate" : JpaUtil.toSimNao(votosPositivos > votosNegativos);
        } else {
            resultado = "Em andamento";
        }

    }
}
