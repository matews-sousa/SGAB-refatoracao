package sgab.model.service;

import java.util.List;
import sgab.model.dao.BibliotecaDAO;
import sgab.model.dto.Biblioteca;
import sgab.model.dto.util.BibliotecaHelper;
import sgab.model.exception.NegocioException;

public class GestaoBibliotecaService {
    
    BibliotecaDAO bibliotecaDAO;
  
    public GestaoBibliotecaService() {
        bibliotecaDAO = new BibliotecaDAO();
    }
    
    public Long cadastrar(Biblioteca biblioteca){
        
        List<String> exMsgs = BibliotecaHelper.validar(biblioteca);
        
        if (!exMsgs.isEmpty())
            throw new NegocioException(exMsgs);        
        
        bibliotecaDAO.inserir(biblioteca);
        return biblioteca.getId();
    }
    
    public void atualizar(Biblioteca biblioteca){
       
        List<String> exMsgs = BibliotecaHelper.validar(biblioteca);
        
        if (!exMsgs.isEmpty())
            throw new NegocioException(exMsgs);        
        
        bibliotecaDAO.alterar(biblioteca);
    }
    
    public void excluir(Biblioteca biblioteca) {
        
        Biblioteca bbl = bibliotecaDAO.pesquisar(biblioteca.getId());
        if (bbl == null)
            throw new NegocioException("Biblioteca 'id=" + biblioteca.getId() 
                        + "'não encontrado!");
        
        bbl.setAtiva(false);
    }

    public List<Biblioteca> pesquisarAtivos() {
        return bibliotecaDAO.listarAtivos();
    }

    public Biblioteca pesquisarPorId(Long id){
        return bibliotecaDAO.pesquisar(id);
    }    

    public Biblioteca pesquisarProNome(String nome){
        
        return bibliotecaDAO.pesquisarPorNome(nome);               
    }
}
