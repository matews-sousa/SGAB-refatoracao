package sgab.model.dto.util;
import java.util.LinkedList;
import java.util.List;
import sgab.model.dto.Fornecedor;

public class FornecedorHelper{   
    public static List<String> validar(Fornecedor fornecedor) {
        List<String> exMsgs = new LinkedList<>();
        
        
        if (fornecedor.getCnpj() == null)
            exMsgs.add("Cnpj não pode ser null");
        else {
            if ((fornecedor.getEmail() == null) || fornecedor.getEmail().isEmpty())
                exMsgs.add("Obrigatório informar o email do fornececor.");
            else if (!(fornecedor.getEmail().contains("@") && fornecedor.getEmail().contains(".")))
                exMsgs.add("Email não é válido.");  
            if ((fornecedor.getEmail() == null) || fornecedor.getEmail().isEmpty())
                exMsgs.add("Obrigatório informar o email do fornecedor.");
            else if (!(fornecedor.getEmail().contains("@") && fornecedor.getEmail().contains(".")))
                exMsgs.add("Email não é válido.");   
            if ((fornecedor.getEmail() == null) || fornecedor.getEmail().isEmpty())
                exMsgs.add("Obrigatório informar o email do fornecedor.");
            else if (!(fornecedor.getEmail().contains("@") && fornecedor.getEmail().contains(".")))
                exMsgs.add("Email não é válido.");   
        }
           
        return exMsgs;
    }
}