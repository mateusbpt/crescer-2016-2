package br.com.cwi.crescer.cadastrofilmes.entidades;

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

  
    @ManyToOne
    private Genero genero;
    
    @Basic(optional = false)
    @Column(name = "DIRETOR_FILME")
    private String diretor;

    @Temporal(TemporalType.DATE)
    @Column(name="DATA_LANCAMENTO")
    private Date dataLancamento;


    @ManyToOne
    private Elenco elenco;

  
 
    @ManyToOne
    private Classificacao classificacao;


    @ManyToOne
    private Idioma idioma;
    
    @Column(name="IMAGEM_FILME")
    private String imagem;
}
