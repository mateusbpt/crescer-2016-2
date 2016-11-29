package br.com.cwi.crescer.aula3.exercicios.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENCY_EXCHANGE")
public class CurrencyExchange implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CURRENCY_EXCHANGE")
    @SequenceGenerator(name = "SEQ_CURRENCY_EXCHANGE", sequenceName = "SEQ_CURRENCY_EXCHANGE", allocationSize = 1)
    @Column(name = "ID_CURRENCY_EXCHANGE")
    private Long idCurrencyExchange;

    @Column(name = "DS_COIN")
    private String dsCoin;

    @Column(name = "DT_CURRENCY_EXCHANGE")
    private byte[] dtCurrencyExchange;

    @Column(name = "VL_RATE", precision = 17, scale = 6)
    private BigDecimal vlRate;

    public Long getIdCurrencyExchange() {
        return idCurrencyExchange;
    }

    public void setIdCurrencyExchange(Long idCurrencyExchange) {
        this.idCurrencyExchange = idCurrencyExchange;
    }

    public String getDsCoin() {
        return dsCoin;
    }

    public void setDsCoin(String dsCoin) {
        this.dsCoin = dsCoin;
    }

    public byte[] getDtCurrencyExchange() {
        return dtCurrencyExchange;
    }

    public void setDtCurrencyExchange(byte[] dtCurrencyExchange) {
        this.dtCurrencyExchange = dtCurrencyExchange;
    }

    public BigDecimal getVlRate() {
        return vlRate;
    }

    public void setVlRate(BigDecimal vlRate) {
        this.vlRate = vlRate;
    }
}
