package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author gabri
 */
public class ReceitaTest {

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

    @Test
    public void salvarDados() {
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
    public void verificaSeRegistroEhReceita_returnTrue() {
        Receita receita = new Receita();
        boolean resultado = receita.verificaSeRegistroEhReceita("SALARIO");
        Assert.assertEquals(true, resultado);

        resultado = receita.verificaSeRegistroEhReceita("FERIAS");
        Assert.assertEquals(true, resultado);

        resultado = receita.verificaSeRegistroEhReceita("DECIMO_TERCEIRO");
        Assert.assertEquals(true, resultado);

        resultado = receita.verificaSeRegistroEhReceita("OUTRAS_ENTRADAS");
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void verificaSeRegistroEhReceita_returnFalse() {
        Receita receita = new Receita();
        boolean resultado = receita.verificaSeRegistroEhReceita("CARRO");
        Assert.assertEquals(false, resultado);
    }
    
    @Test
    public void simpleTest() {
        try {
            Receita receita = new Receita();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void converterStringParaTipoReceita_tiposCompativeis() {
        Receita receita = new Receita();
        TipoReceita resultado = receita.converterStringParaTipoReceita("SALARIO");
        Assert.assertEquals(TipoReceita.SALARIO, resultado);

        resultado = receita.converterStringParaTipoReceita("FERIAS");
        Assert.assertEquals(TipoReceita.FERIAS, resultado);

        resultado = receita.converterStringParaTipoReceita("DECIMO_TERCEIRO");
        Assert.assertEquals(TipoReceita.DECIMO_TERCEIRO, resultado);

        resultado = receita.converterStringParaTipoReceita("OUTRAS_ENTRADAS");
        Assert.assertEquals(TipoReceita.OUTRAS_ENTRADAS, resultado);
    }

    @Test
    public void converterStringParaTipoReceita_exception() {
        Receita receita = new Receita();
        try {
            receita.converterStringParaTipoReceita("CASA");
            throw new AssertionError("O código acima deveria ter gerado um erro");
        } catch (Exception e) {
            Assert.assertEquals("Não foi possível converter o valor CASA em um tipo de receita", e.getMessage());
        }
    }

}
