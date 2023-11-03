/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelDominio.Evento; 
import view.tablemodel.EventoTableModel; 

/**
 *  trabalho interdisciplinar
 * @author laura ferreira & gabriel hackenhaar
 */
public class TelaEvento extends javax.swing.JFrame {
    private EventoTableModel eventoTableModel;
    private Evento nomeEvento;
    private Evento nomeArtista;
    private Evento idEvento;
    private Evento dataHora;
    private Evento valor;
    private Evento qtdCadeiras;

    private boolean editando = false;
    /**
     * Creates new form TelaEvento
     */
    public TelaEvento() {
        initComponents();
        jLLogo.requestFocus();
        atualizaTabela();
        jTEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEventosMouseClicked(evt);
            }
        });
        
        jTFNomeEvento.addActionListener(e -> jTFArtista.requestFocus());
        jTFArtista.addActionListener(e -> jFTFData.requestFocus());
        jFTFData.addActionListener(e -> jFTFHora.requestFocus());
        jFTFHora.addActionListener(e -> jFTFValor.requestFocus());
        jFTFValor.addActionListener(e -> jCBQtdCadeiras.requestFocus());
        //jCBQtdCadeiras.addActionListener(e -> jBSalvar.doClick());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBVoltar = new javax.swing.JButton();
        jBNovo = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jBSalvar = new javax.swing.JButton();
        jLLogo = new javax.swing.JLabel();
        jTFNomeEvento = new javax.swing.JTextField();
        jTFArtista = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTEventos = new javax.swing.JTable();
        jLBanner = new javax.swing.JLabel();
        jBUpload = new javax.swing.JButton();
        jFTFData = new javax.swing.JFormattedTextField();
        jCBQtdCadeiras = new javax.swing.JComboBox<>();
        jFTFValor = new javax.swing.JFormattedTextField();
        jFTFHora = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Evento");

        jBVoltar.setBackground(new java.awt.Color(90, 90, 205));
        jBVoltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBVoltar.setForeground(new java.awt.Color(255, 255, 255));
        jBVoltar.setText("VOLTAR");
        jBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVoltarActionPerformed(evt);
            }
        });

        jBNovo.setBackground(new java.awt.Color(90, 90, 205));
        jBNovo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBNovo.setForeground(new java.awt.Color(255, 255, 255));
        jBNovo.setText("NOVO");
        jBNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoActionPerformed(evt);
            }
        });

        jBExcluir.setBackground(new java.awt.Color(90, 90, 205));
        jBExcluir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jBExcluir.setText("EXCLUIR");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jBSalvar.setBackground(new java.awt.Color(90, 90, 205));
        jBSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jBSalvar.setText("SALVAR");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jLLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/logo pereira.png"))); // NOI18N

        jTFNomeEvento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFNomeEvento.setForeground(new java.awt.Color(153, 153, 153));
        jTFNomeEvento.setText("Nome evento");
        jTFNomeEvento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFNomeEventoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFNomeEventoFocusLost(evt);
            }
        });

        jTFArtista.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFArtista.setForeground(new java.awt.Color(153, 153, 153));
        jTFArtista.setText("Artista");
        jTFArtista.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFArtistaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFArtistaFocusLost(evt);
            }
        });

        jTEventos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Eventos"
            }
        ));
        jTEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEventosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTEventos);

        jBUpload.setBackground(new java.awt.Color(90, 90, 205));
        jBUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/upload.png"))); // NOI18N
        jBUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUploadActionPerformed(evt);
            }
        });

        jFTFData.setForeground(new java.awt.Color(153, 153, 153));
        jFTFData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jFTFData.setText("Data");
        jFTFData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jFTFData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFDataFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTFDataFocusLost(evt);
            }
        });

        jCBQtdCadeiras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCBQtdCadeiras.setForeground(new java.awt.Color(153, 153, 153));
        jCBQtdCadeiras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quantidade cadeiras", "5", "50", "100", "200", "300", "500" }));

        jFTFValor.setForeground(new java.awt.Color(153, 153, 153));
        jFTFValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFTFValor.setText("R$");
        jFTFValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jFTFValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFValorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTFValorFocusLost(evt);
            }
        });

        jFTFHora.setForeground(new java.awt.Color(153, 153, 153));
        jFTFHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jFTFHora.setText("Hora");
        jFTFHora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jFTFHora.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFHoraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFTFHoraFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTFNomeEvento)
                            .addComponent(jTFArtista)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCBQtdCadeiras, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFTFValor)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFTFHora, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(247, 247, 247)
                        .addComponent(jLLogo)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFNomeEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFTFHora, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBQtdCadeiras, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        LocalDateTime dataHora;
        float valor;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            dataHora = LocalDateTime.parse(jFTFData.getText() + " " + jFTFHora.getText(), formatter);
        } catch (Exception e) {
            dataHora = null;
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            valor = ((Number) jFTFValor.getValue()).floatValue();
        } catch (Exception e) {
            valor = 0;
            System.out.println("Erro: " + e.getMessage());
        }

        if (!jTFNomeEvento.getText().equals("")) {
            String nomeEvento = jTFNomeEvento.getText();
            if (!jTFArtista.getText().equals("")) {
                String artista = jTFArtista.getText();
                if (valor > 0) {
                    if (dataHora != null) {
                        if (jCBQtdCadeiras.getSelectedIndex() > 0){
                            if (editando) {
                                // Edição do evento
                                if (jTEventos.getSelectedRow() >= 0) {
                                    int selectedRow = jTEventos.getSelectedRow();
                                    Evento evento = eventoTableModel.getEvento(selectedRow);
                                    evento.setNomeEvento(nomeEvento);
                                    evento.setArtista(artista);
                                    evento.setDataHora(dataHora);
                                    evento.setValor(valor);
                                    evento.setQtdCadeiras(jCBQtdCadeiras.getSelectedIndex());

                                    // método de atualização no servidor
                                    boolean resultado = TeatroPereiraCliente.ccont.eventoAlterar(evento);

                                    if (resultado) {
                                        JOptionPane.showMessageDialog(rootPane, "Evento alterado com sucesso.");
                                        atualizaTabela();
                                        limpaCampos();
                                    } else {
                                        JOptionPane.showMessageDialog(rootPane, "Erro: evento não pode ser atualizado.");
                                    }
                                }
                            } else {
                                // Inserção de um novo evento
                                Evento evento = new Evento(nomeEvento, artista, dataHora, valor, jCBQtdCadeiras.getSelectedIndex());

                                // método de inserção no servidor
                                boolean resultado = TeatroPereiraCliente.ccont.eventoInserir(evento);

                                if (resultado) {
                                    JOptionPane.showMessageDialog(rootPane, "Evento inserido com sucesso.");
                                    atualizaTabela();
                                    limpaCampos();
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Erro: evento não pode ser cadastrado.");
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Erro: informe a quantidade de cadeiras.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Erro: informe a data.");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Erro: informe o valor.");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Erro: informe o nome do artista");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Erro: informe o nome do evento.");
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jBVoltarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        if (jTEventos.getSelectedRow() > 0){
            int resposta = JOptionPane.showConfirmDialog(rootPane,
                    "Deseja realmente excluir o evento?",
                    "Excluir",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION){
                Evento evento = eventoTableModel.getEvento(jTEventos.getSelectedRow());
                
                boolean resultado = TeatroPereiraCliente.ccont.eventoExcluir(evento);
                
                if (resultado == true){
                    JOptionPane.showMessageDialog(rootPane, "Evento excluído com sucesso.");
                    atualizaTabela();
                    jBNovo.doClick();
                } else {
                    JOptionPane.showMessageDialog(rootPane,
                            "Erro: evento não pode ser excluído.",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }    
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jTFNomeEventoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFNomeEventoFocusLost
        if (jTFNomeEvento.getText().isEmpty()) {
            jTFNomeEvento.setText("Nome evento");
        }
    }//GEN-LAST:event_jTFNomeEventoFocusLost

    private void jTFNomeEventoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFNomeEventoFocusGained
        if (jTFNomeEvento.getText().equals("Nome evento")) {
        jTFNomeEvento.setText("");
    }
    }//GEN-LAST:event_jTFNomeEventoFocusGained

    private void jTFArtistaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFArtistaFocusGained
        if (jTFArtista.getText().equals("Artista")) {
            jTFArtista.setText("");
        }
    }//GEN-LAST:event_jTFArtistaFocusGained

    private void jTFArtistaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFArtistaFocusLost
        if (jTFArtista.getText().isEmpty()) {
            jTFArtista.setText("Artista");
        }
    }//GEN-LAST:event_jTFArtistaFocusLost

    private void jFTFDataFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFDataFocusGained
        if (jFTFData.getText().equals("Data")) {
            jFTFData.setText("");
        }
    }//GEN-LAST:event_jFTFDataFocusGained

    private void jFTFDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFDataFocusLost
        if (jFTFData.getText().isEmpty()) {
            jFTFData.setText("Data");
        }
    }//GEN-LAST:event_jFTFDataFocusLost

    private void jFTFHoraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFHoraFocusGained
        if (jFTFHora.getText().equals("Hora")) {
            jFTFHora.setText("");
        }
    }//GEN-LAST:event_jFTFHoraFocusGained

    private void jFTFHoraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFHoraFocusLost
        if (jFTFHora.getText().isEmpty()) {
            jFTFHora.setText("Hora");
        }
    }//GEN-LAST:event_jFTFHoraFocusLost

    private void jFTFValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFValorFocusGained
        if (jFTFValor.getText().equals("R$")) {
            jFTFValor.setText("");
        }
    }//GEN-LAST:event_jFTFValorFocusGained

    private void jFTFValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFValorFocusLost
        if (jFTFValor.getText().isEmpty()) {
            jFTFValor.setText("R$");
        }
    }//GEN-LAST:event_jFTFValorFocusLost

    private void jTEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEventosMouseClicked
        // Obtém a linha selecionada na tabela
        int selectedRow = jTEventos.getSelectedRow();

        // Verifica se há uma linha selecionada
        if (selectedRow >= 0) {
            // Obtém o usuário da linha selecionada
            Evento evento = eventoTableModel.getEvento(selectedRow);

            //Date dataHoraDate = Date.from(evento.getDataHora().atZone(ZoneId.systemDefault()).toInstant());
            
            LocalDateTime dataHora = evento.getDataHora();
            jFTFData.setValue(java.sql.Date.valueOf(dataHora.toLocalDate()));
            jFTFHora.setValue(java.sql.Time.valueOf(dataHora.toLocalTime()));
            jTFNomeEvento.setText(evento.getNomeEvento());
            jTFArtista.setText(evento.getArtista());
            jFTFValor.setValue(evento.getValor());
            if (jCBQtdCadeiras.getSelectedIndex() != evento.getQtdCadeiras()) {
            // Define a quantidade de cadeiras selecionando o índice correto na ComboBox
                jCBQtdCadeiras.setSelectedIndex(evento.getQtdCadeiras());
            }
            //jCBQtdCadeiras.setSelectedItem(String.valueOf(evento.getQtdCadeiras()));

            editando = true;
        }
    }//GEN-LAST:event_jTEventosMouseClicked

    private void jBUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUploadActionPerformed
        /*FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        jFCImagemEvento.addChoosableFileFilter(imageFilter); 
        if (jFCImagemEvento.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            imagem = new Imagem(jFCImagemEvento.getSelectedFile());
            jLBanner.setIcon(imagem.getImageIcon());
        }*/
    }//GEN-LAST:event_jBUploadActionPerformed

    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
        limpaCampos();
        editando = false;
    }//GEN-LAST:event_jBNovoActionPerformed
    private void atualizaTabela() {
        ArrayList<Evento> listaEventos = TeatroPereiraCliente.ccont.eventoLista();

        eventoTableModel = new EventoTableModel(listaEventos);
        jTEventos.setModel(eventoTableModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBNovo;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JButton jBUpload;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JComboBox<String> jCBQtdCadeiras;
    private javax.swing.JFormattedTextField jFTFData;
    private javax.swing.JFormattedTextField jFTFHora;
    private javax.swing.JFormattedTextField jFTFValor;
    private javax.swing.JLabel jLBanner;
    private javax.swing.JLabel jLLogo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTEventos;
    private javax.swing.JTextField jTFArtista;
    private javax.swing.JTextField jTFNomeEvento;
    // End of variables declaration//GEN-END:variables

    private void limpaCampos() {
        jTFNomeEvento.setText("Nome evento");
        jTFArtista.setText("Artista");
        jFTFData.setText("Data");
        jFTFHora.setText("Hora");
        jFTFValor.setText("R$");
        jCBQtdCadeiras.setSelectedIndex(0);
    }
}
