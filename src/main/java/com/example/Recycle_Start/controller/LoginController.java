package com.example.Recycle_Start.controller;

import com.example.Recycle_Start.model.Administrador;
import com.example.Recycle_Start.model.Empresa;
import com.example.Recycle_Start.model.Usuario;
import com.example.Recycle_Start.repositoris.Util;
import com.example.Recycle_Start.service.AdministradorService;
import com.example.Recycle_Start.service.EmpresaService;
import com.example.Recycle_Start.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
   private UsuarioService usuarioService;

    @Autowired
  private EmpresaService empresaService;

    @Autowired
    private AdministradorService administradorService;

    @GetMapping("/login")
    public String getLoginCondominio(Usuario usuario){
        return "login-condominio";
    }


   // login Usuario
    @PostMapping("/efetuarLogin")
    public String efetuarLogin(Usuario usuario, RedirectAttributes ra, HttpSession session) {

        usuario = usuarioService.loginUsuario(
                usuario.getCpf(), Util.md5( usuario.getSenha()));

        // se usuario for diferente de nulo!!!

         if (usuario != null){
           //guarda sessao o objeto usuario
              session.setAttribute("usuarioLogado", usuario);
                     return "redirect:/usuario";
}
         // para um erro cado o login e senha seja errado
                  else {
                //enviar uma mensagem
                        ra.addFlashAttribute("erro", " usuario ou senha invalida");
                               return "redirect:/login";
    }

}


   /* @GetMapping("/loginEmpresa")
    public String getLoginEmpresa(){
        return "login-empresa";
    }*/


             // efetuar login da Empresa
    @PostMapping("/efetuarLoginEmpresa")
    public  String efetuarLoginEmpresa(Empresa empresa, RedirectAttributes ra, HttpSession session ){
        empresa = empresaService.loginEmpresa(empresa.getCnpj(),Util.md5( empresa.getSenha()));

        // condição para entra da empresa
        if (empresa != null){
            session.setAttribute("usuarioLogado", empresa);
            return "redirect:/Empresa";
        }
        else {
            // enviar mensage de não perminito
            ra.addFlashAttribute("messagem", "login/semha invalida" );
            return "redirect:/login-empresa";

        }
    }

    // login adm

    @GetMapping( "/loginAdm")
    public String admLogin(Administrador administrador){
        return "login-administrador";
    }

    @PostMapping("/fetuarLoginAdm")
    public  String efetuarLoginAdministrador( Administrador administrador, RedirectAttributes  ra, HttpSession session ){
        administrador = administradorService.loginAdministrador(administrador.getEmail(), Util.md5(administrador.getSenha()));
        if (administrador != null){
            session.setAttribute("usuarioLogado", administrador);
            return "redirect:/Administrador";
        }
        else {
            // enviar mensage de não perminito
            ra.addFlashAttribute("messagem", "login/semha invalida" );
            return "redirect:/loginAdm";

        }
    }
}
