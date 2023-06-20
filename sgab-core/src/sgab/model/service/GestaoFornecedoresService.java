/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgab.model.service;

import java.util.ArrayList;
import java.util.List;
import sgab.model.dto.Fornecedor;
import sgab.model.dao.FornecedoresDAO;
import sgab.model.dto.util.FornecedorHelper;
import sgab.model.dto.util.FornecedoresStatus;
import sgab.model.exception.NegocioException;

public class GestaoFornecedoresService {
    private FornecedoresDAO fornecedoresDAO;
    
    public GestaoFornecedoresService() {
        fornecedoresDAO = FornecedoresDAO.getInstance();
    }

    public Long cadastrar(Fornecedor fornecedor) {
        
        List<String> exMsgs = FornecedorHelper.validar(fornecedor);
        
        if(!exMsgs.isEmpty())
            throw new NegocioException(exMsgs);
        
        fornecedoresDAO.inserir(fornecedor);
        return fornecedor.getCnpj();
    }
    
    public void atualizar(Fornecedor fornecedor) {
        
        List<String> exMsgs = FornecedorHelper.validar(fornecedor);
        
        if(!exMsgs.isEmpty())
            throw new NegocioException(exMsgs);
        
        fornecedoresDAO.alterar(fornecedor);
    }
    
    public void excluir(Fornecedor fornecedor) {
        
        Fornecedor frncdr = fornecedoresDAO.pesquisar(fornecedor.getCnpj());
        if (frncdr == null)
            throw new NegocioException("Fornecedor 'CNPJ=" + fornecedor.getCnpj() + "' não encontrado!");
        
        fornecedor.setStatus(FornecedoresStatus.SUSPENSO);
    }
    
    public Fornecedor pesquisarPorCNPJ(Long cpnj) {
        return fornecedoresDAO.pesquisar(cpnj);
    }
    
    public Fornecedor pesquisarPorNome(String nome) {
        return fornecedoresDAO.pesquisar(nome);
    }
    
    public List<Fornecedor> pesquisarAtivos() {
        return fornecedoresDAO.listarAtivos();
    }

}
