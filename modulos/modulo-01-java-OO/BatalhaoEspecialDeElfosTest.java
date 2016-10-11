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
        assertEquals(elfoVerde, batalhao.getExercitoDeElfos()[0]);
    }

    @Test
    public void alistarUmElfoNoturnoAoBatalhaoEspecial() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoNoturno = new ElfoNoturno("Black Legolas");
        batalhao.alistarElfo(elfoNoturno);
        assertEquals(elfoNoturno, batalhao.getExercitoDeElfos()[0]);
    }

    @Test
    public void alistarUmElfoNormalAoBatalhaoEspecial() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfo = new Elfo("Legolas");
        batalhao.alistarElfo(elfo);
        assertEquals(0, batalhao.getExercitoDeElfos().length);
    }

    @Test
    public void alistarDosTresTiposSoEntramVerdesENoturnosAoBatalhaoEspecial() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoVerde = new ElfoVerde("Green Legolas");
        Elfo elfo = new Elfo("Legolas");
        Elfo elfoNoturno = new ElfoNoturno("Black Legolas");
        batalhao.alistarElfo(elfoVerde);
        batalhao.alistarElfo(elfo);
        batalhao.alistarElfo(elfoNoturno);
        Elfo[] elfos = batalhao.getExercitoDeElfos();
        assertFalse(contem(elfos, elfo));
        assertTrue(contem(elfos, elfoVerde));
        assertTrue(contem(elfos, elfoNoturno));
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
    }

    @Test
    public void buscarElfoNoBatalhaoPeloNomeQueNaoExiste() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoVerde = new ElfoVerde("Green Legolas");
        Elfo elfo = new Elfo("Legolas");
        Elfo elfoNoturno = new ElfoNoturno("Black Legolas");
        batalhao.alistarElfo(elfoVerde);
        batalhao.alistarElfo(elfo);
        batalhao.alistarElfo(elfoNoturno);
        assertEquals(null, batalhao.buscarPeloNome("Legolas"));
    }

    @Test
    public void buscarElfoNoBatalhaoPeloNomeTendoVariosComOMesmoNome() {
        BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoNoturno = new ElfoNoturno("Black Legolas",60);
        Elfo elfoNoturno1 = new ElfoNoturno("Black Legolas",34);
        Elfo elfoNoturno2 = new ElfoNoturno("Black Legolas",150);
        batalhao.alistarElfo(elfoNoturno);
        batalhao.alistarElfo(elfoNoturno1);
        batalhao.alistarElfo(elfoNoturno2);
        assertEquals(elfoNoturno, batalhao.buscarPeloNome("Black Legolas"));
    }

    private boolean contem(Elfo[]elfos, Elfo elfo){
        int auxiliar = 0;
        while(auxiliar < elfos.length){
            if(elfos[auxiliar].equals(elfo)){
                return true;
            }
            auxiliar++;
        }  
        return false;
    }

    /** to-do: Ajustar esses testes

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
    Elfo elfoNoturno = elfoMorto("Elfo Kamikaze");
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
    public void buscarPorStatusVivoComElfosMortos() {
    BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
    Elfo elfoNoturno = elfoMorto("Kamikaze Legolas");
    batalhao.alistarElfo(elfoNoturno);
    assertTrue(batalhao.buscarPeloStatus(Status.VIVO).isEmpty());
    }

    @Test
    public void buscarPorStatusMortoComElfosMortos() {
    BatalhaoEspecialDeElfos batalhao = new BatalhaoEspecialDeElfos();
    Elfo elfoNoturno = elfoMorto("Kamikaze Legolas");
    Elfo elfoNoturno1 = elfoMorto("Kamikaze Legolas 2");
    batalhao.alistarElfo(elfoNoturno);
    batalhao.alistarElfo(elfoNoturno1);
    ArrayList<Elfo> resultado = batalhao.buscarPeloStatus(Status.MORTO);
    assertEquals(2, resultado.size());
    assertTrue(resultado.contains(elfoNoturno));
    assertTrue(resultado.contains(elfoNoturno1));
    }

    private ElfoNoturno elfoMorto(String nome) {
    ElfoNoturno elfo = new ElfoNoturno(nome, 90);
    for (int i = 0; i < 90; i++){
    elfo.atirarFlecha(new Dwarf());          
    }
    return elfo;
    }

     **/

}
