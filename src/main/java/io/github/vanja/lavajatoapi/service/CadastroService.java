package io.github.vanja.lavajatoapi.service;


import io.github.vanja.lavajatoapi.domain.entity.Cadastro;
import io.github.vanja.lavajatoapi.rest.dto.CadastroDTO;

import java.util.Optional;

public interface CadastroService {
    Cadastro salvar ( CadastroDTO dto );

    Optional <Cadastro> obterCadastroCompleto(Integer id);
}
