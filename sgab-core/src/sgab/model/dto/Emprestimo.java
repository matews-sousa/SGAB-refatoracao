package sgab.model.dto;


import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Emprestimo {

    private Long id;
    private Pessoa pessoa;
    private Exemplar exemplar;
    private String data;

    public Emprestimo(Pessoa pessoa,Exemplar exemplar){
        this.pessoa = pessoa;
        this.exemplar = exemplar;

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        
        this.data = dateFormat.format(date);

    }
    public long getId(){
        return id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public String getDate() {
        return this.data;
    }

    public void setDataEmprestimo() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        this.data = dateFormat.format(date);
    }   
    public String getDataEmprestimo(){
        return this.data;
    }
}