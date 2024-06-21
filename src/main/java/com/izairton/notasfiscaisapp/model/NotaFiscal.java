package com.izairton.notasfiscaisapp.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * A entidade NotaFiscal representa uma nota fiscal no sistema.
 * Cada nota fiscal contém informações sobre o fornecedor, produto, data da
 * nota,
 * número da nota e valor da nota.
 */
@Entity
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único da nota fiscal

    @NotNull(message = "O número da nota fiscal é obrigatório")
    @Digits(integer = 10, fraction = 0, message = "O número da nota fiscal deve conter apenas dígitos")
    @Column(unique = true)
    private Long numeroNota; // Número da nota fiscal

    @NotNull(message = "A data da nota fiscal é obrigatória")
    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "A data deve estar no formato dd/MM/yyyy")
    private String dataNota; // Data da nota fiscal

    @NotNull(message = "O valor da nota fiscal é obrigatório")
    @Digits(integer = 10, fraction = 2, message = "O valor da nota fiscal deve ser um número válido")
    private BigDecimal valorNota; // Valor da nota fiscal

    @NotNull(message = "O fornecedor é obrigatório")
    @Size(min = 2, max = 100, message = "O fornecedor deve ter entre 2 e 100 caracteres")
    private String fornecedor; // Nome do fornecedor

    @NotNull(message = "O produto é obrigatório")
    @Size(min = 2, max = 100, message = "O produto deve ter entre 2 e 100 caracteres")
    private String produto; // Nome do produto

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(Long numeroNota) {
        this.numeroNota = numeroNota;
    }

    public String getDataNota() {
        return dataNota;
    }

    public void setDataNota(String dataNota) {
        this.dataNota = dataNota;
    }

    public BigDecimal getValorNota() {
        return valorNota;
    }

    public void setValorNota(BigDecimal valorNota) {
        this.valorNota = valorNota;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}
