import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoDeElfosTest{

    @Test
    public void adicionarAoExercitoUmElfo(){
        //Arrange
        ElfoVerde elfo = new ElfoVerde("Green Legolas");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        //Act
        exercito.alistarSoldado(elfo);
        //Assert
        assertEquals(elfo.getNome(),exercito.buscarPeloNome("Green Legolas").getNome());
        
    }
}
