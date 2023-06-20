/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sgab.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sgab.model.dto.Fornecedor;
import sgab.model.dto.util.FornecedorHelper;
import sgab.model.dto.util.FornecedoresStatus;
import sgab.model.exception.PersistenciaException;

/**
 *
 * @author luisa
 */
public class FornecedoresDAO implements GenericDAO<Fornecedor, Long> {
    
    private Map<Long, Fornecedor> table = new HashMap<>();
    
    private FornecedoresDAO() { }
    
    private static FornecedoresDAO fornecedorDAO;
    static {
        FornecedoresDAO.fornecedorDAO = null;
    }
    
    public static FornecedoresDAO getInstance() {
        
        if (fornecedorDAO == null)
            fornecedorDAO = new FornecedoresDAO();
        
        return fornecedorDAO;
    }
    
    @Override
    public void inserir(Fornecedor entidade) {
        if (this.pesquisar(entidade.getCnpj()) != null)
            throw new PersistenciaException("'" + entidade.getCnpj() + "' é único.");
        
        table.put(entidade.getCnpj(), entidade);
    }

    @Override
    public void alterar(Fornecedor entidade) {
        Fornecedor fornecedor = table.remove(entidade.getCnpj());
        if (fornecedor == null)
            throw new PersistenciaException("Nenhum fornecedor com " + "o cnpj '" + entidade.getCnpj() + "'.");
        
        inserir(entidade);
    }

    @Override
    public Fornecedor pesquisar(Long cnpj) {
        return table.get(cnpj);
    }
    
    public Fornecedor pesquisar(String nome) {
        for (Long key : table.keySet()) {
            if(nome.equals(table.get(key).getNomeFornecedor()))
                return table.get(key);
        }
        return null;
    }
    
    public List<Fornecedor> listarAtivos() {
        List<Fornecedor> listFornecedores = new ArrayList<>();
        
        for (Fornecedor usr: table.values())
            if (usr.getStatus() == FornecedoresStatus.ATIVO) // lista apenas os usuários ativos
                listFornecedores.add(usr);
        
        return listFornecedores;
    }
    
}
