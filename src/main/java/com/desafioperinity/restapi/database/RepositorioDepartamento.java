package com.desafioperinity.restapi.database;


import org.springframework.data.jpa.repository.JpaRepository;
import com.desafioperinity.restapi.entidades.Departamento;

public interface RepositorioDepartamento extends JpaRepository<Departamento,Long>{
    
}