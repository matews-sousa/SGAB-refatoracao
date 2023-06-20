package sgab.model.service;

import java.util.List;
import sgab.model.dao.EmprestimosDAO;

import sgab.model.dao.PessoasDAO;
import sgab.model.dto.Emprestimo;
import sgab.model.dto.Exemplar;
import sgab.model.dto.Obra;
import sgab.model.dto.Pessoa;
import sgab.model.dto.util.EmprestimoHelper;
import sgab.model.dto.util.ExemplarStatus;
import sgab.model.exception.NegocioException;


public class GestaoEmprestimo {
    private EmprestimosDAO emprestimosDAO = new EmprestimosDAO();
    
    public void realizarEmprestimo(Exemplar exemplar, Pessoa leitor){
        List<String> errosLeitor = EmprestimoHelper.validarLeitor(leitor);
        List<String> erros = EmprestimoHelper.validarEmprestimo(exemplar);
        
        if(!erros.isEmpty()){
            throw new NegocioException(erros);
        }else if(!errosLeitor.isEmpty()){
            throw new NegocioException(errosLeitor);
        }
        
        exemplar.setStatus(ExemplarStatus.EMPRESTADO);
        emprestimosDAO.inserir(exemplar,leitor);
    }


    public List<Emprestimo> listarEmprestimo(){
        List<Emprestimo> lista = emprestimosDAO.listar();
        if(lista.isEmpty()){
            throw new NegocioException("Não há empréstimos existentes!");
        }
        return lista;
    }
    
    public List<Emprestimo> listarEmprestimoPorExemplar(Exemplar exemplar){
        List<Emprestimo> lista = emprestimosDAO.listar(exemplar);
        if(lista.isEmpty()){
            throw new NegocioException("Não há empréstimos existentes!");
        }
        return lista;
    }  
}

