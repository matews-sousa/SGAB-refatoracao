package sgab.model.service;

import java.util.List;
import sgab.model.dao.PessoasDAO;
import sgab.model.dto.Pessoa;
import sgab.model.dto.util.UsuarioTipo;
import sgab.model.exception.NegocioException;

public class GestaoUsuarioService {

    private PessoasDAO pessoaDAO;
    
    public GestaoUsuarioService() {
        pessoaDAO = PessoasDAO.getInstance();
    }

    public void cadastrar(Long pessoaId, UsuarioTipo usrTipo) {
        Pessoa pessoa = pessoaDAO.pesquisar(pessoaId);
        pessoa.setTipo(usrTipo);
        pessoaDAO.alterar(pessoa);
    }

    public void excluirUsuario(Long pessoaId, UsuarioTipo usrTipo) {
        
        Pessoa usr = pessoaDAO.pesquisar(pessoaId);

        if (usr == null)
            throw new NegocioException("Pessoa 'id=" + pessoaId + "'não encontrada!");
        
        usr.removerTipo(usrTipo);
    }

    public List<Pessoa> pesquisarPorTipo(UsuarioTipo usrTipo) {
        List<Pessoa> listPessoa = pessoaDAO.listarAtivosPorTipo(usrTipo);
        return listPessoa;
    }
}
