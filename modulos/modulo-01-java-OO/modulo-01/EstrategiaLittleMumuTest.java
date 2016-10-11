import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaLittleMumuTest{
    @Test
    public void ordenarExercitoVazio() throws ElfosDesproporcionalException {
        Estrategia estrategia = new EstrategiaLittleMumu(); 
        List<Elfo> elfos = new ArrayList<>();      
        assertTrue(estrategia.getOrdemDeAtaque(elfos).isEmpty());
    }

    @Test
    public void ordenarUExercitoComApenasUmElfoNoturno()throws ElfosDesproporcionalException{
        Estrategia estrategia = new EstrategiaLittleMumu(); 
        List<Elfo> elfos = new ArrayList<>();
        elfos.add(new ElfoNoturno("Black Legolas"));
        assertTrue(estrategia.getOrdemDeAtaque(elfos).isEmpty());
    }

    @Test
    public void ordenarDoisElfoVerdesEDoisNoturnos() throws ElfosDesproporcionalException{
        Estrategia estrategia = new EstrategiaLittleMumu();
        List<Elfo> elfos = new ArrayList<>();
        elfos.add(new ElfoVerde("Green Legolas", 150));
        elfos.add(new ElfoVerde("Green Galadriel", 45));
        elfos.add(new ElfoNoturno("Black Arwen", 100));
        elfos.add(new ElfoNoturno("Black Legolas", 300));      
        List<Elfo> resultado = estrategia.getOrdemDeAtaque(elfos);
        assertEquals("Green Legolas", resultado.get(0).getNome());
        assertEquals("Black Arwen", resultado.get(1).getNome());
        assertEquals("Green Galadriel", resultado.get(2).getNome());
        assertEquals(3, resultado.size());
    }

    @Test 
    public void ordenarDoisElfosVerdesUmElfoNoturnoVivoEUmMorto() throws ElfosDesproporcionalException{
        Estrategia estrategia = new EstrategiaLittleMumu();
        List<Elfo> elfos = new ArrayList<>();
        elfos.add(new ElfoNoturno("Black Legolas"));
        elfos.add(new ElfoVerde("Green Legolas", 999));
        elfos.add(new ElfoVerde("Green Arwen", 200)); 
        elfos.add(elfoMorto("Legolas Kamikaze")); 
        List<Elfo> resultado = estrategia.getOrdemDeAtaque(elfos);
        assertEquals("Green Legolas", resultado.get(0).getNome());
        assertEquals("Green Arwen", resultado.get(1).getNome());
        assertEquals(2, resultado.size());
    }


    private ElfoNoturno elfoMorto(String nome) {
        ElfoNoturno elfo = new ElfoNoturno(nome, 90);
        for (int i = 0; i < 90; i++){
            elfo.atirarFlecha(new Dwarf());          
        }
        return elfo;
    }
}
