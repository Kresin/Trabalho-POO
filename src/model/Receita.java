package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel Kresin e Iago Tambosi
 */
public class Receita extends Lancamento {

    private TipoReceita tipoReceita;

    public TipoReceita getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(TipoReceita tipoReceita) {
        this.tipoReceita = tipoReceita;
    }

    @Override
    public void salvarDados() {
        String dadosParaSalvar = this.getDataLancamento() + ";" + this.getValor() + ";" + this.tipoReceita; // Concatena os dados que serão salvos no arquivo
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
    public List<Receita> listarDados() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        ArrayList<Receita> receitas = new ArrayList<>();

        try {
            fileReader = new FileReader("test.txt");

            bufferedReader = new BufferedReader(fileReader);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                int indexPontoVirgula = linha.indexOf(';');
                String data = linha.substring(0, indexPontoVirgula);

                linha = linha.substring(indexPontoVirgula + 1);

                indexPontoVirgula = linha.indexOf(';');
                String valor = linha.substring(0, indexPontoVirgula);

                linha = linha.substring(indexPontoVirgula + 1);

                String enumeracao = linha;

                if (verificaSeRegistroEhReceita(enumeracao)) {
                    Receita r = new Receita();
                    r.setValor(Double.parseDouble(valor));
                    r.setDataLancamento(LocalDate.parse(data));
                    r.setTipoReceita(converterStringParaTipoReceita(enumeracao));
                    receitas.add(r);
                }
            }
        } catch (IOException ex) {
            System.out.println("Erro ao carregar dados.");
        }

        return receitas;
    }

    public List<Receita> listarDados(ArrayList<TipoReceita> tipoReceitas) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        ArrayList<Receita> receitas = new ArrayList<>();

        try {
            fileReader = new FileReader("test.txt");

            bufferedReader = new BufferedReader(fileReader);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                int indexPontoVirgula = linha.indexOf(';');
                String data = linha.substring(0, indexPontoVirgula);

                linha = linha.substring(indexPontoVirgula + 1);

                indexPontoVirgula = linha.indexOf(';');
                String valor = linha.substring(0, indexPontoVirgula);

                linha = linha.substring(indexPontoVirgula + 1);

                String enumeracao = linha;

                if (verificaSeRegistroEhReceita(enumeracao)) {
                    TipoReceita tipoDeReceita = converterStringParaTipoReceita(enumeracao);
                    if (tipoReceitas.contains(tipoDeReceita)) {
                        Receita r = new Receita();
                        r.setValor(Double.parseDouble(valor));
                        r.setDataLancamento(LocalDate.parse(data));
                        r.setTipoReceita(tipoDeReceita);
                        receitas.add(r);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Erro ao carregar dados.");
        }

        return receitas;
    }

    private boolean verificaSeRegistroEhReceita(String enumeracao) {
        return enumeracao.equals(TipoReceita.SALARIO.toString()) //
                || enumeracao.equals(TipoReceita.FERIAS.toString()) // 
                || enumeracao.equals(TipoReceita.DECIMO_TERCEIRO.toString()) //
                || enumeracao.equals(TipoReceita.OUTRAS_ENTRADAS.toString());
    }

    private TipoReceita converterStringParaTipoReceita(String tipoReceita) {
        switch (tipoReceita) {
            case "SALARIO":
                return TipoReceita.SALARIO;
            case "FERIAS":
                return TipoReceita.FERIAS;
            case "DECIMO_TERCEIRO":
                return TipoReceita.DECIMO_TERCEIRO;
            case "OUTRAS_ENTRADAS":
                return TipoReceita.OUTRAS_ENTRADAS;
        }
        throw new RuntimeException("Não foi possível converter o valor " + tipoReceita + "em um tipo de receita");
    }

}
