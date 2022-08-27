package com.example.Recycle_Start.service;

import com.example.Recycle_Start.model.Agendamento;
import com.example.Recycle_Start.repositoris.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    // Editar Agendamento
    public Agendamento agendamentoId(Integer id_agendamento) {
        return agendamentoRepository.findById(id_agendamento).get();
    }



    // Salvar o Agendamento
    public Agendamento salvarAgendamento(Agendamento agendamento) {
        agendamentoRepository.save(agendamento);
        return agendamentoId (agendamento.getId_agendamento());
    }

    public List<Agendamento> mostraAgendamanto() {
        return (List<Agendamento>) agendamentoRepository.findAll();
    }
}

