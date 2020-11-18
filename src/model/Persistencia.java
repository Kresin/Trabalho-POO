package model;

import java.util.List;

/**
 *
 *
 * @author Gabriel Kresin e Iago Tambosi
 */
public interface Persistencia {

    /**
     *
     * @param nomeArquivo
     */
    public void salvarDados(String nomeArquivo);

    /**
     * Este método faz ...
     * @param nomeArquivo
     * @return
     */
    public List listarDados(String nomeArquivo);

}
