package sgab.model.dto.util;

import java.util.LinkedList;
import java.util.List;
import sgab.model.dto.Biblioteca;
import sgab.model.dto.UnidadeOrganizacional;

public class BibliotecaHelper {
    
    public static List<String> validar(Biblioteca biblioteca){
        List<String> exMsgs = new LinkedList<>();
        
        if (biblioteca == null)
            exMsgs.add("Biblioteca não pode ser null.");
        else { 
            if ((biblioteca.getNome() == null) || biblioteca.getNome().isEmpty())
                exMsgs.add("Obrigatório informar o nome.");
            else if (biblioteca.getNome().length() < 5)
                exMsgs.add("Nome deve ter pelo menos 5 caracteres.");            
        
            UnidadeOrganizacional uOrg = biblioteca.getUnidadeOrganizacional();
            exMsgs.addAll(UnidadeOrganizacionalHelper.validar(uOrg));
           
            
        }

        return exMsgs;
    }
}
