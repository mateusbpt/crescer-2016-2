package br.com.cwi.crescer.filmes;

import javax.persistence.EntityManager;

public abstract class AbstractDao<E, ID> implements IDao<E, ID> {

    public abstract EntityManager getEntityManager();

    private final Class<E> c;

    public AbstractDao(Class<E> c) {
        this.c = c;
    }

    @Override
    public void insert(E e) {
        this.getEntityManager().merge(e);
    }

    @Override
    public void delete(E e) {
        this.getEntityManager().remove(e);
    }

    @Override
    public E find(ID id) {
        return this.getEntityManager().find(c, id);
    }

}
