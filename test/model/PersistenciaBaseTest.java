package model;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Gabriel Kresin e Iago Tambosi
 */
public class PersistenciaBaseTest {

    /**
     * Prepara o ambiente para a execução dos testes. Para preparação dos testes
     * é criado um arquivo temporário nomeado como "test-unitario.txt" na raíz
     * do projeto. Esse arquivo será usado para que os métodos da classe testada
     * possam manipular e persistir os dados informados no teste.
     *
     * @param nomeArquivo Nome do arquivo a ser criado
     */
    public void criarArquivoParaTeste(String nomeArquivo) {
        File file = new File(System.getProperty("user.dir") + "\\" + nomeArquivo);
        boolean sucesso;
        try {
            sucesso = file.createNewFile();
            if (sucesso) {
                System.out.println("Arquivo criado com sucesso em: " + file.getCanonicalPath());
            } else {
                System.out.println("Já existe um arquivo com esse nome em: " + file.getCanonicalPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Exclui os registros gerados pelas execuções dos testes.
     * 
     * @param nomeArquivo Nome do arquivo a ser excluído.
     */
    public void excluiArquivoDeTeste(String nomeArquivo) {
        File file = new File(nomeArquivo);
        try {
            if (file.delete()) {
                System.out.println("Arquivo de teste excluído com sucesso");
            } else {
                System.out.println("Não foi possível exlcuír o arquivo de teste");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
