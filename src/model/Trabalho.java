package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import view.MenuPrincipal;

/**
 *
 * @author Gabriel Kresin e Iago Tambosi
 */
public class Trabalho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader bufferedReader = null; //Objeto para realizar leitura de arquivos

        try {

            // Carrega o arquivo a partir dos diretórios da máquina, caso não seja informado um caminho específico, o arquivo é buscado na raíz do projeto
            FileReader fileReader = new FileReader("lancamentos.csv");
            bufferedReader = new BufferedReader(fileReader);

            String linhaAtual;
            System.out.println("Arquivo carregado com sucesso!");
            System.out.println("Conteúdo do arquivo:");
            while ((linhaAtual = bufferedReader.readLine()) != null) {
                System.out.println(linhaAtual);
            }

        } catch (IOException ex) {
            System.out.println("Erro ao carregar arquivo, será criado um novo arquivo...");
            
            // Se ocorrer uma exceção na hora de carregar o arquivo, é criado um arquivo novo na raíz do projeto
            String cwd = System.getProperty("user.dir"); //Obtém o diretório atual do projeto
            System.out.println("Diretório atual do projeto: " + cwd);

            File file = new File(System.getProperty("user.dir") + "\\lancamentos.csv"); //Objeto para manipulação de arquivos em java
            boolean sucesso;
            try {
                sucesso = file.createNewFile(); //Tentar criar o arquivo no caminho especificado
                if (sucesso) {
                    System.out.println("Arquivo criado com sucesso em: " + file.getCanonicalPath());
                } else {
                    System.out.println("Já existe um arquivo com esse nome em: " + file.getCanonicalPath());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            // Caso o arquivo tenha sido carregado é necessário remover ele do buffer
            if (bufferedReader != null) {
                try {
                    bufferedReader.close(); //Fecha o arquivo
                } catch (IOException ex) {
                    System.out.println("Erro ao fechar arquivo.");
                }
            }
        }

        //Habilitar o menu principal
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
    }

}
