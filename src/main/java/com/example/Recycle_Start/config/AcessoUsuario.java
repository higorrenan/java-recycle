package com.example.Recycle_Start.config;

import com.example.Recycle_Start.controller.InterceptorController;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class AcessoUsuario implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor((HandlerInterceptor) new InterceptorController())
                .addPathPatterns(new String[] {"/usuario", "/usuario/**"}).excludePathPatterns("/css/**", "/icons/**", "/js/**", "/img/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/usuario/**")
                .addResourceLocations("classpath:/static/");
    }
}
