/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgab.model.dto;

import sgab.model.dto.util.ObraStatus;
import sgab.model.dto.Autor;
import java.util.List;

/**
 *
 * @author HP
 */
public class Obra  {
    private Long id;
    private String categoria;
    private String titulo;
    private List<Autor> autores;
    private List<Assunto> assuntos;
    private String nota;
    private Integer anoPublicacao;
    private String editora;
    private String cidadeEditora;
    private Integer edicao;
    private Integer volume;
    private ObraStatus status;

    public Obra(String titulo) {
        this.titulo = titulo;
        this.status = ObraStatus.ATIVA;        
    }
    
    public Obra(String categoria, String titulo, List<Autor> autores, List<Assunto> assuntos, String nota, Integer anoPublicacao, String editora, String cidadeEditora, Integer edicao, Integer volume) {
        this.categoria = categoria;
        this.titulo = titulo;
        this.autores = autores;
        this.assuntos = assuntos;
        this.nota = nota;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.cidadeEditora = cidadeEditora;
        this.edicao = edicao;
        this.volume = volume;
        this.status = ObraStatus.ATIVA;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutor() {
        return autores;
    }

    public void setAutor(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Assunto> getAssunto() {
        return assuntos;
    }

    public void setAssunto(List<Assunto> assuntos) {
        this.assuntos = assuntos;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getCidadeEditora() {
        return cidadeEditora;
    }

    public void setCidadeEditora(String cidadeEditora) {
        this.cidadeEditora = cidadeEditora;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public ObraStatus getStatus() {
        return status;
    }

    public void setStatus(ObraStatus status) {
        this.status = status;
    }

    



    
    
    
}
