package io.github.vanja.lavajatoapi.domain.repository;

import io.github.vanja.lavajatoapi.domain.entity.ItemCadastro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsCadastro extends JpaRepository<ItemCadastro, Integer> {
}
