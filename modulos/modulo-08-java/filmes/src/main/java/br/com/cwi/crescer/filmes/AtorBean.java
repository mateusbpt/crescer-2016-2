package br.com.cwi.crescer.filmes;

import br.com.cwi.crescer.filmes.entidades.Ator;
import java.util.List;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AtorBean extends AbstractDao<Ator, Integer>{

    @PersistenceContext(unitName = "cadastro_de_filmes")
    private EntityManager entityManager;

    public AtorBean() {
        super(Ator.class);
    }

    @Override
    public EntityManager getEntityManager() {
         return this.entityManager;
    }

    @Override
    public List<Ator> findAll() {
         return this.getEntityManager().createQuery("select a from Ator a").getResultList();
    }
    
}
