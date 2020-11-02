package model;

import java.util.ArrayList;

/**
 *  
 * 
 * @author Gabriel Kresin e Iago Tambosi
 */
public abstract class Persistencia {
    
    /**
     *
     */
    public abstract void salvarDados();

    /**
     * Este método faz ...
     * @return
     */
    public abstract ArrayList<String> listarDados();
    
}
