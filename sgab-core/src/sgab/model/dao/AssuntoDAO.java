package sgab.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sgab.model.dto.Assunto;
import sgab.model.exception.PersistenciaException;

public class AssuntoDAO implements GenericDAO<Assunto, Long> {
    
private Map<Long, Assunto> table = new HashMap<>();
    
    private static AssuntoDAO assuntoDAO;
    static {
        AssuntoDAO.assuntoDAO = null;
    }
    
    private static Long idSequence; //  gera identificador sequencial
    static {
        AssuntoDAO.idSequence = 0L;
    }
    
    public static Long getNextId() {
        return AssuntoDAO.idSequence++;
    }    
    
    private AssuntoDAO() { } // singleton
    
    public static AssuntoDAO getInstance() {
        
        if (assuntoDAO == null)
            assuntoDAO = new AssuntoDAO();
       
        return assuntoDAO;
    }

    @Override
    public void inserir(Assunto assunto) {
        if (pesquisarNome(assunto.getNome()) != null)
            throw new PersistenciaException("Assunto '" + assunto.getNome() 
                                                            + "' é único.");
        Long assuntoId = AssuntoDAO.getNextId();
        assunto.setId(assuntoId);
              
        table.put(assuntoId, assunto);        
    }

    @Override
    public void alterar(Assunto assunto) {
        Assunto ass = table.remove(assunto.getId());
        if (ass == null)
            throw new PersistenciaException("Nenhum usuário com "
                                        + "o id '" + assunto.getId() + "'.");
        
        inserir(assunto);
    }
    
    @Override
    public Assunto pesquisar(Long assuntoId) {
        return table.get(assuntoId);
    }
       
    public Assunto pesquisarNome(String nome) {
        List<Assunto> listAssunto = listarTodos();
        
        for (Assunto assunto: listAssunto)
            if (assunto.getNome().equals(nome))
                return assunto;
        
        return null;        
    }
   
    public List<Assunto> listarAtivos() {
        List<Assunto> listAssuntos = new ArrayList<>();
        
        for (Assunto ass: table.values())
            if (ass.isAtivo())
                listAssuntos.add(ass);
               
        return listAssuntos;        
    }        
    
    public List<Assunto> listarTodos() {
        List<Assunto> listAssuntos = new ArrayList<>();
        
        listAssuntos.addAll(table.values());
        
        return listAssuntos;        
    }    
}