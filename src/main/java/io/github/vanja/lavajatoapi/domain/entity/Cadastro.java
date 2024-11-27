package io.github.vanja.lavajatoapi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cadastro")
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @Column(name = "total", precision = 20,scale = 2)
    private BigDecimal total;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "status")
//    private StatusCadastro status;

    @OneToMany(mappedBy = "cadastro")
    private List<ItemCadastro> itens;
}
