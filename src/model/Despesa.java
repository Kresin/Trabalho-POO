package model;

import java.util.ArrayList;

/**
 *
 * @author Gabriel Kresin e Iago Tambosi 
 */
public class Despesa extends Receita {

    private TipoDespesa tipoDespesa;

    public TipoDespesa getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }
    
    @Override
    public void salvarDados() {
        
    }

    @Override
    public ArrayList<String> listarDados() {
        return new ArrayList<>();
    }
    
    /**
     *
     * @param despesas
     * @return
     */
    public ArrayList<String> listarDados(ArrayList<TipoDespesa> despesas) {
        ArrayList<String> listarDados = listarDados();
        
        ArrayList<String> dadosFiltrados = listarDados();
        
        for (String string : listarDados) {
            //converter strinig em enum
            if(despesas.contains(string)) {
                dadosFiltrados.add(string);
            }
        }
        return dadosFiltrados;
    }

    
}
