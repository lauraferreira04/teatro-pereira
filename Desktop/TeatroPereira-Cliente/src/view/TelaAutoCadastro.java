/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JOptionPane;
import modelDominio.Administrador;

/**
 *  trabalho interdisciplinar
 * @author laura ferreira & gabriel hackenhaar
 */
public class TelaAutoCadastro extends javax.swing.JFrame {

    /**
     * Creates new form TelaAutoCadastro
     */
    public TelaAutoCadastro() {
        initComponents();
        jLLogo.requestFocus();
        
        jTFNome.addActionListener(e -> jTFUsuario.requestFocus());
        jTFUsuario.addActionListener(e -> jPFSenha.requestFocus());
        jPFSenha.addActionListener(e -> jTFCpf.requestFocus());
        jTFCpf.addActionListener(e -> jTFEmail.requestFocus());
        jTFEmail.addActionListener(e -> jTFTelefone.requestFocus());
        jTFTelefone.addActionListener(e -> jBCadastrar.doClick());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLLogo = new javax.swing.JLabel();
        jTFCpf = new javax.swing.JTextField();
        jTFNome = new javax.swing.JTextField();
        jTFEmail = new javax.swing.JTextField();
        jTFTelefone = new javax.swing.JTextField();
        jTFUsuario = new javax.swing.JTextField();
        jBCadastrar = new javax.swing.JButton();
        jPFSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");

        jLLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/logo pereira.png"))); // NOI18N

        jTFCpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFCpf.setForeground(new java.awt.Color(153, 153, 153));
        jTFCpf.setText("CPF");
        jTFCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFCpfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFCpfFocusLost(evt);
            }
        });

        jTFNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFNome.setForeground(new java.awt.Color(153, 153, 153));
        jTFNome.setText("Nome completo");
        jTFNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFNomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFNomeFocusLost(evt);
            }
        });

        jTFEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFEmail.setForeground(new java.awt.Color(153, 153, 153));
        jTFEmail.setText("Email");
        jTFEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFEmailFocusLost(evt);
            }
        });

        jTFTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFTelefone.setForeground(new java.awt.Color(153, 153, 153));
        jTFTelefone.setText("Telefone");
        jTFTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFTelefoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFTelefoneFocusLost(evt);
            }
        });

        jTFUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFUsuario.setForeground(new java.awt.Color(153, 153, 153));
        jTFUsuario.setText("Usuário");
        jTFUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFUsuarioFocusLost(evt);
            }
        });

        jBCadastrar.setBackground(new java.awt.Color(90, 90, 205));
        jBCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        jBCadastrar.setText("CADASTRAR");
        jBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarActionPerformed(evt);
            }
        });

        jPFSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPFSenha.setForeground(new java.awt.Color(153, 153, 153));
        jPFSenha.setText("senhasenha");
        jPFSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPFSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPFSenhaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTFNome, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(jTFUsuario)
                    .addComponent(jTFCpf)
                    .addComponent(jTFEmail)
                    .addComponent(jTFTelefone)
                    .addComponent(jPFSenha))
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jBCadastrar)
                .addContainerGap(100, Short.MAX_VALUE))
            .addComponent(jLLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed
            String senha = new String(jPFSenha.getPassword());
        if (!jTFNome.getText().equals("") && !jTFNome.getText().equals("Nome completo")){
            String nomeUsuario = jTFNome.getText();          
            if (!jTFUsuario.getText().equals("") && !jTFUsuario.getText().equals("Usuário")){               
                String login = jTFUsuario.getText();
                if(!senha.equals("") && !senha.equals("senhasenha")) {
                    if (!jTFCpf.getText().equals("") && !jTFCpf.getText().equals("CPF")){
                        String cpf = jTFCpf.getText();
                        if (!jTFEmail.getText().equals("") && !jTFEmail.getText().equals("Email")){
                            String email = jTFEmail.getText();
                            if (!jTFTelefone.getText().equals("") && !jTFTelefone.getText().equals("Telefone")){
                                String telefone = jTFTelefone.getText();
                                  
                                Administrador administrador = new Administrador(nomeUsuario, login, senha, cpf, email, telefone, 0);
                                
                                boolean usuarioExiste = TeatroPereiraCliente.ccont.usuarioExiste(administrador);
                                if (usuarioExiste == true){
                                    JOptionPane.showMessageDialog(rootPane, "Nome de usuário já existente. Tente outro");
                                    jTFUsuario.grabFocus();
                                } else {
                                    boolean resultado = TeatroPereiraCliente.ccont.usuarioInserir(administrador);
                                
                                    if (resultado == true){
                                        JOptionPane.showMessageDialog(rootPane, "Usuário inserido com sucesso.");
                                        dispose();
                                    } else {
                                        JOptionPane.showMessageDialog(rootPane, "Erro: usuário não pode ser cadastrado.");
                                    }
                                }
                                
                            } else{
                                JOptionPane.showMessageDialog(rootPane, "Erro: informe o telefone.");
                                jTFTelefone.grabFocus();
                            }                                 
                        } else{
                                JOptionPane.showMessageDialog(rootPane, "\"Erro: informe o email");
                                jTFEmail.grabFocus();
                        }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "\"Erro: informe o CPF.");
                        jTFCpf.grabFocus();
                    }
                } else{
                    JOptionPane.showMessageDialog(rootPane, "Erro: informe a senha.");
                    jPFSenha.grabFocus();
                }
            } else{
                JOptionPane.showMessageDialog(rootPane, "Erro: informe o usuário.");
                jTFUsuario.grabFocus();
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Erro: informe o nome.");
            jTFNome.grabFocus();
        }   
        
    }//GEN-LAST:event_jBCadastrarActionPerformed

    private void jTFNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFNomeFocusGained
        if (jTFNome.getText().equals("Nome completo")) {
            jTFNome.setText("");
        }
    }//GEN-LAST:event_jTFNomeFocusGained

    private void jTFNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFNomeFocusLost
        if (jTFNome.getText().isEmpty()) {
            jTFNome.setText("Nome completo");
        }
    }//GEN-LAST:event_jTFNomeFocusLost

    private void jTFUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFUsuarioFocusGained
        if (jTFUsuario.getText().equals("Usuário")) {
            jTFUsuario.setText("");
        }
    }//GEN-LAST:event_jTFUsuarioFocusGained

    private void jTFUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFUsuarioFocusLost
        if (jTFUsuario.getText().isEmpty()) {
            jTFUsuario.setText("Usuário");
        }
    }//GEN-LAST:event_jTFUsuarioFocusLost

    private void jPFSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPFSenhaFocusGained
        if (new String(jPFSenha.getPassword()).equals("senhasenha")) {
            jPFSenha.setText("");
        }
    }//GEN-LAST:event_jPFSenhaFocusGained

    private void jPFSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPFSenhaFocusLost
        if (new String(jPFSenha.getPassword()).isEmpty()) {
            jPFSenha.setText("senhasenha");
        }
    }//GEN-LAST:event_jPFSenhaFocusLost

    private void jTFCpfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFCpfFocusGained
        if (jTFCpf.getText().equals("CPF")) {
            jTFCpf.setText("");
        }
    }//GEN-LAST:event_jTFCpfFocusGained

    private void jTFCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFCpfFocusLost
        if (jTFCpf.getText().isEmpty()) {
            jTFCpf.setText("CPF");
        }
    }//GEN-LAST:event_jTFCpfFocusLost

    private void jTFEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFEmailFocusGained
        if (jTFEmail.getText().equals("Email")) {
            jTFEmail.setText("");
        }
    }//GEN-LAST:event_jTFEmailFocusGained

    private void jTFEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFEmailFocusLost
        if (jTFEmail.getText().isEmpty()) {
            jTFEmail.setText("Email");
        }
    }//GEN-LAST:event_jTFEmailFocusLost

    private void jTFTelefoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFTelefoneFocusGained
        if (jTFTelefone.getText().equals("Telefone")) {
            jTFTelefone.setText("");
        }
    }//GEN-LAST:event_jTFTelefoneFocusGained

    private void jTFTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFTelefoneFocusLost
        if (jTFTelefone.getText().isEmpty()) {
            jTFTelefone.setText("Telefone");
        }
    }//GEN-LAST:event_jTFTelefoneFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JLabel jLLogo;
    private javax.swing.JPasswordField jPFSenha;
    private javax.swing.JTextField jTFCpf;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFTelefone;
    private javax.swing.JTextField jTFUsuario;
    // End of variables declaration//GEN-END:variables
}