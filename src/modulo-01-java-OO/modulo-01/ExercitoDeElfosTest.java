import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoDeElfosTest{
    @After
    public void limpaTeste(){
        System.gc();
    }    
    
    @Test
    public void adicionarAoExercitoUmElfoVerde(){
        //Arrange
        ElfoVerde elfo = new ElfoVerde("Green Legolas");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        //Act
        exercito.alistarSoldado(elfo);
        //Assert
        assertEquals(elfo,exercito.buscarPeloNome(elfo.getNome()));

    }

    @Test
    public void adicionarAoExercitoUmElfoNoturno(){
        //Arrange
        ElfoNoturno elfo = new ElfoNoturno("Black Legolas");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        //Act
        exercito.alistarSoldado(elfo);
        //Assert
        assertEquals(elfo,exercito.buscarPeloNome(elfo.getNome()));

    }

    @Test
    public void adicionarAoExercitoUmElfoNoturnoEUmElfoVerde(){
        //Arrange
        ElfoNoturno elfo = new ElfoNoturno("Black Legolas");
        ElfoVerde elfo1 = new ElfoVerde("Green Legolas");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        //Act
        exercito.alistarSoldado(elfo);
        exercito.alistarSoldado(elfo1);
        //Assert
        assertEquals(elfo,exercito.buscarPeloNome(elfo.getNome()));
        assertEquals(elfo1,exercito.buscarPeloNome(elfo1.getNome()));
    }

    @Test
    public void adicionarAoExercitoUmElfo(){
        //Arrange
        Elfo elfo = new Elfo("Legolas");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        //Act
        exercito.alistarSoldado(elfo);
        //Assert
        assertNull(exercito.buscarPeloNome(elfo.getNome()));
    }

    @Test
    public void buscarElfosDoExercitoVivos(){
        //Arrange
        ElfoNoturno elfo = new ElfoNoturno("Black Legolas");
        ElfoVerde elfo1 = new ElfoVerde("Green Legolas");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        //Act
        exercito.alistarSoldado(elfo);
        exercito.alistarSoldado(elfo1);
        //Assert
        assertTrue(exercito.buscarPeloStatus(Status.VIVO).contains(elfo));
        assertTrue(exercito.buscarPeloStatus(Status.VIVO).contains(elfo1));
    }  

    @Test
    public void buscarElfosDoExercitoMortos(){
        //Arrange
        ElfoNoturno elfo = new ElfoNoturno("Black Legolas");
        ElfoVerde elfo1 = new ElfoVerde("Green Legolas");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        //Act
        exercito.alistarSoldado(elfo);
        exercito.alistarSoldado(elfo1);
        //Assert
        assertFalse(exercito.buscarPeloStatus(Status.MORTO).contains(elfo));
        assertFalse(exercito.buscarPeloStatus(Status.MORTO).contains(elfo1));
    } 

    @Test
    public void buscarElfosNoturnoMorto(){
        //Arrange
        ElfoNoturno elfo = new ElfoNoturno("Black Legolas", 150);
        ElfoNoturno elfo1 = new ElfoNoturno("Black Galadriel", 150);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        //Act
        exercito.alistarSoldado(elfo);
        exercito.alistarSoldado(elfo1);
        int auxiliar = 90;
        while(auxiliar != 0){
            elfo.atirarFlecha(new Dwarf()); 
            elfo1.atirarFlecha(new Dwarf());   
            auxiliar--;
        }    
        //Assert
        assertTrue(exercito.buscarPeloStatus(Status.MORTO).contains(elfo));
        assertTrue(exercito.buscarPeloStatus(Status.MORTO).contains(elfo1));
    } 
    
    @Test
    public void buscarElfoNoturnoPeloStatusQueNaoExisteNoExercito(){
        //Arrange
        ElfoNoturno elfo = new ElfoNoturno("Black Legolas");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        //Act & Assert
        assertNull(exercito.buscarPeloStatus(Status.MORTO));
        assertNull(exercito.buscarPeloStatus(Status.VIVO));
    } 
    
    @Test
    public void buscarElfoPeloStatusQueNaoExisteNoExercito(){
        //Arrange
        Elfo elfo = new Elfo("Legolas");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        //Act  
        exercito.alistarSoldado(elfo);
        //Assert
        assertNull(exercito.buscarPeloStatus(Status.MORTO));
        assertNull(exercito.buscarPeloStatus(Status.VIVO));
    } 
}   

