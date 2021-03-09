/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoiceGenerator.view;

import invoiceGenerator.util.AuthorisationUtil;

import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author tnebes
 */
public class Authorisation extends javax.swing.JFrame {

    private boolean enterFlag = false;
    
    /**
     * Creates new form Authorisation
     */
    public Authorisation() {      
        initComponents();
        // TODO remove this
        txtUsernameTextField.setText("tnebes@drau.de");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblUsernameLabel = new javax.swing.JLabel();
        lblPasswordLabel = new javax.swing.JLabel();
        txtUsernameTextField = new javax.swing.JTextField();
        pswPasswordTextField = new javax.swing.JPasswordField();
        btnLoginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("background");

        lblUsernameLabel.setText("username");

        lblPasswordLabel.setText("password");

        txtUsernameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsernameTextFieldKeyReleased(evt);
            }
        });

        pswPasswordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pswPasswordTextFieldKeyReleased(evt);
            }
        });

        btnLoginButton.setText("login");
        btnLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginButtonActionPerformed(evt);
            }
        });
        btnLoginButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnLoginButtonKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPasswordLabel)
                            .addComponent(lblUsernameLabel)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsernameTextField)
                            .addComponent(pswPasswordTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnLoginButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsernameLabel)
                    .addComponent(txtUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPasswordLabel)
                    .addComponent(pswPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLoginButton)
                .addGap(41, 41, 41))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // TODO fix the double enter thing.
    private void btnLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginButtonActionPerformed
        if (AuthorisationUtil.login(this, txtUsernameTextField, pswPasswordTextField)) {
            this.setVisible(false);
            AuthorisationUtil.createMainMenu();
        }
    }//GEN-LAST:event_btnLoginButtonActionPerformed

    private void pswPasswordTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswPasswordTextFieldKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !enterFlag) {
            if (AuthorisationUtil.login(this, txtUsernameTextField, pswPasswordTextField)) {
                this.setVisible(false);
                AuthorisationUtil.createMainMenu();
            }
        }
    }//GEN-LAST:event_pswPasswordTextFieldKeyReleased

    private void txtUsernameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameTextFieldKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !enterFlag) {
            if (AuthorisationUtil.login(this, txtUsernameTextField, pswPasswordTextField)) {
                this.setVisible(false);
                AuthorisationUtil.createMainMenu();
            }
        }
    }//GEN-LAST:event_txtUsernameTextFieldKeyReleased

    private void btnLoginButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginButtonKeyReleased
        pswPasswordTextFieldKeyReleased(evt);
    }//GEN-LAST:event_btnLoginButtonKeyReleased

    /**
     * @param args the command line arguments
     */

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblPasswordLabel;
    private javax.swing.JLabel lblUsernameLabel;
    private javax.swing.JPasswordField pswPasswordTextField;
    private javax.swing.JTextField txtUsernameTextField;
    // End of variables declaration//GEN-END:variables

    public void handleError(JComponent component, String message) {
        JOptionPane.showMessageDialog(rootPane, message);
        component.requestFocus();
    }
    
}
