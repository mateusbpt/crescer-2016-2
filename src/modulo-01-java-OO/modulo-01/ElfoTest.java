import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void elfoNasceComNome() {
        // Arrange
        String nomeEsperado = "Bruce Wayne";
        // Act
        Elfo elfoDoTeste = new Elfo(nomeEsperado);
        // Assert
        assertEquals(nomeEsperado, elfoDoTeste.getNome());
    }

    @Test
    public void elfoNasceComArco() {
        // Act
        Elfo elfoDoTeste = new Elfo("Elrond");
        // Assert
        assertEquals("Arco", elfoDoTeste.getArco().getDescricao());
        assertEquals(1, elfoDoTeste.getArco().getQuantidade());
    }

    @Test
    public void quantidadeDefaultFlechas() {
        //Act
        Elfo elfoTeste = new Elfo ("Legolas");
        //Assert
        assertEquals("Flechas", elfoTeste.getFlecha().getDescricao()); 
        assertEquals(42, elfoTeste.getFlecha().getQuantidade()); 
    }  

    @Test
    public void elfoAtiraUmaFlecha() {
        //Act
        Elfo elfoTeste1 = new Elfo ("Legolas 1");
        elfoTeste1.atirarFlecha();
        //Assert
        assertEquals(41, elfoTeste1.getFlecha().getQuantidade()); 
    } 

    @Test
    public void elfoAtiraDezFlechas() {
        //Act
        Elfo elfoTeste2 = new Elfo ("Arwen");
        int i = 10;
        int num = 42;
        while(i != 0){
            elfoTeste2.atirarFlecha();
            i--;
            num--;
        }
        //Assert
        assertEquals(num, elfoTeste2.getFlecha().getQuantidade()); 
    } 

    @Test
    public void elfoAtiraTodasAsFlechas() {
        //Act
        Elfo elfoTeste3 = new Elfo ("Galadriel");
        int i = elfoTeste3.getFlecha().getQuantidade();
        while(i != 0){
            elfoTeste3.atirarFlecha();
            i--;
        }
        //Assert
        assertEquals(0, i); 
    } 

    @Test
    public void elfoDivideDezLembas() {
        //Act
        CestoDeLembas cesto1 = new CestoDeLembas(10);
        //Assert    
        assertEquals(true, cesto1.podeDividirEmPares()); 

    } 

    @Test
    public void elfoNaoDivideTresLembas() {
        //Act
        CestoDeLembas cesto2 = new CestoDeLembas(3);
        //Assert    
        assertEquals(false, cesto2.podeDividirEmPares()); 

    } 

    @Test
    public void elfoAtacouDwarvesUmaVez(){
        //Act
        Elfo elfoTeste4 = new Elfo ("Galadriel 1");
        elfoTeste4.atacarDwarves();
        //Assert
        assertEquals(100, elfoTeste4.getDwarves()); 
    }

    @Test
    public void elfoMatouDwarves(){
        //Act
        Elfo elfoTeste5 = new Elfo ("Galadriel 2");
        int i = 11;    
        while(i > 0){
            elfoTeste5.atacarDwarves();
            i--;
        }
        //Assert
        assertEquals(0, elfoTeste5.getDwarves()); 
    }
}    