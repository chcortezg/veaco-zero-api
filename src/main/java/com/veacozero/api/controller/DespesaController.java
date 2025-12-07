package com.veacozero.api.controller;

import com.veacozero.api.model.Despesa;
import com.veacozero.api.service.DespesaService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

    private final DespesaService service;

    public DespesaController(DespesaService service) {
        this.service = service;
    }

    @PostMapping
    public Despesa registrar(@RequestBody Despesa despesa) {
        return service.registrarDespesa(despesa);
    }

    // endpoint que calcula quem deve a quem
    @GetMapping("/saldo/{grupoId}")
    public Map<Long, Double> verSaldoDoGrupo(@PathVariable Long grupoId) {
        return service.calcularSaldo(grupoId);
    }
}