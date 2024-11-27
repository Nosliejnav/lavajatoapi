package io.github.vanja.lavajatoapi.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacaoItemCadastroDTO {
    private String marcaVeiculo;
    private BigDecimal precoUnitario;
    private Integer quantidade;
}
