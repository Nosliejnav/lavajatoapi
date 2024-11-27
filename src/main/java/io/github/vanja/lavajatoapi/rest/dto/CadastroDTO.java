package io.github.vanja.lavajatoapi.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastroDTO {

    private Integer cliente;
    private BigDecimal total;
    private List<ItemCadastroDTO> items;

}
