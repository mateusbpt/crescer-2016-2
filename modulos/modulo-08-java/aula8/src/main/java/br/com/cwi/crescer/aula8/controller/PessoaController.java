/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mateus.teixeira
 */
@RestController
public class PessoaController {
    
    @Autowired
    PessoaService pessoa;
    
    @RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public Iterable<Pessoa> list(){
        return pessoa.listAll();
    }
    
    @RequestMapping(value = "/pessoa", method = RequestMethod.POST)
    public Iterable<Pessoa> list(@RequestBody Pessoa p) {
    pessoa.add(p);
    return pessoa.listAll();
}
    
    
}


