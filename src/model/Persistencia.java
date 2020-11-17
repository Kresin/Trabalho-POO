package model;

import java.util.ArrayList;
import java.util.List;

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
    public List listarDados();
    
}
