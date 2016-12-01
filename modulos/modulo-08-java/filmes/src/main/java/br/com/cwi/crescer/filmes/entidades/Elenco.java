package br.com.cwi.crescer.filmes.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.CascadeType.ALL;

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

    @OneToMany(cascade = ALL)
    private List<Ator> atores;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

}
