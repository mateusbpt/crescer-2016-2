package br.com.cwi.crescer.cadastrofilmes;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Run {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("cadastro_de_filmes");
        factory.close();
    }
}
