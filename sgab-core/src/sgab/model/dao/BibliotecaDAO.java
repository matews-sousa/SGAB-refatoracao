package sgab.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sgab.model.dto.Biblioteca;
import sgab.model.exception.PersistenciaException;


public class BibliotecaDAO implements GenericDAO<Biblioteca, Long> {
    
    private static Map<Long, Biblioteca> table;
    static {
        BibliotecaDAO.table = new HashMap<>();
    }
    
    private static Long idSequence; //  gera identificador sequencial
    static {
        BibliotecaDAO.idSequence = 0L;
    }
    
    public static Long getNextId() {
        return BibliotecaDAO.idSequence++;
    }  
    
    @Override
    public void inserir(Biblioteca biblioteca){
        if (pesquisarPorNome(biblioteca.getNome()) != null)
            throw new PersistenciaException("'" + biblioteca.getNome() 
                                                            + "' é único.");
        Long bibliotecaId = BibliotecaDAO.getNextId();
        biblioteca.setId(bibliotecaId);
               
        table.put(bibliotecaId, biblioteca);
    }
    
    @Override
    public void alterar(Biblioteca biblioteca){
        
        Biblioteca bbl = table.remove(biblioteca.getId());
       
        if (bbl == null)
            throw new PersistenciaException("Nenhuma biblioteca com "
                                        + "o id '" + biblioteca.getId() + "'.");
        
        table.put(biblioteca.getId(), biblioteca);
    }

    @Override
    public Biblioteca pesquisar(Long id){
        return table.get(id);
    }
    
       
    public Biblioteca pesquisarPorNome(String nome){
        List<Biblioteca> listBiblioteca = listarAtivos();
        
        for (Biblioteca bbl: listBiblioteca)
            if (bbl.getNome().equals(nome))
                return bbl;
        
        return null;
    }    
    
    public List<Biblioteca> listarAtivos() {
        List<Biblioteca> listBiblioteca = new ArrayList<>();
        
        for (Biblioteca bbl: table.values())
            if (bbl.isAtiva()) // lista apenas os usuários ativos
                listBiblioteca.add(bbl);
        
        return listBiblioteca;
    }
    
    public List<Biblioteca> listarTodos() {
        List<Biblioteca> listBiblioteca = new ArrayList<>();
        
        listBiblioteca.addAll(table.values());
        
        return listBiblioteca;
    }     
}
