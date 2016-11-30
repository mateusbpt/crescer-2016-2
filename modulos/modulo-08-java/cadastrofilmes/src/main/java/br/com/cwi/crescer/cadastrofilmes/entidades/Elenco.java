package br.com.cwi.crescer.cadastrofilmes.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Elenco implements Serializable {
   
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_ELENCO")
    @SequenceGenerator(name = "SEQ_ELENCO", sequenceName = "SEQ_ELENCO", allocationSize = 1)
    @Column(name = "ID_ELENCO")
    private int id;

    @Basic(optional = false)
    @Column(name = "NOME_ELENCO")
    private String nome;
    
    
    @OneToMany
    private List<Ator> atores;
}
