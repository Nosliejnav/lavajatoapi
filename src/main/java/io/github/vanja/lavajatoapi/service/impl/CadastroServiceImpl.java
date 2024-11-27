package io.github.vanja.lavajatoapi.service.impl;

import io.github.vanja.lavajatoapi.domain.entity.Cliente;
import io.github.vanja.lavajatoapi.domain.entity.ItemCadastro;
import io.github.vanja.lavajatoapi.domain.entity.Cadastro;
import io.github.vanja.lavajatoapi.domain.entity.Veiculo;
import io.github.vanja.lavajatoapi.domain.repository.Cadastros;
import io.github.vanja.lavajatoapi.domain.repository.Clientes;
import io.github.vanja.lavajatoapi.domain.repository.ItemsCadastro;
import io.github.vanja.lavajatoapi.domain.repository.Veiculos;
import io.github.vanja.lavajatoapi.exception.RegraNegocioException;
import io.github.vanja.lavajatoapi.rest.dto.ItemCadastroDTO;
import io.github.vanja.lavajatoapi.rest.dto.CadastroDTO;
import io.github.vanja.lavajatoapi.service.CadastroService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // Elimina todos os construtors se tiver o argumento obrigatorio "private final"
public class CadastroServiceImpl implements CadastroService {

    private final Cadastros repository;
    private final Clientes clientesRepository;
    private final Veiculos veiculosRepository;
    private final ItemsCadastro itemsCadastroRepository;

//    public CadastroServiceImpl( Cadastros repository, Clientes clientes){
//        this.repository = repository;
//        this.clientesRepository = clientes;
//    }

    @Override
    @Transactional
    public Cadastro salvar(CadastroDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository
                .findById(idCliente).
                orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));

        Cadastro cadastro = new Cadastro();
        cadastro.setTotal(dto.getTotal());
        cadastro.setDataCadastro(LocalDate.now());
        cadastro.setCliente(cliente);
//        Cadastro.setStatus(StatusPedido.REALIZADO);

        List<ItemCadastro> itemsCadastro = converterItems(cadastro, dto.getItems());
        repository.save(cadastro);
        itemsCadastroRepository.saveAll(itemsCadastro);
        cadastro.setItens(itemsCadastro);
        return cadastro;
    }

    @Override
    public Optional<Cadastro> obterCadastroCompleto(Integer id) {
        return repository.findByIdFetchItens(id);
    }



    private List<ItemCadastro> converterItems(Cadastro cadastro, List<ItemCadastroDTO> items){
        if(items.isEmpty()){
            throw new RegraNegocioException("Não é possível realizar um cadastro sem items.");
        }

        return items
                .stream()
                .map( dto -> {
                    Integer idVeiculo = dto.getVeiculo();
                    Veiculo veiculo = veiculosRepository
                            .findById(idVeiculo)
                            .orElseThrow(
                                    () -> new RegraNegocioException(
                                            "Código de Veiculo inválido: " + idVeiculo
                                    ));

                    ItemCadastro itemCadastro = new ItemCadastro();
                    itemCadastro.setQuantidade(dto.getQuantidade());
                    itemCadastro.setCadastro(cadastro);
                    itemCadastro.setVeiculo(veiculo);
                    return itemCadastro;

                }).collect(Collectors.toList());
   }
}
