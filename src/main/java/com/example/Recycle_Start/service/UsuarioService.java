package com.example.Recycle_Start.service;

import com.example.Recycle_Start.model.Usuario;
import com.example.Recycle_Start.repositoris.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    //recuperar senha do usuario 
    public Usuario RecuperacaoSenha(String email, String cpf) {
        return usuarioRepository.EsqueceuSenha(email, cpf);
    }



    // para resposta da senha
    public Usuario ConfirmacaoResposta(String resposta) {
        return usuarioRepository.RespostaChave(resposta);
    }


// Salvar Usuario
public Usuario salvarUsuario(Usuario usuario) {
    usuarioRepository.save(usuario);
    return usuarioCpf(usuario.getCpf());
}


// Para lista todos os Usuarios da aplicação
    public List<Usuario> mostraUsuario() {
        return (List<Usuario>) usuarioRepository.findAll();
    }


    // Para editar Usuario
    public Usuario usuarioCpf(String cpf) {
        return usuarioRepository.findById(cpf).get();
    }

    public void excluirUsuario(String cpf) {
        usuarioRepository.deleteById(cpf);
    }
// loginUsuario
    public Usuario loginUsuario(String cpf , String senha) {
        return usuarioRepository.findByLoginAndSenha(cpf, senha);
    }
}
