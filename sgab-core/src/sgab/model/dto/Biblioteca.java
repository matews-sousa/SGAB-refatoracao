package sgab.model.dto;

public class Biblioteca{

    private Long id;
    private UnidadeOrganizacional uOrg;
    private String nome;
    private boolean ativa;

    public Biblioteca(String nome){
        this.nome = nome;
        this.ativa = true;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }

    public UnidadeOrganizacional getUnidadeOrganizacional() {
        return uOrg;
    }

    public void setUnidadeOrganizacional(UnidadeOrganizacional uOrg) {
        this.uOrg = uOrg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
}
