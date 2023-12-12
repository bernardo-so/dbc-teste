package com.dbc.gerenciador.votacao.sessao.repository;

import com.dbc.gerenciador.votacao.sessao.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
}