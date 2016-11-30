package br.com.cwi.crescer.cadastrofilmes.entidades;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Idioma implements Serializable {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_IDIOMA")
    @SequenceGenerator(name = "SEQ_IDIOMA", sequenceName = "SEQ_IDIOMA", allocationSize = 1)
    @Column(name = "ID_IDIOMA")
    private int id;

    @Basic(optional = false)
    @Column(name = "NOME_IDIOMA")
    private String nome;
}
