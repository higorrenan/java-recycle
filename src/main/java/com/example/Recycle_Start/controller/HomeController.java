package com.example.Recycle_Start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

    // login

    @GetMapping("/loginEmpresa")
    public String getLoginEmpresa(){
        return "login-empresa.";
    }


      @GetMapping("/cadastro-empresa")
    public String getCadatroEmpresa(){
        return "registro-empresa";
    }


    // lgpd
    @GetMapping("/lgpd")
    public String getLgpd(){
        return"termos-lgpd";
    }



}