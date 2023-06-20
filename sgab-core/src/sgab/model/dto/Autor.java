package sgab.model.dto;

/**
 * GRUPO F
 * @author luisf, Marcos Paulo
 */

public class Autor{
    private String nome;
    private long id;

    public Autor(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
