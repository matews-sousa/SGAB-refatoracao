/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgab.model.dto;

import sgab.model.dto.util.FornecedoresStatus;

public class Fornecedor {
    private Long cnpj;
    private String nomeFornecedor;
    private String email;
    private Long telefone;
    private Long cep;
    private String endereco;
    private FornecedoresStatus status;
    private boolean habilitado;
    
    public Fornecedor(long cnpj){         
        this.cnpj = cnpj;
        this.status = FornecedoresStatus.ATIVO;
        this.habilitado = true;        
    }
    
    public Fornecedor(long cnpj, String nomeFornecedor, String email,
                              Long telefone, Long cep, String endereco){
        this.cnpj = cnpj;
        this.nomeFornecedor = nomeFornecedor;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
        this.endereco = endereco;
        this.status = FornecedoresStatus.ATIVO;
        this.habilitado = true;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public FornecedoresStatus getStatus() {
        return status;
    }

    public void setStatus(FornecedoresStatus status) {
        this.status = status;
    }
    
    
            
}
