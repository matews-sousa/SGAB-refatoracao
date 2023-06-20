package sgab.model.dto;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import sgab.model.dto.Exemplar;
import java.util.ArrayList;

public class Reserva {
    private Long id;
    private Pessoa pessoa;
    private Exemplar exemplar;
    private final String horario;
    private boolean eraDisponivel;
    
    
    //construtor 
    public Reserva(Pessoa pessoa, Exemplar exemplar){
        this.pessoa = pessoa;
        this.exemplar =  exemplar;
        this.eraDisponivel = false;

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        
        this.horario = dateFormat.format(date);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEraDisponivel(boolean eraDisponivel) {
        this.eraDisponivel = eraDisponivel;
    }
    
    public boolean getEraDisponivel() {
        return this.eraDisponivel;
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public String getHorario() {
        return horario;
    }
}