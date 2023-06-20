package sgab.model.service;

import sgab.model.dto.Assunto;
import java.util.ArrayList;
import java.util.List;
import sgab.model.dao.AssuntoDAO;
import sgab.model.dto.util.AssuntoHelper;
import sgab.model.exception.NegocioException;

public class GestaoAssuntoService {
    
    private AssuntoDAO assuntoDAO;
    
    public GestaoAssuntoService() {
        assuntoDAO = AssuntoDAO.getInstance();
    }
    
    public Long cadastrar(Assunto assunto) {
               
        if (!AssuntoHelper.validar(assunto))
            throw new NegocioException("Assunto inválido!");
       
        assuntoDAO.inserir(assunto);
        return assunto.getId();
    }

    public void atualizar(Assunto assunto) {
               
        if (!AssuntoHelper.validar(assunto))
            throw new NegocioException("Assunto inválido!");
        
        assuntoDAO.alterar(assunto);
    }

    public void excluir(Assunto assunto) {
        
        Assunto ass = assuntoDAO.pesquisar(assunto.getId());
        if (ass == null)
            throw new NegocioException("Assunto 'id=" + assunto.getId() + "'não encontrado!");
        
        ass.setAtivo(false);
    }

    public List<Assunto> pesquisarAtivos() {
        return assuntoDAO.listarAtivos();
    }

    public Assunto pesquisarPorId(Long id){
        return assuntoDAO.pesquisar(id);
    }    

    public Assunto pesquisarAssunto(String nome){
        
        return assuntoDAO.pesquisarNome(nome);               
    }    
}
