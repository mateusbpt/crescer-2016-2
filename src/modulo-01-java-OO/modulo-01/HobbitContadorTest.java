import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HobbitContadorTest{

    @Test
    public void calculaMMC72e120(){
        //Arrange
        HobbitContador frodo = new HobbitContador();  
        //Act & Assert
        assertEquals(360, frodo.calculaMMC(72,120));
    }
    
    @Test
    public void calculaMMC2e4(){
        //Arrange
        HobbitContador frodo = new HobbitContador();  
        //Act & Assert
        assertEquals(4, frodo.calculaMMC(2,4));
    }
    
    @Test
    public void calculaMMC100e18(){
        //Arrange
        HobbitContador frodo = new HobbitContador();  
        //Act & Assert
        assertEquals(9000, frodo.calculaMMC(1000,18));
    }
    
    @Test
    public void calculaMMC0e0(){
        //Arrange
        HobbitContador frodo = new HobbitContador();  
        //Act & Assert
        assertEquals(0, frodo.calculaMMC(0,0));
    }
}