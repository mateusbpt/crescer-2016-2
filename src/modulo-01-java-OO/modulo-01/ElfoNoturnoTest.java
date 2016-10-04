import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest {

    @Test
    public void elfoNoturnoAtacaUmaVez(){
        //Arrange
        Dwarf dwarf = new Dwarf();
        ElfoNoturno elfo = new ElfoNoturno("Black Legolas");
        //Act
        elfo.atirarFlecha(dwarf);
        //Assert
        assertEquals(3, elfo.getExperiencia());
        assertEquals(95.0, elfo.getVida(), .0);
    }
    
    
    @Test
    public void elfoNoturnoAtacaDuasVezes(){
        //Arrange
        Dwarf dwarf = new Dwarf();
        ElfoNoturno elfo = new ElfoNoturno("Black Legolas");
        //Act
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        //Assert
        assertEquals(6, elfo.getExperiencia());
        assertEquals(90.25, elfo.getVida(), .0);
    }
    
    @Test
    public void elfoNoturnoNaoAtaca(){
        //Arrange
        Dwarf dwarf = new Dwarf();
        ElfoNoturno elfo = new ElfoNoturno("Black Legolas");
        //Act & Assert
        assertEquals(0, elfo.getExperiencia());
        assertEquals(100.0, elfo.getVida(), .0);
    }
    
    @Test
    public void elfoNoturnoAtaca90Vezes(){
        //Arrange
        Dwarf dwarf = new Dwarf();
        ElfoNoturno elfo = new ElfoNoturno("Black Legolas", 150);
        //Act
        int auxiliar = 90;
        while(auxiliar != 0){
        elfo.atirarFlecha(dwarf);    
        auxiliar--;
        }    
        //Assert
        assertEquals(270, elfo.getExperiencia());
        assertEquals(Status.MORTO, elfo.getStatus());
    }
}
