package br.com.cwi.crescer.filmes.views;

import br.com.cwi.crescer.filmes.AtorBean;
import br.com.cwi.crescer.filmes.entidades.Ator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class AtorView{
   
    @EJB
    private AtorBean atorBean;
    
    private Ator ator;
    private List<Ator> atores;

    @PostConstruct
    public void init() {
        this.ator = new Ator();
        this.atores = atorBean.findAll();
        this.atores.sort((a,b)-> a.getId().compareTo(b.getId()));
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public void adicionar() {
        atorBean.insert(ator);
        this.init();       
    }

}

