package com.desafioperinity.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioperinity.restapi.database.RepositorioDepartamento;
import com.desafioperinity.restapi.entidades.Departamento;

@RestController
@RequestMapping("/departamento")
public class DepartamentoRest {
    @Autowired
    public RepositorioDepartamento repositorioDepartamento;
    
    @GetMapping
    public List<Departamento> listar(){
        return repositorioDepartamento.findAll();
    }
}
