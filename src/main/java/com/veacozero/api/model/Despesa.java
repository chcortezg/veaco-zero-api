package com.veacozero.api.model;

public class Despesa {
    private Long id;
    private String descricao;
    private Double valor;
    private Long pagadorId; // id de quem pagou a conta
    private Long grupoId;   // id do grupo onde a despesa ocorreu

    public Despesa(Long id, String descricao, Double valor, Long pagadorId, Long grupoId) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.pagadorId = pagadorId;
        this.grupoId = grupoId;
    }

    public Long getId() { return id; }
    public String getDescricao() { return descricao; }
    public Double getValor() { return valor; }
    public Long getPagadorId() { return pagadorId; }
    public Long getGrupoId() { return grupoId; }
}