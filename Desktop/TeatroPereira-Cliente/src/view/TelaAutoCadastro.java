/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro");

        jLLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/logo pereira.png"))); // NOI18N

        jTFCpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFCpf.setForeground(new java.awt.Color(153, 153, 153));
        jTFCpf.setText("CPF");

        jTFNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFNome.setForeground(new java.awt.Color(153, 153, 153));
        jTFNome.setText("Nome completo");

        jTFEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFEmail.setForeground(new java.awt.Color(153, 153, 153));
        jTFEmail.setText("Email");

        jTFTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFTelefone.setForeground(new java.awt.Color(153, 153, 153));
        jTFTelefone.setText("Telefone");

        jTFUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFUsuario.setForeground(new java.awt.Color(153, 153, 153));
        jTFUsuario.setText("Usuário");

        jBCadastrar.setBackground(new java.awt.Color(90, 90, 205));
        jBCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        jBCadastrar.setText("CADASTRAR");

        jPFSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPFSenha.setForeground(new java.awt.Color(153, 153, 153));
        jPFSenha.setText("jPasswordField1");

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
