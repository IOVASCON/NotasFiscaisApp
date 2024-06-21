package com.izairton.notasfiscaisapp.repository;

import com.izairton.notasfiscaisapp.model.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * O repositório NotaFiscalRepository fornece as operações de acesso aos dados
 * para a entidade NotaFiscal.
 * Ele herda as operações CRUD do JpaRepository.
 */
@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {

    /**
     * Verifica se uma nota fiscal com o número especificado já existe.
     *
     * @param numeroNota o número da nota fiscal
     * @return true se uma nota fiscal com o número especificado já existir, false
     *         caso contrário
     */
    boolean existsByNumeroNota(Long numeroNota);
}
