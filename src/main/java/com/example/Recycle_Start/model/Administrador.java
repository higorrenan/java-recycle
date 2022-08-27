package com.example.Recycle_Start.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_administrador")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_adm;

    @Column( name =  "email_admin")
    private String email;

    @Column (name =  "senha_admin")
    private String senha;

    @OneToMany
    private List<Empresa>empresas;

    @OneToMany
    private List<Usuario> usuario;

}
