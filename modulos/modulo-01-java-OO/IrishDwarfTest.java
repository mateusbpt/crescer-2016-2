import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    @Test
    public void irishDwarfComSorte() {
        IrishDwarf dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.ganharItem(new Item("Pint de Guinness",5));
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.tentarSorte();
        assertEquals(15005, dwarf.getInventario().getItens().get(0).getQuantidade());
    }

    @Test
    public void irishDwarfQuantidadeNegativaComSorte() {
        IrishDwarf dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.ganharItem(new Item("Pint de Guinness", -5));
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.tentarSorte();
        assertEquals(14995, dwarf.getInventario().getItens().get(0).getQuantidade());
    }
    
    @Test
    public void irishDwarfComSorteSemQuantidadeItem() {
        IrishDwarf dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.ganharItem(new Item("Pint de Guinness",0));
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.tentarSorte();
        assertEquals(0, dwarf.getInventario().getItens().get(0).getQuantidade());
    }
    
    @Test
    public void irishDwarfComSorteEVariosItens() {
        IrishDwarf dwarf = new IrishDwarf("Pete 'O Murphy", new DataTerceiraEra(1, 1, 2000));
        dwarf.ganharItem(new Item("Machado",12));
        dwarf.ganharItem(new Item("Pint de Guinness",5));
        dwarf.ganharItem(new Item("Elmo",2));
        dwarf.ganharItem(new Item("Moedas de Ouro", 35)); 
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.tentarSorte();
        assertEquals(78012, dwarf.getInventario().getItens().get(0).getQuantidade());
        assertEquals(15005, dwarf.getInventario().getItens().get(1).getQuantidade());
        assertEquals(3002, dwarf.getInventario().getItens().get(2).getQuantidade());
        assertEquals(630035, dwarf.getInventario().getItens().get(3).getQuantidade());
    }
}
