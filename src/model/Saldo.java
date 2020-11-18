package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.util.converter.LocalDateStringConverter;

/**
 *
 * @author Gabriel Kresin e Iago Tambosi
 */
public class Saldo {
    
    /**
     *
     * @return
     */
    public double obterSaldoNaDataAtual() {
        /*Entrada entrada = new Entrada();
        ArrayList<String> listarDados = entrada.listarDados();
        for (String registro : listarDados) {
            
        }*/
        LocalDate dateNow = LocalDate.now();
        double saldo = 0;
        Receita receita = new Receita();
        List<Receita> receitas = receita.listarDados("test.txt");
        
        Despesa despesa = new Despesa();
        List<Despesa> despesas = despesa.listarDados("test.txt");
        
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
    
    public double obterSaldo() {
        double saldo = 0;
        Receita receita = new Receita();
        List<Receita> receitas = receita.listarDados("test.txt");
        
        Despesa despesa = new Despesa();
        List<Despesa> despesas = despesa.listarDados("test.txt");
        
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
