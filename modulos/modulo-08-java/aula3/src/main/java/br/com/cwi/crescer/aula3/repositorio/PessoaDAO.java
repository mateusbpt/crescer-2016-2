package br.com.cwi.crescer.aula3.repositorio;

import br.com.cwi.crescer.aula3.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import static org.hibernate.criterion.MatchMode.ANYWHERE;
import org.hibernate.criterion.Restrictions;


public class PessoaDAO implements IDao<Pessoa, Long> {

   
    private final EntityManager em;
    
    public PessoaDAO(EntityManager em){
        this.em = em;
    }

    @Override
    public void insert(Pessoa e) {
        try {
            em.getTransaction().begin();
            if (e.getIdPessoa() == null) {
                em.persist(e);
            } else {
                em.merge(e);
            }
            em.getTransaction().commit();
        } catch (Exception exp) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Pessoa e) {
        try {
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
        } catch (Exception exp) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Pessoa find(Class c, Long id) {
        return em.find(Pessoa.class, id);
    }

    @Override
    public List<Pessoa> findAll() {
        return em.createQuery("select p from Pessoa p").getResultList();
    }

    @Override
    public List<Pessoa> findByName(String nmPessoa) {
        final Session session = em.unwrap(Session.class);
        final Criteria criteria = session.createCriteria(Pessoa.class);
        criteria.add(Restrictions.like("nmPessoa", nmPessoa, ANYWHERE));
        return criteria.list();
    }
    
    
}
