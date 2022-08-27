package com.example.Recycle_Start.service;

import com.example.Recycle_Start.model.Empresa;
import com.example.Recycle_Start.model.Usuario;
import com.example.Recycle_Start.repositoris.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;


    // Lista todas as lojas
    public List<Empresa> mostraEmpresas() {
        return (List<Empresa>) empresaRepository.findAll();
    }

    //salvar empresa
    public Empresa salvarEmpresa(Empresa empresa) {
        empresaRepository.save(empresa);
        return empresaCnpj(empresa.getCnpj());
    }

    // PARA DELETAR EMPRESA
    public void excluirEmpresa(String cnpj) {
        empresaRepository.deleteById(cnpj);
    }

    //para edita enpresa
    public Empresa empresaCnpj(String cnpj) {
        return empresaRepository.findById(cnpj).get();
    }


    // login empresa
    public Empresa loginEmpresa( String cnpj, String senha ) {
        return empresaRepository.findByLoginAndSenha(cnpj, senha);
    }
}






