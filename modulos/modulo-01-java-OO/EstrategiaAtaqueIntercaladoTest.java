import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaAtaqueIntercaladoTest{

    @Test
    public void ordenarExercitoVazio() throws ElfosDesproporcionalException{
        Estrategia estrategia = new EstrategiaAtaqueIntercalado(); 
        List<Elfo> elfos = new ArrayList<>();      
        assertTrue(estrategia.getOrdemDeAtaque(elfos).isEmpty());
    }

    @Test(expected=ElfosDesproporcionalException.class)
    public void ordenarUExercitoComApenasUmElfo() throws ElfosDesproporcionalException{
        Estrategia estrategia = new EstrategiaAtaqueIntercalado(); 
        List<Elfo> elfos = new ArrayList<>();
        elfos.add(new ElfoNoturno("Black Legolas"));
        assertTrue(estrategia.getOrdemDeAtaque(elfos).isEmpty());
    }

    @Test
    public void ordenarDoisElfoVerdesEDoisNoturnos() throws ElfosDesproporcionalException{
        Estrategia estrategia = new EstrategiaAtaqueIntercalado();
        List<Elfo> elfos = new ArrayList<>();
        elfos.add(new ElfoVerde("Green Legolas"));
        elfos.add(new ElfoVerde("Green Galadriel"));
        elfos.add(new ElfoNoturno("Black Arwen"));
        elfos.add(new ElfoNoturno("Black Legolas"));      
        List<Elfo> resultado = estrategia.getOrdemDeAtaque(elfos);
        assertTrue(resultado.get(0) instanceof ElfoVerde);
        assertTrue(resultado.get(1) instanceof ElfoNoturno);
        assertTrue(resultado.get(2) instanceof ElfoVerde);
        assertTrue(resultado.get(3) instanceof ElfoNoturno);
    }

    @Test (expected=ElfosDesproporcionalException.class)
    public void ordenarDoisElfosVerdesUmElfoNoturnoVivoEUmMorto() throws ElfosDesproporcionalException{
        Estrategia estrategia = new EstrategiaAtaqueIntercalado();
        List<Elfo> elfos = new ArrayList<>();
        elfos.add(new ElfoNoturno("Black Legolas"));
        elfos.add(new ElfoVerde("Green Legolas"));
        elfos.add(new ElfoVerde("Green Arwen")); 
        elfos.add(elfoMorto("Elfo Fraco")); 
        assertTrue(estrategia.getOrdemDeAtaque(elfos).isEmpty());
    }
    
    @Test
    public void ordenarDoisElfoVerdesDoisNoturnosEUmMorto() throws ElfosDesproporcionalException{
        Estrategia estrategia = new EstrategiaAtaqueIntercalado();
        List<Elfo> elfos = new ArrayList<>();
        elfos.add(new ElfoVerde("Green Legolas"));
        elfos.add(new ElfoVerde("Green Galadriel"));
        elfos.add(elfoMorto("Legolas Kamikaze"));
        elfos.add(new ElfoNoturno("Black Arwen"));
        elfos.add(new ElfoNoturno("Black Legolas"));       
        List<Elfo> resultado = estrategia.getOrdemDeAtaque(elfos);
        assertTrue(resultado.get(0) instanceof ElfoVerde);
        assertTrue(resultado.get(1) instanceof ElfoNoturno);
        assertTrue(resultado.get(2) instanceof ElfoVerde);
        assertTrue(resultado.get(3) instanceof ElfoNoturno);
    }
    
    private ElfoNoturno elfoMorto(String nome) {
        ElfoNoturno elfo = new ElfoNoturno(nome, 90);
        for (int i = 0; i < 90; i++){
            elfo.atirarFlecha(new Dwarf());          
        }
        return elfo;
    }
}
