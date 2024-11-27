package io.github.vanja.lavajatoapi.rest.controller;

import io.github.vanja.lavajatoapi.domain.entity.Cadastro;
import io.github.vanja.lavajatoapi.domain.entity.ItemCadastro;
import io.github.vanja.lavajatoapi.rest.dto.CadastroDTO;
import io.github.vanja.lavajatoapi.rest.dto.InformacaoItemCadastroDTO;
import io.github.vanja.lavajatoapi.rest.dto.InformacoesCadastroDTO;
import io.github.vanja.lavajatoapi.service.CadastroService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("cadastros")
//@NoArgsConstructor
public class CadastroController {


    private CadastroService service;

    //
    public CadastroController(CadastroService service) {
        this.service = service;
    }
    //

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody CadastroDTO dto){
        Cadastro cadastro = service.salvar(dto);
        return cadastro.getId();
    }

    @GetMapping("{id}")
    public InformacoesCadastroDTO getById( @PathVariable Integer id){
        return service
                .obterCadastroCompleto(id)
                .map(c -> converter(c) )
                .orElseThrow(() ->
                        new ResponseStatusException(NOT_FOUND, "Cadastro não encontrado."));

    }

    private InformacoesCadastroDTO converter(Cadastro cadastro){
        return InformacoesCadastroDTO
                .builder()
                .codigo(cadastro.getId())
                .dataCadastro(cadastro.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .cpf(cadastro.getCliente().getCpf())
                .nomeCliente(cadastro.getCliente().getNome())
                .total(cadastro.getTotal())
                .items(converter((cadastro.getItens())))
                .build();
    }

    private List<InformacaoItemCadastroDTO> converter(List<ItemCadastro> itens){
        if(CollectionUtils.isEmpty(itens)){
            return Collections.emptyList();
        }

        return itens.stream().map(
                item -> InformacaoItemCadastroDTO
                        .builder().marcaVeiculo(item.getVeiculo().getMarca())
                        .precoUnitario(item.getVeiculo().getPreco())
                        .quantidade(item.getQuantidade())
                        .build()
        ).collect(Collectors.toList());
    }
}
