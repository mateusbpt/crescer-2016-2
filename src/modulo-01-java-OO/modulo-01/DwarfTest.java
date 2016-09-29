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
        DataTerceiraEra data = new DataTerceiraEra (25, 12, 2000);
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

        //Assert
        assertEquals(-3333, (int)dwarf1.getNumeroSorte()); //para assertEquals double era necessário 3 parâmetros
    }

    @Test
    public void numeroSorteDwarfSeixas(){
        //Arrange
        DataTerceiraEra data = new DataTerceiraEra (12, 01, 1997);
        Dwarf dwarf1 = new Dwarf("Seixas", data);
        //Act & Assert
        assertEquals(33, (int)dwarf1.getNumeroSorte()); //para assertEquals double era necessário 3 parâmetros
    }

    @Test
    public void numeroSorteDwarf(){
        //Arrange
        DataTerceiraEra data = new DataTerceiraEra (12, 01, 2000);
        Dwarf dwarf1 = new Dwarf("Seixas", data);
        //Act & Assert
        assertEquals(101, (int)dwarf1.getNumeroSorte()); //para assertEquals double era necessário 3 parâmetros
    }
}

