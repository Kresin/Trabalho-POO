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
    public void salvarDados(String nomeArquivo) {
        String dadosParaSalvar = this.getDataLancamento() + ";" + this.getValor() + ";" + this.tipoReceita; // Concatena os dados que serão salvos no arquivo
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
    public List<Receita> listarDados(String nomeArquivo) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        ArrayList<Receita> receitas = new ArrayList<>();

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

                if (verificaSeRegistroEhReceita(enumeracao)) {
                    Receita r = new Receita();
                    r.setValor(Double.parseDouble(valor));
                    r.setDataLancamento(LocalDate.parse(data));
                    r.setTipoReceita(converterStringParaTipoReceita(enumeracao));
                    receitas.add(r);
                }
            }
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println("Erro ao carregar dados.");
        }

        return receitas;
    }

    /**
     * Retorna todos os dados contidos no arquivo especificado com base nos filtros passados.
     * 
     * @param nomeArquivo Arquivo onde os dados serão buscados.
     * @param tipoReceitas Lista de receitas que serão consideradas para fazer o filtro na hora de retornar os dados.
     * @return Lista contendo os dados filtrados do arquivo.
     */
    public List<Receita> listarDados(String nomeArquivo, ArrayList<TipoReceita> tipoReceitas) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        ArrayList<Receita> receitas = new ArrayList<>();

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
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println("Erro ao carregar dados.");
        }

        return receitas;
    }

    /**
     * Verifica se o a String passada por parâmtro é uma enumaração da classe TipoReceita.
     * Caso o valor passado seja compatível com alguma enumeração é retornado true, 
     * caso contrário é retornado false.
     * 
     * @param enumeracao String contendo o nome da enumeração que será verificada.
     * @return Valor booleano indicando se o registro é uma receita.
     */
    protected boolean verificaSeRegistroEhReceita(String enumeracao) {
        return enumeracao.equals(TipoReceita.SALARIO.toString()) //
                || enumeracao.equals(TipoReceita.FERIAS.toString()) // 
                || enumeracao.equals(TipoReceita.DECIMO_TERCEIRO.toString()) //
                || enumeracao.equals(TipoReceita.OUTRAS_RECEITAS.toString());
    }

    /**
     * Converte uma String para uma enumeração do tipo TipoReceita. Caso o valor passado não seja compatível
     * com nenhuma enumeração da classe TipoReceita, é lançada uma exceção.
     * 
     * @param tipoReceita String a ser convertida em uma enumeração de TipoReceita.
     * @return Enumeração de TipoReceita.
     */
    protected TipoReceita converterStringParaTipoReceita(String tipoReceita) {
        switch (tipoReceita) {
            case "SALARIO":
                return TipoReceita.SALARIO;
            case "FERIAS":
                return TipoReceita.FERIAS;
            case "DECIMO_TERCEIRO":
                return TipoReceita.DECIMO_TERCEIRO;
            case "OUTRAS_RECEITAS":
                return TipoReceita.OUTRAS_RECEITAS;
        }
        throw new RuntimeException("Não foi possível converter o valor " + tipoReceita + " em um tipo de receita");
    }
    
    /**
     * Converte uma enumeração do tipo TipoReceita para uma String.
     * 
     * @param tipoReceita Enumeração de TipoReceita a ser convertida.
     * @return String convertida.
     */
    public String converterTipoReceitaParaString(TipoReceita tipoReceita) {
        switch (tipoReceita) {
            case SALARIO:
                return "Salário";
            case DECIMO_TERCEIRO:
                return "Décimo terceiro";
            case FERIAS:
                return "Férias";
            default:
                return "Outras receitas";
        }
    }

}
