package sgab.model.service;

import java.util.List;
import sgab.model.dto.util.ObraHelper;
import sgab.model.dto.Obra;
import sgab.model.dao.ObraDAO;
import sgab.model.dto.util.ObraStatus;
import sgab.model.exception.NegocioException;

public class GestaoObras {
    
    private ObraDAO obraDAO;
    
    public GestaoObras(){
        obraDAO = ObraDAO.getInstance();
    }
    
    public Long cadastrarObra(Obra obra){
        
        List<String> erros = ObraHelper.validarObra(obra);
        if(!erros.isEmpty()){
            throw new NegocioException(erros);
        }
        
        obraDAO.inserir(obra);
        return obra.getId();
    }
    
    public void atualizaCadastroObra(Obra obra){
        List<String> erros = ObraHelper.validarObra(obra);
        if(!erros.isEmpty()){
            throw new NegocioException(erros);
        }
        
        obraDAO.alterar(obra);
    }
    
    public void excluirObra(Obra obra){
        Obra obr = obraDAO.pesquisar(obra.getId());
        if(obr == null){
            throw new NegocioException("Obra 'id=" + obra.getId() + "'não encontrado!");
        }
        
        obr.setStatus(ObraStatus.DESATIVADA);
    }
    
    public Obra pesquisarObraID(Long id){
        return obraDAO.pesquisar(id);
    }
    
    public List<Obra> pesquisarObraNome(String nome){
        return obraDAO.pesquisarNome(nome);
    }
    
    public List<Obra> pesquisarTituloAprox(String titulo){
        return obraDAO.pesquisaTituloAproximado(titulo);
    }
     
    public List<Obra> pesquisarObrasAtivas(){
        return obraDAO.listarObras();
    }
    
    public List<Obra> pesquisarObrasAutor(String autor){
        return obraDAO.pesquisarAutor(autor);
    }
    
    
    /*public List pesquisarObra(List parameterList){
        ObraHelper.validarParameter(parameterList);
        return list;
    }*/
}
