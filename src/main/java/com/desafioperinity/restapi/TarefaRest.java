package com.desafioperinity.restapi;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.desafioperinity.restapi.database.RepositorioTarefa;
import com.desafioperinity.restapi.entidades.Tarefa;

@RestController
@RequestMapping("/tarefas")
public class TarefaRest {
    @Autowired
    public RepositorioTarefa repositorioTarefa;

    @PostMapping
    public void adicionar(@RequestBody Tarefa tarefa){
        repositorioTarefa.save(tarefa);
    }

    @PutMapping("/tarefas/{id}")
    public Optional<Long> finalizarTarefa(long finalizarTarefa) {
		if (repositorioTarefa.findById(finalizarTarefa).isPresent()) {
			Tarefa tarefa = repositorioTarefa.getReferenceById(finalizarTarefa);
			tarefa.setFinalizado(true);
			repositorioTarefa.save(tarefa);
			return Optional.of(finalizarTarefa);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID não localizado", null);
		}
	}


    
}
