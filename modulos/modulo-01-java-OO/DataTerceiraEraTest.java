import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void testaAno2016Bissexto(){
        //Arrange
        DataTerceiraEra data = new DataTerceiraEra(29, 8, 2016);
        //Act & Assert
        assertTrue(data.ehBissexto());
    }

    @Test
    public void testaAno3019NaoBissexto(){
        //Arrange
        DataTerceiraEra fimDaGuerraDoAnel = new DataTerceiraEra(1, 10, 3019);
        //Act & Assert
        assertFalse(fimDaGuerraDoAnel.ehBissexto());
    }

    @Test
    public void testaAno2000NaoBissexto(){
        //Arrange
        DataTerceiraEra data1 = new DataTerceiraEra(12, 12, 2000);
        //Act & Assert
        assertTrue(data1.ehBissexto());
    }

}
