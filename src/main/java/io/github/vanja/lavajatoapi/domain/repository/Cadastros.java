package io.github.vanja.lavajatoapi.domain.repository;

import io.github.vanja.lavajatoapi.domain.entity.Cliente;
import io.github.vanja.lavajatoapi.domain.entity.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface Cadastros extends JpaRepository<Cadastro, Integer> {

    List<Cadastro> findByCliente(Cliente cliente);

    @Query(" select c from Cadastro c left join fetch c.itens where c.id = :id ")
    Optional<Cadastro> findByIdFetchItens(@Param("id") Integer id);

//    Optional<Cadastro> findByIdFetchItens(@Param("id") Integer id);
}
