package br.com.cwi.crescer.cadastrodefilmes.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Filme implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_FILME")
    @SequenceGenerator(name = "SEQ_FILME", sequenceName = "SEQ_FILME", allocationSize = 1)
    @Column(name = "ID_FILME")
    private int id;

    @Basic(optional = false)
    @Column(name = "TITULO_FILME")
    private String titulo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_GENERO", referencedColumnName = "ID")
    private Genero genero;

    @Basic(optional = false)
    @Column(name = "DIRETOR_FILME")
    private String diretor;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_LANCAMENTO")
    private Date dataLancamento;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_ELENCO", referencedColumnName = "ID")
    private Elenco elenco;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_CLASSIFICACAO", referencedColumnName = "ID")
    private Classificacao classificacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_IDIOMA", referencedColumnName = "ID")
    private Idioma idioma;

    @Column(name = "IMAGEM_FILME")
    private String imagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

}
