import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CestoDeLembasTest
{
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
}
