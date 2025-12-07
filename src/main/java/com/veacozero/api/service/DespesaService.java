package com.veacozero.api.service;

import com.veacozero.api.model.Despesa;
import com.veacozero.api.model.Grupo;
import com.veacozero.api.repository.DespesaRepository;
import com.veacozero.api.repository.GrupoRepository;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DespesaService {
    private final DespesaRepository despesaRepository;
    private final GrupoRepository grupoRepository;

    public DespesaService(DespesaRepository despesaRepository, GrupoRepository grupoRepository) {
        this.despesaRepository = despesaRepository;
        this.grupoRepository = grupoRepository;
    }

    // funcionalidade 1: registrar a despesa
    public Despesa registrarDespesa(Despesa despesa) {
        // valida se o grupo existe antes de salvar
        if (grupoRepository.buscarPorId(despesa.getGrupoId()).isEmpty()) {
            throw new RuntimeException("Grupo não encontrado com ID: " + despesa.getGrupoId());
        }
        return despesaRepository.salvar(despesa);
    }

    // funcionalidade 2: calcular quem deve a quem 
    public Map<Long, Double> calcularSaldo(Long grupoId) {
        Grupo grupo = grupoRepository.buscarPorId(grupoId)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado"));

        List<Despesa> despesas = despesaRepository.listarPorGrupo(grupoId);
        Map<Long, Double> saldos = new HashMap<>();

        // inicializa saldo zerado para todos os participantes
        for (Long usuarioId : grupo.getParticipantesIds()) {
            saldos.put(usuarioId, 0.0);
        }

        // processa cada despesa
        for (Despesa d : despesas) {
            // divisão simples: valor total / número de participantes
            int numParticipantes = grupo.getParticipantesIds().size();
            if (numParticipantes == 0) continue;
            
            Double valorPorPessoa = d.getValor() / numParticipantes;

            // o pagador ganha crédito pelo valor total que desembolsou
            Long pagador = d.getPagadorId();
            saldos.put(pagador, saldos.getOrDefault(pagador, 0.0) + d.getValor());

            // todos perdem a sua parte no consumo
            for (Long participanteId : grupo.getParticipantesIds()) {
                saldos.put(participanteId, saldos.getOrDefault(participanteId, 0.0) - valorPorPessoa);
            }
        }
        
        // resultado: 
        // valor positivo = a pessoa tem dinheiro a receber
        // valor negativo = a pessoa deve esse valor
        return saldos;
    }
}