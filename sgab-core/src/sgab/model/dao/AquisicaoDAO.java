package sgab.model.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import sgab.model.dto.Aquisicao;
import sgab.model.dto.util.AquisicaoStatus;
import sgab.model.exception.*;

public class AquisicaoDAO implements GenericDAO<Aquisicao, Long>{
    private Map<Long, Aquisicao> aquisicoes = new HashMap<>();
    
    private static AquisicaoDAO aquisicaoDAO;
    static {
        AquisicaoDAO.aquisicaoDAO = null;
    }
    
    private static Long ids;
    static {
        AquisicaoDAO.ids = 0L;
    }
    
    public static Long getNextId() {
        return AquisicaoDAO.ids++;
    }
    
    private AquisicaoDAO() { }
    
    public static AquisicaoDAO getInstance() {
        if(aquisicaoDAO == null) {
            aquisicaoDAO = new AquisicaoDAO();
        }
        return aquisicaoDAO;
    }
    
    @Override
    public void inserir(Aquisicao entidade) {
        entidade.setId(AquisicaoDAO.getNextId());
        aquisicoes.put(entidade.getId(), entidade);
    }
    
    @Override
    public void alterar(Aquisicao entidade) {
        Aquisicao aquisicaoAlvo = aquisicoes.remove(entidade.getId());
        if(aquisicaoAlvo == null) {
            throw new PersistenciaException("Nenhuma aquisição com o id '"
                                            + entidade.getId() + "'.");
        }
        
        inserir(entidade);
    }
    
    @Override
    public Aquisicao pesquisar(Long key) {
        return aquisicoes.get(key);
    }
    
    //é necessário adicionar método de pesquisar por Pessoa e Obra?

    public List<Aquisicao> listarAquisicoes() {
        List<Aquisicao> aquisicoesExistentes = new LinkedList<>();
        
        for(Aquisicao aquisicao : aquisicoes.values()) {
            if(aquisicao.getStatus() != AquisicaoStatus.CANCELADO) {
                aquisicoesExistentes.add(aquisicao);
            }
        }
        return aquisicoesExistentes;
    }
    
    public List<Aquisicao> aquisicoesFinalizadas() {
        List<Aquisicao> aquisicoesFinalizadas = new LinkedList<>();
        
        for(Aquisicao aquisicao : aquisicoes.values()) {
            if(aquisicao.getStatus() == AquisicaoStatus.FINALIZADA) {
                aquisicoesFinalizadas.add(aquisicao);
            }
        }
        return aquisicoesFinalizadas;
    }
    
    public List<Aquisicao> aquisicoesAtivas() {
        List<Aquisicao> aquisicoesAtivas = new LinkedList<>();
        
        for(Aquisicao aquisicao : aquisicoes.values()) {
            if(aquisicao.getStatus() == AquisicaoStatus.ATIVO) {
                aquisicoesAtivas.add(aquisicao);
            }
        }
        
        return aquisicoesAtivas;
    } 

    public List<Aquisicao> aquisicoesPendentes() {
        List<Aquisicao> aquisicoesPendentes = new LinkedList<>();
        
        for(Aquisicao aquisicao : aquisicoes.values()) {
            if(aquisicao.getStatus() == AquisicaoStatus.PENDENTE) {
                aquisicoesPendentes.add(aquisicao);
            }
        }
        
        return aquisicoesPendentes;
    }
    
    public void excluir(Long key) {
        aquisicoes.remove(key);
    }
}
