package sgab.model.service;

import java.util.List;
import sgab.model.dao.PessoasDAO;
import sgab.model.dto.Pessoa;
import sgab.model.dto.util.PessoaHelper;
import sgab.model.exception.NegocioException;
public class GestaoPessoasService {
    private PessoasDAO pessoasDAO;

    public GestaoPessoasService() {
        pessoasDAO = PessoasDAO.getInstance();
    }

    public Long cadastrar(Pessoa pessoa) {
        List<String> exMsgs = PessoaHelper.validarPessoa(pessoa, pessoasDAO);
        
        if (!exMsgs.isEmpty()){
            throw new NegocioException(exMsgs);
        }
            
        pessoasDAO.inserir(pessoa);
        return pessoa.getId();
    }

    public void excluir(Pessoa pessoa){
        pessoasDAO.delete(pessoa.getId());
    }

    public List<Pessoa> pesquisarAtivos() {
        return pessoasDAO.listarAtivos();
    }

    public Pessoa pesquisarPorId(Long id){
        return pessoasDAO.pesquisar(id);
    }   

    public Pessoa pesquisarConta(String login, String senha){
        
        Pessoa result = pessoasDAO.pesquisarLoginSenha(login, senha);
        return result;               
    }

    public Pessoa pesquisarPorLogin(String login){
        Pessoa result = pessoasDAO.pesquisarLogin(login);
        return result;
    }

    public void alterar(Pessoa pessoa){
        List<String> exMsgs = PessoaHelper.validarAlteracao(pessoa, pessoasDAO);
        
        if (!exMsgs.isEmpty())
            throw new NegocioException(exMsgs);
        
        pessoasDAO.alterar(pessoa);
    }
}
