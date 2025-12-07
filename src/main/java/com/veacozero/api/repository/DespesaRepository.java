package com.veacozero.api.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.veacozero.api.model.Despesa;

@Repository
public class DespesaRepository {
    private Map<Long, Despesa> dados = new HashMap<>();
    private Long proximoId = 1L;

    public Despesa salvar(Despesa despesa) {
        Despesa novaDespesa = new Despesa(
            proximoId++,
            despesa.getDescricao(),
            despesa.getValor(),
            despesa.getPagadorId(),
            despesa.getGrupoId()
        );
        dados.put(novaDespesa.getId(), novaDespesa);
        return novaDespesa;
    }

    public List<Despesa> listarPorGrupo(Long grupoId) {
        return dados.values().stream()
                .filter(d -> d.getGrupoId().equals(grupoId))
                .collect(Collectors.toList());
    }
}