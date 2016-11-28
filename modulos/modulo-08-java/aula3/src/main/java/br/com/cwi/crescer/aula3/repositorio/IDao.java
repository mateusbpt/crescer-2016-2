package br.com.cwi.crescer.aula3.repositorio;

import java.util.List;


public interface IDao<E, ID> {
    
    
    void insert(E e);
    
    void delete(E e);
    
    E find(Class c, ID id);
    
    List<E> findAll();
    
    List<E> findByName(String nmPessoa);
}
