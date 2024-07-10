/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;
        
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.Date;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;



public class Pendaftaran extends javax.swing.JFrame {

    /**
     * Creates new form order
     */
    public Pendaftaran() {
        initComponents();
        setTitle("Pendaftaran"); // Menambahkan judul aplikasi
        tampil_comboProdi();
        tampil_comboMahasiswa();
    }
    
    
   
    public void tampil_comboProdi(){
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from program_studi");
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                combo_idProdi.addItem(rs.getString("Nama_Prodi"));    
            }
            
                rs.last();
                int jumlahdata = rs.getRow();
                rs.first();
                
        } catch (Exception e) {
        }
        
    }
    
    public void tampil_comboMahasiswa(){
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from mahasiswa");
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                combo_NIM.addItem(rs.getString("Nama"));    
            }
            
                rs.last();
                int jumlahdata = rs.getRow();
                rs.first();
                
        } catch (Exception e) {
        }
        
    }
    
    public void getProdiDetails() {
    String prodiNama = combo_idProdi.getSelectedItem().toString();

    try {
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement("SELECT * FROM program_studi WHERE Nama_Prodi=?");
        pst.setString(1, prodiNama);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            lbl_idProdi.setText(rs.getString("ID_Prodi"));
            lbl_namaProdi.setText(rs.getString("Nama_Prodi"));
            lbl_fakultas.setText(rs.getString("Fakultas"));
            lbl_akreditasi.setText(rs.getString("Akreditasi"));
        } else {
            JOptionPane.showMessageDialog(null, "Program Studi tidak ditemukan.");
            bersih();
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        // Menambahkan penanganan kesalahan, seperti menampilkan pesan error atau log ke konsol
    }
}

    
    public void getMahasiswaDetails() {
        String namaMahasiswa = combo_NIM.getSelectedItem().toString();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT NIM, Nama, Alamat, No_Telepon, Email, YEAR(Angkatan) AS Angkatan FROM mahasiswa WHERE Nama=?");
            pst.setString(1, namaMahasiswa);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lbl_NIM.setText(rs.getString("NIM"));
                lbl_nama.setText(rs.getString("Nama"));
                lbl_alamat.setText(rs.getString("Alamat"));
                lbl_noTelp.setText(rs.getString("No_Telepon"));
                lbl_email.setText(rs.getString("Email"));
                lbl_angkatan.setText(rs.getString("Angkatan")); // Menampilkan hanya tahun
            } else {
                JOptionPane.showMessageDialog(this, "Data Mahasiswa Tidak Ditemukan");
                bersih();
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method untuk generate ID Pendaftaran
    private String generateIDPendaftaran() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String id = "ID_" + dateFormat.format(new Date());
        return id;
    }
    

    // Method untuk melakukan proses pendaftaran
    public boolean ProsesPendaftaran() {
        boolean success = false; // Default value
        
        String idPendaftaran = generateIDPendaftaran();
        String nim = lbl_NIM.getText(); // Ambil NIM dari lbl_NIM, sesuaikan dengan nama label sebenarnya
        String idProdi = lbl_idProdi.getText(); // Ambil ID_Prodi dari lbl_idProdi, sesuaikan dengan nama label sebenarnya
        String tanggalPendaftaran = getCurrentDateTime(); // Ambil tanggal saat ini
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("INSERT INTO pendaftaran (ID_Pendaftaran, NIM, ID_Prodi, Tanggal_Pendaftaran) VALUES (?, ?, ?, ?)");
            pst.setString(1, idPendaftaran);
            pst.setString(2, nim);
            pst.setString(3, idProdi);
            pst.setString(4, tanggalPendaftaran);
            
            int rowsAffected = pst.executeUpdate();
            con.close();
            
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            // Handle any exceptions here
            success = false;
        }
        
        return success;
    }

    // Method untuk mendapatkan tanggal saat ini dalam format yang diinginkan
    private String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    public boolean isMahasiswaRegistered(String nim) {
        boolean isRegistered = false;
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM pendaftaran WHERE NIM=?");
            pst.setString(1, nim);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                isRegistered = true; // Mahasiswa sudah terdaftar
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exceptions here
        }
        
        return isRegistered;
    }
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        lbl_akreditasi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jdl_username4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_idProdi = new javax.swing.JTextField();
        lbl_namaProdi = new javax.swing.JTextField();
        lbl_fakultas = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_email = new javax.swing.JTextField();
        lbl_nama = new javax.swing.JTextField();
        lbl_noTelp = new javax.swing.JTextField();
        lbl_studentError = new javax.swing.JLabel();
        jdl_username5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_NIM = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_alamat = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        lbl_angkatan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jdl_username1 = new javax.swing.JLabel();
        combo_idProdi = new javax.swing.JComboBox<>();
        jdl_username2 = new javax.swing.JLabel();
        combo_NIM = new javax.swing.JComboBox<>();
        processPendaftaran = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(153, 153, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel8.setText("Detail Program Studi");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 280, 90));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Akreditasi");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        lbl_bookError.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 204, 51));
        jPanel8.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, -1, -1));

        lbl_akreditasi.setEditable(false);
        lbl_akreditasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_akreditasiActionPerformed(evt);
            }
        });
        jPanel8.add(lbl_akreditasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 210, 30));

        jLabel7.setBackground(new java.awt.Color(102, 102, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Back_40Px2.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 204, 102));
        jButton1.setText("Yes");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, 60, -1));

        jdl_username4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jdl_username4.setForeground(new java.awt.Color(255, 255, 255));
        jdl_username4.setText("Cek Program Studi?");
        jPanel8.add(jdl_username4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 140, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Nama Prodi");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Fakultas");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        lbl_idProdi.setEditable(false);
        lbl_idProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_idProdiActionPerformed(evt);
            }
        });
        jPanel8.add(lbl_idProdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 210, 30));

        lbl_namaProdi.setEditable(false);
        lbl_namaProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_namaProdiActionPerformed(evt);
            }
        });
        jPanel8.add(lbl_namaProdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 210, 30));

        lbl_fakultas.setEditable(false);
        lbl_fakultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_fakultasActionPerformed(evt);
            }
        });
        jPanel8.add(lbl_fakultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 210, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ID Prodi");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 770));

        jPanel3.setBackground(new java.awt.Color(96, 123, 179));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_email.setEditable(false);
        lbl_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_emailActionPerformed(evt);
            }
        });
        jPanel3.add(lbl_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 190, 30));

        lbl_nama.setEditable(false);
        lbl_nama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_namaFocusLost(evt);
            }
        });
        lbl_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_namaActionPerformed(evt);
            }
        });
        jPanel3.add(lbl_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 190, 30));

        lbl_noTelp.setEditable(false);
        lbl_noTelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_noTelpActionPerformed(evt);
            }
        });
        jPanel3.add(lbl_noTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 190, 30));

        lbl_studentError.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(255, 204, 51));
        jPanel3.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, -1, -1));

        jdl_username5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jdl_username5.setForeground(new java.awt.Color(255, 255, 255));
        jdl_username5.setText("Cek Mahasiswa?");
        jPanel3.add(jdl_username5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 120, -1));

        jButton2.setBackground(new java.awt.Color(255, 204, 102));
        jButton2.setText("Yes");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 570, 60, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Email");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("NIM");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Nama Mahasiswa");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("No. Telpon");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        lbl_NIM.setEditable(false);
        lbl_NIM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_NIMFocusLost(evt);
            }
        });
        lbl_NIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_NIMActionPerformed(evt);
            }
        });
        jPanel3.add(lbl_NIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 190, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jLabel15.setText("Detail Mahasiswa");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 290, 70));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Alamat");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        lbl_alamat.setEditable(false);
        lbl_alamat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_alamatFocusLost(evt);
            }
        });
        lbl_alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_alamatActionPerformed(evt);
            }
        });
        jPanel3.add(lbl_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 190, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Angkatan");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        lbl_angkatan.setEditable(false);
        lbl_angkatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_angkatanActionPerformed(evt);
            }
        });
        jPanel3.add(lbl_angkatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 190, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 390, 770));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Pendaftaran");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, 220, 50));

        jdl_username1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jdl_username1.setForeground(new java.awt.Color(0, 0, 153));
        jdl_username1.setText("Pilih Program Studi :");
        jPanel2.add(jdl_username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 330, -1, -1));

        combo_idProdi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Pilih ---" }));
        combo_idProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_idProdiActionPerformed(evt);
            }
        });
        jPanel2.add(combo_idProdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 360, 240, 40));

        jdl_username2.setBackground(new java.awt.Color(153, 153, 255));
        jdl_username2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jdl_username2.setForeground(new java.awt.Color(0, 0, 153));
        jdl_username2.setText("Pilih Mahasiswa :");
        jPanel2.add(jdl_username2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 240, -1, -1));

        combo_NIM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Pilih ---" }));
        combo_NIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_NIMActionPerformed(evt);
            }
        });
        jPanel2.add(combo_NIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 270, 240, 40));

        processPendaftaran.setBackground(new java.awt.Color(153, 153, 255));
        processPendaftaran.setForeground(new java.awt.Color(255, 255, 255));
        processPendaftaran.setText("PROCESS");
        processPendaftaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processPendaftaranActionPerformed(evt);
            }
        });
        jPanel2.add(processPendaftaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 440, 190, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void processPendaftaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processPendaftaranActionPerformed
        // Ambil nilai dari label lbl_NIM dan lbl_idProdi
    String nim = lbl_NIM.getText();
    String idProdi = lbl_idProdi.getText();
    
    // Validasi bahwa nilai tidak kosong
    if (nim.isEmpty() || idProdi.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Mohon lengkapi NIM dan ID Prodi terlebih dahulu.");
        return; // Menghentikan proses karena data belum lengkap
    }
    
    // Lakukan pengecekan apakah mahasiswa sudah terdaftar
    if (isMahasiswaRegistered(nim)) {
        JOptionPane.showMessageDialog(null, "Mahasiswa dengan NIM " + nim + " sudah terdaftar.");
        return; // Menghentikan proses karena mahasiswa sudah terdaftar
    }
    
    // Lanjutkan dengan proses pendaftaran
    boolean isSuccess = ProsesPendaftaran();
    
    if (isSuccess) {
        JOptionPane.showMessageDialog(null, "Pendaftaran berhasil.");
        bersih();
        // Lakukan tindakan lanjutan setelah pendaftaran berhasil
    } else {
        JOptionPane.showMessageDialog(null, "Pendaftaran gagal. Silakan coba lagi.");
        // Handle jika pendaftaran gagal
    }
    }//GEN-LAST:event_processPendaftaranActionPerformed

    private void lbl_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_emailActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_lbl_emailActionPerformed

    private void lbl_akreditasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_akreditasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_akreditasiActionPerformed

    private void lbl_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_namaActionPerformed

    private void lbl_noTelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_noTelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_noTelpActionPerformed

    private void lbl_namaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_namaFocusLost
       
        
    }//GEN-LAST:event_lbl_namaFocusLost

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        DataProdi mngProduc = new DataProdi();
        mngProduc.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        DataMahasiswa MngStd = new DataMahasiswa();
        MngStd.setVisible(true);
        dispose();
                
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void combo_idProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_idProdiActionPerformed
    if (combo_idProdi.getSelectedIndex() != 0) {
        getProdiDetails();
    }
    }//GEN-LAST:event_combo_idProdiActionPerformed

    private void combo_NIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_NIMActionPerformed
    if (combo_NIM.getSelectedIndex() != 0) {
        getMahasiswaDetails();
    }
    }//GEN-LAST:event_combo_NIMActionPerformed

    private void lbl_idProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_idProdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_idProdiActionPerformed

    private void lbl_namaProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_namaProdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_namaProdiActionPerformed

    private void lbl_fakultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_fakultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_fakultasActionPerformed

    private void lbl_NIMFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_NIMFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_NIMFocusLost

    private void lbl_NIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_NIMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_NIMActionPerformed
  
    private void lbl_alamatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_alamatFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_alamatFocusLost

    private void lbl_alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_alamatActionPerformed

    private void lbl_angkatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_angkatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_angkatanActionPerformed

private void bersih() {
    combo_NIM.setSelectedIndex(0);
    combo_idProdi.setSelectedIndex(0);
    lbl_NIM.setText("");
    lbl_nama.setText(""); // Membersihkan teks dari lbl_customerName
    lbl_noTelp.setText("");
    lbl_email.setText("");
    lbl_angkatan.setText("");
    lbl_alamat.setText("");

    lbl_idProdi.setText("");
    lbl_namaProdi.setText(""); // Membersihkan teks dari lbl_namaProduk
    lbl_akreditasi.setText(""); // Membersihkan teks dari lbl_hargaProduk
    lbl_fakultas.setText(""); // Membersihkan teks dari lbl_quantitas

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
            java.util.logging.Logger.getLogger(Pendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pendaftaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_NIM;
    private javax.swing.JComboBox<String> combo_idProdi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel jdl_username1;
    private javax.swing.JLabel jdl_username2;
    private javax.swing.JLabel jdl_username4;
    private javax.swing.JLabel jdl_username5;
    private javax.swing.JTextField lbl_NIM;
    private javax.swing.JTextField lbl_akreditasi;
    private javax.swing.JTextField lbl_alamat;
    private javax.swing.JTextField lbl_angkatan;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JTextField lbl_email;
    private javax.swing.JTextField lbl_fakultas;
    private javax.swing.JTextField lbl_idProdi;
    private javax.swing.JTextField lbl_nama;
    private javax.swing.JTextField lbl_namaProdi;
    private javax.swing.JTextField lbl_noTelp;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JButton processPendaftaran;
    // End of variables declaration//GEN-END:variables
}
