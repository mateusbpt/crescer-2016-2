import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest{

    @Test
    public void adicionarEspadaDeAco(){
        //Arrange
        ElfoVerde elfo = new ElfoVerde("Legolas");
        //Act
        elfo.ganharItem(new Item("Espada de aço valiriano", 1));
        //Assert
        assertEquals("Espada de aço valiriano", elfo.getInventario().getItens().get(2).getDescricao());
    }

    @Test
    public void adicionarArcoEFlechaDeVidro(){
        //Arrange
        ElfoVerde elfo = new ElfoVerde("Legolas");
        //Act
        elfo.ganharItem(new Item("Arco e Flecha de Vidro", 1));
        //Assert
        assertEquals("Arco e Flecha de Vidro", elfo.getInventario().getItens().get(2).getDescricao());
    }

    @Test
    public void adicionarArcoEFlechaDeOuroEVidro(){
        //Arrange
        ElfoVerde elfo = new ElfoVerde("Legolas");
        //Act
        elfo.ganharItem(new Item("Arco e Flecha de Ouro", 1));
        elfo.ganharItem(new Item("Arco e Flecha de Vidro", 1));
        //Assert
        assertEquals("Arco e Flecha de Vidro", elfo.getInventario().getItens().get(2).getDescricao());
    }

    @Test
    public void elfoVerdeAtacaUmaVez(){
        //Arrange
        Dwarf dwarf = new Dwarf();
        ElfoVerde elfo = new ElfoVerde("Green Legolas");
        //Act
        elfo.atirarFlecha(dwarf);
        //Assert
        assertEquals(2, elfo.getExperiencia());
    }

    @Test
    public void elfoVerdeAtacaTodasAsFlechas(){
        //Arrange
        Dwarf dwarf = new Dwarf();
        ElfoVerde elfo = new ElfoVerde("Green Legolas");
        //Act
        int auxiliar = 42;
        while(auxiliar != 0){
            elfo.atirarFlecha(dwarf);
            auxiliar --;
        }
        //Assert
        assertEquals(84, elfo.getExperiencia());
    }
    
    @Test
    public void elfoVerdeNaoAtaca(){
        //Arrange
        Dwarf dwarf = new Dwarf();
        ElfoVerde elfo = new ElfoVerde("Green Legolas");
        //Act & Assert
        assertEquals(0, elfo.getExperiencia());
    }
    
    @Test
    public void elfoVerdeAtacaMaisFlechasDoQuePossui(){
        //Arrange
        Dwarf dwarf = new Dwarf();
        ElfoVerde elfo = new ElfoVerde("Green Legolas");
        //Act
        int auxiliar = 90;
        while(auxiliar != 0){
            elfo.atirarFlecha(dwarf);
            auxiliar --;
        }
        //Assert
        assertEquals(84, elfo.getExperiencia());
    }
}