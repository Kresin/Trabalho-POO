/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Despesa;
import model.TipoDespesa;

/**
 *
 * @author gabri
 */
public class VisualizarDespesas extends javax.swing.JDialog {

    /**
     * Creates new form VisualizarDespesas
     */
    public VisualizarDespesas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        Despesa despesa = new Despesa();
        List<Despesa> despesas = despesa.listarDados();

        popularTabela(despesas);
    }
    
        private void popularTabela(List<Despesa> despesas) {
        Collections.sort(despesas, (o1, o2) -> {
            if (o1.getDataLancamento().isBefore(o2.getDataLancamento())) {
                return -1;
            } else {
                return 1;
            }
        });

        DefaultTableModel dtm = new DefaultTableModel(despesas.size(), 0);
        dtm.addColumn("Tipo de Despesa");
        dtm.addColumn("Data de lançamento");
        dtm.addColumn("Valor");
        tableDespesas.setModel(dtm);

        for (int i = 0; i < despesas.size(); i++) {
            tableDespesas.setValueAt(despesas.get(i).getTipoDespesa(), i, 0);
            tableDespesas.setValueAt(despesas.get(i).getDataLancamento(), i, 1);
            tableDespesas.setValueAt(despesas.get(i).getValor(), i, 2);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        cbAlimentacao = new javax.swing.JCheckBox();
        cbTransporte = new javax.swing.JCheckBox();
        cbSaude = new javax.swing.JCheckBox();
        cbEducacao = new javax.swing.JCheckBox();
        cbEntretenimento = new javax.swing.JCheckBox();
        cbResidencia = new javax.swing.JCheckBox();
        cbOutros = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDespesas = new javax.swing.JTable();
        jbLimparFiltro = new javax.swing.JButton();
        jbFiltrar = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Despesa"));

        cbAlimentacao.setText("Alimentação");

        cbTransporte.setText("Transporte");

        cbSaude.setText("Saúde");
        cbSaude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSaudeActionPerformed(evt);
            }
        });

        cbEducacao.setText("Educação");

        cbEntretenimento.setText("Entretenimento");

        cbResidencia.setText("Residência");

        cbOutros.setText("Outros");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbEntretenimento)
                    .addComponent(cbAlimentacao))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbResidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(cbOutros))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbTransporte)
                        .addGap(30, 30, 30)
                        .addComponent(cbSaude)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbEducacao)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAlimentacao)
                    .addComponent(cbTransporte)
                    .addComponent(cbSaude)
                    .addComponent(cbEducacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEntretenimento)
                    .addComponent(cbResidencia)
                    .addComponent(cbOutros))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableDespesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo da Despesa", "Data de lançamento", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableDespesas);

        jbLimparFiltro.setText("Limpar Filtros");
        jbLimparFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparFiltroActionPerformed(evt);
            }
        });

        jbFiltrar.setText("Filtrar");
        jbFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFiltrarActionPerformed(evt);
            }
        });

        jbFechar.setText("Fechar");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jbLimparFiltro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbFiltrar)
                .addGap(12, 12, 12)
                .addComponent(jbFechar)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbLimparFiltro)
                    .addComponent(jbFiltrar)
                    .addComponent(jbFechar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbSaudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSaudeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSaudeActionPerformed

    private void jbFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFiltrarActionPerformed
        // TODO add your handling code here:
                ArrayList<TipoDespesa> tipoDespesas = new ArrayList<>();

        if (cbAlimentacao.isSelected()) {
            tipoDespesas.add(TipoDespesa.ALIMENTACAO);
        }
        if (cbEducacao.isSelected()) {
            tipoDespesas.add(TipoDespesa.EDUCACAO);
        }
        if (cbEntretenimento.isSelected()) {
            tipoDespesas.add(TipoDespesa.ENTRETENIMENTO);
        }
        if (cbOutros.isSelected()) {
            tipoDespesas.add(TipoDespesa.OUTRAS_DESPESAS);
        }
        if (cbResidencia.isSelected()) {
            tipoDespesas.add(TipoDespesa.RESIDENCIA);
        }
        if (cbSaude.isSelected()) {
            tipoDespesas.add(TipoDespesa.SAUDE);
        }
        if (cbTransporte.isSelected()) {
            tipoDespesas.add(TipoDespesa.TRANSPORTE);
        }

        if (!tipoDespesas.isEmpty()) {
            Despesa despesa = new Despesa();
            List<Despesa> despesas = despesa.listarDados(tipoDespesas);
            popularTabela(despesas);
        }
        
    }//GEN-LAST:event_jbFiltrarActionPerformed

    private void jbLimparFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparFiltroActionPerformed
        // TODO add your handling code here:
        cbAlimentacao.setSelected(false);
        cbEducacao.setSelected(false);
        cbEntretenimento.setSelected(false);
        cbOutros.setSelected(false);
        cbResidencia.setSelected(false);
        cbSaude.setSelected(false);
        cbTransporte.setSelected(false);
    }//GEN-LAST:event_jbLimparFiltroActionPerformed

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jbFecharActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VisualizarDespesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizarDespesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizarDespesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizarDespesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VisualizarDespesas dialog = new VisualizarDespesas(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox cbAlimentacao;
    private javax.swing.JCheckBox cbEducacao;
    private javax.swing.JCheckBox cbEntretenimento;
    private javax.swing.JCheckBox cbOutros;
    private javax.swing.JCheckBox cbResidencia;
    private javax.swing.JCheckBox cbSaude;
    private javax.swing.JCheckBox cbTransporte;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbFiltrar;
    private javax.swing.JButton jbLimparFiltro;
    private javax.swing.JTable tableDespesas;
    // End of variables declaration//GEN-END:variables
}
