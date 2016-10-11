import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

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

    @Test
    public void calculaDiferencaVetores1(){
        HobbitContador frodo = new HobbitContador();
        ArrayList<Integer> numeros1 = new ArrayList<>();
        ArrayList<Integer> numeros2 = new ArrayList<>();
        ArrayList<Integer> numeros3 = new ArrayList<>();
        numeros1.add(15);
        numeros1.add(18);
        numeros2.add(4);
        numeros2.add(5);
        numeros3.add(12);   
        numeros3.add(60);

        frodo.adicionarArrayDePares(numeros1);
        frodo.adicionarArrayDePares(numeros2);
        frodo.adicionarArrayDePares(numeros3);

        assertEquals(840, frodo.calcularDiferenca());
    }

    @Test
    public void calculaDiferencaDeVetoresZerados(){
        HobbitContador frodo = new HobbitContador();
        ArrayList<Integer> numeros1 = new ArrayList<>();
        ArrayList<Integer> numeros2 = new ArrayList<>();

        numeros1.add(0);
        numeros1.add(0);
        numeros2.add(0);
        numeros2.add(0);

        frodo.adicionarArrayDePares(numeros1);
        frodo.adicionarArrayDePares(numeros2);

        assertEquals(0, frodo.calcularDiferenca());
    }
    @Test
    public void calculaDiferencaDeVetoresComNumerosUm(){
        HobbitContador frodo = new HobbitContador();
        ArrayList<Integer> numeros1 = new ArrayList<>();
        ArrayList<Integer> numeros2 = new ArrayList<>();

        numeros1.add(1);
        numeros1.add(1);
        numeros2.add(1);
        numeros2.add(1);

        frodo.adicionarArrayDePares(numeros1);
        frodo.adicionarArrayDePares(numeros2);

        assertEquals(0, frodo.calcularDiferenca());
    }

    @Test
    public void calculaDiferencaDeVetoresComNumerosIguais(){
        HobbitContador frodo = new HobbitContador();
        ArrayList<Integer> numeros1 = new ArrayList<>();
        ArrayList<Integer> numeros2 = new ArrayList<>();

        numeros1.add(5);
        numeros1.add(5);
        numeros2.add(5);
        numeros2.add(5);

        frodo.adicionarArrayDePares(numeros1);
        frodo.adicionarArrayDePares(numeros2);

        assertEquals((25-5)*2, frodo.calcularDiferenca());
    }
}