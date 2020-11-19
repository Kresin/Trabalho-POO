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
import model.Receita;
import model.TipoReceita;

/**
 *
 * @author Gabriel Kresin e Iago Tambosi
 */
public class VisualizarReceitas extends javax.swing.JDialog {

    /**
     * Creates new form VisualizarReceitas
     */
    public VisualizarReceitas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        Receita receita = new Receita();
        List<Receita> receitas = receita.listarDados("test.txt");

        popularTabela(receitas);
    }

    /**
     * Popula a tabela da tela com base nos dados da lista fornecida por
     * parâmetro.
     *
     * @param receitas  Lista de receitas que serão usadas para preencher a
     * tabela.
     */
    private void popularTabela(List<Receita> receitas) {
        Collections.sort(receitas, (o1, o2) -> {
            if (o1.getDataLancamento().isBefore(o2.getDataLancamento())) {
                return -1;
            } else {
                return 1;
            }
        });

        DefaultTableModel dtm = new DefaultTableModel(receitas.size(), 0);
        dtm.addColumn("Tipo de Receita");
        dtm.addColumn("Data de lançamento");
        dtm.addColumn("Valor");
        tableReceitas.setModel(dtm);

        for (int i = 0; i < receitas.size(); i++) {
            tableReceitas.setValueAt(receitas.get(i).getTipoReceita(), i, 0);
            tableReceitas.setValueAt(receitas.get(i).getDataLancamento(), i, 1);
            tableReceitas.setValueAt(receitas.get(i).getValor(), i, 2);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        checkBoxSalario = new javax.swing.JCheckBox();
        checkBoxDecimoTerceiro = new javax.swing.JCheckBox();
        checkBoxOutrasEntradas = new javax.swing.JCheckBox();
        checkBoxFerias = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableReceitas = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();
        btnFiltrar = new javax.swing.JButton();
        btnLimparFiltros = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Receita"));

        checkBoxSalario.setText("Salário");

        checkBoxDecimoTerceiro.setText("Décimo Terceiro");
        checkBoxDecimoTerceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxDecimoTerceiroActionPerformed(evt);
            }
        });

        checkBoxOutrasEntradas.setText("Outras Entradas");

        checkBoxFerias.setText("Férias");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBoxSalario)
                .addGap(18, 18, 18)
                .addComponent(checkBoxDecimoTerceiro)
                .addGap(18, 18, 18)
                .addComponent(checkBoxFerias)
                .addGap(18, 18, 18)
                .addComponent(checkBoxOutrasEntradas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxSalario)
                    .addComponent(checkBoxDecimoTerceiro)
                    .addComponent(checkBoxOutrasEntradas)
                    .addComponent(checkBoxFerias))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableReceitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de receita", "Data de lançamento", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableReceitas);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnLimparFiltros.setText("Limpar Filtros");
        btnLimparFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparFiltrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLimparFiltros)
                        .addGap(18, 18, 18)
                        .addComponent(btnFiltrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnFechar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFiltrar)
                    .addComponent(btnLimparFiltros)
                    .addComponent(btnFechar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoxDecimoTerceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxDecimoTerceiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxDecimoTerceiroActionPerformed

    private void btnLimparFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparFiltrosActionPerformed
        checkBoxSalario.setSelected(false);
        checkBoxDecimoTerceiro.setSelected(false);
        checkBoxFerias.setSelected(false);
        checkBoxOutrasEntradas.setSelected(false);
    }//GEN-LAST:event_btnLimparFiltrosActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        ArrayList<TipoReceita> tipoReceitas = new ArrayList<>();

        if (checkBoxSalario.isSelected()) {
            tipoReceitas.add(TipoReceita.SALARIO);
        }
        if (checkBoxFerias.isSelected()) {
            tipoReceitas.add(TipoReceita.FERIAS);
        }
        if (checkBoxDecimoTerceiro.isSelected()) {
            tipoReceitas.add(TipoReceita.DECIMO_TERCEIRO);
        }
        if (checkBoxOutrasEntradas.isSelected()) {
            tipoReceitas.add(TipoReceita.OUTRAS_ENTRADAS);
        }

        if (!tipoReceitas.isEmpty()) {
            Receita receita = new Receita();
            List<Receita> receitas = receita.listarDados("test.txt", tipoReceitas);
            popularTabela(receitas);
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed

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
            java.util.logging.Logger.getLogger(VisualizarReceitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizarReceitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizarReceitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizarReceitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VisualizarReceitas dialog = new VisualizarReceitas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnLimparFiltros;
    private javax.swing.JCheckBox checkBoxDecimoTerceiro;
    private javax.swing.JCheckBox checkBoxFerias;
    private javax.swing.JCheckBox checkBoxOutrasEntradas;
    private javax.swing.JCheckBox checkBoxSalario;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableReceitas;
    // End of variables declaration//GEN-END:variables
}
