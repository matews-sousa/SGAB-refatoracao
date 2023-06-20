package sgab.model.dto.util;

import sgab.model.dto.Pessoa;
import sgab.model.dao.PessoasDAO;

import java.util.LinkedList;
import java.util.List;
import sgab.model.dto.Exemplar;

public class DevolucaoHelper extends PessoaHelper{

    public static List<String> validarLeitor(Pessoa pessoa, PessoasDAO pessoas) {
        List<String> mensagens = validarPessoa(pessoa,pessoas);
        if(!pessoa.getTipo().contains(UsuarioTipo.LEITOR)){
            mensagens.add("Pessoa não é um leitor!");
        }
        return mensagens;
    }

    public static List<String> validarEmprestimo(Exemplar exemplar){
        List<String> erros = new LinkedList<>();
        if(exemplar == null){
            erros.add("O exemplar não é válido");
        }else if(exemplar.getStatus() == ExemplarStatus.REPARO){
            erros.add("O exemplar está em reparo");
        }else if(exemplar.getStatus() == ExemplarStatus.RESERVADO){
            erros.add("O exemplar está reservado");
        }   
        else if(exemplar.getStatus() == ExemplarStatus.DESATIVADA){
            erros.add("O exemplar está desativado");
        }  
        else if(exemplar.getStatus() == ExemplarStatus.DISPONIVEL){
            erros.add("O exemplar já está disponível");
        }  
        return erros;
    }
}
