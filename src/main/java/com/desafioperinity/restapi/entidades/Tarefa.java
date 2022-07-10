package com.desafioperinity.restapi.entidades;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private Date prazo;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Integer iddepartamento;
    @Column(nullable = false)
    private Integer duracao;
    @Column(nullable = false)
    private Integer idpessoa;
    @Column(nullable = false)
    private boolean finalizado;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }   
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Date getPrazo() {
        return prazo;
    }
    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }
    public Integer getIddepartamento() {
        return iddepartamento;
    }
    public void setIddepartamento(Integer iddepartamento) {
        this.iddepartamento = iddepartamento;
    }
    public Integer getIdpessoa() {
        return idpessoa;
    }
    public void setIdpessoa(Integer idpessoa) {
        this.idpessoa = idpessoa;
    }
    public Integer getDuracao() {
        return duracao;
    }
    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }
    public boolean isFinalizado() {
        return finalizado;
    }
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    
}
