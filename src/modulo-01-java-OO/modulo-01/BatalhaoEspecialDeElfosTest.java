import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class BatalhaoEspecialDeElfosTest {
    @After
    public void tearDown() {
        System.gc();
    }

    @Test
    public void alistarUmElfoVerdeAoBatalhaoEspecial() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoVerde = new ElfoVerde("Green Legolas");
        batalhao.alistarElfo(elfoVerde);
        assertEquals(elfoVerde, batalhao.getExercitoDeElfosArray()[0]);
        assertTrue(batalhao.getExercitoDeElfos().containsValue(elfoVerde));
    }

    @Test
    public void alistarUmElfoNoturnoAoBatalhaoEspecial() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoNoturno = new ElfoNoturno("Black Legolas");
        batalhao.alistarElfo(elfoNoturno);
        assertEquals(elfoNoturno, batalhao.getExercitoDeElfosArray()[0]);
        assertTrue(batalhao.getExercitoDeElfos().containsValue(elfoNoturno));
    }

    @Test
    public void alistarUmElfoNormalAoBatalhaoEspecial() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfo = new Elfo("Legolas");
        batalhao.alistarElfo(elfo);
        assertEquals(0, batalhao.getExercitoDeElfosArray().length);
        assertFalse(batalhao.getExercitoDeElfos().containsValue(elfo));
    }

    @Test
    public void alistarDosTresTiposSoEntramVerdesENoturnosAoBatalhoEspecial() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoVerde = new ElfoVerde("Green Legolas");
        Elfo elfo = new Elfo("Legolas");
        Elfo elfoNoturno = new ElfoNoturno("Black Legolas");
        batalhao.alistarElfo(elfoVerde);
        batalhao.alistarElfo(elfo);
        batalhao.alistarElfo(elfoNoturno);
        assertFalse(batalhao.getExercitoDeElfos().containsValue(elfo));
        assertTrue(batalhao.getExercitoDeElfos().containsValue(elfoVerde));
        assertTrue(batalhao.getExercitoDeElfos().containsValue(elfoNoturno));
    }

    @Test
    public void buscarElfoNoBatalhaoPeloNome() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoVerde = new ElfoVerde("Green Legolas");
        Elfo elfo = new Elfo("Legolas");
        Elfo elfoNoturno = new ElfoNoturno("Black Legolas");
        batalhao.alistarElfo(elfoVerde);
        batalhao.alistarElfo(elfo);
        batalhao.alistarElfo(elfoNoturno);
        assertEquals(elfoNoturno, batalhao.buscarPeloNome("Black Legolas"));
        assertNull(batalhao.buscarPeloNome(elfo.getNome()));
    }

    @Test
    public void buscarElfoNoBatalhaoPeloNomeTendoVariosComOMesmoNome() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoNoturno = new ElfoNoturno("Black Legolas");
        Elfo elfoNoturno1 = new ElfoNoturno("Black Legolas");
        Elfo elfoNoturno2 = new ElfoNoturno("Black Legolas");
        batalhao.alistarElfo(elfoNoturno);
        batalhao.alistarElfo(elfoNoturno1);
        batalhao.alistarElfo(elfoNoturno2);
        assertEquals(elfoNoturno, batalhao.buscarPeloNome("Black Legolas"));
    }

    @Test
    public void buscarPorStatusVivo() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoVerde = new ElfoVerde("Green Legolas");
        Elfo elfoNoturno = new ElfoNoturno("Black Legolas");
        Elfo elfoVerde1 = new ElfoVerde("Green Legolas 2");
        batalhao.alistarElfo(elfoNoturno);
        batalhao.alistarElfo(elfoVerde);
        batalhao.alistarElfo(elfoVerde1);
        ArrayList<Elfo> resultado = batalhao.buscarPeloStatus(Status.VIVO);
        assertEquals(3, resultado.size());
        assertTrue(resultado.contains(elfoNoturno));
        assertTrue(resultado.contains(elfoVerde));
        assertTrue(resultado.contains(elfoVerde1));
    }

    @Test
    public void buscarPorStatusMorto() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoVerde = new ElfoVerde("Green Legolas");
        Elfo elfoNoturno = new ElfoNoturno("Black Legolas");
        Elfo elfoVerde1 = new ElfoVerde("Green Legolas 2");
        batalhao.alistarElfo(elfoNoturno);
        batalhao.alistarElfo(elfoVerde);
        batalhao.alistarElfo(elfoVerde1);
        ArrayList<Elfo> resultado = batalhao.buscarPeloStatus(Status.MORTO);
        assertEquals(0, resultado.size());
        assertFalse(resultado.contains(elfoNoturno));
        assertFalse(resultado.contains(elfoVerde));
        assertFalse(resultado.contains(elfoVerde1));
    }
    
    @Test
    public void buscarPorStatusVivoSemElfosVivos() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoNoturno = elfoMorto();
        batalhao.alistarElfo(elfoNoturno);
        ArrayList<Elfo> resultado = batalhao.buscarPeloStatus(Status.MORTO);
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(elfoNoturno));
    }
    
    @Test
    public void buscarPorStatusMortoSemElfosMortos() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoVerde = new ElfoVerde("Green Legolas");
        Elfo elfoNoturno = new ElfoNoturno("Black Legolas");
        Elfo elfoVerde1 = new ElfoVerde("Green Legolas 2");
        batalhao.alistarElfo(elfoNoturno);
        batalhao.alistarElfo(elfoVerde);
        batalhao.alistarElfo(elfoVerde1);
        assertTrue(batalhao.buscarPeloStatus(Status.MORTO).isEmpty());
    }
       
    @Test
    public void buscarPorStatusMortoComElfosMortos() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoNoturno = elfoMorto();
        batalhao.alistarElfo(elfoNoturno);
        assertTrue(batalhao.buscarPeloStatus(Status.VIVO).isEmpty());
    }
    
    private ElfoNoturno elfoMorto() {
        ElfoNoturno elfo = new ElfoNoturno("Legolas kamikaze", 90);
        for (int i = 0; i < 90; i++){
            elfo.atirarFlecha(new Dwarf());          
        }
        return elfo;
    }
}
