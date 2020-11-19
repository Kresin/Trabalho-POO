/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author iagot
 */
public class SaldoTest {
    
    @BeforeClass
    public static void prepararTestes() {
        File file = new File(System.getProperty("user.dir") + "\\test-unitario.txt");
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

    @AfterClass
    public static void limparExecucao() {
        File file = new File("test-unitario.txt");
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
    
    public SaldoTest() {
    }

    @Test
    public void test_obterSaldoNaDataAtual() {
        Receita receita = new Receita();
        receita.setDataLancamento(LocalDate.of(2021, 7, 25));
        receita.setTipoReceita(TipoReceita.OUTRAS_ENTRADAS);
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
