package sgab.model.dto.util;

import sgab.model.dto.Autor;

/**
 * @author Luiz Fernando
 * Grupo F
 */

public class AutorHelper {
    public static boolean validarAutor(Autor autor){
      boolean resultado = true;
                 
        if(autor.getNome().length() <= 1){
            resultado = false;
        }
        
        else if(autor.getId() < 0){
            resultado = false;
        }

        return resultado;
    }
     
    public static boolean validarId(Long id){
        if(id < 0){
            return false;
        }
        else{
            return true;
        }
    }
    
    public static boolean validarNome(String nome){
        if(nome.length() <= 1){
            return false;
        }
        else{
            return true;
        }
    }
}