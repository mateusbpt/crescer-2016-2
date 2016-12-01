package br.com.cwi.crescer.cadastrodefilmes.entidades;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Ator implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_ATOR")
    @SequenceGenerator(name = "SEQ_ATOR", sequenceName = "SEQ_ATOR", allocationSize = 1)
    @Column(name = "ID_ATOR")
    private int id;

    @Basic(optional = false)
    @Column(name = "NOME_ATOR")
    private String Nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

}
