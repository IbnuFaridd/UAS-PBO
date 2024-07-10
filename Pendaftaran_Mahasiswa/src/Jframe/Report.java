/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

//import static java.awt.Color.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.text.NumberFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.Locale;

/**
 *
 * 
 */
public class Report extends javax.swing.JFrame {

    DefaultTableModel model;

    public Report() {
        initComponents();
        
         // Set locale menjadi bahasa Indonesia
        Locale.setDefault(new Locale("id"));
        
        setTitle("Laporan Pendaftaran"); // Menambahkan judul aplikasi
        setPendaftaranDetails();
        hitungPendaftaran();
       
        
    }
    
    public void hitungPendaftaran() {
        int totalPendaftaran = 0; // Inisialisasi totalPendaftaran dengan 0

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM pendaftaran");

            if (rs.next()) {
                totalPendaftaran = rs.getInt("total");
            }

            lbl_pendaftaran.setText(Integer.toString(totalPendaftaran));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    
    public void setPendaftaranDetails() {
    try {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT p.ID_Pendaftaran, m.Nama AS Nama_Mahasiswa, ps.Nama_Prodi AS Nama_Prodi, p.Tanggal_Pendaftaran " +
                                       "FROM pendaftaran p " +
                                       "INNER JOIN mahasiswa m ON p.NIM = m.NIM " +
                                       "INNER JOIN program_studi ps ON p.ID_Prodi = ps.ID_Prodi");

        while (rs.next()) {
            String idPendaftaran = rs.getString("ID_Pendaftaran");
            String namaMahasiswa = rs.getString("Nama_Mahasiswa");
            String namaProdi = rs.getString("Nama_Prodi");
            String tanggalPendaftaran = rs.getString("Tanggal_Pendaftaran");

            Object[] obj = { idPendaftaran, namaMahasiswa, namaProdi, tanggalPendaftaran };
            DefaultTableModel model = (DefaultTableModel) tbl_details.getModel();
            model.addRow(obj);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
//method clear table

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_details.getModel();
        model.setRowCount(0); // Clear existing table data
    }

public void search() {
    Date uFromDate = date_fromDate.getDate();
    Date uToDate = date_toDate.getDate();
    int totalPendaftaran = 0; // Inisialisasi totalPendaftaran

    if (uFromDate != null && uToDate != null) {
        if (uFromDate.compareTo(uToDate) > 0) {
            // Tanggal awal lebih besar dari tanggal akhir
            JOptionPane.showMessageDialog(this, "Tanggal Awal TIDAK BISA LEBIH dari Tanggal Akhir");
        } else {
            try {
                long time11 = uFromDate.getTime();
                long time12 = uToDate.getTime();

                java.sql.Date sFromDate = new java.sql.Date(time11);
                java.sql.Date sToDate = new java.sql.Date(time12);

                Connection con = DBConnection.getConnection();

                String sql = "SELECT * FROM pendaftaran WHERE Tanggal_Pendaftaran BETWEEN ? AND ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setDate(1, sFromDate);
                pst.setDate(2, sToDate);

                ResultSet rs = pst.executeQuery();

                DefaultTableModel model = (DefaultTableModel) tbl_details.getModel();
                model.setRowCount(0); // Mengosongkan tabel sebelum menambahkan data baru

                while (rs.next()) {
                    String idPendaftaran = rs.getString("ID_Pendaftaran");
                    String nim = rs.getString("NIM");
                    String idProdi = rs.getString("ID_Prodi");
                    String tanggalPendaftaran = rs.getString("Tanggal_Pendaftaran");

                    // Dapatkan nama mahasiswa berdasarkan NIM dari tabel mahasiswa
                    String namaMahasiswa = getNamaMahasiswa(nim);

                    // Dapatkan nama prodi berdasarkan ID_Prodi dari tabel program_studi
                    String namaProdi = getNamaProdi(idProdi);

                    Object[] obj = { idPendaftaran, namaMahasiswa, namaProdi, tanggalPendaftaran };
                    model.addRow(obj);

                    // Hitung total quantity (bisa dihitung berdasarkan jumlah baris atau field lain yang sesuai)
                    totalPendaftaran++;
                }

                lbl_pendaftaran.setText(String.valueOf(totalPendaftaran)); // Set label jumlah pendaftaran

                // Tutup sumber daya
                rs.close();
                pst.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Harap pilih Tanggal Awal dan Tanggal Akhir.");
    }
}


private String getNamaMahasiswa(String nim) {
    String namaMahasiswa = "";

    try {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT Nama FROM mahasiswa WHERE NIM = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, nim);

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            namaMahasiswa = rs.getString("Nama");
        }

        rs.close();
        pst.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return namaMahasiswa;
}

private String getNamaProdi(String idProdi) {
    String namaProdi = "";

    try {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT Nama_Prodi FROM program_studi WHERE ID_Prodi = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, idProdi);

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            namaProdi = rs.getString("Nama_Prodi");
        }

        rs.close();
        pst.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return namaProdi;
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jdl_username = new javax.swing.JLabel();
        jdl_username3 = new javax.swing.JLabel();
        SearchIssue = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        date_toDate = new com.toedter.calendar.JDateChooser();
        date_fromDate = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        lbl_pendaftaran = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_details = new rojerusan.RSTableMetro();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1366, 768));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/register.png"))); // NOI18N
        jLabel8.setText("Laporan Pendaftaran");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 430, 80));

        jdl_username.setBackground(new java.awt.Color(255, 255, 255));
        jdl_username.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jdl_username.setText("Tanggal Awal :");
        jPanel1.add(jdl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, -1, -1));

        jdl_username3.setBackground(new java.awt.Color(255, 0, 0));
        jdl_username3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jdl_username3.setText("Tanggal Akhir :");
        jPanel1.add(jdl_username3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, -1, -1));

        SearchIssue.setBackground(new java.awt.Color(255, 51, 51));
        SearchIssue.setForeground(new java.awt.Color(255, 255, 255));
        SearchIssue.setText("SEARCH");
        SearchIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchIssueActionPerformed(evt);
            }
        });
        jPanel1.add(SearchIssue, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 210, 140, 40));

        jLabel5.setBackground(new java.awt.Color(102, 102, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Back_40Px2.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel1.add(date_toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 210, 40));
        jPanel1.add(date_fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 210, 40));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(96, 123, 179)));

        lbl_pendaftaran.setFont(new java.awt.Font("Segoe UI Black", 1, 50)); // NOI18N
        lbl_pendaftaran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/register.png"))); // NOI18N
        lbl_pendaftaran.setText(" 10");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbl_pendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_pendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Total Pendaftaran");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 130, 30));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_details.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbl_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Pendaftaran", "Nama", "Prodi", "Tgl. Pendaftaran"
            }
        ));
        tbl_details.setColorBackgoundHead(new java.awt.Color(96, 123, 179));
        tbl_details.setRowHeight(25);
        tbl_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_detailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_details);
        if (tbl_details.getColumnModel().getColumnCount() > 0) {
            tbl_details.getColumnModel().getColumn(0).setMinWidth(0);
            tbl_details.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 1370, 330));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 900, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchIssueActionPerformed
        clearTable();
        search();
        
    }//GEN-LAST:event_SearchIssueActionPerformed

    private void tbl_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_detailsMouseClicked
        
    }//GEN-LAST:event_tbl_detailsMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
         HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SearchIssue;
    private com.toedter.calendar.JDateChooser date_fromDate;
    private com.toedter.calendar.JDateChooser date_toDate;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jdl_username;
    private javax.swing.JLabel jdl_username3;
    private javax.swing.JLabel lbl_pendaftaran;
    private rojerusan.RSTableMetro tbl_details;
    // End of variables declaration//GEN-END:variables
}




