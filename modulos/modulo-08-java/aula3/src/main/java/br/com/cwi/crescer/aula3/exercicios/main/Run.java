package br.com.cwi.crescer.aula3.exercicios.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Run {

    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CADASTRO_DE_EVENTO");
        final EntityManager em = emf.createEntityManager();

        if (em.isOpen()) {
            System.out.println("Conectou!");
        }

        em.close();
        emf.close();

    }
}
