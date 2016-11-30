
package br.com.cwi.crescer.aula5;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Hello {

    private Pessoa pessoa = new Pessoa();

    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public void setPessoa(Pessoa p){
        this.pessoa = p;
    }
    
    

}