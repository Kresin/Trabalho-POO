package model;

import java.util.List;

/**
 *
 * @author Gabriel Kresin e Iago Tambosi
 */
public interface Persistencia {

    /**
     * Persiste os dados no arquivo especificado.
     * 
     * @param nomeArquivo Arquivo onde os dados serão salvos.
     */
    public void salvarDados(String nomeArquivo);

    /**
     * Retorna todos os dados contidos no arquivo especificado.
     * 
     * @param nomeArquivo Arquivo onde os dados serão buscados.
     * @return Lista contendo os dados do arquivo.
     */
    public List listarDados(String nomeArquivo);

}
