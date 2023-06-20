package sgab.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sgab.model.dto.Usuario;
import sgab.model.dto.util.UsuarioStatus;
import sgab.model.exception.PersistenciaException;
import sgab.util.PasswordDigest;

public class UsuarioDAO implements GenericDAO<Usuario, Long> {

    private Map<Long, Usuario> table = new HashMap<>();
    
    private static UsuarioDAO usuarioDAO;
    static {
        UsuarioDAO.usuarioDAO = null;
    }
    
    private static Long idSequence; //  gera identificador sequencial
    static {
        UsuarioDAO.idSequence = 0L;
    }
    
    public static Long getNextId() {
        return UsuarioDAO.idSequence++;
    }    
    
    private UsuarioDAO() { } // singleton
    
    public static UsuarioDAO getInstance() {
        
        if (usuarioDAO == null) {
            usuarioDAO = new UsuarioDAO();
            
            // insere administrador do sistema
            Usuario admin = new Usuario("admin");
            admin.setNome("Administrador do Sistema");
            admin.setEmail("admin@sgab.cefetmg.br");
            admin.setSenha("admin");
            admin.setStatus(UsuarioStatus.ATIVO);
        
            usuarioDAO.inserir(admin);
        }
        
        return usuarioDAO;
    }
    
    @Override
    public void inserir(Usuario usuario) {
        
        if (pesquisarLogin(usuario.getLogin()) != null)
            throw new PersistenciaException("'" + usuario.getLogin() 
                                                            + "' é único.");
        Long usuarioId = UsuarioDAO.getNextId();
        usuario.setId(usuarioId);
        
        String usrPasswd = PasswordDigest.passwordDigestMD5(usuario.getSenha());
        usuario.setSenha(usrPasswd);
        
        table.put(usuarioId, usuario);
    }

    @Override
    public void alterar(Usuario usuario) {
        
        Usuario usr = table.remove(usuario.getId());
        if (usr == null)
            throw new PersistenciaException("Nenhum usuário com "
                                        + "o id '" + usuario.getId() + "'.");
        
        inserir(usuario);
    }

    @Override
    public Usuario pesquisar(Long id) {
        return table.get(id);
    }
    
    public Usuario pesquisarLogin(String login) {       
        List<Usuario> listUsuario = listarTodos();
        for (Usuario usr: listUsuario)
            if (usr.getLogin().equals(login))
                return usr;
        
        return null;
    }
    
    public Usuario pesquisarLoginSenha(String login, String senha) {
        Usuario usr = pesquisarLogin(login);
        
        String passwd = PasswordDigest.passwordDigestMD5(senha);
        
        if (usr.getSenha().equals(passwd))
            return usr;
        
        return null;
    }
    
    public List<Usuario> listarAtivos() {
        List<Usuario> listUsuarios = new ArrayList<>();
        
        for (Usuario usr: table.values())
            if (usr.getStatus() == UsuarioStatus.ATIVO) // lista apenas os usuários ativos
                listUsuarios.add(usr);
        
        return listUsuarios;
    }
    
    public List<Usuario> listarTodos() {
        List<Usuario> listUsuarios = new ArrayList<>();
        
        listUsuarios.addAll(table.values());
        
        return listUsuarios;
    }
    
}
