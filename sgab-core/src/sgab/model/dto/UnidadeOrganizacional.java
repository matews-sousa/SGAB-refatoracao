package sgab.model.dto;

public class UnidadeOrganizacional {

    private Long id;
    private String nome; 
    private String endereco;
    private boolean habilitado;    
    
    public UnidadeOrganizacional() {
        this.habilitado = true;
    }
    
    public UnidadeOrganizacional(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.habilitado = true;
    }    
    
    public UnidadeOrganizacional(Long id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.habilitado = true;
    }
        
    public UnidadeOrganizacional(Long id, String nome, String endereco, boolean habilitado) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.habilitado = habilitado;        
    }
    
    public boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
