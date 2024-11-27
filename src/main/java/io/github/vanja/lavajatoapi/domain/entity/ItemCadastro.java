package io.github.vanja.lavajatoapi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item_cadastro")
public class ItemCadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Cadastro_id")
    private Cadastro cadastro;

    @ManyToOne
    @JoinColumn(name = "Veiculo_id")
    private Veiculo veiculo;

    @Column
    private Integer quantidade;
}
