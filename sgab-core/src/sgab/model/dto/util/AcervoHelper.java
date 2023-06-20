package sgab.model.dto.util;

import java.util.LinkedList;
import java.util.List;
import sgab.model.dto.Exemplar;

public class AcervoHelper {
    public static List<String> validarExemplar(Exemplar exemplar){
        List<String> erros = new LinkedList<>();
        if(exemplar == null){
            erros.add("Exemplar não pode ser null.");
        }
        else{
            if(exemplar.getObra() == null){
                erros.add("Obra não pode ser null.");
            }
            if(exemplar.getBibliotecaPosse() == null){
                erros.add("A biblioteca não pode ser null.");
            }
        }
        
        return erros;
    }
}
