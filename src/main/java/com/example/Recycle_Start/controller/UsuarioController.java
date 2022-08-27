package com.example.Recycle_Start.controller;

import com.example.Recycle_Start.model.Usuario;
import com.example.Recycle_Start.repositoris.Util;
import com.example.Recycle_Start.service.EmpresaService;
import com.example.Recycle_Start.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/*@RestController
@RequestMapping(value = "/users")
*/

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmpresaService empresaService;

    // para teste do get
  /* @Autowired
   private UsuarioRepository usuarioRepository;*/


   @GetMapping("/cadastro")
   public String cadastroUsuario(Usuario usuario) {
       return "registro-condominio";

   }

    @GetMapping("/esqueceu-senha")
    public String getEsqueceu(Usuario usuario){
        return "recuperar-senha";
    }


// enviar dados para recuper senha
    @PostMapping("/EnviarDadosSenha")
    public String EnviarDadosSenha(String email, String cpf, Model model){
        Usuario usuario = this.usuarioService.RecuperacaoSenha(email, cpf);

        // condições 1 se difernte de nuloo 2 nullo

        if (usuario != null) {
            model.addAttribute("usuarioObject", usuario);
            return "redirect:/pergunta-chave";
        }else {
            System.out.printf("Esse usuario não participa da comunidade recycle");
            return "redirect:/esqueceu-senha";
        }
    }


    // condição se verdade vai para usuario se não pegunta chave

    @PostMapping("/EnviarResposta")
    public String EnviarPerguntaChave(String resposta, HttpSession session) {
        Usuario usuario = this.usuarioService.ConfirmacaoResposta(resposta);
        if (usuario != null) {
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:/usuario";
        }else {
            System.out.print("Resposta inválida");
            return "redirect:/pergunta-chave";
        }
    }

    // pergunta chave informação

    @GetMapping("/pergunta-chave")
    public String getPergunta( Usuario usuario) {
        return "recuperar-senha-pergunta";
    }

    // salvar novo Usuario e retonara para o login

   @PostMapping("/salvarUsuario")
    public String novoUsuario(@ModelAttribute("usuario") Usuario usuario) {

        usuario.setSenha(Util.md5(usuario.getSenha()));
        usuarioService.salvarUsuario(usuario);
        return "redirect:/login";
    }




    // listar USUARIO  mais usuario é em add
    @GetMapping("/usuarios")
    public  String mostraUsuario(Model model){
        List<Usuario> usuario =  usuarioService.mostraUsuario();
        model.addAttribute("usuario",usuario);
        return "administrador-condominio";
    }



    // para edita Usuario
    @GetMapping ("/editarUsuario")
    public String editarUsuario( Model model, String cpf) {
        model.addAttribute("usuario", usuarioService.usuarioCpf(cpf));
        return "condominio-dados";
    }
   /* @GetMapping("/editar")
    public String mostraDado(Usuario usuario){
       return "condominio-dados" ;
    }*/





    // para o usuario selecionar a empresa que esta estanciado e service empresa

    @GetMapping ("/usuario")
    public String getUsuario(Model model) {
        // para mostra no condominio
        /*model.addAttribute("empresa", this.empresaService.mostraEmpresas());*/
            return "condominio-principal";
        }

        //
    @PostMapping ("/atualizar")
    public String atualizarUsuario(@Valid Usuario usuario, BindingResult result) {

        if(result.hasErrors()) {
            System.out.println(result.getAllErrors().get(0).getDefaultMessage());
            usuario.setSenha(Util.md5(usuario.getSenha()));
            System.out.println(usuario.getCpf());
            return "condominio-principal";
        }else {
            System.out.println(usuario.getCpf());
            usuario.setSenha(Util.md5(usuario.getSenha()));
            usuarioService.salvarUsuario(usuario);
            return "condominio-principal";
        }
    }


    // Para deletar todos os Usuarios

    @GetMapping("/delete/{cpf}")
    private String deletarUsuario(@PathVariable("cpf") String cpf, Model model) {
        usuarioService.excluirUsuario(cpf);
        return "redirect:/usuarios";
    }

    
// TESTE ok o teste funcionou
/*@GetMapping("/TESTE")
    public String teste(){
        Usuario st = new Usuario();
        st.setCpf("7032597894");
        st.setEmail("cassioi@gmail.com");
        st.setNome("cassio");
        st.setSenha("123456");
        st.setTelefone("36218820");
        st.setResposta("mamae");
      usuarioService.salvarUsuario(st);
      return "teste";

}*/


}
