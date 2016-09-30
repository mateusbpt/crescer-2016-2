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
        assertEquals("Machado,Faca,Espada", inventario.getDescricoesItens()); 
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
        assertEquals("Machado,Espada", inventario.getDescricoesItens()); 
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
        assertEquals("Arco,Faca,Foice,Adaga", inventario.getDescricoesItens()); 
    }      

    @Test    
    public void inventarioVazio(){
        //Arrange
        Inventario inventario = new Inventario();
        //Act & Assert
        assertEquals(null, inventario.getDescricoesItens());
    }

    @Test
    public void itemMaiorQuantidade() {
        //Arrange
        Inventario inventario = new Inventario();
        Item arma1 = new Item("Machado", 42);
        Item arma2 = new Item("Faca", 12);
        Item arma3 = new Item("Espada", 1);
        //Act
        inventario.adicionarItem(arma1);
        inventario.adicionarItem(arma2);
        inventario.adicionarItem(arma3);
        //Assert
        assertEquals(arma1, inventario.retornaItemMaiorQuantidade()); 
    } 

    @Test
    public void itemMaiorQuantidade2() {
        //Arrange
        Inventario inventario = new Inventario();
        Item arma1 = new Item("Machado", 150);
        Item arma2 = new Item("Faca", 23);
        Item arma3 = new Item("Espada", 1);
        Item arma4 = new Item("Arco", 99);
        Item arma5 = new Item("Foice", 21);
        Item arma6 = new Item("Adaga", 31);
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
        assertEquals(arma4, inventario.retornaItemMaiorQuantidade()); 
    } 

    @Test
    public void itemMaiorQuantidade3() {
        //Arrange
        Inventario inventario = new Inventario();
        Item arma1 = new Item("Machado", 12);
        Item arma2 = new Item("Faca", 13);
        Item arma3 = new Item("Espada", 13);
        Item arma4 = new Item("Arco", 12);
        Item arma5 = new Item("Foice", 11);
        Item arma6 = new Item("Adaga", 10);
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
        assertEquals(arma2, inventario.retornaItemMaiorQuantidade()); 
    } 

    @Test
    public void itemMaiorQuantidadeIgual() {
        //Arrange
        Inventario inventario = new Inventario();
        Item arma1 = new Item("Machado", 10);
        Item arma2 = new Item("Faca", 10);
        Item arma3 = new Item("Espada", 10);
        Item arma4 = new Item("Arco", 10);
        Item arma5 = new Item("Foice", 10);
        Item arma6 = new Item("Adaga", 10);
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
        assertEquals(arma6, inventario.retornaItemMaiorQuantidade()); 
    } 

    @Test
    public void ordena5Itens(){
        //Arrange
        Inventario inventario = new Inventario();
        Item arma1 = new Item("Machado", 23);
        Item arma2 = new Item("Faca", 34);
        Item arma3 = new Item("Espada", 10);
        Item arma4 = new Item("Arco", 123);
        Item arma5 = new Item("Foice", 1);        
        //Act
        inventario.adicionarItem(arma1);
        inventario.adicionarItem(arma2);
        inventario.adicionarItem(arma3);
        inventario.adicionarItem(arma4);
        inventario.adicionarItem(arma5);
        inventario.ordenarItens();
        //Assert
        assertEquals("Foice,Espada,Machado,Faca,Arco", inventario.getDescricoesItens());

    }

    @Test
    public void itensJaOrdenados(){
        //Arrange
        Inventario inventario = new Inventario();
        Item arma1 = new Item("Machado", 10);
        Item arma2 = new Item("Faca", 11);
        Item arma3 = new Item("Espada", 12);
        Item arma4 = new Item("Arco", 13);
        Item arma5 = new Item("Foice", 14);        
        //Act
        inventario.adicionarItem(arma1);
        inventario.adicionarItem(arma2);
        inventario.adicionarItem(arma3);
        inventario.adicionarItem(arma4);
        inventario.adicionarItem(arma5);
        inventario.ordenarItens();
        //Assert
        assertEquals("Machado,Faca,Espada,Arco,Foice", inventario.getDescricoesItens());
    }

    @Test
    public void ordenaInventarioComUmitem(){
        //Arrange
        Inventario inventario = new Inventario();
        Item arma1 = new Item("Machado", 10);

        //Act
        inventario.adicionarItem(arma1);
        inventario.ordenarItens();
        //Assert
        assertEquals("Machado", inventario.getDescricoesItens());
    }
    
    @Test
    public void inventarioSemItens(){
        //Arrange
        Inventario inventario = new Inventario();
        //Act
        inventario.ordenarItens();
        //Assert
        assertEquals(null, inventario.getDescricoesItens());
    }
}