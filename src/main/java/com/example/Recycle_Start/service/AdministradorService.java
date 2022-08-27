package com.example.Recycle_Start.service;

import com.example.Recycle_Start.model.Administrador;
import com.example.Recycle_Start.repositoris.AdministradorRepository;
import com.example.Recycle_Start.repositoris.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {
    @Autowired
    private AdministradorRepository administradorRepository;

    // excluir Adm
   /* public void ExcluirAdm(Integer id_adm){
        administradorRepository.deleteById(id_adm);
    }*/

    // salva  adm
    public Administrador SalvaAdministrador(Administrador administrador) {
        administradorRepository.save(administrador);
        return administradorId(administrador.getId_adm());

    }

// edita adm
    public Administrador administradorId(Integer id_adm) {
        return administradorRepository.findById(id_adm).get();
    }

    public Administrador loginAdministrador(String email, String senha) {
        return administradorRepository.findByLoginAndSenha(email, senha);
    }
}
