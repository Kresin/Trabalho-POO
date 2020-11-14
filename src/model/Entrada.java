package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Kresin e Iago Tambosi
 */
public class Entrada extends Receita {

    private TipoEntrada tipoEntrada;

    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(TipoEntrada tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    @Override
    public void salvarDados() {
        String dadosParaSalvar = this.getDataLancamento() + ";" + this.getValor() + ";" + this.tipoEntrada; // Concatena os dados que serão salvos no arquivo
        System.out.println("Valores concatenados: ");
        System.out.println(dadosParaSalvar);

        // Objetos para manipulação de arquivos
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            // Carrega o arquivo. O parâmetro 'true' indica que o arquivo carregado NÃO deverá ser sobreescrito, e sim feito a concatenação de todos os dados
            fileWriter = new FileWriter("test.txt", true);

            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(dadosParaSalvar); // Escreve os dados no arquivo
            bufferedWriter.newLine(); // Pula uma linha no arquivo
            bufferedWriter.flush(); // Salva as alterações feitas no arquivo

            bufferedWriter.close(); // Fecha o arquivo
        } catch (IOException ex) {
            System.out.println("Erro ao salvar os dados da entrada!");
        }
    }

    @Override
    public ArrayList<String> listarDados() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        ArrayList<String> entradas = new ArrayList<>();

        try {
            fileReader = new FileReader("test.txt");

            bufferedReader = new BufferedReader(fileReader);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {

                //String exemplo: 
                //0123456789 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
                //2020-11-06 ;  2  0  0  0  .  0  ;  S  A  L  A  R  I  O
                int indexPontoVirgula = linha.indexOf(';');
                String data = linha.substring(0, indexPontoVirgula);

                linha = linha.substring(indexPontoVirgula + 1);

                indexPontoVirgula = linha.indexOf(';');
                String valor = linha.substring(0, indexPontoVirgula);

                linha = linha.substring(indexPontoVirgula + 1);

                String enumeracao = linha;

                if (verificaSeRegistroEhEntrada(enumeracao)) {
                    entradas.add(data);
                    entradas.add(valor);
                    entradas.add(enumeracao);
                }
            }
        } catch (IOException ex) {
            System.out.println("Erro ao carregar dados.");
        }

        return entradas;
    }

    private boolean verificaSeRegistroEhEntrada(String enumeracao) {
        return enumeracao.equals(TipoEntrada.SALARIO.toString()) //
                || enumeracao.equals(TipoEntrada.FERIAS.toString()) // 
                || enumeracao.equals(TipoEntrada.DECIMO_TERCEIRO.toString()) //
                || enumeracao.equals(TipoEntrada.OUTRAS_ENTRADAS.toString());
    }
}
