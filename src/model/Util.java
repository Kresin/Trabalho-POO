/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author iagot
 */
public class Util {
    /**
     * Este método retorna uma String que corresponde ao objeto localDate (inserido como parâmetro) no formato de data "dd/mm/aaaa"
     * @param localDate
     * @return 
     */
    public static String formatarData(LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return localDate.format(formatter);
    }
    
}
