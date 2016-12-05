package br.com.cwi.crescer.aula8.services;

import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.repository.PessoaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mateus.teixeira
 */
@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository auxiliar;
 
    public Iterable<Pessoa> listAll(){
        return auxiliar.findAll();
    }
    
    public void add(Pessoa p){
        auxiliar.save(p);
    }
    
}
