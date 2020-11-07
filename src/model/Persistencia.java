package model;

import java.util.ArrayList;

/**
 *  
 * 
 * @author Gabriel Kresin e Iago Tambosi
 */
public interface Persistencia {
    
    /**
     *
     */
    public void salvarDados();

    /**
     * Este método faz ...
     * @return
     */
    public ArrayList<String> listarDados();
    
}
