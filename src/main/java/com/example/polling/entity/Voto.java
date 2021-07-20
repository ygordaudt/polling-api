package com.example.polling.entity;

import com.example.polling.commons.JpaUtil;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Associado associado;

    @Column(nullable = false)
    private LocalDateTime dataRegistro;

    /* Tratamento do valor booleano */
    @Column(name = "voto", length = 3)
    private String voto;

    @Transient
    public Boolean getVotoSimNao() {
        return JpaUtil.toBoolean(voto);
    }

    public void setVotoSimNao(Boolean voto) {
        setVotoSimNaoString(JpaUtil.toSimNao(voto));
    }

    @Transient
    private String getVotoSimNaoString() {
        return voto;
    }

    private void setVotoSimNaoString(String voto) {
        this.voto = voto;
    }

}
