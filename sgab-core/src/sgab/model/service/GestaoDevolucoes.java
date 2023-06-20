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
import sgab.model.dto.util.DevolucaoHelper;
import sgab.model.exception.NegocioException;

public class GestaoDevolucoes {
    private PessoasDAO pessoasDAO;
    
    public void RegistrarDevolucoes(Long id){
        
        EmprestimosDAO emprestimosDAO = new EmprestimosDAO();

        Exemplar exemplar = emprestimosDAO.pesquisar(id).getExemplar(); 
  
        if(exemplar!=null){
            exemplar.setStatus(ExemplarStatus.DISPONIVEL);
            emprestimosDAO.remover(id);
        }

        else{
            throw new NegocioException("Não existe empréstimo deste exemplar!");
        }
    }
}
