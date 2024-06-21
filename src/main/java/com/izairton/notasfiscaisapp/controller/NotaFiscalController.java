package com.izairton.notasfiscaisapp.controller;

import com.izairton.notasfiscaisapp.model.NotaFiscal;
import com.izairton.notasfiscaisapp.service.NotaFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController // Use @RestController aqui
@RequestMapping("/notasfiscais")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalService notaFiscalService;

    @GetMapping
    public List<NotaFiscal> listarNotasFiscais() {
        return notaFiscalService.listarNotasFiscais();
    }

    @GetMapping("/{id}")
    public NotaFiscal obterNotaFiscal(@PathVariable Long id) {
        return notaFiscalService.obterNotaFiscal(id);
    }

    @PostMapping
    public NotaFiscal adicionarNotaFiscal(@Valid @RequestBody NotaFiscal notaFiscal) {
        return notaFiscalService.adicionarNotaFiscal(notaFiscal);
    }

    @PutMapping("/{id}")
    public NotaFiscal atualizarNotaFiscal(@PathVariable Long id, @Valid @RequestBody NotaFiscal notaFiscal) {
        return notaFiscalService.atualizarNotaFiscal(id, notaFiscal);
    }

    @DeleteMapping("/{id}")
    public void excluirNotaFiscal(@PathVariable Long id) {
        notaFiscalService.excluirNotaFiscal(id);
    }
}
