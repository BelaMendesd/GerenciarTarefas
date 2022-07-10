package com.desafioperinity.restapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioperinity.restapi.database.RepositorioPessoa;
import com.desafioperinity.restapi.entidades.Pessoa;

@RestController
@RequestMapping("/pessoas")
public class PessoaRest {
    @Autowired
    public RepositorioPessoa repositorioPessoa;
    
    @GetMapping
    public List<Pessoa> listar(){
        return repositorioPessoa.findAll();
    }
    
    @PutMapping("/pessoas/{id}")
    public ResponseEntity<Pessoa> Put(@PathVariable(value = "id") long id, @RequestBody Pessoa newPessoa)
    {
        Optional<Pessoa> oldPessoa = repositorioPessoa.findById(id);
        if(oldPessoa.isPresent()){
            Pessoa pessoa = oldPessoa.get();
            pessoa.setNome(newPessoa.getNome());
            pessoa.setIddepartamento(newPessoa.getIddepartamento());
            repositorioPessoa.save(pessoa);
            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    @DeleteMapping("/pessoas/{id}")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Pessoa> pessoa = repositorioPessoa.findById(id);
        if(pessoa.isPresent()){
            repositorioPessoa.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public void adicionar(@RequestBody Pessoa pessoa){
        repositorioPessoa.save(pessoa);
    }
}
