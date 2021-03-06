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
import model.Receita;
import model.TipoReceita;

/**
 *
 * @author Gabriel Kresin e Iago Tambosi
 */
public class CadastroReceita extends javax.swing.JDialog {

    /**
     * Creates new form CadastroReceita
     */
    public CadastroReceita(java.awt.Frame parent, boolean modal) {
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
        radioButtonSalario = new javax.swing.JRadioButton();
        radioButtonDecimoTerceiro = new javax.swing.JRadioButton();
        radioButtonFerias = new javax.swing.JRadioButton();
        radioButtonOutrasReceitas = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        textFieldValorReceita = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        textFieldDataEntrada = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Receita"));

        jLabel1.setText("Tipo de receita:");

        buttonGroup.add(radioButtonSalario);
        radioButtonSalario.setText("Salário");
        radioButtonSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonSalarioActionPerformed(evt);
            }
        });

        buttonGroup.add(radioButtonDecimoTerceiro);
        radioButtonDecimoTerceiro.setText("Décimo terceiro");

        buttonGroup.add(radioButtonFerias);
        radioButtonFerias.setText("Férias");

        buttonGroup.add(radioButtonOutrasReceitas);
        radioButtonOutrasReceitas.setText("Outras receitas");

        jLabel2.setText("Valor da receita:");

        jLabel3.setText("Data de entrada:");

        try {
            textFieldDataEntrada = new JFormattedTextField(new MaskFormatter("##/##/####"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radioButtonSalario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioButtonDecimoTerceiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioButtonFerias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioButtonOutrasReceitas))
                    .addComponent(jLabel3)
                    .addComponent(textFieldDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textFieldValorReceita, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButtonSalario)
                    .addComponent(radioButtonDecimoTerceiro)
                    .addComponent(radioButtonFerias)
                    .addComponent(radioButtonOutrasReceitas))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textFieldValorReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioButtonSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonSalarioActionPerformed
    }//GEN-LAST:event_radioButtonSalarioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // Valida se alguma opção está selecionada
        if (!radioButtonSalario.isSelected() && !radioButtonFerias.isSelected() && !radioButtonDecimoTerceiro.isSelected() && !radioButtonOutrasReceitas.isSelected()) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um tipo de receita!", "Erro", JOptionPane.ERROR_MESSAGE); // Pop-up de erro
            return; // O return serve para encerrar a execução do método, ou seja não será executado mais nada a partir desse ponto
        }
        // Valida se foi informado o valor da entrada
        if (textFieldValorReceita.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "É necessário informar o valor da receita!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Receita receita = new Receita();

        // Verifica qual tipo de entrada foi selecionado
        if (radioButtonSalario.isSelected()) {
            receita.setTipoReceita(TipoReceita.SALARIO);
        } else if (radioButtonDecimoTerceiro.isSelected()) {
            receita.setTipoReceita(TipoReceita.DECIMO_TERCEIRO);
        } else if (radioButtonFerias.isSelected()) {
            receita.setTipoReceita(TipoReceita.FERIAS);
        } else {
            receita.setTipoReceita(TipoReceita.OUTRAS_RECEITAS);
        }

        double valorEntrada;
        try {
            // Converte o valor informado para o tipo double
            valorEntrada = Double.parseDouble(textFieldValorReceita.getText());
        } catch (NumberFormatException ex) {
            // Caso ocorra uma exceção na hora de converter o campo, é mostrada uma mensagem de erro ao usuário
            JOptionPane.showMessageDialog(null, "Valor da receita está incorreto!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Verifica se o valor informado é superior a 0
        if (valorEntrada <= 0) {
            JOptionPane.showMessageDialog(null, "Valor da receita deve ser maior que 0!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        receita.setValor(valorEntrada);
        
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
        
        receita.setDataLancamento(dataLancamento);
        receita.salvarDados("lancamentos.csv"); // Salva os dados

        this.setVisible(false); // Fecha a tela
    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroReceita dialog = new CadastroReceita(new javax.swing.JFrame(), true);
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
    private javax.swing.JRadioButton radioButtonDecimoTerceiro;
    private javax.swing.JRadioButton radioButtonFerias;
    private javax.swing.JRadioButton radioButtonOutrasReceitas;
    private javax.swing.JRadioButton radioButtonSalario;
    private javax.swing.JFormattedTextField textFieldDataEntrada;
    private javax.swing.JFormattedTextField textFieldValorReceita;
    // End of variables declaration//GEN-END:variables
}
