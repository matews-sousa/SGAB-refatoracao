package sgab.model.dao;

import sgab.model.dto.Pessoa;
import sgab.model.dto.util.UsuarioTipo;
import sgab.model.exception.PersistenciaException;
import sgab.util.PasswordDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PessoasDAO implements GenericDeleteDAO<Pessoa, Long>{
    private Map<Long, Pessoa> table = new HashMap<>();

    private static PessoasDAO pessoasDAO;
    static {
        PessoasDAO.pessoasDAO = null;
    }


    private static Long idSequence;
    static {
        PessoasDAO.idSequence = 0L;
    }

    public static Long getNextId() {
        return PessoasDAO.idSequence++;
    } 

    private PessoasDAO() { }

    public static PessoasDAO getInstance() {
        
        if (pessoasDAO == null) {
            pessoasDAO = new PessoasDAO();
            
            Pessoa admin = new Pessoa("admin", 10000000001L);
            Long pessoaId = PessoasDAO.getNextId();
            admin.setId(pessoaId);
            admin.setNome("Administrador do Sistema");
            admin.setEmail("admin@sgab.cefetmg.br");
            admin.setSenha("admin");
            admin.setTipo(UsuarioTipo.ADMINISTRADOR);
            admin.setTipo(UsuarioTipo.BIBLIOTECARIO);
            admin.setHabilitado(true);
        
            pessoasDAO.inserir(admin);
        }
        
        return pessoasDAO;
    }

    @Override
    public void inserir(Pessoa pessoa) {
        if (pesquisarLogin(pessoa.getLogin()) != null)
            throw new PersistenciaException("'" + pessoa.getLogin() 
                                                            + "' precisa ser único.");
        
        Long pessoaId = PessoasDAO.getNextId();
        pessoa.setId(pessoaId);
        
        String pesPasswd = PasswordDigest.passwordDigestMD5(pessoa.getSenha());
        pessoa.setSenha(pesPasswd);
        
        table.put(pessoaId, pessoa);
    }

    public Pessoa pesquisarLogin(String login) {       
        List<Pessoa> listPesssoa = listarTodos();
        for (Pessoa pes: listPesssoa)
            if (pes.getLogin().equals(login))
                return pes;
        
        return null;
    }

    public List<Pessoa> listarAtivos() {
        List<Pessoa> listPessoas = new ArrayList<>();
        
        for (Pessoa pes: table.values())
            if (pes.getHabilitado() == true)
                listPessoas.add(pes);
        
        return listPessoas;
    }

    public List<Pessoa> listarAtivosPorTipo(UsuarioTipo tipo) {
        List<Pessoa> listPessoas = new ArrayList<>();
        for(Pessoa pessoa: listarAtivos())
            if (pessoa.getTipo().contains(tipo))
                listPessoas.add(pessoa);
        return listPessoas;
    }

    public List<Pessoa> listarTodos() {
        List<Pessoa> listPessoas = new ArrayList<>();
        
        listPessoas.addAll(table.values());
        
        return listPessoas;
    }
    
    @Override
    public void alterar(Pessoa pessoa){
        String senhaAnterior = pesquisar(pessoa.getId()).getSenha();
        Pessoa pes = table.remove(pessoa.getId());
        
        if (pes == null)
            throw new PersistenciaException("Nenhum usuário com "
                                        + "o id '" + pessoa.getId() + "'.");
        
        if(pessoa.getSenha().equals(senhaAnterior)){
            if (pesquisarLogin(pessoa.getLogin()) != null)
                throw new PersistenciaException("'" + pessoa.getLogin() 
                                                                + "' precisa ser único.");
            
//            Long pessoaId = PessoasDAO.getNextId();
//            pessoa.setId(pessoaId);
            
            table.put(pessoa.getId(), pessoa);
        } else {
            inserir(pessoa);
        }
    }

    @Override
    public Pessoa pesquisar(Long id) {
        List<Pessoa> listPesssoa = listarTodos();
        for (Pessoa pes: listPesssoa)
            if (pes.getId().equals(id))
                return pes;
        
        return null;
    }

    public Pessoa pesquisarCpf(Long cpf) {
        List<Pessoa> listPesssoa = listarTodos();
        for (Pessoa pes: listPesssoa)
            if (pes.getCpf().equals(cpf))
                return pes;
        
        return null;
    }

    public Pessoa pesquisarNome(String nome) {
        List<Pessoa> listPesssoa = listarTodos();
        for (Pessoa pes: listPesssoa)
            if (pes.getNome().equals(nome))
                return pes;
        
        return null;
    }

    public Pessoa pesquisarLoginSenha(String login, String senha) {
        Pessoa pes = pesquisarLogin(login);
        
        String passwd = PasswordDigest.passwordDigestMD5(senha);
        
        if (pes.getSenha().equals(passwd))
            return pes;
        
        return null;
    }

    @Override
    public void delete(Long id){
        Pessoa p = pesquisar(id);
        
        if(p == null)
            throw new PersistenciaException("Nenhum usuário com "
                                        + "o id '" + id + "'.");

        if(p.getTipo().contains(UsuarioTipo.ADMINISTRADOR)){
            throw new PersistenciaException("Pessoa é um " + p.getTipo() + "!");
        }

        p.setHabilitado(false);
    }
}