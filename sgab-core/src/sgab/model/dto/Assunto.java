package sgab.model.dto;

public class Assunto {
    private String nome;
    private Long id;
    private boolean ativo;

    public Assunto(String nome) {
        this.nome = nome;
        this.ativo = true;
    }
    
    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}