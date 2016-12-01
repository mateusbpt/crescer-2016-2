package br.com.cwi.crescer.filmes;

import java.util.List;

public interface IDao<E, ID> {

    void insert(E e);

    void delete(E e);

    E find(ID id);

    List<E> findAll();

}
