/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import model.Despesa;
import model.TipoDespesa;

/**
 *
 * @author Gabriel Kresin e Iago Tambosi
 */
public class CadastroDespesa extends javax.swing.JDialog {

    /**
     * Creates new form CadastroReceita
     */
    public CadastroDespesa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        radioButtonAlimentacao = new javax.swing.JRadioButton();
        radioButtonTransporte = new javax.swing.JRadioButton();
        radioButtonResidencia = new javax.swing.JRadioButton();
        radioButtonSaude = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        textFieldValorDespesa = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        textFieldDataEntrada = new javax.swing.JFormattedTextField();
        radioButtonEducacao = new javax.swing.JRadioButton();
        radioButtonEntretenimento = new javax.swing.JRadioButton();
        radioButtonOutros = new javax.swing.JRadioButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Despesa"));

        jLabel1.setText("Tipo de despesa:");

        buttonGroup.add(radioButtonAlimentacao);
        radioButtonAlimentacao.setText("Alimentação");
        radioButtonAlimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonAlimentacaoActionPerformed(evt);
            }
        });

        buttonGroup.add(radioButtonTransporte);
        radioButtonTransporte.setText("Transporte");

        buttonGroup.add(radioButtonResidencia);
        radioButtonResidencia.setText("Residência");
        radioButtonResidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonResidenciaActionPerformed(evt);
            }
        });

        buttonGroup.add(radioButtonSaude);
        radioButtonSaude.setText("Saúde");

        jLabel2.setText("Valor da despesa:");

        jLabel3.setText("Data de entrada:");

        try {
            textFieldDataEntrada = new JFormattedTextField(new MaskFormatter("##/##/####"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        buttonGroup.add(radioButtonEducacao);
        radioButtonEducacao.setText("Educação");

        buttonGroup.add(radioButtonEntretenimento);
        radioButtonEntretenimento.setText("Entretenimento");

        buttonGroup.add(radioButtonOutros);
        radioButtonOutros.setText("Outros");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(textFieldDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textFieldValorDespesa, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioButtonAlimentacao)
                            .addComponent(radioButtonEducacao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioButtonEntretenimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioButtonOutros))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioButtonTransporte)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(radioButtonResidencia)
                                .addGap(18, 18, 18)
                                .addComponent(radioButtonSaude)))))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButtonAlimentacao)
                    .addComponent(radioButtonTransporte)
                    .addComponent(radioButtonResidencia)
                    .addComponent(radioButtonSaude))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButtonEducacao)
                    .addComponent(radioButtonEntretenimento)
                    .addComponent(radioButtonOutros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textFieldValorDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textFieldDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalvar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Cadastro de Despesa");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioButtonAlimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonAlimentacaoActionPerformed
    }//GEN-LAST:event_radioButtonAlimentacaoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // Valida se alguma opção está selecionada
        if (!radioButtonAlimentacao.isSelected() && !radioButtonResidencia.isSelected() && !radioButtonTransporte.isSelected() && !radioButtonSaude.isSelected() && !radioButtonEducacao.isSelected() && !radioButtonEntretenimento.isSelected() && !radioButtonOutros.isSelected()) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um tipo de despesa!", "Erro", JOptionPane.ERROR_MESSAGE); // Pop-up de erro
            return; // O return serve para encerrar a execução do método, ou seja não será executado mais nada a partir desse ponto
        }
        // Valida se foi informado o valor da despesa
        if (textFieldValorDespesa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "É necessário informar o valor da despesa!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Despesa despesa = new Despesa();

        // Verifica qual tipo de despesa foi selecionado
        if (radioButtonAlimentacao.isSelected()) {
            despesa.setTipoDespesa(TipoDespesa.ALIMENTACAO);
        } else if (radioButtonEducacao.isSelected()) {
            despesa.setTipoDespesa(TipoDespesa.EDUCACAO);
        } else if (radioButtonEntretenimento.isSelected()){
            despesa.setTipoDespesa(TipoDespesa.ENTRETENIMENTO);
        } else if (radioButtonOutros.isSelected()) {
            despesa.setTipoDespesa(TipoDespesa.OUTRAS_DESPESAS);
        } else if (radioButtonResidencia.isSelected()) {
            despesa.setTipoDespesa(TipoDespesa.RESIDENCIA);
        } else if (radioButtonSaude.isSelected()) {
            despesa.setTipoDespesa(TipoDespesa.SAUDE);
        } else {
            despesa.setTipoDespesa(TipoDespesa.TRANSPORTE);
        }

        double valorDespesa;
        try {
            // Converte o valor informado para o tipo double
            valorDespesa = Double.parseDouble(textFieldValorDespesa.getText());
        } catch (NumberFormatException ex) {
            // Caso ocorra uma exceção na hora de converter o campo, é mostrada uma mensagem de erro ao usuário
            JOptionPane.showMessageDialog(null, "Valor da despesa está incorreto!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Verifica se o valor informado é superior a 0
        if (valorDespesa <= 0) {
            JOptionPane.showMessageDialog(null, "Valor da despesa deve ser maior que 0!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        despesa.setValor(valorDespesa);
        
        LocalDate dataLancamento;
        try {
            // Cria um formatador de data
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            // Converte uma String no mesmo formato do parâmetro 'formatter' em um objeto do tipo LocalDate
            dataLancamento = LocalDate.parse(textFieldDataEntrada.getText(), formatter);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data de entrada incorreta!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        despesa.setDataLancamento(dataLancamento);
        despesa.salvarDados(); // Salva os dados

        this.setVisible(false); // Fecha a tela
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void radioButtonResidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonResidenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioButtonResidenciaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroDespesa dialog = new CadastroDespesa(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton radioButtonAlimentacao;
    private javax.swing.JRadioButton radioButtonEducacao;
    private javax.swing.JRadioButton radioButtonEntretenimento;
    private javax.swing.JRadioButton radioButtonOutros;
    private javax.swing.JRadioButton radioButtonResidencia;
    private javax.swing.JRadioButton radioButtonSaude;
    private javax.swing.JRadioButton radioButtonTransporte;
    private javax.swing.JFormattedTextField textFieldDataEntrada;
    private javax.swing.JFormattedTextField textFieldValorDespesa;
    // End of variables declaration//GEN-END:variables
}