/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import java.util.Random;
import java.time.Year;
/**
 *
 * 
 */
public class DataMahasiswa extends javax.swing.JFrame {

    /**
     * Creates new form ManageStudents
     */
    String Id, Name,NoTelp,Email;
  
    DefaultTableModel model;
    
    public DataMahasiswa() {
        initComponents();
        setTitle("Data Mahasiswa"); // Menambahkan judul aplikasi
        setDetailsToTabel();
        
        //Agar id hanya menginput number
        txt_noTelp.addKeyListener(new KeyAdapter() {
    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c)) { // Memeriksa apakah karakter bukan angka
            e.consume(); // Mengabaikan keystroke jika bukan angka
        }
    }
});
        
    }
    
public void setDetailsToTabel() {
    try {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT NIM, Nama, Alamat, No_Telepon, Email, YEAR(Angkatan) AS Angkatan FROM mahasiswa");

        while (rs.next()) {
            String NIM = rs.getString("NIM");
            String Nama = rs.getString("Nama");
            String Alamat = rs.getString("Alamat");
            String NoTelp = rs.getString("No_Telepon");
            String Email = rs.getString("Email");
            String Angkatan = rs.getString("Angkatan");

            Object[] obj = {NIM, Nama, Alamat, NoTelp, Email, Angkatan};
            model = (DefaultTableModel) tbl_mahasiswa.getModel();
            model.addRow(obj);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_signup = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jdl_username = new javax.swing.JLabel();
        txt_NIM = new javax.swing.JTextField();
        txt_noTelp = new javax.swing.JTextField();
        jdl_username1 = new javax.swing.JLabel();
        jdl_username3 = new javax.swing.JLabel();
        button_Add = new javax.swing.JButton();
        button_Update = new javax.swing.JButton();
        button_Delete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        jdl_username4 = new javax.swing.JLabel();
        txt_alamat = new javax.swing.JTextField();
        jdl_username2 = new javax.swing.JLabel();
        combo_angkatan = new javax.swing.JComboBox<>();
        jdl_username5 = new javax.swing.JLabel();
        button_Reset = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_mahasiswa = new rojerusan.RSTableMetro();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();

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

        jPanel1.setBackground(new java.awt.Color(96, 123, 179));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jdl_username.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jdl_username.setForeground(new java.awt.Color(255, 255, 255));
        jdl_username.setText("NIM : ");
        jPanel1.add(jdl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        txt_NIM.setEditable(false);
        txt_NIM.setBackground(new java.awt.Color(204, 204, 204));
        txt_NIM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_NIM.setText("AUTO");
        txt_NIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NIMActionPerformed(evt);
            }
        });
        jPanel1.add(txt_NIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 247, 36));

        txt_noTelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_noTelpActionPerformed(evt);
            }
        });
        jPanel1.add(txt_noTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 247, 36));

        jdl_username1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jdl_username1.setForeground(new java.awt.Color(255, 255, 255));
        jdl_username1.setText("Nama Mahasiswa :");
        jPanel1.add(jdl_username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        jdl_username3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jdl_username3.setForeground(new java.awt.Color(255, 255, 255));
        jdl_username3.setText("No. Telpon :");
        jPanel1.add(jdl_username3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        button_Add.setBackground(new java.awt.Color(51, 204, 0));
        button_Add.setForeground(new java.awt.Color(255, 255, 255));
        button_Add.setText("ADD");
        button_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_AddActionPerformed(evt);
            }
        });
        jPanel1.add(button_Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, 110, 30));

        button_Update.setBackground(new java.awt.Color(255, 204, 0));
        button_Update.setForeground(new java.awt.Color(255, 255, 255));
        button_Update.setText("UPDATE");
        button_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_UpdateActionPerformed(evt);
            }
        });
        jPanel1.add(button_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, 110, 30));

        button_Delete.setBackground(new java.awt.Color(255, 52, 37));
        button_Delete.setForeground(new java.awt.Color(255, 255, 255));
        button_Delete.setText("DELETE");
        button_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(button_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, 113, 30));

        jLabel7.setBackground(new java.awt.Color(102, 102, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Back_40Px2.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 56, -1));

        txt_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 247, 36));

        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        jPanel1.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 247, 36));

        jdl_username4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jdl_username4.setForeground(new java.awt.Color(255, 255, 255));
        jdl_username4.setText("Angkatan :");
        jPanel1.add(jdl_username4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, -1));

        txt_alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_alamatActionPerformed(evt);
            }
        });
        jPanel1.add(txt_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 247, 36));

        jdl_username2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jdl_username2.setForeground(new java.awt.Color(255, 255, 255));
        jdl_username2.setText("Alamat :");
        jPanel1.add(jdl_username2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        combo_angkatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih-", "2023", "2024", "2025" }));
        combo_angkatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_angkatanActionPerformed(evt);
            }
        });
        jPanel1.add(combo_angkatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 250, 40));

        jdl_username5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jdl_username5.setForeground(new java.awt.Color(255, 255, 255));
        jdl_username5.setText("Email :");
        jPanel1.add(jdl_username5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        button_Reset.setBackground(new java.awt.Color(255, 0, 0));
        button_Reset.setForeground(new java.awt.Color(255, 255, 255));
        button_Reset.setText("RESET");
        button_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ResetActionPerformed(evt);
            }
        });
        jPanel1.add(button_Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 610, 113, 30));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_mahasiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIM", "Nama", "Alamat", "No. Telp", "Email", "Angkatan"
            }
        ));
        tbl_mahasiswa.setColorBackgoundHead(new java.awt.Color(96, 123, 179));
        tbl_mahasiswa.setRowHeight(25);
        tbl_mahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_mahasiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_mahasiswa);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(96, 123, 179));
        jLabel4.setText("Data Mahasiswa");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_People_50px.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        jLabel6.setText("Cari Mahasiswa");

        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Fungsi generateNIM
    public void generateNIM() {
        // Mendapatkan dua digit terakhir dari tahun saat ini
        int year = Year.now().getValue() % 100;

        // Membuat instance Random untuk menghasilkan angka acak
        Random random = new Random();
        
        // Menghasilkan 5 angka acak
        int randomNumber = random.nextInt(100000);  // menghasilkan angka antara 0 dan 99999
        
        // Menggunakan String.format untuk memastikan 5 angka dengan padding nol
        String formattedRandomNumber = String.format("%05d", randomNumber);
        
        // Menggabungkan tahun dan angka acak untuk mendapatkan NIM
        String NIM = year + formattedRandomNumber;

        // Mengatur nilai NIM ke dalam text field
        txt_NIM.setText(NIM);
    }
    
    public boolean addMahasiswa() {
    boolean isAdded = false;

    String NIM = txt_NIM.getText();
    String Name = txt_nama.getText();
    String Alamat = txt_alamat.getText();
    String NoTelp = txt_noTelp.getText();
    String Email = txt_email.getText();
    String Angkatan = combo_angkatan.getSelectedItem().toString();

    try {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO mahasiswa (NIM, Nama, Alamat, No_Telepon, Email, Angkatan) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, NIM);
        pst.setString(2, Name);
        pst.setString(3, Alamat);
        pst.setString(4, NoTelp);
        pst.setString(5, Email);
        pst.setString(6, Angkatan);

        int rowCount = pst.executeUpdate();
        isAdded = rowCount > 0;

    } catch (Exception e) {
        e.printStackTrace();
    }
    return isAdded;
}

    
      
        public boolean isValidNIM(String NIM) {
    boolean isValid = true;
    try {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM mahasiswa WHERE NIM = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, NIM);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            isValid = false;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return isValid;
}

        
    
    
    //method clear table
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_mahasiswa.getModel();
        model.setRowCount(0);
        
    }
 

    
    //update Student details
   
    public boolean updateMahasiswa() {
    boolean isUpdated = false;

    String NIM = txt_NIM.getText();
    String Name = txt_nama.getText();
    String Alamat = txt_alamat.getText();
    String NoTelp = txt_noTelp.getText();
    String Email = txt_email.getText();
    String Angkatan = combo_angkatan.getSelectedItem().toString();

    try {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE mahasiswa SET Nama = ?, Alamat = ?, No_Telepon = ?, Email = ?, Angkatan = ? WHERE NIM = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, Name);
        pst.setString(2, Alamat);
        pst.setString(3, NoTelp);
        pst.setString(4, Email);
        pst.setString(5, Angkatan);
        pst.setString(6, NIM);

        int rowCount = pst.executeUpdate();
        isUpdated = rowCount > 0;

    } catch (Exception e) {
        e.printStackTrace();
    }
    return isUpdated;
}

    
    
   public boolean deleteMahasiswa() {
    boolean isDeleted = false;
    String NIM = txt_NIM.getText();

    try {
        Connection con = DBConnection.getConnection();
        String sql = "DELETE FROM mahasiswa WHERE NIM = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, NIM);

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
    String cari = txt_cari.getText();
    try {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        String sql = "SELECT * FROM mahasiswa WHERE NIM LIKE '%" + cari + "%' OR Nama LIKE '%" + cari + "%' OR No_Telepon LIKE '%" + cari + "%' OR Email LIKE '%" + cari + "%'";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            String NIM = rs.getString("NIM");
            String Name = rs.getString("Nama");
            String NoTelp = rs.getString("No_Telepon");
            String Email = rs.getString("Email");
            String Alamat = rs.getString("Alamat");
            String Angkatan = rs.getString("Angkatan");

            Object[] obj = {NIM, Name, Alamat, NoTelp, Email, Angkatan};
            model = (DefaultTableModel) tbl_mahasiswa.getModel();
            model.addRow(obj);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    public void clearForm() {
        txt_NIM.setText("");
        txt_nama.setText("");
        txt_alamat.setText("");
        txt_noTelp.setText("");
        txt_email.setText("");
        combo_angkatan.setSelectedIndex(0);  // Mengatur combo_angkatan ke indeks pertama (biasanya untuk "-Pilih-")
    }


    private void txt_NIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NIMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NIMActionPerformed

    private void txt_noTelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_noTelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_noTelpActionPerformed

    private void button_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_signupActionPerformed
 
    }//GEN-LAST:event_button_signupActionPerformed

    private void button_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AddActionPerformed
    generateNIM();
    String NIM = txt_NIM.getText();
    String Name = txt_nama.getText();
    String Alamat = txt_alamat.getText();
    String NoTelp = txt_noTelp.getText();
    String Email = txt_email.getText();
    String Angkatan = combo_angkatan.getSelectedItem().toString();

    // Memeriksa apakah salah satu form kosong atau combo_angkatan masih memilih nilai awal
    if (NIM.isEmpty() || Name.isEmpty() || Alamat.isEmpty() || NoTelp.isEmpty() || Email.isEmpty() || Angkatan.isEmpty() || Angkatan.equals("-Pilih-")) {
        JOptionPane.showMessageDialog(this, "Harap lengkapi semua kolom dan pilih angkatan.");
    } else {
        boolean isValidNIM = isValidNIM(NIM);

        if (isValidNIM) {
            if (addMahasiswa()) {
                JOptionPane.showMessageDialog(this, "Mahasiswa Berhasil Ditambahkan");
                clearTable();
                setDetailsToTabel();
                clearForm();

            } else {
                JOptionPane.showMessageDialog(this, "Pendaftaran Mahasiswa Gagal");
            }
        } else {
            JOptionPane.showMessageDialog(this, "NIM Sudah Ada");
        }
    }

    }//GEN-LAST:event_button_AddActionPerformed

    private void button_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_UpdateActionPerformed
    String NIM = txt_NIM.getText();
    String Name = txt_nama.getText();
    String Alamat = txt_alamat.getText();
    String NoTelp = txt_noTelp.getText();
    String Email = txt_email.getText();
    String Angkatan = combo_angkatan.getSelectedItem().toString();

    // Memeriksa apakah salah satu form kosong
    if (NIM.isEmpty() || Name.isEmpty() || Alamat.isEmpty() || NoTelp.isEmpty() || Email.isEmpty() || Angkatan.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Data Belum Dipilih");
    } else {
        if (updateMahasiswa() == true) {
            JOptionPane.showMessageDialog(this, "Data Mahasiswa Berhasil Diperbarui");
            clearTable();
            setDetailsToTabel();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Pembaharuan Data Gagal");
        }
    }
    }//GEN-LAST:event_button_UpdateActionPerformed

    private void button_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_DeleteActionPerformed
    String NIM = txt_NIM.getText();
    String Name = txt_nama.getText();
    String Alamat = txt_alamat.getText();
    String NoTelp = txt_noTelp.getText();
    String Email = txt_email.getText();
    String Angkatan = combo_angkatan.getSelectedItem().toString();

    // Memeriksa apakah salah satu form kosong
    if (NIM.isEmpty() || Name.isEmpty() || Alamat.isEmpty() || NoTelp.isEmpty() || Email.isEmpty() || Angkatan.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Formulir Masih Kosong");
    } else {
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus Data " + Name + "?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (deleteMahasiswa()) {
                JOptionPane.showMessageDialog(this, "Data Mahasiswa Berhasil Dihapus");
                clearTable();
                setDetailsToTabel();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Penghapusan Data Gagal");
            }
        }
    }
    }//GEN-LAST:event_button_DeleteActionPerformed

    private void tbl_mahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_mahasiswaMouseClicked
        int rowNo = tbl_mahasiswa.getSelectedRow();
    TableModel model = tbl_mahasiswa.getModel();

    txt_NIM.setText(model.getValueAt(rowNo, 0).toString());
    txt_nama.setText(model.getValueAt(rowNo, 1).toString());
    txt_alamat.setText(model.getValueAt(rowNo, 2).toString());
    txt_noTelp.setText(model.getValueAt(rowNo, 3).toString());
    txt_email.setText(model.getValueAt(rowNo, 4).toString());
    combo_angkatan.setSelectedItem(model.getValueAt(rowNo, 5).toString());
        
    }//GEN-LAST:event_tbl_mahasiswaMouseClicked

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
        // TODO add your handling code here:
        cariData();
    }//GEN-LAST:event_txt_cariKeyReleased

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void txt_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namaActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_alamatActionPerformed

    private void combo_angkatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_angkatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_angkatanActionPerformed

    private void button_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ResetActionPerformed
        clearForm();
    }//GEN-LAST:event_button_ResetActionPerformed

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
            java.util.logging.Logger.getLogger(DataMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataMahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Add;
    private javax.swing.JButton button_Delete;
    private javax.swing.JButton button_Reset;
    private javax.swing.JButton button_Update;
    private javax.swing.JButton button_signup;
    private javax.swing.JComboBox<String> combo_angkatan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jdl_username;
    private javax.swing.JLabel jdl_username1;
    private javax.swing.JLabel jdl_username2;
    private javax.swing.JLabel jdl_username3;
    private javax.swing.JLabel jdl_username4;
    private javax.swing.JLabel jdl_username5;
    private rojerusan.RSTableMetro tbl_mahasiswa;
    private javax.swing.JTextField txt_NIM;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_noTelp;
    // End of variables declaration//GEN-END:variables

    private void diapose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
