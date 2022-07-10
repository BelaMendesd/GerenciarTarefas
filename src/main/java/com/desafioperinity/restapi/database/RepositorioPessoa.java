package com.desafioperinity.restapi.database;


import org.springframework.data.jpa.repository.JpaRepository;
import com.desafioperinity.restapi.entidades.Pessoa;

public interface RepositorioPessoa extends JpaRepository<Pessoa,Long>{
    
    
}
