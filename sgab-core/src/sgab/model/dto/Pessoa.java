package sgab.model.dto;

import sgab.model.dto.util.UsuarioTipo;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    
    private Long id;
    private final String login;
    private final Long cpf;
    private String nome;
    private String email;
    private String senha;
    private boolean habilitado;
    private List<UsuarioTipo> perfis;

    public Pessoa(String login, Long cpf){
        this.login = login;
        this.cpf = cpf;
        this.habilitado = true;
        this.perfis =  new ArrayList<>();
    }

    public Pessoa(Long cpf, String login, String nome, String email, String senha){
        this(login, cpf);
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    public List<UsuarioTipo> getTipo(){
        return this.perfis;
    }

    public void setTipo(UsuarioTipo tipo) {
        if (!perfis.contains(tipo))
            this.perfis.add(tipo);
    }

    public void removerTipo(UsuarioTipo tipo) {
        perfis.remove(tipo);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }    

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    
    public boolean getHabilitado() {
        return habilitado;
    }

}
