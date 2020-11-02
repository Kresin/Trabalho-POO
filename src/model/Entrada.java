package model;

import java.util.ArrayList;

/**
 *
 * @author Gabriel Kresin e Iago Tambosi
 */
public class Entrada extends Receita {

    private TipoEntrada tipoEntrada;

    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(TipoEntrada tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }
    
    @Override
    public void salvarDados() {
        /*entrada.dataLancamento = LocalDate.now();
        entrada.TipoEntrada = ENUM;
        entrada.valor = valor;
        
        FW fw = new fw;
        fw.write(getData() + ";" + entrada.valor + ";" + entrada.enum);
        fw.newline();
        fw.flush();
        fw.close();*/
    }

    @Override
    public ArrayList<String> listarDados() {
        return new ArrayList<>();
    }
    
    /*public ArrayList<String> listarDadosComFiltro(LocalDate date) {
        ArrayList<String> listarDados = listarDados();
        
    }*/

}
