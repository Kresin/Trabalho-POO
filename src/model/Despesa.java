package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Kresin e Iago Tambosi 
 */
public class Despesa extends Lancamento {

    private TipoDespesa tipoDespesa;

    public TipoDespesa getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }
    
    @Override
    public void salvarDados() {
        String dadosParaSalvar = this.getDataLancamento() + ";" + this.getValor() + ";" + this.tipoDespesa; // Concatena os dados que serão salvos no arquivo
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
        return new ArrayList<>();
    }
    
    /**
     *
     * @param despesas
     * @return
     */
    public ArrayList<String> listarDados(ArrayList<TipoDespesa> despesas) {
        ArrayList<String> listarDados = listarDados();
        
        ArrayList<String> dadosFiltrados = listarDados();
        
        for (String string : listarDados) {
            //converter strinig em enum
            if(despesas.contains(string)) {
                dadosFiltrados.add(string);
            }
        }
        return dadosFiltrados;
    }

    
}
