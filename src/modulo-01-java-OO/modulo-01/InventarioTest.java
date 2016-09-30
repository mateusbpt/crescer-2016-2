import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest {

    @Test
    public void imprime3itens() {
        //Arrange
        Inventario inventario = new Inventario();
        Item arma1 = new Item("Machado", 1);
        Item arma2 = new Item("Faca", 1);
        Item arma3 = new Item("Espada", 1);
        //Act
        inventario.adicionarItem(arma1);
        inventario.adicionarItem(arma2);
        inventario.adicionarItem(arma3);
        //Assert
        assertEquals("Machado, Faca, Espada", inventario.getDescricoesItens()); 
    }    

    @Test
    public void imprime2itensRemovendo1() {
        //Arrange
        Inventario inventario = new Inventario();
        Item arma1 = new Item("Machado", 1);
        Item arma2 = new Item("Faca", 1);
        Item arma3 = new Item("Espada", 1);
        //Act
        inventario.adicionarItem(arma1);
        inventario.adicionarItem(arma2);
        inventario.adicionarItem(arma3);
        inventario.removerItem(arma2);
        //Assert
        assertEquals("Machado, Espada", inventario.getDescricoesItens()); 
    } 

    @Test
    public void imprime4itensRemovendo3() {
        //Arrange
        Inventario inventario = new Inventario();
        Item arma1 = new Item("Machado", 1);
        Item arma2 = new Item("Faca", 1);
        Item arma3 = new Item("Espada", 1);
        Item arma4 = new Item("Arco", 1);
        Item arma5 = new Item("Foice", 1);
        Item arma6 = new Item("Adaga", 1);
        //Act
        inventario.adicionarItem(arma1);
        inventario.adicionarItem(arma2);
        inventario.adicionarItem(arma3);
        inventario.removerItem(arma2);
        inventario.adicionarItem(arma4);
        inventario.adicionarItem(arma2);
        inventario.removerItem(arma3);
        inventario.adicionarItem(arma5);
        inventario.removerItem(arma1);
        inventario.adicionarItem(arma6);
        //Assert
        assertEquals("Arco, Faca, Foice, Adaga", inventario.getDescricoesItens()); 
    }      

    @Test    
    public void inventarioVazio(){
    //Arrange
    Inventario inventario = new Inventario();
    //Act & Assert
    assertEquals(null, inventario.getDescricoesItens());
    }
}
