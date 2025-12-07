package com.veacozero.api.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.veacozero.api.model.Grupo;

@Repository
public class GrupoRepository {
    private Map<Long, Grupo> dados = new HashMap<>();
    private Long proximoId = 1L;

    public Grupo salvar(Grupo grupo) {
        // se for novo, gera id
        if (grupo.getId() == null) {
            Grupo novoGrupo = new Grupo(proximoId++, grupo.getNome());
            // copia participantes se houver
            novoGrupo.getParticipantesIds().addAll(grupo.getParticipantesIds());
            dados.put(novoGrupo.getId(), novoGrupo);
            return novoGrupo;
        }
        // se já existe, atualiza
        dados.put(grupo.getId(), grupo);
        return grupo;
    }

    public List<Grupo> listarTodos() {
        return new ArrayList<>(dados.values());
    }

    public Optional<Grupo> buscarPorId(Long id) {
        return Optional.ofNullable(dados.get(id));
    }
}