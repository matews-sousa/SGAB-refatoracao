package sgab.model.dto;

import sgab.model.dto.util.ExemplarStatus;
import sgab.model.dto.util.ExemplarTipo;


public class Exemplar {
    private Obra obra;
    private Long id;
    private ExemplarStatus status;
    private ExemplarTipo tipo;
    private Biblioteca bibliotecaPosse;
    private String historico;    

    public Exemplar(Obra obra, Biblioteca biblioteca) {
        this.obra = obra;
        this.bibliotecaPosse = biblioteca;
        status = ExemplarStatus.DISPONIVEL;
        tipo = ExemplarTipo.NORMAL;
    }

    public Obra getObra() {
        return obra;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public ExemplarStatus getStatus() {
        return status;
    }

    public ExemplarTipo getTipo() {
        return tipo;
    }

    public void setStatus(ExemplarStatus status) {
        this.status = status;
    }

    public void setTipo(ExemplarTipo tipo) {
        this.tipo = tipo;
    }

    public Biblioteca getBibliotecaPosse() {
        return bibliotecaPosse;
    }

    public void setBibliotecaPosse(Biblioteca bibliotecaPosse) {
        this.bibliotecaPosse = bibliotecaPosse;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }
}