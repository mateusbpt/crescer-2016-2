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
    public void elfoFlechas() {
    //Act
    Elfo elfoDasFlechas = new Elfo ("Legolas");
    //Assert
    assertEquals(42, elfoDasFlechas.getFlecha().getQuantidade()); 
    }  
    
    @Test
    public void elfoPerdeFlechas() {
    //Act
    Elfo elfoPerdeFlechas = new Elfo ("Legolas");
    elfoPerdeFlechas.atirarFlecha();
    //Assert
    assertEquals(41, elfoPerdeFlechas.getFlecha().getQuantidade()); 
    } 
    
    @Test
    public void elfoPerdeFlechas2() {
    //Act
    Elfo elfoPerdeFlechas2 = new Elfo ("Legolas 2");
    int i = 5;
    int num = 42;
    while(i != 0){
    elfoPerdeFlechas2.atirarFlecha();
    i--;
    num--;
    }
    //Assert
    assertEquals(num, elfoPerdeFlechas2.getFlecha().getQuantidade()); 
    } 
    
    @Test
    public void elfoPerdeFlechas3() {
    //Act
    Elfo elfoPerdeFlechas3 = new Elfo ("Legolas 3");
    int i = 5;
    int num = 42;
    while(i != 0){
    elfoPerdeFlechas3.atirarFlecha();
    elfoPerdeFlechas3.atirarFlecha();
    i--;
    num = num-2;
    }
    //Assert
    assertEquals(num, elfoPerdeFlechas3.getFlecha().getQuantidade()); 
    } 
    
}