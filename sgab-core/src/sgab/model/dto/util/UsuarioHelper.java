package sgab.model.dto.util;

import java.util.LinkedList;
import java.util.List;
import sgab.model.dto.Usuario;

/**
 *
 * @author maffort <maffort@gmail.com>
 */
public class UsuarioHelper {
     
    public static List<String> validar(Usuario usuario) {
        List<String> exMsgs = new LinkedList<>();
        
        if (usuario == null)
            exMsgs.add("Usuario não pode ser null");
        else {
            if ((usuario.getLogin() == null) || usuario.getLogin().isEmpty())
                exMsgs.add("Obrigatório informar o login.");
            else if (usuario.getLogin().length() < 5)
                exMsgs.add("Login deve ter pelo menos 5 caracteres.");

            if ((usuario.getSenha() == null) || usuario.getSenha().isEmpty())
                exMsgs.add("Obrigatório informar a senha.");
            else if (usuario.getSenha().length() < 8)
                exMsgs.add("Senha deve ter pelo menos 8 caracteres.");

            if ((usuario.getNome() == null) || usuario.getNome().isEmpty())
                exMsgs.add("Obrigatório informar o nome completo do usuário.");
            else if (usuario.getNome().split(" ").length < 2)
                exMsgs.add("Nome completo do usuario deve ter pelo menos duas palavras.");

            if ((usuario.getEmail() == null) || usuario.getEmail().isEmpty())
                exMsgs.add("Obrigatório informar o email do usuário.");
            else if (!(usuario.getEmail().contains("@") && usuario.getEmail().contains(".")))
                exMsgs.add("Email não é válido.");            
        }
           
        return exMsgs;
    }
}
