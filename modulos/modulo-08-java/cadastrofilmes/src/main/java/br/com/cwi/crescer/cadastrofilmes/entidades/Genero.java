package br.com.cwi.crescer.cadastrofilmes.entidades;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Genero implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_GENERO")
    @SequenceGenerator(name = "SEQ_GENERO", sequenceName = "SEQ_GENERO", allocationSize = 1)
    @Column(name = "ID_GENERO")
    private int id;

    @Basic(optional = false)
    @Column(name = "DESCRICAO_GENERO")
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
