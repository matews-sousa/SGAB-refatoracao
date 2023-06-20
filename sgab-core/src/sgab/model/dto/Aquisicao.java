package sgab.model.dto;

import sgab.model.dto.util.AquisicaoStatus;

public class Aquisicao {
    private Pessoa pessoa;
    private Long quantidade;
    private Fornecedor fornecedor;
    private AquisicaoStatus status;
    private Obra obra;
    private boolean obraExiste;
    private Long id;
    private Biblioteca bibliotecaAlvo;
    private String justificativaQuantidade;

    //construtor 
    public Aquisicao(Biblioteca biblioteca, Pessoa pessoa, Long quantidade, Fornecedor fornecedor, AquisicaoStatus status, Obra obra){
        this.pessoa = pessoa;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
        this.status = status;
        this.obra = obra;
        this.bibliotecaAlvo = biblioteca;
        this.obraExiste = true;
        this.justificativaQuantidade = "";
    }

    //get e set id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //get e set pessoa
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    //get e set quantidade
    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
    //get e set fornecedor
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    //get e set status
    public AquisicaoStatus getStatus() {
        return status;
    }

    public void setStatus(AquisicaoStatus status) {
        this.status = status;
    }
    //get e set obra
    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public void setObraExiste(boolean obraExiste) {
        this.obraExiste = obraExiste;
    }

    public boolean getObraExiste() {
        return obraExiste;
    }

    public void setBiblioteca(Biblioteca bibliotecaAlvo) {
        this.bibliotecaAlvo = bibliotecaAlvo;
    }
    
    public Biblioteca getBiblioteca(){
        return bibliotecaAlvo;
    }

    public String getJustificativaQuantidade() {
        return justificativaQuantidade;
    }

    public void setJustificativaQuantidade(String justificativaQuantidade) {
        this.justificativaQuantidade = justificativaQuantidade;
    }
    
    
}
