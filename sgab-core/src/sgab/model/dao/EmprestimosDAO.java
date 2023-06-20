package sgab.model.dao;


import java.util.ArrayList;
import java.util.List;

import sgab.model.dto.Emprestimo;
import sgab.model.dto.Exemplar;
import sgab.model.dto.Pessoa;
import sgab.model.exception.NegocioException;

public class EmprestimosDAO{
  
  private static ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
  
  private static EmprestimosDAO emprestimosDAO; 
  
  
  private static Long idSequence;
    static {
        EmprestimosDAO.idSequence = 0L;
    }

    public static Long getNextId() {
        return EmprestimosDAO.idSequence++;
    }   

  private boolean podeInserir(Pessoa pessoa){
    int nEmprestimos = 1;
    for (Emprestimo emprestimo : emprestimos) {
      if (emprestimo.getPessoa().equals(pessoa)) {
        nEmprestimos++;
      }
    }
    if (nEmprestimos > 3) {
      return false;
    }
    return true;
  }

  public void inserir(Exemplar exemplar, Pessoa pessoa) throws NegocioException{
    Emprestimo emprestimo = new Emprestimo(pessoa, exemplar);
    if (podeInserir(pessoa)) {
      emprestimos.add(emprestimo);
    }else{
      throw new NegocioException("Não é possível realizar mais de 3 empréstimos por pessoa.");
    }
  }

  public void remover(Emprestimo emprestimo) {
    emprestimos.remove(emprestimo);
  }

  public void remover(Long id) {
    for (Emprestimo emprestimo : emprestimos) {
      if (emprestimo.getId() == (id)) {
        emprestimos.remove(emprestimo);
        break;
      }
    }
  }

  public Emprestimo pesquisar(long id){
    for (Emprestimo emprestimo : emprestimos) {
      if (emprestimo.getId() == (id)) {
        return emprestimo;
      }
    }
    return null;
  }

  public List<Emprestimo> listar() {
    return emprestimos;
  }
  
  public List<Emprestimo> listar(Exemplar exemplar) {
    List<Emprestimo> result = new ArrayList<>();
        
    for(Emprestimo emprestimo : emprestimos){
        if(emprestimo.getExemplar().equals(exemplar)){
            result.add(emprestimo);
        }
    }

    return result;
  }
}