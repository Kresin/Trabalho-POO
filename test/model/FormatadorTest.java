package model;

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Gabriel Kresin e Iago Tambosi
 */
public class FormatadorTest {

    @Test
    public void test_formatarData() {
        LocalDate localDate = LocalDate.of(2020, 4, 8);
        Formatador formatador = new Formatador();
        
        String resultado = formatador.formatarData(localDate);
        
        Assert.assertEquals("08/04/2020", resultado);
    }
    
}
