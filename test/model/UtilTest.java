/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author iagot
 */
public class UtilTest {
    
    public UtilTest() {
    }

    @Test
    public void test_formatarData() {
        LocalDate localDate = LocalDate.of(2020, 4, 8);
        Assert.assertEquals("08/04/2020", Util.formatarData(localDate));
    }
    
}
