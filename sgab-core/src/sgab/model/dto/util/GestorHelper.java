package sgab.model.dto.util;

import sgab.model.dto.Pessoa;
import sgab.model.dao.PessoasDAO;
import java.util.List;

public class GestorHelper extends PessoaHelper{

    public static List<String> validarGestor(Pessoa pessoa, PessoasDAO pessoas) {
        List<String> mensagens = validarPessoa(pessoa,pessoas);
        if(!pessoa.getTipo().contains(UsuarioTipo.GESTOR)){
            mensagens.add("Pessoa não é um gestor!");
        }
        return mensagens;
    }

    public static List<String> validarBibliotecario(Pessoa pessoa, PessoasDAO pessoas) {
        List<String> mensagens = validarPessoa(pessoa,pessoas);
        if(!pessoa.getTipo().contains(UsuarioTipo.BIBLIOTECARIO)){
            mensagens.add("Pessoa não é um bibliotecário!");
        }
        return mensagens;
    }

    public static List<String> validarAtendente(Pessoa pessoa, PessoasDAO pessoas) {
        List<String> mensagens = validarPessoa(pessoa,pessoas);
        if(!pessoa.getTipo().contains(UsuarioTipo.ATENDENTE)){
            mensagens.add("Pessoa não é um atendente!");
        }
        return mensagens;
    }

    public static List<String> validarGestorAlteracao(Pessoa pessoa, PessoasDAO pessoas) {
        List<String> mensagens = validarAlteracao(pessoa,pessoas);
        if(!pessoa.getTipo().contains(UsuarioTipo.GESTOR)){
            mensagens.add("Pessoa não é um gestor!");
        }
        return mensagens;
    }

    public static List<String> validarBibliotecarioAlteracao(Pessoa pessoa, PessoasDAO pessoas) {
        List<String> mensagens = validarAlteracao(pessoa,pessoas);
        if(!pessoa.getTipo().contains(UsuarioTipo.BIBLIOTECARIO)){
            mensagens.add("Pessoa não é um bibliotecario!");
        }
        return mensagens;
    }

    public static List<String> validarAtendenteAlteracao(Pessoa pessoa, PessoasDAO pessoas) {
        List<String> mensagens = validarAlteracao(pessoa,pessoas);
        if(!pessoa.getTipo().contains(UsuarioTipo.ATENDENTE)){
            mensagens.add("Pessoa não é um atendente!");
        }
        return mensagens;
    }

}
