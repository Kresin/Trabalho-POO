package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Gabriel Kresin e Iago Tambosi
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DespesaTest {

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
    public void test_01_salvarDados() {
        Despesa despesa = new Despesa();
        despesa.setValor(50);
        despesa.setTipoDespesa(TipoDespesa.ENTRETENIMENTO);
        despesa.setDataLancamento(LocalDate.of(2020, 5, 10));

        Despesa despesa2 = new Despesa();
        despesa2.setValor(125);
        despesa2.setTipoDespesa(TipoDespesa.SAUDE);
        despesa2.setDataLancamento(LocalDate.of(2020, 6, 15));

        despesa.salvarDados("test-unitario.txt");
        despesa2.salvarDados("test-unitario.txt");

        try {
            FileReader fileReader = new FileReader("test-unitario.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha1 = bufferedReader.readLine();
            String linha2 = bufferedReader.readLine();
            bufferedReader.close();

            Assert.assertEquals("2020-05-10;50.0;ENTRETENIMENTO", linha1);
            Assert.assertEquals("2020-06-15;125.0;SAUDE", linha2);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void test_02_listarDados() {
        Despesa despesa = new Despesa();
        List<Despesa> resultado = despesa.listarDados("test-unitario.txt");

        Assert.assertEquals(2, resultado.size());
        Assert.assertEquals(50, resultado.get(0).getValor(), 0);
        Assert.assertEquals(LocalDate.of(2020, 5, 10), resultado.get(0).getDataLancamento());
        Assert.assertEquals(TipoDespesa.ENTRETENIMENTO, resultado.get(0).getTipoDespesa());
        Assert.assertEquals(125, resultado.get(1).getValor(), 0);
        Assert.assertEquals(LocalDate.of(2020, 6, 15), resultado.get(1).getDataLancamento());
        Assert.assertEquals(TipoDespesa.SAUDE, resultado.get(1).getTipoDespesa());
    }

    @Test
    public void test_03_listarDados_comFiltro() {
        Despesa despesa = new Despesa();
        ArrayList<TipoDespesa> tipoDespesas = new ArrayList<>();
        tipoDespesas.add(TipoDespesa.SAUDE);

        List<Despesa> resultado = despesa.listarDados("test-unitario.txt", tipoDespesas);

        Assert.assertEquals(1, resultado.size());
        Assert.assertEquals(125, resultado.get(0).getValor(), 0);
        Assert.assertEquals(LocalDate.of(2020, 6, 15), resultado.get(0).getDataLancamento());
        Assert.assertEquals(TipoDespesa.SAUDE, resultado.get(0).getTipoDespesa());
    }

    @Test
    public void test_04_verificaSeRegistroEhDespesa_returnTrue() {
        Despesa despesa = new Despesa();
        boolean resultado = despesa.verificaSeRegistroEhDespesa("ALIMENTACAO");
        Assert.assertEquals(true, resultado);

        resultado = despesa.verificaSeRegistroEhDespesa("TRANSPORTE");
        Assert.assertEquals(true, resultado);

        resultado = despesa.verificaSeRegistroEhDespesa("RESIDENCIA");
        Assert.assertEquals(true, resultado);

        resultado = despesa.verificaSeRegistroEhDespesa("SAUDE");
        Assert.assertEquals(true, resultado);

        resultado = despesa.verificaSeRegistroEhDespesa("EDUCACAO");
        Assert.assertEquals(true, resultado);

        resultado = despesa.verificaSeRegistroEhDespesa("ENTRETENIMENTO");
        Assert.assertEquals(true, resultado);

        resultado = despesa.verificaSeRegistroEhDespesa("OUTRAS_DESPESAS");
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void test_05_verificaSeRegistroEhDespesa_returnFalse() {
        Despesa despesa = new Despesa();
        boolean resultado = despesa.verificaSeRegistroEhDespesa("BATATA");
        boolean resultado2 = despesa.verificaSeRegistroEhDespesa("SALARIO");
        Assert.assertEquals(false, (resultado || resultado2));
    }

    @Test
    public void test_06_converterStringParaTipoDespesa() {
        Despesa despesa = new Despesa();
        TipoDespesa resultado = despesa.converterStringParaTipoDespesa("ALIMENTACAO");
        Assert.assertEquals(TipoDespesa.ALIMENTACAO, resultado);

        resultado = despesa.converterStringParaTipoDespesa("TRANSPORTE");
        Assert.assertEquals(TipoDespesa.TRANSPORTE, resultado);

        resultado = despesa.converterStringParaTipoDespesa("RESIDENCIA");
        Assert.assertEquals(TipoDespesa.RESIDENCIA, resultado);

        resultado = despesa.converterStringParaTipoDespesa("SAUDE");
        Assert.assertEquals(TipoDespesa.SAUDE, resultado);

        resultado = despesa.converterStringParaTipoDespesa("EDUCACAO");
        Assert.assertEquals(TipoDespesa.EDUCACAO, resultado);

        resultado = despesa.converterStringParaTipoDespesa("ENTRETENIMENTO");
        Assert.assertEquals(TipoDespesa.ENTRETENIMENTO, resultado);

        resultado = despesa.converterStringParaTipoDespesa("OUTRAS_DESPESAS");
        Assert.assertEquals(TipoDespesa.OUTRAS_DESPESAS, resultado);
    }

    @Test
    public void test_07_converterStringParaTipoDespesa() {
        Despesa despesa = new Despesa();
        try {
            despesa.converterStringParaTipoDespesa("DECIMO_TERCEIRO");
            throw new AssertionError("O código acima deveria ter gerado um erro");
        } catch (Exception e) {
            Assert.assertEquals("Não foi possível converter o valor DECIMO_TERCEIRO em um tipo de despesa", e.getMessage());
        }
    }
    
    @Test
    public void test_08_converterTipoDespesaParaString() {
        Despesa despesa = new Despesa();
        
        String resultado = despesa.converterTipoDespesaParaString(TipoDespesa.ALIMENTACAO);
        Assert.assertEquals("Alimentação", resultado);
        
        resultado = despesa.converterTipoDespesaParaString(TipoDespesa.EDUCACAO);
        Assert.assertEquals("Educação", resultado);
        
        resultado = despesa.converterTipoDespesaParaString(TipoDespesa.ENTRETENIMENTO);
        Assert.assertEquals("Entretenimento", resultado);
        
        resultado = despesa.converterTipoDespesaParaString(TipoDespesa.RESIDENCIA);
        Assert.assertEquals("Residência", resultado);
        
        resultado = despesa.converterTipoDespesaParaString(TipoDespesa.SAUDE);
        Assert.assertEquals("Saúde", resultado);
        
        resultado = despesa.converterTipoDespesaParaString(TipoDespesa.TRANSPORTE);
        Assert.assertEquals("Transporte", resultado);
        
        resultado = despesa.converterTipoDespesaParaString(TipoDespesa.OUTRAS_DESPESAS);
        Assert.assertEquals("Outras despesas", resultado);
    }

}
