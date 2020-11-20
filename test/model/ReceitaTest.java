package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Gabriel Kresin e Iago Tambosi
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReceitaTest {

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
    public void teste_01_salvarDados() {
        Receita receita = new Receita();
        receita.setDataLancamento(LocalDate.of(2020, 01, 01));
        receita.setValor(200);
        receita.setTipoReceita(TipoReceita.SALARIO);

        Receita receita2 = new Receita();
        receita2.setDataLancamento(LocalDate.of(2020, 01, 30));
        receita2.setValor(450);
        receita2.setTipoReceita(TipoReceita.FERIAS);

        receita.salvarDados("test-unitario.txt");
        receita2.salvarDados("test-unitario.txt");

        try {
            FileReader fileReader = new FileReader("test-unitario.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha1 = bufferedReader.readLine();
            String linha2 = bufferedReader.readLine();
            bufferedReader.close();

            Assert.assertEquals("2020-01-01;200.0;SALARIO", linha1);
            Assert.assertEquals("2020-01-30;450.0;FERIAS", linha2);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void teste_02_listarDados() {
        Receita receita = new Receita();
        List<Receita> resultado = receita.listarDados("test-unitario.txt");

        Assert.assertEquals(2, resultado.size());
        Assert.assertEquals(200, resultado.get(0).getValor(), 0);
        Assert.assertEquals(LocalDate.of(2020, 1, 1), resultado.get(0).getDataLancamento());
        Assert.assertEquals(TipoReceita.SALARIO, resultado.get(0).getTipoReceita());
        Assert.assertEquals(450, resultado.get(1).getValor(), 0);
        Assert.assertEquals(LocalDate.of(2020, 1, 30), resultado.get(1).getDataLancamento());
        Assert.assertEquals(TipoReceita.FERIAS, resultado.get(1).getTipoReceita());
    }

    @Test
    public void teste_03_listarDados_comFiltro() {
        Receita receita = new Receita();
        ArrayList<TipoReceita> tipoReceitas = new ArrayList<>();
        tipoReceitas.add(TipoReceita.FERIAS);

        List<Receita> resultado = receita.listarDados("test-unitario.txt", tipoReceitas);

        Assert.assertEquals(1, resultado.size());
        Assert.assertEquals(450, resultado.get(0).getValor(), 0);
        Assert.assertEquals(LocalDate.of(2020, 1, 30), resultado.get(0).getDataLancamento());
        Assert.assertEquals(TipoReceita.FERIAS, resultado.get(0).getTipoReceita());
    }

    @Test
    public void teste_04_verificaSeRegistroEhReceita_returnTrue() {
        Receita receita = new Receita();
        boolean resultado = receita.verificaSeRegistroEhReceita("SALARIO");
        Assert.assertEquals(true, resultado);

        resultado = receita.verificaSeRegistroEhReceita("FERIAS");
        Assert.assertEquals(true, resultado);

        resultado = receita.verificaSeRegistroEhReceita("DECIMO_TERCEIRO");
        Assert.assertEquals(true, resultado);

        resultado = receita.verificaSeRegistroEhReceita("OUTRAS_RECEITAS");
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void teste_05_verificaSeRegistroEhReceita_returnFalse() {
        Receita receita = new Receita();
        boolean resultado = receita.verificaSeRegistroEhReceita("CARRO");
        Assert.assertEquals(false, resultado);
    }

    @Test
    public void teste_06_converterStringParaTipoReceita_tiposCompativeis() {
        Receita receita = new Receita();
        TipoReceita resultado = receita.converterStringParaTipoReceita("SALARIO");
        Assert.assertEquals(TipoReceita.SALARIO, resultado);

        resultado = receita.converterStringParaTipoReceita("FERIAS");
        Assert.assertEquals(TipoReceita.FERIAS, resultado);

        resultado = receita.converterStringParaTipoReceita("DECIMO_TERCEIRO");
        Assert.assertEquals(TipoReceita.DECIMO_TERCEIRO, resultado);

        resultado = receita.converterStringParaTipoReceita("OUTRAS_RECEITAS");
        Assert.assertEquals(TipoReceita.OUTRAS_RECEITAS, resultado);
    }

    @Test
    public void teste_07_converterStringParaTipoReceita_exception() {
        Receita receita = new Receita();
        try {
            receita.converterStringParaTipoReceita("CASA");
            throw new AssertionError("O código acima deveria ter gerado um erro");
        } catch (Exception e) {
            Assert.assertEquals("Não foi possível converter o valor CASA em um tipo de receita", e.getMessage());
        }
    }
    
    @Test
    public void test_08_converterTipoReceitaParaString() {
        Receita receita = new Receita();
        
        String resultado = receita.converterTipoReceitaParaString(TipoReceita.SALARIO);
        Assert.assertEquals("Salário", resultado);
        
        resultado = receita.converterTipoReceitaParaString(TipoReceita.FERIAS);
        Assert.assertEquals("Férias", resultado);
        
        resultado = receita.converterTipoReceitaParaString(TipoReceita.DECIMO_TERCEIRO);
        Assert.assertEquals("Décimo terceiro", resultado);
        
        resultado = receita.converterTipoReceitaParaString(TipoReceita.OUTRAS_RECEITAS);
        Assert.assertEquals("Outras receitas", resultado);
    }

}
