package sgab.model.dto.util;

import sgab.model.dto.Pessoa;
import sgab.model.dao.PessoasDAO;

import java.util.LinkedList;
import java.util.List;
import sgab.model.dto.Exemplar;

public class EmprestimoHelper extends PessoaHelper{

    public static List<String> validarLeitor(Pessoa pessoa) {
        List<String> mensagens = new LinkedList<>();
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
        //FIXME: verificar se o exemplar está reservado pela mesma pessoa
        }else if(exemplar.getStatus() == ExemplarStatus.RESERVADO){
            erros.add("O exemplar está reservado");
        }   
        else if(exemplar.getStatus() == ExemplarStatus.DESATIVADA){
            erros.add("O exemplar está desativado");
        }  
        else if(exemplar.getStatus() == ExemplarStatus.EMPRESTADO){
            erros.add("O exemplar está emprestado");
        }  
        return erros;
    }
}