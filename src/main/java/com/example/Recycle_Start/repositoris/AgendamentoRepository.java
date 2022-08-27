package com.example.Recycle_Start.repositoris;

import com.example.Recycle_Start.model.Agendamento;
import com.example.Recycle_Start.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Integer> {

    //consultar do agendamento aparti do cnpj da empresa e cpf do usuario
    @Query(value =  "select * from agendamento where empresa_cnpj = ?1 AND usuario_cpf = ?2", nativeQuery = true)
    Empresa loginEmpresa(String cnpj, String senha);


    // consultar CONSULTA O AGENDAMENTO DA EMPRESA CONSUTANDO PELO CNPJ
    @Query(value = "select * from agendamento where nome_empreaa = ?1 ORDER BY RAND(cnpj) ", nativeQuery = true)
    List<Empresa> buscarPorNome(String nome, String cnpj);

    //consulta empresas
    @Query(value = "select count(cnpj) from empresa", nativeQuery = true)
    public Empresa EmpresasCadastrados (String cnpj);
}
