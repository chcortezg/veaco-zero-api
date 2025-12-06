package com.veacozero.api.model;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private Long id;
    private String nome;
    // lista de ods dos usuários que participam do grupo
    private List<Long> participantesIds = new ArrayList<>();

    public Grupo(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public List<Long> getParticipantesIds() { return participantesIds; }

    public void adicionarParticipante(Long usuarioId) {
        this.participantesIds.add(usuarioId);
    }
}