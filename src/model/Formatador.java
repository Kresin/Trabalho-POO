package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Gabriel Kresin e Iago Tambosi
 */
public class Formatador {
    
    /**
     * Este método retorna uma String que corresponde ao objeto localDate (inserido como parâmetro) no formato de data "dd/mm/aaaa"
     * @param localDate Data a ser formatada
     * @return String com a data formatada
     */
    public String formatarData(LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return localDate.format(formatter);
    }
    
}
