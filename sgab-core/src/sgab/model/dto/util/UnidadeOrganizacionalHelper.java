
package sgab.model.dto.util;

import java.util.LinkedList;
import java.util.List;
import sgab.model.dto.UnidadeOrganizacional;

public class UnidadeOrganizacionalHelper {
    
    public static List<String> validar(UnidadeOrganizacional uOrg){

        List<String> exMsgs = new LinkedList<>();

        if (uOrg == null)
            exMsgs.add("Unidade Organizacional não pode ser null.");
        else {
            if (uOrg.getNome() == null || uOrg.getNome().length() == 0)
                exMsgs.add("Obrigatório informar o nome da Unidade Organizacional.");
            else if (uOrg.getNome().length() < 3)
                exMsgs.add("Nome da Unidade Organizacional deve ter pelo menos 2 caracteres.");

            if (uOrg.getEndereco() == null || uOrg.getEndereco().length() == 0)
               exMsgs.add("Obrigatório informar o endereço.");
        }
        
        return exMsgs;
    }
}