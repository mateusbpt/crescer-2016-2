import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaOrdenacaoDeElfosTest {
    @Test
    public void ordena3ElfosVerdes2ElfosNoturnos(){
        ArrayList<Elfo> elfos = new ArrayList<>();
        EstrategiaOrdenacaoDeElfos elfosOrdenados = new EstrategiaOrdenacaoDeElfos();

        elfos.add(new ElfoVerde("Legolas"));
        elfos.add(new ElfoVerde("Legolas2"));
        elfos.add(new ElfoNoturno("Legolas3"));
        elfos.add(new ElfoNoturno("Legolas4"));
        elfos.add(new ElfoVerde("Legolas5"));
        List<Elfo> ordenada = elfosOrdenados.getOrdemDeAtaque(elfos);

        assertEquals(5, ordenada.size());
        assertTrue(ordenada.get(0) instanceof ElfoVerde);
        assertTrue(ordenada.get(1) instanceof ElfoVerde);
        assertTrue(ordenada.get(2) instanceof ElfoVerde);
        assertTrue(ordenada.get(3) instanceof ElfoNoturno);
        assertTrue(ordenada.get(4) instanceof ElfoNoturno);
    }

    @Test
    public void ordena3ElfosVerdes2ElfosNoturnosMortos(){
        ArrayList<Elfo> elfos = new ArrayList<>();
        EstrategiaOrdenacaoDeElfos elfosOrdenados = new EstrategiaOrdenacaoDeElfos();

        elfos.add(new ElfoVerde("Legolas"));
        elfos.add(new ElfoVerde("Legolas2"));
        elfos.add(elfoMorto("Legolas3"));
        elfos.add(elfoMorto("Legolas4"));
        elfos.add(new ElfoVerde("Legolas5"));
        List<Elfo> ordenada = elfosOrdenados.getOrdemDeAtaque(elfos);

        assertEquals(3, ordenada.size());
        assertTrue(ordenada.get(0) instanceof ElfoVerde);
        assertTrue(ordenada.get(1) instanceof ElfoVerde);
        assertTrue(ordenada.get(2) instanceof ElfoVerde);
    }

    private ElfoNoturno elfoMorto(String nome) {
        ElfoNoturno elfo = new ElfoNoturno(nome, 90);
        for (int i = 0; i < 90; i++){
            elfo.atirarFlecha(new Dwarf());          
        }
        return elfo;
    }

}