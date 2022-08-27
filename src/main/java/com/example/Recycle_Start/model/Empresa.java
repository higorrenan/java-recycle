package com.example.Recycle_Start.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Getter @Setter
@Entity
@Table(name = "tb_empresa")
public class Empresa {
    @Id
    @NotBlank(message = " O Campo não pode esta vazio ")
    private String cnpj;

    @Column(nullable = false, length = 90, name =  "email_empresa")
    @NotBlank (message = "O Campo não pode esta vazio ")
    private String email;

    @Column (nullable = false, length = 15, name =  "telefone_empresa")
    @NotBlank (message = " O Campo não pode esta vazio ")
    private String telefone;

    @Column (nullable = false, length = 150, name =  "nome_empresa")
    @NotBlank (message = " O Campo não pode esta vazio ")
    private String nome;

    @Column (nullable = false, name =  "senha_empresa")
    @NotBlank (message = " O Campo não pode esta vazio ")
    private String senha;

    @Column (nullable = false, name =  "estado_empresa")
    @NotBlank (message = " O Campo não pode esta vazio ")
    private String estado;

    @Column (nullable = false, name =  "cidade_empresa")
    @NotBlank (message = " O Campo não pode esta vazio ")
    private String cidade;

    @Column (nullable = false, name =  "bairro_empresa")
    @NotBlank (message = " O Campo não pode esta vazio ")
    private String bairro;

    @Column (nullable = false, name =  "rua_empresa")
    @NotBlank (message = " O Campo não pode esta vazio ")
    private String rua;

    @Column (nullable = false, name =  "numero_empresa")
    @NotBlank (message = "o  campo não pode esta  vazio")
    private String numero;

    @Column (nullable = false, name =  "cep_empresa")
    @NotBlank (message = "o  campo não pode esta  vazio")
    private String cep;


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
