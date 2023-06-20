package sgab.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sgab.model.dto.UnidadeOrganizacional;
import sgab.model.exception.PersistenciaException;

public class UnidadeOrganizacionalDAO implements GenericDAO<UnidadeOrganizacional, Long>  {
    
    private Map<Long, UnidadeOrganizacional> table = new HashMap<>();

    private static UnidadeOrganizacionalDAO uOrgDAO;
    static {
        UnidadeOrganizacionalDAO.uOrgDAO = null;
    }
 
    private static Long idSequence; //  gera identificador sequencial
    static {
        UnidadeOrganizacionalDAO.idSequence = 0L;
    }
    
    public static Long getNextId() {
        return UnidadeOrganizacionalDAO.idSequence++;
    }        
    
    private UnidadeOrganizacionalDAO() { }
    
    public static UnidadeOrganizacionalDAO getInstance() {
        if (uOrgDAO == null)
           uOrgDAO = new UnidadeOrganizacionalDAO();
        
        return uOrgDAO;
    }
    
    @Override
    public void inserir(UnidadeOrganizacional entidade) {
        
        Long uOrgId = UnidadeOrganizacionalDAO.getNextId();
        entidade.setId(uOrgId);
        
        
        table.put(entidade.getId(), entidade);
    }

    @Override
    public void alterar(UnidadeOrganizacional entidade) {
        UnidadeOrganizacional uOrg = table.remove(entidade.getId());
        if (uOrg == null)
            throw new PersistenciaException("Nenhuma Unidade  Organizacional com "
                                        + "o id '" + entidade.getId() + "'.");        
        
        inserir(entidade);
    }

    @Override
    public UnidadeOrganizacional pesquisar(Long id) {
        return table.get(id);
    }

    public UnidadeOrganizacional pesquisarPorNome(String nome) {
        List<UnidadeOrganizacional> listUOrg = new ArrayList<>();
        
        for (UnidadeOrganizacional uOrg: table.values())
            if (uOrg.getNome().equals(nome))
                return uOrg;
        
        return null;
    }    
    
    public List<UnidadeOrganizacional> listarAtivos() {
        List<UnidadeOrganizacional> listUOrg = new ArrayList<>();
        
        for (UnidadeOrganizacional uOrg: table.values())
            if (uOrg.getHabilitado() == true)
                listUOrg.add(uOrg);
        
        return listUOrg;
    }
    
    public List<UnidadeOrganizacional> listarTodos() {
        List<UnidadeOrganizacional> listUOrg = new ArrayList<>();
        
        listUOrg.addAll(table.values());
        
        return listUOrg;
    }

}
