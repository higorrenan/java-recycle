package com.example.Recycle_Start.repositoris;

import com.example.Recycle_Start.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa , String> {

    // login da empresa buscar por cnpj ou senha
    @Query(value =  "select * from tb_empresa  where cnpj = ?1 AND senha_empresa = ?2", nativeQuery = true)
    public Empresa findByLoginAndSenha(String cnpj, String senha);

    //buscar empresa por nome e cnpj
    @Query(value = "select * from tb_empresa where nome_empresa = ?1 ORDER BY RAND (cnpj) ", nativeQuery = true)
    List<Empresa> buscarPorNome(String nome, String cnpj);

}
