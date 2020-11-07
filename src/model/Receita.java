package model;

import java.time.LocalDate;

/**
 *
 * @author Gabriel Kresin e Iago Tambosi
 */
public abstract class Receita implements Persistencia {
    
    private LocalDate dataLancamento;
    private double valor;

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
