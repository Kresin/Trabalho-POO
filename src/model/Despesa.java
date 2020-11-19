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
public class Despesa extends Lancamento {

    private TipoDespesa tipoDespesa;

    public TipoDespesa getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    @Override
    public void salvarDados(String nomeArquivo) {
        String dadosParaSalvar = this.getDataLancamento() + ";" + this.getValor() + ";" + this.tipoDespesa; // Concatena os dados que serão salvos no arquivo
        System.out.println("Valores concatenados: ");
        System.out.println(dadosParaSalvar);

        // Objetos para manipulação de arquivos
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            // Carrega o arquivo. O parâmetro 'true' indica que o arquivo carregado NÃO deverá ser sobreescrito, e sim feito a concatenação de todos os dados
            fileWriter = new FileWriter(nomeArquivo, true);

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
    public List<Despesa> listarDados(String nomeArquivo) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        ArrayList<Despesa> despesas = new ArrayList<>();

        try {
            fileReader = new FileReader(nomeArquivo);

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

                if (verificaSeRegistroEhDespesa(enumeracao)) {
                    Despesa d = new Despesa();
                    d.setValor(Double.parseDouble(valor));
                    d.setDataLancamento(LocalDate.parse(data));
                    d.setTipoDespesa(converterStringParaTipoDespesa(enumeracao));
                    despesas.add(d);
                }
            }
        } catch (IOException ex) {
            System.out.println("Erro ao carregar dados.");
        }

        return despesas;
    }

    /**
     *
     * @param tipoDespesas
     * @return
     */
    public List<Despesa> listarDados(String nomeArquivo, ArrayList<TipoDespesa> tipoDespesas) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        ArrayList<Despesa> despesas = new ArrayList<>();

        try {
            fileReader = new FileReader(nomeArquivo);

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

                if (verificaSeRegistroEhDespesa(enumeracao)) {
                    TipoDespesa tipoDeDespesa = converterStringParaTipoDespesa(enumeracao);
                    if (tipoDespesas.contains(tipoDeDespesa)) {
                        Despesa d = new Despesa();
                        d.setValor(Double.parseDouble(valor));
                        d.setDataLancamento(LocalDate.parse(data));
                        d.setTipoDespesa(converterStringParaTipoDespesa(enumeracao));
                        despesas.add(d);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Erro ao carregar dados.");
        }

        return despesas;
    }

    protected boolean verificaSeRegistroEhDespesa(String enumeracao) {
        return enumeracao.equals(TipoDespesa.ALIMENTACAO.toString()) //
                || enumeracao.equals(TipoDespesa.EDUCACAO.toString()) //
                || enumeracao.equals(TipoDespesa.ENTRETENIMENTO.toString()) //
                || enumeracao.equals(TipoDespesa.OUTRAS_DESPESAS.toString()) //
                || enumeracao.equals(TipoDespesa.RESIDENCIA.toString()) //
                || enumeracao.equals(TipoDespesa.SAUDE.toString()) //
                || enumeracao.equals(TipoDespesa.TRANSPORTE.toString());
    }

    protected TipoDespesa converterStringParaTipoDespesa(String tipoDespesa) {
        switch (tipoDespesa) {
            case "ALIMENTACAO":
                return TipoDespesa.ALIMENTACAO;
            case "EDUCACAO":
                return TipoDespesa.EDUCACAO;
            case "ENTRETENIMENTO":
                return TipoDespesa.ENTRETENIMENTO;
            case "OUTRAS_DESPESAS":
                return TipoDespesa.OUTRAS_DESPESAS;
            case "RESIDENCIA":
                return TipoDespesa.RESIDENCIA;
            case "SAUDE":
                return TipoDespesa.SAUDE;
            case "TRANSPORTE":
                return TipoDespesa.TRANSPORTE;
        }
        throw new RuntimeException("Não foi possível converter o valor " + tipoDespesa + " em um tipo de despesa");
    }

}
