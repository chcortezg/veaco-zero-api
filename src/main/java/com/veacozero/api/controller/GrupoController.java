package com.veacozero.api.controller;

import com.veacozero.api.model.Grupo;
import com.veacozero.api.repository.GrupoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {
    
    private final GrupoRepository repository;

    public GrupoController(GrupoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Grupo criarGrupo(@RequestBody Grupo grupo) {
        return repository.salvar(grupo);
    }

    @GetMapping
    public List<Grupo> listar() {
        return repository.listarTodos();
    }

    // endpoint para adicionar alguém no grupo: POST /grupos/1/participantes/5
    @PostMapping("/{grupoId}/participantes/{usuarioId}")
    public Grupo adicionarParticipante(@PathVariable Long grupoId, @PathVariable Long usuarioId) {
        Grupo grupo = repository.buscarPorId(grupoId)
            .orElseThrow(() -> new RuntimeException("Grupo não encontrado"));
        
        grupo.adicionarParticipante(usuarioId);
        return repository.salvar(grupo);
    }
}