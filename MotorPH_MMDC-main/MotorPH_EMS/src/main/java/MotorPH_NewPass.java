package default package;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class MotorPH_NewPass extends javax.swing.JFrame {
    private final String username;
    private final Connection connection;

    public MotorPH_NewPass(String username, Connection connection) {
        this.username = username;
        this.connection = connection;
        initComponents();
    }

    private void changePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        String oldPassword = new String(Oldpassf.getPassword());
        String newPassword = new String(Newpassf.getPassword());
        String confirmPassword = new String(Confpassf.getPassword());

        // Validate old password
        if (validateOldPassword(username, oldPassword)) {
            // Check if new password matches confirm password
            if (newPassword.equals(confirmPassword)) {
                // Update password in the database
                updatePassword(username, newPassword);

                // Update 'first_login' status to false
                updateFirstLoginStatus(username);

                JOptionPane.showMessageDialog(this, "Password changed successfully!");
                this.dispose();  // Close the ChangePasswordForm
            } else {
                JOptionPane.showMessageDialog(this, "New password and confirm password do not match.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid old password.");
        }
    }                                                     

    private boolean validateOldPassword(String username, String oldPassword) {
        try {
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, oldPassword);
            ResultSet resultSet = preparedStatement.executeQuery();

            boolean isValid = resultSet.next();

            resultSet.close();
            preparedStatement.close();

            return isValid;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void updatePassword(String username, String newPassword) {
        try {
            String query = "UPDATE users SET password=? WHERE username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateFirstLoginStatus(String username) {
        try {
            String query = "UPDATE users SET first_login=false WHERE username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        UpdatePass = new javax.swing.JButton();
        OldPasst = new javax.swing.JLabel();
        NewPasst = new javax.swing.JLabel();
        ConfPasst = new javax.swing.JLabel();
        Newpassf = new javax.swing.JPasswordField();
        Oldpassf = new javax.swing.JPasswordField();
        Confpassf = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1030, 770));

        UpdatePass.setFont(new java.awt.Font("Maiandra GD", 0, 12)); // NOI18N
        UpdatePass.setText("Update Password");
        UpdatePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatePassActionPerformed(evt);
            }
        });

        OldPasst.setFont(new java.awt.Font("Maiandra GD", 0, 12)); // NOI18N
        OldPasst.setText("Old Password:");

        NewPasst.setFont(new java.awt.Font("Maiandra GD", 0, 12)); // NOI18N
        NewPasst.setText("New Password:");

        ConfPasst.setFont(new java.awt.Font("Maiandra GD", 0, 12)); // NOI18N
        ConfPasst.setText("Confirm Password:");

        Oldpassf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OldpassfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(335, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NewPasst)
                            .addComponent(OldPasst)
                            .addComponent(ConfPasst))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Confpassf, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Newpassf, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Oldpassf, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(329, 329, 329))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(UpdatePass)
                        .addGap(441, 441, 441))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OldPasst)
                    .addComponent(Oldpassf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NewPasst)
                    .addComponent(Newpassf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ConfPasst)
                    .addComponent(Confpassf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addComponent(UpdatePass)
                .addContainerGap(414, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OldpassfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OldpassfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OldpassfActionPerformed

    private void UpdatePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatePassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdatePassActionPerformed

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
            java.util.logging.Logger.getLogger(MotorPH_NewPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MotorPH_NewPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MotorPH_NewPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MotorPH_NewPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MotorPH_NewPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ConfPasst;
    private javax.swing.JPasswordField Confpassf;
    private javax.swing.JLabel NewPasst;
    private javax.swing.JPasswordField Newpassf;
    private javax.swing.JLabel OldPasst;
    private javax.swing.JPasswordField Oldpassf;
    private javax.swing.JButton UpdatePass;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

