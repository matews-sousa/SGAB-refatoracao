package sgab.model.dto;

import sgab.model.dto.util.UsuarioStatus;

public class Usuario {

    private Long id;
    private final String login;   // login usuário é imutável
    private String senha;
    private String nome;
    private String email;
    private UsuarioStatus status;

    public Usuario(String login) {
        this.login = login;
        this.status = UsuarioStatus.ATIVO;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeCompleto) {
        this.nome = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UsuarioStatus getStatus() {
        return status;
    }

    public void setStatus(UsuarioStatus status) {
        this.status = status;
    }
}
