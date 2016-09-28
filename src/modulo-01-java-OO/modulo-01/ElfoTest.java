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
        // Arrange
        Elfo elfoTeste1 = new Elfo ("Legolas 1");
        //Act
        elfoTeste1.atirarFlecha(new Dwarf());
        //Assert
        assertEquals(41, elfoTeste1.getFlecha().getQuantidade()); 
    } 

    @Test
    public void elfoAtiraDezFlechas() {
        //Arrange
        Elfo elfoTeste2 = new Elfo ("Arwen");
        //Act
        int numeroflechasUsadas = 10;
        int numeroFlechasTotal = elfoTeste2.getFlecha().getQuantidade();
        while(numeroflechasUsadas != 0){
            elfoTeste2.atirarFlecha(new Dwarf());
            numeroflechasUsadas--;
            numeroFlechasTotal--;
        }
        //Assert
        assertEquals(numeroFlechasTotal, elfoTeste2.getFlecha().getQuantidade()); 
    } 

    @Test
    public void elfoAtiraTodasAsFlechas() {
        //Arrange
        Elfo elfoTeste3 = new Elfo ("Galadriel");
        //Act
        int numeroFlechasTotal = elfoTeste3.getFlecha().getQuantidade();
        while(numeroFlechasTotal != 0){
            elfoTeste3.atirarFlecha(new Dwarf());
            numeroFlechasTotal --;
        }
        //Assert
        assertEquals(0, numeroFlechasTotal); 
    } 

    @Test
    public void elfoAtacouDwarfUmaVez(){
        //Arrange
        Elfo elfoTeste4 = new Elfo ("Galadriel 1");
        Dwarf dwarfTeste = new Dwarf();
        //Act
        elfoTeste4.atirarFlecha(dwarfTeste);
        //Assert
        assertEquals(100, dwarfTeste.getVida()); 
    }

    @Test
    public void elfoMatouUmDwarf(){
        //Arrange
        Elfo elfoTeste5 = new Elfo ("Galadriel 2");
        Dwarf dwarfTeste2 = new Dwarf();
        //Act
        int flechasUtilizadas = 11;    
        while(flechasUtilizadas > 0){
            elfoTeste5.atirarFlecha(dwarfTeste2);
            flechasUtilizadas--;
        }
        //Assert
        assertEquals(0, dwarfTeste2.getVida()); 
    }

    @Test
    public void statusInicialElfo(){
        //Arrange
        Elfo elfoTeste6 = new Elfo("Legolas");
        //Act & Assert
        assertEquals("Legolas possui 42 flechas e 0 níveis de experiência.", elfoTeste6.toString());
    }

    @Test
    public void statusElfoAtacouUmaVez(){
        //Arrange
        Elfo elfoTeste6 = new Elfo("Legolas");
        //Act
        elfoTeste6.atirarFlecha(new Dwarf());
        //Assert
        assertEquals("Legolas possui 41 flechas e 1 nível de experiência.", elfoTeste6.toString());
    }

    @Test
    public void statusElfoSemFlechas(){
        //Arrange
        Elfo elfoTeste7 = new Elfo("Legolas");
        //Act
        int numeroFlechasTotal = elfoTeste7.getFlecha().getQuantidade();
        while(numeroFlechasTotal != 0){
            elfoTeste7.atirarFlecha(new Dwarf());
            numeroFlechasTotal--;
        }
        //Assert
        assertEquals("Legolas possui 0 flechas e 42 níveis de experiência.", elfoTeste7.toString());
    }

    @Test
    public void elfoComecaComUmaFlecha(){
        //Act
        Elfo elfoTeste8 = new Elfo ("Legolas", 1);
        //Assert
        assertEquals("Flechas", elfoTeste8.getFlecha().getDescricao()); 
        assertEquals(1, elfoTeste8.getFlecha().getQuantidade()); 

    }    

    @Test
    public void elfoComecaComDezFlechas(){  
        //Act
        Elfo elfoTeste9 = new Elfo ("Legolas", 10);
        //Assert
        assertEquals("Flechas", elfoTeste9.getFlecha().getDescricao()); 
        assertEquals(10, elfoTeste9.getFlecha().getQuantidade()); 
    }

    @Test
    public void elfoComecaComDuzentasFlechas(){ 
        //Act
        Elfo elfoTeste10 = new Elfo ("Arwen", 200);
        //Assert
        assertEquals("Flechas", elfoTeste10.getFlecha().getDescricao()); 
        assertEquals(200, elfoTeste10.getFlecha().getQuantidade()); 

    }
    
    @Test
    public void elfoComFlechasNegativas(){ 
        //Act
        Elfo elfoTeste10 = new Elfo ("Arwen", -100);
        //Assert
        assertEquals("Flechas", elfoTeste10.getFlecha().getDescricao()); 
        assertEquals(42, elfoTeste10.getFlecha().getQuantidade()); 

    }   
}