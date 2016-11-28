package br.com.cwi.crescer.aula3;

import br.com.cwi.crescer.aula3.entity.Pessoa;
import br.com.cwi.crescer.aula3.repositorio.PessoaDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Run {

    public static void main(String[] args) {
        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("exercicios");
        final EntityManager em;
        em = emf.createEntityManager();
        em.isOpen();
        
        PessoaDAO pessoaRepositorio = new PessoaDAO(em);
       

            Pessoa pessoa = new Pessoa();
            Pessoa pessoa2 = new Pessoa();

            pessoa.setNmPessoa("Mateus Teixeira");
            pessoa2.setNmPessoa("fdfrsegrsera");

            //pessoaRepositorio.insert(pessoa);
            //pessoaRepositorio.insert(pessoa2);
            
            
            pessoaRepositorio.findByName("Mateus").forEach(p -> System.out.format("%s \n", p.getNmPessoa()));

        

        em.close();
        emf.close();
    }

}
