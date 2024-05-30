package br.com.fiap.calorias.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_alimentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Alimento {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_ALIMENTOS"
    )
    @SequenceGenerator(
            name = "SEQ_ALIMENTOS",
            sequenceName = "SEQ_ALIMENTOS",
            allocationSize = 1
    )
    private Long alimentoId;

    private String nome;
    private String porcao;

    @Column(name = "qtde_proteina")
    private Double quantidadeProteina;

    @Column(name = "qtde_carboidrato")
    private Double quantidadeCarboidrato;

    @Column(name = "qtde_gorduras")
    private Double quantidadeGorduras;

    @Column(name = "total_calorias")
    private Double totalCalorias;
}