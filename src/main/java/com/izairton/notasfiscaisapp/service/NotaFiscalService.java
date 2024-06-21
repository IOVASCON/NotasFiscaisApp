package com.izairton.notasfiscaisapp.service;

import com.izairton.notasfiscaisapp.model.NotaFiscal;
import com.izairton.notasfiscaisapp.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * O serviço NotaFiscalService fornece operações de negócio relacionadas à
 * entidade NotaFiscal.
 */
@Service
public class NotaFiscalService {

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    /**
     * Lista todas as notas fiscais.
     *
     * @return uma lista de todas as notas fiscais
     */
    public List<NotaFiscal> listarNotasFiscais() {
        return notaFiscalRepository.findAll();
    }

    /**
     * Obtém uma nota fiscal pelo seu ID.
     *
     * @param id o ID da nota fiscal
     * @return a nota fiscal correspondente ao ID fornecido
     * @throws EntityNotFoundException se a nota fiscal não for encontrada
     */
    public NotaFiscal obterNotaFiscal(Long id) {
        return notaFiscalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nota Fiscal não encontrada"));
    }

    /**
     * Adiciona uma nova nota fiscal.
     *
     * @param notaFiscal a nota fiscal a ser adicionada
     * @return a nota fiscal adicionada
     * @throws EntityExistsException se uma nota fiscal com o mesmo número já
     *                               existir
     */
    public NotaFiscal adicionarNotaFiscal(NotaFiscal notaFiscal) {
        if (notaFiscalRepository.existsByNumeroNota(notaFiscal.getNumeroNota())) {
            throw new EntityExistsException("Nota Fiscal com este número já existe");
        }
        return notaFiscalRepository.save(notaFiscal);
    }

    /**
     * Atualiza uma nota fiscal existente.
     *
     * @param id         o ID da nota fiscal a ser atualizada
     * @param notaFiscal os novos dados da nota fiscal
     * @return a nota fiscal atualizada
     * @throws EntityNotFoundException se a nota fiscal não for encontrada
     */
    public NotaFiscal atualizarNotaFiscal(Long id, NotaFiscal notaFiscal) {
        NotaFiscal notaExistente = notaFiscalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nota Fiscal não encontrada"));

        notaExistente.setNumeroNota(notaFiscal.getNumeroNota());
        notaExistente.setDataNota(notaFiscal.getDataNota());
        notaExistente.setValorNota(notaFiscal.getValorNota());
        notaExistente.setFornecedor(notaFiscal.getFornecedor());
        notaExistente.setProduto(notaFiscal.getProduto());

        return notaFiscalRepository.save(notaExistente);
    }

    /**
     * Exclui uma nota fiscal pelo seu ID.
     *
     * @param id o ID da nota fiscal a ser excluída
     * @throws EntityNotFoundException se a nota fiscal não for encontrada
     */
    public void excluirNotaFiscal(Long id) {
        NotaFiscal notaFiscal = notaFiscalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nota Fiscal não encontrada"));
        notaFiscalRepository.delete(notaFiscal);
    }
}
