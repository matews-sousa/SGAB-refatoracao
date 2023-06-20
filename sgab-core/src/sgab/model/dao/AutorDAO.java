package sgab.model.dao;

import sgab.model.dto.Autor;
import java.util.ArrayList;
import java.util.List;

/**
* GRUPO F
* @author Marcos Paulo
*/

public class AutorDAO implements GenericDAO<Autor, Long>{
    private static ArrayList<Autor> mock = new ArrayList<Autor>();
    
    private static Long idSequence;
    static {
        AutorDAO.idSequence = 0L;
    }

    public static Long getNextId() {
        return AutorDAO.idSequence++;
    } 
    
    public void inserir(Autor autor){
        Long autorId = AutorDAO.getNextId();
        autor.setId(autorId);
        this.mock.add(autor);
    }

    public void alterar(Autor autor) throws RuntimeException{
        boolean encontrado = false;
        for(int i = 0; i < this.mock.size(); i++){
            if(this.mock.get(i).getId() == autor.getId()){
                encontrado = true;
                this.mock.set(i, autor);
            }
        }
        if(!encontrado){
            throw new RuntimeException("Autor não encontrado");
        }
        
    }

    public Autor pesquisar(Long key){
        for(Autor a : mock){
            if(a.getId() == key){
                return a;
            }
        }
        return null;
    }

    public Autor pesquisar(String nome){
        for(Autor autor : mock){
            if(autor.getNome().equals(nome)){
                return autor;
            }
        }
        return null;
    }

    public void remover(Long key){
        boolean encontrado = false;
        for(Autor a : mock){
            if(a.getId() == key){
                encontrado = true;
                this.mock.remove(a);
                return;
            }
        }
        if(!encontrado){
            throw new RuntimeException("Autor não encontrado");
        }
    }

}