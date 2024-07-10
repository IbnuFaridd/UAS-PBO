
package Jframe;

import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class DataProdi extends javax.swing.JFrame {
    
    DefaultTableModel model;
    
    public DataProdi() {
        initComponents();
        setTitle("Data Program Studi");
        setProdiDetails();

    }

    
    public void setProdiDetails(){
        try{
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from program_studi");
            
            while(rs.next()){
                String IDProdi = rs.getString("ID_Prodi");
                String NamaProdi = rs.getString("Nama_Prodi");
                String Fakultas = rs.getString("Fakultas");
                String akreditasi = rs.getString("akreditasi");
                
                Object[] obj = {IDProdi,NamaProdi,Fakultas,akreditasi};
                model = (DefaultTableModel)tbl_prodi.getModel();
                model.addRow(obj);
                
            }
        }
    catch (Exception e) {
        
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_signup = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jdl_username = new javax.swing.JLabel();
        txt_idProdi = new javax.swing.JTextField();
        txt_prodi = new javax.swing.JTextField();
        jdl_username1 = new javax.swing.JLabel();
        jdl_username3 = new javax.swing.JLabel();
        button_Add = new javax.swing.JButton();
        button_Update = new javax.swing.JButton();
        button_Delete = new javax.swing.JButton();
        jdl_username4 = new javax.swing.JLabel();
        txt_akreditasi = new javax.swing.JTextField();
        txt_fakultas = new javax.swing.JTextField();
        button_Delete1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_cariProdi = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_prodi = new rojerusan.RSTableMetro();

        button_signup.setBackground(new java.awt.Color(255, 204, 0));
        button_signup.setText("Sign Up");
        button_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_signupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(102, 102, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Back_40Px2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jdl_username.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jdl_username.setForeground(new java.awt.Color(255, 255, 255));
        jdl_username.setText("ID Program Studi");
        jPanel1.add(jdl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        txt_idProdi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_idProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idProdiActionPerformed(evt);
            }
        });
        jPanel1.add(txt_idProdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 247, 36));

        txt_prodi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_prodiActionPerformed(evt);
            }
        });
        jPanel1.add(txt_prodi, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 247, 36));

        jdl_username1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jdl_username1.setForeground(new java.awt.Color(255, 255, 255));
        jdl_username1.setText("Nama Program Studi");
        jPanel1.add(jdl_username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        jdl_username3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jdl_username3.setForeground(new java.awt.Color(255, 255, 255));
        jdl_username3.setText("Fakultas");
        jPanel1.add(jdl_username3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        button_Add.setBackground(new java.awt.Color(51, 204, 0));
        button_Add.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        button_Add.setForeground(new java.awt.Color(255, 255, 255));
        button_Add.setText("ADD");
        button_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_AddActionPerformed(evt);
            }
        });
        jPanel1.add(button_Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 130, 30));

        button_Update.setBackground(new java.awt.Color(255, 204, 51));
        button_Update.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        button_Update.setForeground(new java.awt.Color(255, 255, 255));
        button_Update.setText("UPDATE");
        button_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_UpdateActionPerformed(evt);
            }
        });
        jPanel1.add(button_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 130, 30));

        button_Delete.setBackground(new java.awt.Color(255, 102, 102));
        button_Delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        button_Delete.setForeground(new java.awt.Color(255, 255, 255));
        button_Delete.setText("DELETE");
        button_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(button_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 130, 30));

        jdl_username4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jdl_username4.setForeground(new java.awt.Color(255, 255, 255));
        jdl_username4.setText("Akreditas");
        jPanel1.add(jdl_username4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        txt_akreditasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_akreditasiActionPerformed(evt);
            }
        });
        jPanel1.add(txt_akreditasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 247, 36));

        txt_fakultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fakultasActionPerformed(evt);
            }
        });
        jPanel1.add(txt_fakultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 247, 36));

        button_Delete1.setBackground(new java.awt.Color(255, 0, 0));
        button_Delete1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        button_Delete1.setForeground(new java.awt.Color(255, 255, 255));
        button_Delete1.setText("RESET");
        button_Delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_Delete1ActionPerformed(evt);
            }
        });
        jPanel1.add(button_Delete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 130, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 600));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1212, 38, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1206, 0, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel4.setText("  x");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 42, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(96, 123, 179));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/graduation.png"))); // NOI18N
        jLabel6.setText(" Data Program Studi");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        jLabel1.setText("Cari Program Studi:");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 140, 30));

        txt_cariProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariProdiActionPerformed(evt);
            }
        });
        txt_cariProdi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariProdiKeyReleased(evt);
            }
        });
        jPanel5.add(txt_cariProdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 200, 30));

        tbl_prodi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Prodi", "Nama", "Fakultas", "Akreditasi"
            }
        ));
        tbl_prodi.setColorBackgoundHead(new java.awt.Color(96, 123, 179));
        tbl_prodi.setRowHeight(25);
        tbl_prodi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_prodiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_prodi);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 660, 310));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 0, 790, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    
   public boolean isValid_IDProdi(String idProdi) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT COUNT(*) FROM program_studi WHERE ID_Prodi = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, idProdi);
            
            ResultSet resultSet = pst.executeQuery();
            resultSet.next();
            int rowCount = resultSet.getInt(1);
            
            return rowCount == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
   
    public boolean addProdi() {
        boolean isAdded = false;
        
        String idProdi = txt_idProdi.getText();
        String prodi = txt_prodi.getText();
        String fakultas = txt_fakultas.getText();
        String akreditasi = txt_akreditasi.getText();

        try {
            Connection con = DBConnection.getConnection();
            // SQL query with auto-increment for ID_Prodi
            String sql = "INSERT INTO program_studi VALUES (?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, idProdi);
            pst.setString(2, prodi);
            pst.setString(3, fakultas);
            pst.setString(4, akreditasi);

            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isAdded = true;
            } else {
                isAdded = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    //method clear table
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_prodi.getModel();
        model.setRowCount(0);
    }

    public boolean updateProdi() {
        boolean isUpdated = false;

        String idProdi = txt_idProdi.getText();
        String prodi = txt_prodi.getText();
        String fakultas = txt_fakultas.getText();
        String akreditasi = txt_akreditasi.getText();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE program_studi SET Nama_Prodi = ?, Fakultas = ?, akreditasi = ? WHERE ID_Prodi = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, prodi);
            pst.setString(2, fakultas);
            pst.setString(3, akreditasi);
            pst.setString(4, idProdi);

            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isUpdated = true;
            } else {
                isUpdated = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    
    // method delete Prodi
    public boolean deleteProdi() {
        boolean isDeleted = false;
        String idProdi = txt_idProdi.getText();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM program_studi WHERE ID_Prodi = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, idProdi);

            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isDeleted = true;
            } else {
                isDeleted = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    public void cariData() {
        clearTable();
        String cari = txt_cariProdi.getText();
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM program_studi WHERE ID_Prodi LIKE '%" + cari + "%' OR Nama_Prodi LIKE '%" + cari + "%' OR Fakultas LIKE '%" + cari + "%' OR akreditasi LIKE '%" + cari + "%'";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String idProdi = rs.getString("ID_Prodi");
                String namaProdi = rs.getString("Nama_Prodi");
                String fakultas = rs.getString("Fakultas");
                String akreditasi = rs.getString("akreditasi");

                Object[] obj = {idProdi, namaProdi, fakultas, akreditasi};
                model = (DefaultTableModel) tbl_prodi.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    private void txt_idProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idProdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idProdiActionPerformed

    private void txt_prodiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_prodiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_prodiActionPerformed

    private void button_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_signupActionPerformed
 
    }//GEN-LAST:event_button_signupActionPerformed

    private void button_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AddActionPerformed
    String prodiID = txt_idProdi.getText();
    String namaProdiText = txt_prodi.getText();
    String fakultasText = txt_fakultas.getText();
    String akreditasiText = txt_akreditasi.getText();

    // Memeriksa apakah salah satu form kosong
    if (prodiID.isEmpty() || namaProdiText.isEmpty() || fakultasText.isEmpty() || akreditasiText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Formulir Masih Kosong");
    } else {
        // Memeriksa apakah ID Prodi sudah ada dalam database
        if (!isValid_IDProdi(prodiID)) {
            JOptionPane.showMessageDialog(this, "ID Prodi sudah ada dalam database");
            return; // Menghentikan proses karena ID Prodi sudah ada
        }

        // Tidak perlu pemeriksaan ID Produk karena dihasilkan otomatis
        if (addProdi()) {
            JOptionPane.showMessageDialog(this, "Program Studi Berhasil Ditambahkan");
            clearTable();
            setProdiDetails();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Penambahan Program Studi Gagal");
        }
    }
    }//GEN-LAST:event_button_AddActionPerformed

    private void button_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_UpdateActionPerformed
    String prodiID = txt_idProdi.getText();
    String namaProdi = txt_prodi.getText();
    String fakultas = txt_fakultas.getText();
    String akreditasi = txt_akreditasi.getText();

    // Memeriksa apakah salah satu form kosong
    if (prodiID.isEmpty() || namaProdi.isEmpty() || fakultas.isEmpty() || akreditasi.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Data Belum Dipilih");
    } else {
        if (updateProdi() == true) {
            JOptionPane.showMessageDialog(this, "Program Studi Berhasil Diperbarui");
            clearTable();
            setProdiDetails();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Pembaharuan Program Studi Gagal");
        }
    }
    }//GEN-LAST:event_button_UpdateActionPerformed

    private void button_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_DeleteActionPerformed
    String idProdi = txt_idProdi.getText();

    // Memeriksa apakah form productId kosong
    if (idProdi.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Data Belum Dipilih");
    } else {
        int confirm = JOptionPane.showConfirmDialog(
            this, 
            "Apakah Anda yakin ingin menghapus Program Studi " + idProdi + "?", 
            "Konfirmasi Penghapusan", 
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            if (deleteProdi()) {
                JOptionPane.showMessageDialog(this, "Produk Berhasil Dihapus");
                clearTable();
                setProdiDetails();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Penghapusan Produk Gagal");
            }
        }
    }
    }//GEN-LAST:event_button_DeleteActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void txt_cariProdiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariProdiKeyReleased
        // TODO add your handling code here:
        cariData();
    }//GEN-LAST:event_txt_cariProdiKeyReleased

    private void tbl_prodiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodiMouseClicked
     int rowNo = tbl_prodi.getSelectedRow();
    TableModel model = tbl_prodi.getModel();

    txt_idProdi.setText(model.getValueAt(rowNo, 0).toString());
    txt_prodi.setText(model.getValueAt(rowNo, 1).toString());
    txt_fakultas.setText(model.getValueAt(rowNo, 2).toString());
    txt_akreditasi.setText(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_tbl_prodiMouseClicked

    private void txt_cariProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariProdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cariProdiActionPerformed

    private void txt_akreditasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_akreditasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_akreditasiActionPerformed

    private void txt_fakultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fakultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fakultasActionPerformed

    private void button_Delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_Delete1ActionPerformed
        clearForm();
    }//GEN-LAST:event_button_Delete1ActionPerformed

    private void clearForm(){
        txt_idProdi.setText("");
        txt_prodi.setText("");
        txt_fakultas.setText("");
        txt_akreditasi.setText("");
                 
    }
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
            java.util.logging.Logger.getLogger(DataProdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataProdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataProdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataProdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataProdi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Add;
    private javax.swing.JButton button_Delete;
    private javax.swing.JButton button_Delete1;
    private javax.swing.JButton button_Update;
    private javax.swing.JButton button_signup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jdl_username;
    private javax.swing.JLabel jdl_username1;
    private javax.swing.JLabel jdl_username3;
    private javax.swing.JLabel jdl_username4;
    private rojerusan.RSTableMetro tbl_prodi;
    private javax.swing.JTextField txt_akreditasi;
    private javax.swing.JTextField txt_cariProdi;
    private javax.swing.JTextField txt_fakultas;
    private javax.swing.JTextField txt_idProdi;
    private javax.swing.JTextField txt_prodi;
    // End of variables declaration//GEN-END:variables

    private void diapose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
