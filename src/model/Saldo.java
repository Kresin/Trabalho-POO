package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel Kresin e Iago Tambosi
 */
public class Saldo {
    
    /**
     * Calcula o valor do saldo para a data de hoje com base nos registros contidos no arquivo
     * passado como parâmetro.
     * 
     * @param nomeArquivo
     * @return Valor do saldo.
     */
    public double obterSaldoNaDataAtual(String nomeArquivo) {
        LocalDate dateNow = LocalDate.now();
        double saldo = 0;
        Receita receita = new Receita();
        List<Receita> receitas = receita.listarDados(nomeArquivo);
        
        Despesa despesa = new Despesa();
        List<Despesa> despesas = despesa.listarDados(nomeArquivo);
        
        List<Lancamento> lancamentos = new ArrayList<>();
        lancamentos.addAll(receitas);
        lancamentos.addAll(despesas);
        
        for(int i = 0; i < lancamentos.size(); i++){
            if(lancamentos.get(i).getDataLancamento().isBefore(dateNow) || lancamentos.get(i).getDataLancamento().isEqual(dateNow)){
                if (lancamentos.get(i) instanceof Receita) {
                saldo += lancamentos.get(i).getValor();
                
                } else {
                saldo -= lancamentos.get(i).getValor();
                }
            }
            
        }
        return saldo;
    }
    
    /**
     * Calcula o valor do saldo sem considerar uma data limite. Ou seja, o saldo é calculado
     * com base em todos os valores contidos no registro passado por parâmetro.
     * 
     * @return Valor do saldo.
     */
    public double obterSaldo(String nomeArquivo) {
        double saldo = 0;
        Receita receita = new Receita();
        List<Receita> receitas = receita.listarDados(nomeArquivo);
        
        Despesa despesa = new Despesa();
        List<Despesa> despesas = despesa.listarDados(nomeArquivo);
        
        List<Lancamento> lancamentos = new ArrayList<>();
        lancamentos.addAll(receitas);
        lancamentos.addAll(despesas);
        
        for(int i = 0; i < lancamentos.size(); i++){
        if (lancamentos.get(i) instanceof Receita) {
            saldo += lancamentos.get(i).getValor();
            } else {
            saldo -= lancamentos.get(i).getValor();
            }
        }
        return saldo;
    }
    
}
