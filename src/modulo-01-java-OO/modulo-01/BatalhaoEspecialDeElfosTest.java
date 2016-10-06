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

    //Aqui está o bug
    @Test
    public void buscarElfoNoBatalhaoPeloNomeTendoVariosComOMesmoNome() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoNoturno = new ElfoNoturno("Black Legolas");
        Elfo elfoNoturno1 = new ElfoNoturno("Black Legolas");
        Elfo elfoNoturno2 = new ElfoNoturno("Black Legolas");
        batalhao.alistarElfo(elfoNoturno);
        batalhao.alistarElfo(elfoNoturno1);
        batalhao.alistarElfo(elfoNoturno2);
        assertEquals(elfoNoturno2, batalhao.buscarPeloNome("Black Legolas"));
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
        assertEquals(elfoNoturno, resultado.get(0));
        assertEquals(elfoVerde, resultado.get(1));
        assertEquals(elfoVerde1, resultado.get(2));
    }

    private ElfoNoturno elfoMorto() {
        ElfoNoturno elfo = new ElfoNoturno("Legolas kamikaze", 90);
        for (int i = 0; i < 90; i++){
            elfo.atirarFlecha(new Dwarf());          
        }
        return elfo;
    }
    //TO-DO: ainda faltam Testes para o método buscarPorStatus
}
