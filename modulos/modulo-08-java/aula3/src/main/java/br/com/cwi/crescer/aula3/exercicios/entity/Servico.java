package br.com.cwi.crescer.aula3.exercicios.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICO")
public class Servico implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_SERVICO")
    @SequenceGenerator(name = "SEQ_SERVICO", sequenceName = "SEQ_SERVICO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_SERVICO")
    private Long idServico;

    @Column(name = "DS_DESCRICAO")
    private String dsDescricao;

    @Column(name = "DS_PERIODICIDADE")
    private String dsPeriodicidade;

    @Column(name = "DS_SIMBOLO_MOEDA")
    private String dsSimboloMoeda;

    @Column(name = "DS_SITUACAO")
    private String dsSituacao;

    @Column(name = "DS_WEBSITE")
    private String dsWebsite;

    @Column(name = "NM_SERVICO")
    private String nmServico;

    @Column(name = "VL_MENSAL_USD", precision = 17, scale = 6)
    private BigDecimal vlMensalUsd;

    @Column(name = "VL_TOTAL_SERVICO", precision = 17, scale = 6)
    private BigDecimal vlTotalServico;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO",
            foreignKey = @ForeignKey(name = "FK_SERVICO_USUARIO"))
    private Usuario usuario;

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public String getDsDescricao() {
        return dsDescricao;
    }

    public void setDsDescricao(String dsDescricao) {
        this.dsDescricao = dsDescricao;
    }

    public String getDsPeriodicidade() {
        return dsPeriodicidade;
    }

    public void setDsPeriodicidade(String dsPeriodicidade) {
        this.dsPeriodicidade = dsPeriodicidade;
    }

    public String getDsSimboloMoeda() {
        return dsSimboloMoeda;
    }

    public void setDsSimboloMoeda(String dsSimboloMoeda) {
        this.dsSimboloMoeda = dsSimboloMoeda;
    }

    public String getDsSituacao() {
        return dsSituacao;
    }

    public void setDsSituacao(String dsSituacao) {
        this.dsSituacao = dsSituacao;
    }

    public String getDsWebsite() {
        return dsWebsite;
    }

    public void setDsWebsite(String dsWebsite) {
        this.dsWebsite = dsWebsite;
    }

    public String getNmServico() {
        return nmServico;
    }

    public void setNmServico(String nmServico) {
        this.nmServico = nmServico;
    }

    public BigDecimal getVlMensalUsd() {
        return vlMensalUsd;
    }

    public void setVlMensalUsd(BigDecimal vlMensalUsd) {
        this.vlMensalUsd = vlMensalUsd;
    }

    public BigDecimal getVlTotalServico() {
        return vlTotalServico;
    }

    public void setVlTotalServico(BigDecimal vlTotalServico) {
        this.vlTotalServico = vlTotalServico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
