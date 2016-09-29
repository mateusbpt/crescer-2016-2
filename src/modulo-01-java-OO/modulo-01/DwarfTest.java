import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest {

    @Test
    public void dwarfNasce110Vida(){
        DataTerceiraEra data = new DataTerceiraEra (25, 12, 2000);
        Dwarf dwarf1 = new Dwarf("Thorin", data);
        assertEquals(110, dwarf1.getVida());
    }

    @Test
    public void dwarfPerdeVidaUmaVez(){
        DataTerceiraEra data = new DataTerceiraEra (25, 12, 2000);
        Dwarf dwarf = new Dwarf("Thorin", data);
        dwarf.perderVida();
        assertEquals(100, dwarf.getVida());
    }

    @Test
    public void dwarfPerdeVidaDezVezes(){
        DataTerceiraEra data = new DataTerceiraEra (25, 12, 2001);
        Dwarf dwarf = new Dwarf("Thorin", data);
        int ataqueDwarf = 10;
        while(ataqueDwarf != 0){
            dwarf.perderVida();
            ataqueDwarf--;
        }
        assertEquals(10, dwarf.getVida());
    }

    @Test
    public void numeroSorteDwarfBissexto(){
        //Arrange
        DataTerceiraEra data = new DataTerceiraEra (25, 12, 2000);
        Dwarf dwarf1 = new Dwarf("Thorin", data);

        //Act
        dwarf1.perderVida();
        dwarf1.perderVida();
        dwarf1.perderVida();

        //Assert
        assertEquals(-3333.0 ,dwarf1.getNumeroSorte(), .0); 
        assertEquals(2, dwarf1.getExperiencia());
    }

    @Test
    public void numeroSorteDwarfSeixas(){
        //Arrange
        DataTerceiraEra data = new DataTerceiraEra (12, 01, 1997);
        Dwarf dwarf1 = new Dwarf("Seixas", data);
        //Act & Assert
        assertEquals(33.0, dwarf1.getNumeroSorte(), .0);
        assertEquals(110, dwarf1.getVida());
        assertEquals(0, dwarf1.getExperiencia());
    }

    @Test
    public void numeroSorteDwarf(){
        //Arrange
        DataTerceiraEra data = new DataTerceiraEra (12, 01, 2000);
        Dwarf dwarf1 = new Dwarf("Seixas", data);
        //Act 
        dwarf1.perderVida();
        //Assert
        assertEquals(101.0, dwarf1.getNumeroSorte(), .0);
        assertEquals(100, dwarf1.getVida());
    }

    @Test
    public void numeroStatusVivo(){
        //Arrange
        DataTerceiraEra data = new DataTerceiraEra (12, 01, 1997);
        Dwarf dwarf1 = new Dwarf("Seixas", data); 
        //Act & Assert
        assertEquals(Status.VIVO, dwarf1.getStatus());
    }

    @Test
    public void numeroStatusMorto(){
        //Arrange
        Dwarf dwarf1 = new Dwarf(); 
        //Act 
        int ataque = 11;
        while(ataque != 0){
            dwarf1.perderVida();
            ataque--;
        }
        //Assert
        assertEquals(0, dwarf1.getVida());
        assertEquals(Status.MORTO, dwarf1.getStatus());
    }

    @Test
    public void vidaDwarfApos12Ataques(){
        //Arrange
        Dwarf dwarf1 = new Dwarf(); 
        //Act 
        int ataque = 12;
        while(ataque != 0){
            dwarf1.perderVida();
            ataque--;
        }
        //Assert
        assertEquals(Status.MORTO, dwarf1.getStatus());
        assertEquals(0, dwarf1.getVida());
    }

    @Test
    public void vidaDwarfApos5Ataques(){
        //Arrange
        Dwarf dwarf1 = new Dwarf(); 
        //Act 
        int ataque = 5;
        while(ataque != 0){
            dwarf1.perderVida();
            ataque--;
        }
        //Assert
        assertEquals(Status.VIVO, dwarf1.getStatus());
        assertEquals(60, dwarf1.getVida());
    }
}

