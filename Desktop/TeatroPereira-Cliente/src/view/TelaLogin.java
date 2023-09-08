/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

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
        jTFSenha = new javax.swing.JTextField();
        jBEntrar = new javax.swing.JButton();
        jBCadastro = new javax.swing.JButton();
        jLRecuperarSenha = new javax.swing.JLabel();
        jLLogo = new javax.swing.JLabel();
        jLTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jTFUsuario.setForeground(new java.awt.Color(153, 153, 153));
        jTFUsuario.setText("Usuário");

        jTFSenha.setForeground(new java.awt.Color(153, 153, 153));
        jTFSenha.setText("Senha");

        jBEntrar.setBackground(new java.awt.Color(90, 90, 205));
        jBEntrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBEntrar.setForeground(new java.awt.Color(255, 255, 255));
        jBEntrar.setText("Entrar");

        jBCadastro.setBackground(new java.awt.Color(90, 90, 205));
        jBCadastro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBCadastro.setForeground(new java.awt.Color(255, 255, 255));
        jBCadastro.setText("Cadastro");
        jBCadastro.setAlignmentX(0.5F);

        jLRecuperarSenha.setForeground(new java.awt.Color(90, 90, 205));
        jLRecuperarSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLRecuperarSenha.setText("Esqueceu sua senha?");

        jLLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLLogo.setText("logo");

        jLTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLTitulo.setForeground(new java.awt.Color(90, 90, 205));
        jLTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTitulo.setText("LOGIN");
        jLTitulo.setToolTipText("");
        jLTitulo.setAlignmentY(0.0F);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLRecuperarSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jBEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLTitulo)
                .addGap(20, 20, 20)
                .addComponent(jLLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTFSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jLRecuperarSenha)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadastro;
    private javax.swing.JButton jBEntrar;
    private javax.swing.JLabel jLLogo;
    private javax.swing.JLabel jLRecuperarSenha;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JTextField jTFSenha;
    private javax.swing.JTextField jTFUsuario;
    // End of variables declaration//GEN-END:variables
}