package br.com.cwi.crescer.cadastrofilmes.entidades;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Classificacao implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CLASSIFICACAO")
    @SequenceGenerator(name = "SEQ_CLASSIFICACAO", sequenceName = "SEQ_CLASSIFICACAO", allocationSize = 1)
    @Column(name = "ID_CLASSIFICACAO")
    private int Id;

    @Basic(optional = false)
    @Column(name = "DESCRICAO_CLASSIFICACAO")
    private String Descricao;
    
    @Column(name = "IDADE_CLASSIFICACAO")
    private int idade;

}
