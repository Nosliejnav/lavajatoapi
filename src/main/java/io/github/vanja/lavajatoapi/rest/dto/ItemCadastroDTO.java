package io.github.vanja.lavajatoapi.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCadastroDTO {

    private Integer veiculo;
    private Integer quantidade;
}
