/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelDominio.Hash;
import modelDominio.Usuario;

/**
 *  trabalho interdisciplinar
 * @author laura ferreira & gabriel hackenhaar
 */
public class TelaLogin extends javax.swing.JFrame {

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
        
        jLLogo.requestFocus();
        
        jTFUsuario.addActionListener(e -> jPFSenha.requestFocus());
        jPFSenha.addActionListener(e -> jBEntrar.doClick());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTFUsuario = new javax.swing.JTextField();
        jBEntrar = new javax.swing.JButton();
        jBCadastro = new javax.swing.JButton();
        jLRecuperarSenha = new javax.swing.JLabel();
        jLLogo = new javax.swing.JLabel();
        jPFSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

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

        jBEntrar.setBackground(new java.awt.Color(90, 90, 205));
        jBEntrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBEntrar.setForeground(new java.awt.Color(255, 255, 255));
        jBEntrar.setText("Entrar");
        jBEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEntrarActionPerformed(evt);
            }
        });

        jBCadastro.setBackground(new java.awt.Color(90, 90, 205));
        jBCadastro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBCadastro.setForeground(new java.awt.Color(255, 255, 255));
        jBCadastro.setText("Cadastrar");
        jBCadastro.setAlignmentX(0.5F);
        jBCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastroActionPerformed(evt);
            }
        });

        jLRecuperarSenha.setForeground(new java.awt.Color(90, 90, 205));
        jLRecuperarSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLRecuperarSenha.setText("Esqueceu sua senha?");
        jLRecuperarSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLRecuperarSenhaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLRecuperarSenhaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLRecuperarSenhaMouseExited(evt);
            }
        });

        jLLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/logo pereira.png"))); // NOI18N

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
        jPFSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPFSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPFSenha)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLRecuperarSenha)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLRecuperarSenha)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEntrarActionPerformed
        String senha = new String(jPFSenha.getPassword());
        if(!jTFUsuario.getText().equals("")) {
            if(!senha.equals("")) {
                try {
                    String login = jTFUsuario.getText();
                    String senhaCriptografada = Hash.encriptar(senha, "SHA-256");
                    
                    Usuario usuario = new Usuario(login, senhaCriptografada);
                    
                    Usuario usuarioLogado = TeatroPereiraCliente.ccont.efetuarlogin(usuario);
                    
                    if (usuarioLogado != null) {
                        //JOptionPane.showMessageDialog(rootPane, "Autenticação efetuada com sucesso.");
                        TeatroPereiraCliente.ccont.usuarioLogado = usuarioLogado;
                        TelaHome telaHome = new TelaHome();
                        telaHome.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Erro: usuário e/ou senha inválidos.");
                    }
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Erro: informe a senha.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Erro: informe o usuário.");
        }
    }//GEN-LAST:event_jBEntrarActionPerformed

    private void jBCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastroActionPerformed
        TelaAutoCadastro telaAutoCadastro = new TelaAutoCadastro();
        telaAutoCadastro.setVisible(true);
    }//GEN-LAST:event_jBCadastroActionPerformed

    private void jLRecuperarSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLRecuperarSenhaMouseClicked
        TelaRecuperarSenha telaRecuperarSenha = new TelaRecuperarSenha();
        telaRecuperarSenha.setVisible(true);
    }//GEN-LAST:event_jLRecuperarSenhaMouseClicked

    private void jPFSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPFSenhaActionPerformed
        jPFSenha.setText("");
    }//GEN-LAST:event_jPFSenhaActionPerformed

    private void jLRecuperarSenhaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLRecuperarSenhaMouseExited
        jLRecuperarSenha.setForeground(new Color(90, 90, 205));
    }//GEN-LAST:event_jLRecuperarSenhaMouseExited

    private void jLRecuperarSenhaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLRecuperarSenhaMouseEntered
        jLRecuperarSenha.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLRecuperarSenhaMouseEntered

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadastro;
    private javax.swing.JButton jBEntrar;
    private javax.swing.JLabel jLLogo;
    private javax.swing.JLabel jLRecuperarSenha;
    private javax.swing.JPasswordField jPFSenha;
    private javax.swing.JTextField jTFUsuario;
    // End of variables declaration//GEN-END:variables
}
