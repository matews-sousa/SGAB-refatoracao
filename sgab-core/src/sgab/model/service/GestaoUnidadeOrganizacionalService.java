package sgab.model.service;
import java.util.List;
import sgab.model.dao.UnidadeOrganizacionalDAO;
import sgab.model.dto.UnidadeOrganizacional;
import sgab.model.dto.util.UnidadeOrganizacionalHelper;
import sgab.model.exception.NegocioException;

public class GestaoUnidadeOrganizacionalService {
    
    private UnidadeOrganizacionalDAO uOrgDAO = 
            UnidadeOrganizacionalDAO.getInstance();
    
    public Long cadastrar (UnidadeOrganizacional uOrg) {
        List<String> msgs = UnidadeOrganizacionalHelper.validar(uOrg);
        
        if (!msgs.isEmpty())
            throw new NegocioException(msgs);
        
        uOrgDAO.inserir(uOrg);
        return uOrg.getId();
    }
    
    public void atualizar(UnidadeOrganizacional uOrg) {
        List<String> msgs = UnidadeOrganizacionalHelper.validar(uOrg);
        
        if (!msgs.isEmpty())
            throw new NegocioException(msgs);
        
        uOrgDAO.alterar(uOrg);        
    }

    public void excluir(UnidadeOrganizacional uOrg) {
               
        if (uOrgDAO.pesquisar(uOrg.getId()) == null)
            throw new NegocioException("Unidade Organizacional 'id="
                + uOrg.getId() + "' não encontrada.");
        
        uOrg.setHabilitado(false);
    }
    
    public List<UnidadeOrganizacional> pesquisarAtivos() {
        return uOrgDAO.listarAtivos();
    }
    
    public UnidadeOrganizacional pesquisarPorId(Long id) {
        return uOrgDAO.pesquisar(id);
    }
}
 