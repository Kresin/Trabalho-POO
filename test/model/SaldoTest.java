package model;

import java.time.LocalDate;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;

/**
 *
 * @author Gabriel Kresin e Iago Tambosi
 */
public class SaldoTest {
    
    @BeforeClass
    public static void prepararTestes() {
        PersistenciaBaseTest persistencia = new PersistenciaBaseTest();
        persistencia.criarArquivoParaTeste("test-unitario.txt");
    }

    @AfterClass
    public static void limparExecucao() {
        PersistenciaBaseTest persistencia = new PersistenciaBaseTest();
        persistencia.excluiArquivoDeTeste("test-unitario.txt");
    }

    @Test
    public void test_obterSaldoNaDataAtual() {
        Receita receita = new Receita();
        receita.setDataLancamento(LocalDate.of(2021, 7, 25));
        receita.setTipoReceita(TipoReceita.OUTRAS_RECEITAS);
        receita.setValor(2500);
        
        Receita receita2 = new Receita();
        receita2.setDataLancamento(LocalDate.of(2020, 3, 2));
        receita2.setTipoReceita(TipoReceita.SALARIO);
        receita2.setValor(1000);
        
        Despesa despesa = new Despesa();
        despesa.setDataLancamento(LocalDate.of(2019, 1, 15));
        despesa.setTipoDespesa(TipoDespesa.TRANSPORTE);
        despesa.setValor(250);
        
        Despesa despesa2 = new Despesa();
        despesa2.setDataLancamento(LocalDate.of(2021, 6, 5));
        despesa2.setTipoDespesa(TipoDespesa.RESIDENCIA);
        despesa2.setValor(500);
        
        receita.salvarDados("test-unitario.txt");
        receita2.salvarDados("test-unitario.txt");
        despesa.salvarDados("test-unitario.txt");
        despesa2.salvarDados("test-unitario.txt");
        
        Saldo saldo = new Saldo();
        
        Assert.assertEquals(750, saldo.obterSaldoNaDataAtual("test-unitario.txt") , 0);
    }
    
    @Test
    public void test_obterSaldo() {
        Saldo saldo = new Saldo();
        
        Assert.assertEquals(2750, saldo.obterSaldo("test-unitario.txt"), 0); 
    }
    
}
