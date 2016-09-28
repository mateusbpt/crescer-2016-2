import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest {

    @Test
    public void dwarfNasce110Vida(){
        Dwarf dwarf = new Dwarf();
        assertEquals(110, dwarf.getVida());
    }

    @Test
    public void dwarfPerdeVidaUmaVez(){
        Dwarf dwarf = new Dwarf();
        dwarf.perderVida();
        assertEquals(100, dwarf.getVida());
    }

    @Test
    public void dwarfPerdeVidaDezVezes(){
        Dwarf dwarf = new Dwarf();
        int ataqueDwarf = 10;
        while(ataqueDwarf != 0){
            dwarf.perderVida();
            ataqueDwarf--;
        }
        assertEquals(10, dwarf.getVida());
    }

}