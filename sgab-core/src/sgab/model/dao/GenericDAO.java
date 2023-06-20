package sgab.model.dao;

public interface GenericDAO<E, K> {
    void inserir(E entidade);
    void alterar(E entidade);
    E pesquisar(K key);
}
