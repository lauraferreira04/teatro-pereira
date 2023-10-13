/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JOptionPane;
import modelDominio.Administrador;
import modelDominio.Usuario;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *  trabalho interdisciplinar
 * @author laura ferreira & gabriel hackenhaar
 */
public class TelaRecuperarSenha extends javax.swing.JFrame {
        
    public TelaRecuperarSenha() {
        initComponents();
        jLLogo.requestFocus();
        
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
        jTFEmail = new javax.swing.JTextField();
        jBAlterar = new javax.swing.JButton();
        jTFUsuario = new javax.swing.JTextField();
        jTFCpf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recuperar senha");

        jLLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/logo pereira.png"))); // NOI18N

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

        jBAlterar.setBackground(new java.awt.Color(90, 90, 205));
        jBAlterar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBAlterar.setForeground(new java.awt.Color(255, 255, 255));
        jBAlterar.setText("ALTERAR");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jTFCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        if(!jTFUsuario.getText().equals("") && !jTFUsuario.getText().equals("Usuário")) {
            String login = jTFUsuario.getText();
            if (!jTFCpf.getText().equals("") && !jTFCpf.getText().equals("CPF")){
                String cpf = jTFCpf.getText();
                if (!jTFEmail.getText().equals("") && !jTFEmail.getText().equals("Email")){
                    String email = jTFEmail.getText();
                    //pega os dados e cria o objeto
                    Usuario usuario = new Usuario(login, cpf, email);
                    //manda o objeto com login, cpf e email para o usuarioExiste
                    boolean usuarioExiste = TeatroPereiraCliente.ccont.usuarioExiste(usuario);
                   
                    if (usuarioExiste == true){ // se usuario existe
                        //senha recebe senha padrão de recuperação 123456
                        String senha = "123456";
                        //cria o objeto com login, cpf, email e senha
                        Usuario usuario1 = new Usuario(login, cpf, email, senha);
                        
                        
                        
                        boolean resultado = TeatroPereiraCliente.ccont.usuarioAlterar(usuario1);
                        if(resultado == true) { //se alterou sem erro
                                                      
                            //espaço dedicado para os requesitos necessários para enviar email (JavaMail)
                            //...
                            try {
                                enviarEmailRecuperacao(email, senha);
                            } catch(MessagingException e){
                                e.printStackTrace();
                                JOptionPane.showMessageDialog(rootPane, "Erro ao enviar e-mail de recuperação: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        
                            }
                            
                            
                            JOptionPane.showMessageDialog(null, "Foi enviado um email com sua nova senha,"
                            + " troque-a assim que fizer login novamente", "Senha alterada", JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                        } else { //deu erro para alterar
                            JOptionPane.showMessageDialog(rootPane, "Erro: usuário não pode ser atualizado.");
                        }
                        
                    } else { //usuario não existe, método usuarioExiste == false
                        JOptionPane.showMessageDialog(null, "O usuário, cpf e/ou email informado não existe,"
                            + " confira se as informações estão corretas", "Usuário não encontrado", JOptionPane.WARNING_MESSAGE);
                    }    
                    
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Erro: informe o email.");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Erro: informe o CPF.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Erro: informe o usuário.");
        }        
    }//GEN-LAST:event_jBAlterarActionPerformed

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

    private void jTFEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFEmailFocusLost
        if (jTFEmail.getText().isEmpty()) {
            jTFEmail.setText("Email");
        }
    }//GEN-LAST:event_jTFEmailFocusLost

    private void jTFEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFEmailFocusGained
        if (jTFEmail.getText().equals("Email")) {
            jTFEmail.setText("");
        }
    }//GEN-LAST:event_jTFEmailFocusGained

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

    private void enviarEmailRecuperacao(String destinatario, String novaSenha) throws MessagingException {
    // Configurações do servidor SMTP (no caso, Gmail)
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");

    // Sessão de e-mail
    Session session = Session.getDefaultInstance(props, new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("laurinhagameplayzin@gmail.com", "eumoronumacasa");
        }
    });

    // Criação da mensagem
    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress("laurinhagameplayzin@gmail.com"));
    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
    message.setSubject("Recuperação de Senha");
    message.setText("Você solicitou a recuperação de senha. Sua nova senha temporária é: " + novaSenha);

    // Envio da mensagem
    Transport.send(message);
    System.out.println("E-mail de recuperação enviado para: " + destinatario);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JLabel jLLogo;
    private javax.swing.JTextField jTFCpf;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFUsuario;
    // End of variables declaration//GEN-END:variables
}
