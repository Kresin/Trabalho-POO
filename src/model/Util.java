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
    
    public static String formatarData(LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return localDate.format(formatter);
    }
    
}
