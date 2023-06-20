package sgab.model.dao;

public interface GenericDeleteDAO<E, K> extends GenericDAO<E, K>{
    void delete(K key);
}
