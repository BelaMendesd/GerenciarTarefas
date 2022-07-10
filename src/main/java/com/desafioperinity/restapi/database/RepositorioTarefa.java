package com.desafioperinity.restapi.database;


import org.springframework.data.jpa.repository.JpaRepository;
import com.desafioperinity.restapi.entidades.Tarefa;

public interface RepositorioTarefa extends JpaRepository<Tarefa,Long>{
    
}
