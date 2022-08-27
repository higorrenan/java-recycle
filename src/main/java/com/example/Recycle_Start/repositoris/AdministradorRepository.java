package com.example.Recycle_Start.repositoris;

import com.example.Recycle_Start.model.Administrador;
import com.example.Recycle_Start.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdministradorRepository extends JpaRepository<Administrador , Integer> {

    @Query(value =  "select * from tb_administrador where email_admin = ?1 AND senha_admin = ?2", nativeQuery = true)
    Administrador findByLoginAndSenha(String email, String senha);
}
