package com.example.Recycle_Start.repositoris;

import com.example.Recycle_Start.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario ,String> {

    //consulta os dados para efetuar login
    @Query(value =  "select * from tb_usuario where cpf = ?1 AND senha_usuario = ?2 ", nativeQuery = true)
    public Usuario findByLoginAndSenha(String cpf, String senha);

    //PARA ver usuario cadastrado por cpf
    @Query(value = "select count(cpf) from tb_usuario", nativeQuery = true)
    public Usuario UsuarioCadastrados (String cpf);

    // esqueeu senha para ir com email e cpf
    @Query(value =  "select * from tb_usuario where email_usuario = ?1 AND  cpf = ?2", nativeQuery = true)
    public Usuario EsqueceuSenha(String email, String cpf);

    // recupera com a resposta chave
    @Query(value =  "select * from tb_usuario where resposta_usuario = ?1 ", nativeQuery = true)
    public Usuario RespostaChave(String resposta);

}
