/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import model.HoaDonCT;
import model.HoaDonCTDAO;
import model.HoaDonDAO;
import model.JDialogNhapLoaiHang;
import model.KhachHang;
import model.KhachHangDAO;
import model.ReportDAO;
import model.SanPham;
import model.SanPhamDAO;



/**
 *
 * @author ductr
 */
public class MainFrame extends javax.swing.JFrame {
    SanPhamDAO spDAO;
    KhachHangDAO khDAO;
    HoaDonDAO hdDAO;
    ArrayList<HoaDonCT> listHDCT;
    ArrayList<SanPham> listsp;
    HoaDonCTDAO hdctDAO;
    int soLuongTemp;
    Connection cn;
    String url;
    Vector head, data;
    
    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);
        VisiblePanel(jPanelBanHang);
        buttonGroup1.add(rdbNam);
        buttonGroup1.add(rdbNu);
        khDAO = new KhachHangDAO();
        spDAO = new SanPhamDAO();
        hdDAO = new HoaDonDAO();
        listHDCT = new ArrayList<>();
        hdctDAO = new HoaDonCTDAO();
        listsp= new ArrayList<>();
        listsp=spDAO.getAll();
        head = new Vector();
        head.add("Họ tên"); head.add("Ca làm"); head.add("Mã nhân viên");
        head.add("Mã hóa đơn"); head.add("Tổng tiền");
        url="jdbc:sqlserver://localhost:1433;databaseName=QLBANHANG;userName=sa;password=123";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection(url);
            System.out.println("Connect thành công");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
       showNoti();
       setIcon();
    }
    private void showNoti(){
        Notification n= new Notification(this, true);
        n.setVisible(true);
    }
    private boolean CheckForm() {
        boolean kt = true;
        StringBuilder sb = new StringBuilder();
        if (txtTenSanPham.getText().length() == 0) {
            sb.append("Tên SP không được để trống\n");
            kt = false;
        }
        try {
            /*if (Integer.parseInt(txtMaSP.getText()) == 0) {
                sb.append("Mã SP không được để trống\n");
                 kt = false;
            }*/
            if (txtMaLo.getText().length() == 0) {
                sb.append("Mã lô không được để trống\n");
                 kt = false;
            }else if(Integer.parseInt(txtMaLo.getText()) < 0){
                sb.append("Mã lô không được < 0\n");
                 kt = false;
            }
            if (txtMaLoai.getText().length() == 0) {
                sb.append("Mã loại không được để trống\n");
                 kt = false;
            }else if (Integer.parseInt(txtMaLoai.getText()) < 0) {
                sb.append("Mã loại không được < 0\n");
                 kt = false;
            }
            if (txtSoLuong.getText().length() == 0) {
                sb.append("Số lượng không được để trống\n");
                 kt = false;
            }else if (Integer.parseInt(txtSoLuong.getText()) < 0) {
                sb.append("Số lượng không được < 0\n");
                 kt = false;
            }           
            if (txtSoLuongMin.getText().length() == 0) {
                sb.append("Số lượng không được để trống\n");
                 kt = false;
            }else if (Integer.parseInt(txtSoLuongMin.getText()) < 0) {
                sb.append("Số lượng Min không được < 0\n");
                 kt = false;
            }
            if (txtGiaNhap.getText().length() == 0) {
                sb.append("Giá nhập không được để trống\n");
                 kt = false;
            }else if (Double.parseDouble(txtGiaNhap.getText()) < 0) {
                sb.append("Giá nhập không được < 0\n");
                 kt = false;
            }
            if (txtGiaBan.getText().length() == 0) {
                sb.append("Giá bán không được để trống\n");
                 kt = false;
            }else if (Double.parseDouble(txtGiaBan.getText()) < 0) {
                sb.append("Giá bán không được < 0\n");
                 kt = false;
            }
            if (txtHSDMin.getText().length() == 0) {
                sb.append("HSD Min không được để trống\n");
                 kt = false;
            }else if (Integer.parseInt(txtHSDMin.getText()) < 0) {
                sb.append("Hạn sử dụng Min không được < 0\n");
                 kt = false;
            }
        } catch (NumberFormatException e) {
            sb.append("Vui lòng nhập đúng định dạng (number)\n");
             kt = false;
        }
        try {
            if(txtNSX.getText().length() == 0) {                
                sb.append("NSX không được để trống\n");
                 kt = false;
            }else{
                Date d = new SimpleDateFormat("yyyy-MM-dd").parse(txtNSX.getText());
            }
        } catch (ParseException ex) {
            sb.append("NSX không đúng định dạng (yyyy-MM-dd)\n");
             kt = false;
        }
        try {
            if(txtHSD.getText().length() == 0) {               
                sb.append("HSD không được để trống\n");
                 kt = false;
            }else{
                Date d = new SimpleDateFormat("yyyy-MM-dd").parse(txtNSX.getText());
            }
        } catch (ParseException ex) {
            sb.append("HSD không đúng định dạng (yyyy-MM-dd)\n");
             kt = false;
        }
        if(sb.length() >0){
            JOptionPane.showMessageDialog(this, sb.toString(), "Invalidate", JOptionPane.ERROR_MESSAGE);
        }
        return kt;
    }
    
    public boolean checkFormKH() {
        boolean kt = true;
        StringBuilder sb = new StringBuilder();
        if (txtTenKH.getText().length() == 0) {
            sb.append("Tên KH không được để trống\n");
            kt = false;
        }
        try {
            if (txtSdt.getText().length() == 0) {
                sb.append("Số điện thoại không được để trống\n");
                kt = false;
            }if (txtSdt.getText().length() < 10) {
                sb.append("Số điện thoại phải đủ 10 chữ số\n");
                kt = false;
            }else if (Integer.parseInt(txtSdt.getText()) < 0) {
                sb.append("Số điện thoại phải là số dương\n");
                kt = false;
            }
        } catch (NumberFormatException e) {
            sb.append("Vui lòng nhập đúng định dạng (number)\n");
            kt = false;

        }
        try {
            String date = txtNgaySinh.getText();
            if (date.length() == 0) {
                sb.append("Ngày sinh không được để trống\n");
                kt = false;
            }
            else{
                Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            }
        } catch (Exception ex) {
            sb.append("Ngày sinh không đúng định dạng (yyyy-MM-dd)\n");
            kt = false;
        }
        if (rdbNam.isSelected() == false && rdbNu.isSelected() == false) {
            sb.append("Vui lòng chọn giới tính\n");
            kt = false;
        }
        if (txtDiaChi.getText().length() == 0) {
            sb.append("Địa chỉ không được để trống\n");
            kt = false;
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString(), "Invalidate", JOptionPane.ERROR_MESSAGE);
        }
        return kt;
    }
    
    boolean checkBaoCao(){
        boolean kt = true;
        StringBuilder sb = new StringBuilder();
        try {
            String date = txtTimeStart.getText();
            if (date.length() == 0) {
                sb.append("Ngày bắt đầu không được để trống\n");
                kt = false;
            }
            else{
                Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            }
        } catch (Exception ex) {
            sb.append("Ngày bắt đầu không đúng định dạng (yyyy-MM-dd)\n");
            kt = false;
        }
        try {
            String date = txtTimeEnd.getText();
            if (date.length() == 0) {
                sb.append("Ngày kết thúc không được để trống\n");
                kt = false;
            }
            else{
                Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            }
        } catch (Exception ex) {
            sb.append("Ngày kết thúc không đúng định dạng (yyyy-MM-dd)\n");
            kt = false;
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString(), "Invalidate", JOptionPane.ERROR_MESSAGE);
        }
        return kt;
    }
    void fillTable() {
        DefaultTableModel model = new DefaultTableModel(data, head);
        tblNhanVienCa.setModel(model);
        try {
            String maNV="";
            String sql = "select HOTEN as 'Họ tên',CALAM as 'Ca làm',hoadon.MaNV"
                    + " 'Mã Nhân Viên', mahoadon as 'Mã Hóa Đơn',TongTien as 'Tổng tiền'"
                    + " from NHANVIEN inner join HOADON on HOADON.MaNV = NHANVIEN.MANV "
                    + "where hoadon.MaNV like '%"+maNV +"%' and CALAM = ? and  "
                    + "CONVERT(date,hoadon.mahoadon,120) between ? and ? ";
            PreparedStatement ps = cn.prepareStatement(sql);
            if(cbbMaNV.getSelectedIndex()==0){
                maNV="";
            }else 
                maNV= cbbMaNV.getSelectedItem()+"";          
            ps.setString(1, (String) cbbCaLam.getSelectedItem());
            ps.setString(2, txtTimeStart.getText());
            ps.setString(3, txtTimeEnd.getText());
            ResultSet rs = ps.executeQuery();
            model.setRowCount(0);
            if(rs.next() == false){
                JOptionPane.showMessageDialog(rootPane,"Không có dữ liệu trong"
                        + " khoảng thời gian này");
            }else{
                while (rs.next()) {
                    String[] row = new String[]{
                        rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5)
                    };
                    model.addRow(row);
                }
                model.fireTableDataChanged();
                txtHDTong.setText(tblNhanVienCa.getRowCount()+"");
                ArrayList<String> listTongTien = new ArrayList();
                for(int i=0;i<tblNhanVienCa.getRowCount();i++){
                    listTongTien.add((String) tblNhanVienCa.getValueAt(i,4));
                }
                double tongT=0;
                for (String l : listTongTien) {
                    tongT+=Double.parseDouble(l);
                }
                txtDT.setText(tongT+"");
                rs.close();
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jMainPanel = new javax.swing.JPanel();
        jPanelBaoCao = new javax.swing.JPanel();
        jPanelKhachHang = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        rdbNam = new javax.swing.JRadioButton();
        rdbNu = new javax.swing.JRadioButton();
        jLabel33 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        btnThemKH = new javax.swing.JButton();
        btnXoaFormKH = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanelQLNhanVien = new javax.swing.JPanel();
        jPanelBanHang = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_ThemSpVaoHoaDon = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        MaSP = new javax.swing.JTextField();
        txtSoLuongNhap = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        maKH1 = new javax.swing.JTextField();
        new_HoaDon = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ThemHoaDon = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        txtCK = new javax.swing.JTextField();
        maKH = new javax.swing.JTextField();
        maNV = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        maHD = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jPanelDSHH = new javax.swing.JPanel();
        jTextField17 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        JPanelNhapHangHoa = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        txtNSX = new javax.swing.JTextField();
        txtHSD = new javax.swing.JTextField();
        txtHSDMin = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtMaLo = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtSoLuongMin = new javax.swing.JTextField();
        btnNhap = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        txtMaLoai = new javax.swing.JTextField();
        btnLuu1 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        PanelBaoCaoHoaDon = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBaoCao = new javax.swing.JTable();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        btn_reportHD = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        dayMin = new javax.swing.JTextField();
        dayMax = new javax.swing.JTextField();
        lblBaocao1 = new javax.swing.JLabel();
        lblBaoCao2 = new javax.swing.JLabel();
        tongHoaDon = new javax.swing.JLabel();
        tongDoanhThu = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        tongMatHang = new javax.swing.JLabel();
        tongSLHang = new javax.swing.JLabel();
        pannelBaoCaoCT = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        cbbCaLam = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        cbbMaNV = new javax.swing.JComboBox<>();
        jLabel47 = new javax.swing.JLabel();
        txtTimeStart = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txtTimeEnd = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblNhanVienCa = new javax.swing.JTable();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtHDTong = new javax.swing.JLabel();
        txtDT = new javax.swing.JLabel();
        BaoCaoNV = new javax.swing.JButton();
        BaoCaoNV1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMnBanHang = new javax.swing.JMenu();
        JMnNhapHoaDon = new javax.swing.JMenuItem();
        jMnNhapThanhVien = new javax.swing.JMenuItem();
        jMnHangHoa = new javax.swing.JMenu();
        jMnNhapHangHoa = new javax.swing.JMenuItem();
        jMnNhapLoaiHangHoa = new javax.swing.JMenuItem();
        jMnDSHangHoa = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMnNhanVien = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Bán Hàng");

        jMainPanel.setLayout(new java.awt.CardLayout());

        jPanelBaoCao.setBackground(new java.awt.Color(204, 204, 0));

        jPanelKhachHang.setForeground(new java.awt.Color(255, 255, 204));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 255));
        jLabel28.setText("THÊM KHÁCH HÀNG");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("Tên khách hàng:");

        txtTenKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTenKH.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("Địa chỉ:");

        txtDiaChi.setColumns(20);
        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDiaChi.setRows(5);
        jScrollPane3.setViewportView(txtDiaChi);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("Số điện thoại:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("Giới tính:");

        buttonGroup1.add(rdbNam);
        rdbNam.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdbNam.setText("Nam");

        buttonGroup1.add(rdbNu);
        rdbNu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdbNu.setText("Nữ");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("Ngày sinh:");

        txtNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNgaySinh.setPreferredSize(new java.awt.Dimension(6, 25));

        txtSdt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSdt.setPreferredSize(new java.awt.Dimension(6, 25));

        btnThemKH.setBackground(new java.awt.Color(153, 255, 153));
        btnThemKH.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThemKH.setForeground(new java.awt.Color(0, 0, 255));
        btnThemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Accept.png"))); // NOI18N
        btnThemKH.setText("Thêm");
        btnThemKH.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThemKH.setBorderPainted(false);
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        btnXoaFormKH.setBackground(new java.awt.Color(255, 153, 153));
        btnXoaFormKH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoaFormKH.setForeground(new java.awt.Color(51, 51, 255));
        btnXoaFormKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        btnXoaFormKH.setText("Xóa Form");
        btnXoaFormKH.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXoaFormKH.setBorderPainted(false);
        btnXoaFormKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaFormKHActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login1.png"))); // NOI18N

        javax.swing.GroupLayout jPanelKhachHangLayout = new javax.swing.GroupLayout(jPanelKhachHang);
        jPanelKhachHang.setLayout(jPanelKhachHangLayout);
        jPanelKhachHangLayout.setHorizontalGroup(
            jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKhachHangLayout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(btnXoaFormKH)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelKhachHangLayout.createSequentialGroup()
                .addGroup(jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelKhachHangLayout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addGroup(jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelKhachHangLayout.createSequentialGroup()
                                .addComponent(rdbNam)
                                .addGap(53, 53, 53)
                                .addComponent(rdbNu))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelKhachHangLayout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addGroup(jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelKhachHangLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel29)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel30))
                        .addGap(40, 40, 40)
                        .addGroup(jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanelKhachHangLayout.setVerticalGroup(
            jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(21, 21, 21)
                .addGroup(jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(18, 18, 18)
                .addGroup(jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbNu)
                    .addComponent(rdbNam)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addGroup(jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaFormKH, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelBaoCaoLayout = new javax.swing.GroupLayout(jPanelBaoCao);
        jPanelBaoCao.setLayout(jPanelBaoCaoLayout);
        jPanelBaoCaoLayout.setHorizontalGroup(
            jPanelBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaoCaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanelBaoCaoLayout.setVerticalGroup(
            jPanelBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBaoCaoLayout.createSequentialGroup()
                .addComponent(jPanelKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMainPanel.add(jPanelBaoCao, "card4");

        jPanelQLNhanVien.setBackground(new java.awt.Color(102, 102, 0));

        javax.swing.GroupLayout jPanelQLNhanVienLayout = new javax.swing.GroupLayout(jPanelQLNhanVien);
        jPanelQLNhanVien.setLayout(jPanelQLNhanVienLayout);
        jPanelQLNhanVienLayout.setHorizontalGroup(
            jPanelQLNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 911, Short.MAX_VALUE)
        );
        jPanelQLNhanVienLayout.setVerticalGroup(
            jPanelQLNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 831, Short.MAX_VALUE)
        );

        jMainPanel.add(jPanelQLNhanVien, "card5");

        jPanelBanHang.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã SP:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Số Lượng:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Thành Tiền");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Đơn Giá");

        btn_ThemSpVaoHoaDon.setBackground(new java.awt.Color(204, 255, 204));
        btn_ThemSpVaoHoaDon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_ThemSpVaoHoaDon.setForeground(new java.awt.Color(153, 255, 153));
        btn_ThemSpVaoHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Accept.png"))); // NOI18N
        btn_ThemSpVaoHoaDon.setText("Thêm");
        btn_ThemSpVaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemSpVaoHoaDonActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 153, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Hủy");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("NHÂN VIÊN: ABC - CA:XYZ");

        MaSP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MaSPFocusLost(evt);
            }
        });

        txtSoLuongNhap.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoLuongNhapFocusLost(evt);
            }
        });

        txtDonGia.setEditable(false);

        txtThanhTien.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Khách hàng:");

        maKH1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                maKH1FocusLost(evt);
            }
        });

        new_HoaDon.setBackground(new java.awt.Color(153, 255, 153));
        new_HoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        new_HoaDon.setForeground(new java.awt.Color(0, 204, 0));
        new_HoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add.png"))); // NOI18N
        new_HoaDon.setText("Hóa đơn mới");
        new_HoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_HoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_ThemSpVaoHoaDon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(MaSP)
                                    .addComponent(txtSoLuongNhap)
                                    .addComponent(txtDonGia)
                                    .addComponent(txtThanhTien)
                                    .addComponent(maKH1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(new_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maKH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ThemSpVaoHoaDon)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(new_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setPreferredSize(new java.awt.Dimension(500, 600));

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("JZTR MART");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("137 Nguyễn Thị Thập");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Hòa Minh, Liên Chiểu, Đà Nẵng");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("HÓA ĐƠN BÁN HÀNG");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mặt Hàng", "Đơn Giá", "Số Lượng", "Thành Tiền"
            }
        ));
        tblHoaDon.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblHoaDonPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Tổng tiền phải thanh toán:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Chiết khấu (%):");

        ThemHoaDon.setBackground(new java.awt.Color(153, 255, 153));
        ThemHoaDon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ThemHoaDon.setForeground(new java.awt.Color(0, 204, 0));
        ThemHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Accept.png"))); // NOI18N
        ThemHoaDon.setText("In");
        ThemHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemHoaDonActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 153, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Xóa");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Nhân Viên:");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("Khách hàng:");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Mã hóa đơn:");

        maHD.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel8))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addGap(78, 78, 78)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(maKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(maHD, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCK)
                                    .addComponent(maNV)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTongTien)))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(ThemHoaDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(60, 60, 60)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(maNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(maKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(maHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(jLabel13))
                    .addComponent(txtCK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ThemHoaDon)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addContainerGap())
        );

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sanpham.png"))); // NOI18N

        javax.swing.GroupLayout jPanelBanHangLayout = new javax.swing.GroupLayout(jPanelBanHang);
        jPanelBanHang.setLayout(jPanelBanHangLayout);
        jPanelBanHangLayout.setHorizontalGroup(
            jPanelBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBanHangLayout.createSequentialGroup()
                .addGroup(jPanelBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBanHangLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBanHangLayout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jLabel36)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanelBanHangLayout.setVerticalGroup(
            jPanelBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBanHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE))
                .addContainerGap(216, Short.MAX_VALUE))
        );

        jMainPanel.add(jPanelBanHang, "card2");

        jPanelDSHH.setBackground(new java.awt.Color(255, 255, 204));

        jButton7.setBackground(new java.awt.Color(153, 153, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Zoom-icon.png"))); // NOI18N
        jButton7.setText("Tìm kiếm");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không", "Hàng sắp hết HSD", "Hàng có số lượng thấp" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", ".", ".", ".", " " }));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 51, 255));
        jLabel26.setText("Lọc theo: ");

        jLabel27.setText("Sắp xếp theo:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanelDSHHLayout = new javax.swing.GroupLayout(jPanelDSHH);
        jPanelDSHH.setLayout(jPanelDSHHLayout);
        jPanelDSHHLayout.setHorizontalGroup(
            jPanelDSHHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDSHHLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(jLabel27)
                .addGap(37, 37, 37)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
            .addGroup(jPanelDSHHLayout.createSequentialGroup()
                .addGroup(jPanelDSHHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDSHHLayout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7))
                    .addGroup(jPanelDSHHLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        jPanelDSHHLayout.setVerticalGroup(
            jPanelDSHHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDSHHLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelDSHHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDSHHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(311, Short.MAX_VALUE))
        );

        jMainPanel.add(jPanelDSHH, "card8");

        JPanelNhapHangHoa.setBackground(new java.awt.Color(255, 255, 204));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 255));
        jLabel14.setText("NHẬP SẢN PHẨM");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Giá Bán:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("NSX:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("HSD:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("HSD Min:");

        txtGiaBan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtNSX.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtHSD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtHSDMin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtGiaNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Giá Nhập:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Mã Loại:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Số Lượng:");

        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtMaLo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Mã Lô:");

        txtMaSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMaSP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaSPFocusLost(evt);
            }
        });

        txtTenSanPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Tên Sản Phâm:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Mã Sản Phẩm:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Số Lượng Min:");

        txtSoLuongMin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnNhap.setBackground(new java.awt.Color(102, 255, 102));
        btnNhap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add.png"))); // NOI18N
        btnNhap.setText("Thêm sản phẩm");
        btnNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapActionPerformed(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(153, 255, 153));
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Create.png"))); // NOI18N
        btnLuu.setText("Cập nhật số lượng");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        txtMaLoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnLuu1.setBackground(new java.awt.Color(153, 255, 153));
        btnLuu1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLuu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh.png"))); // NOI18N
        btnLuu1.setText("Xóa Form");
        btnLuu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuu1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPanelNhapHangHoaLayout = new javax.swing.GroupLayout(JPanelNhapHangHoa);
        JPanelNhapHangHoa.setLayout(JPanelNhapHangHoaLayout);
        JPanelNhapHangHoaLayout.setHorizontalGroup(
            JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel25))
                                .addGap(62, 62, 62)
                                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtMaLo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(txtSoLuongMin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(txtMaLoai, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPanelNhapHangHoaLayout.createSequentialGroup()
                                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel24))
                                .addGap(62, 62, 62)
                                .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnNhap)
                        .addGap(87, 87, 87)))
                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel17))
                    .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel15))
                                .addGap(62, 62, 62)
                                .addComponent(txtNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtHSD, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(btnLuu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelNhapHangHoaLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(52, 52, 52)))
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHSDMin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLuu1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 123, Short.MAX_VALUE))
            .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addGap(395, 395, 395)
                        .addComponent(jLabel37))
                    .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(jLabel14)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        JPanelNhapHangHoaLayout.setVerticalGroup(
            JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(21, 21, 21)
                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23))
                            .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19)))
                        .addGap(58, 58, 58)
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(46, 46, 46)
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaLo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(txtNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(50, 50, 50)
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addComponent(jLabel20))
                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(55, 55, 55)
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuongMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(87, 87, 87))
                    .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHSDMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuu1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        jMainPanel.add(JPanelNhapHangHoa, "card3");

        tblBaoCao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblBaoCao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblBaoCao.setRowHeight(30);
        tblBaoCao.setRowMargin(5);
        jScrollPane4.setViewportView(tblBaoCao);

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel39.setText("Ngày bắt đầu:");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel40.setText("Ngày kết thúc:");

        btn_reportHD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_reportHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Numbered list.png"))); // NOI18N
        btn_reportHD.setText("Báo cáo hóa đơn");
        btn_reportHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportHDActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 204));
        jLabel41.setText("BÁO CÁO HÓA ĐƠN");

        dayMin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        dayMax.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblBaocao1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBaocao1.setText("Tổng số hóa đơn bán ra:");

        lblBaoCao2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBaoCao2.setText("Tổng doanh thu:");

        tongHoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tongHoaDon.setText("NULL");

        tongDoanhThu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tongDoanhThu.setText("NULL");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Best.png"))); // NOI18N
        jButton1.setText("Báo cáo hàng hóa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel42.setText("Số mặt hàng đã bán:");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel43.setText("Tổng số lượng đã bán:");

        tongMatHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tongMatHang.setText("NULL");

        tongSLHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tongSLHang.setText("NULL");

        javax.swing.GroupLayout PanelBaoCaoHoaDonLayout = new javax.swing.GroupLayout(PanelBaoCaoHoaDon);
        PanelBaoCaoHoaDon.setLayout(PanelBaoCaoHoaDonLayout);
        PanelBaoCaoHoaDonLayout.setHorizontalGroup(
            PanelBaoCaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBaoCaoHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBaoCaoHoaDonLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel39)
                .addGap(18, 18, 18)
                .addComponent(dayMin, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addGap(18, 18, 18)
                .addComponent(dayMax, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
            .addGroup(PanelBaoCaoHoaDonLayout.createSequentialGroup()
                .addGroup(PanelBaoCaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBaoCaoHoaDonLayout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jLabel41))
                    .addGroup(PanelBaoCaoHoaDonLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(btn_reportHD, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addComponent(jButton1))
                    .addGroup(PanelBaoCaoHoaDonLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(PanelBaoCaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel42)
                            .addComponent(lblBaocao1))
                        .addGap(37, 37, 37)
                        .addGroup(PanelBaoCaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tongHoaDon)
                            .addComponent(tongMatHang))
                        .addGap(99, 99, 99)
                        .addGroup(PanelBaoCaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblBaoCao2)
                            .addComponent(jLabel43))
                        .addGap(28, 28, 28)
                        .addGroup(PanelBaoCaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tongDoanhThu)
                            .addComponent(tongSLHang))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelBaoCaoHoaDonLayout.setVerticalGroup(
            PanelBaoCaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBaoCaoHoaDonLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel41)
                .addGap(37, 37, 37)
                .addGroup(PanelBaoCaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dayMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(dayMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addGap(39, 39, 39)
                .addGroup(PanelBaoCaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_reportHD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(PanelBaoCaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBaocao1)
                    .addComponent(tongHoaDon)
                    .addComponent(lblBaoCao2)
                    .addComponent(tongDoanhThu))
                .addGap(49, 49, 49)
                .addGroup(PanelBaoCaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43)
                    .addComponent(tongMatHang)
                    .addComponent(tongSLHang))
                .addGap(67, 67, 67))
        );

        jMainPanel.add(PanelBaoCaoHoaDon, "card7");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 204));
        jLabel44.setText("BÁO CÁO CHI TIẾT");

        cbbCaLam.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbbCaLam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel45.setText("CA LÀM:");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel46.setText("NHÂN VIÊN:");

        cbbMaNV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbbMaNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "NV001", "NV002", "NV003", "NV004", "NV005" }));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel47.setText("Ngày bắt đầu");

        txtTimeStart.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel48.setText("Ngày kết thúc");

        txtTimeEnd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tblNhanVienCa.setAutoCreateRowSorter(true);
        tblNhanVienCa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblNhanVienCa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblNhanVienCa.setRowHeight(30);
        tblNhanVienCa.setRowMargin(5);
        tblNhanVienCa.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblNhanVienCaPropertyChange(evt);
            }
        });
        jScrollPane5.setViewportView(tblNhanVienCa);

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel49.setText("Tống số hóa đơn:");

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel50.setText("Tổng doanh thu");

        txtHDTong.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtHDTong.setText("--");

        txtDT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtDT.setText("--");

        BaoCaoNV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BaoCaoNV.setText("Báo cáo nhân viên & ca làm");
        BaoCaoNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaoCaoNVActionPerformed(evt);
            }
        });

        BaoCaoNV1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BaoCaoNV1.setText("Nhân viên có số hóa đơn cao nhất");
        BaoCaoNV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaoCaoNV1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pannelBaoCaoCTLayout = new javax.swing.GroupLayout(pannelBaoCaoCT);
        pannelBaoCaoCT.setLayout(pannelBaoCaoCTLayout);
        pannelBaoCaoCTLayout.setHorizontalGroup(
            pannelBaoCaoCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelBaoCaoCTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelBaoCaoCTLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel49)
                .addGap(18, 18, 18)
                .addComponent(txtHDTong)
                .addGap(225, 225, 225)
                .addComponent(jLabel50)
                .addGap(18, 18, 18)
                .addComponent(txtDT)
                .addGap(165, 165, 165))
            .addGroup(pannelBaoCaoCTLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pannelBaoCaoCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel45)
                    .addComponent(jLabel47))
                .addGap(70, 70, 70)
                .addGroup(pannelBaoCaoCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimeStart, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbCaLam, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addGroup(pannelBaoCaoCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pannelBaoCaoCTLayout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addGap(97, 97, 97)
                        .addGroup(pannelBaoCaoCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTimeEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel46))
                .addGap(48, 48, 48))
            .addGroup(pannelBaoCaoCTLayout.createSequentialGroup()
                .addGroup(pannelBaoCaoCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pannelBaoCaoCTLayout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(jLabel44))
                    .addGroup(pannelBaoCaoCTLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(BaoCaoNV)
                        .addGap(128, 128, 128)
                        .addComponent(BaoCaoNV1)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        pannelBaoCaoCTLayout.setVerticalGroup(
            pannelBaoCaoCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelBaoCaoCTLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel44)
                .addGap(77, 77, 77)
                .addGroup(pannelBaoCaoCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimeStart, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48)
                    .addComponent(txtTimeEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pannelBaoCaoCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(cbbCaLam, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(cbbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(pannelBaoCaoCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BaoCaoNV)
                    .addComponent(BaoCaoNV1))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(pannelBaoCaoCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50)
                    .addComponent(txtHDTong)
                    .addComponent(txtDT))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jMainPanel.add(pannelBaoCaoCT, "card8");

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.setMaximumSize(new java.awt.Dimension(500, 32769));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(438, 35));

        jMnBanHang.setBackground(new java.awt.Color(255, 255, 255));
        jMnBanHang.setForeground(new java.awt.Color(255, 102, 0));
        jMnBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nhanvien.png"))); // NOI18N
        jMnBanHang.setText("Quản lý bán hàng");
        jMnBanHang.setAlignmentX(1.0F);
        jMnBanHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMnBanHang.setMinimumSize(new java.awt.Dimension(35, 30));
        jMnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnBanHangActionPerformed(evt);
            }
        });

        JMnNhapHoaDon.setBackground(new java.awt.Color(204, 204, 204));
        JMnNhapHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JMnNhapHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/List.png"))); // NOI18N
        JMnNhapHoaDon.setText("Nhập hóa đơn");
        JMnNhapHoaDon.setInheritsPopupMenu(true);
        JMnNhapHoaDon.setOpaque(true);
        JMnNhapHoaDon.setRolloverEnabled(true);
        JMnNhapHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMnNhapHoaDonActionPerformed(evt);
            }
        });
        jMnBanHang.add(JMnNhapHoaDon);

        jMnNhapThanhVien.setBackground(new java.awt.Color(153, 153, 153));
        jMnNhapThanhVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMnNhapThanhVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Users.png"))); // NOI18N
        jMnNhapThanhVien.setText("Nhập thẻ thành viên");
        jMnNhapThanhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnNhapThanhVienActionPerformed(evt);
            }
        });
        jMnBanHang.add(jMnNhapThanhVien);

        jMenuBar1.add(jMnBanHang);

        jMnHangHoa.setForeground(new java.awt.Color(255, 102, 0));
        jMnHangHoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hoadon.png"))); // NOI18N
        jMnHangHoa.setText("Quản lý hàng hóa");
        jMnHangHoa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMnHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnHangHoaActionPerformed(evt);
            }
        });

        jMnNhapHangHoa.setBackground(new java.awt.Color(204, 204, 204));
        jMnNhapHangHoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMnNhapHangHoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Numbered list.png"))); // NOI18N
        jMnNhapHangHoa.setText("Nhập hàng hóa");
        jMnNhapHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnNhapHangHoaActionPerformed(evt);
            }
        });
        jMnHangHoa.add(jMnNhapHangHoa);

        jMnNhapLoaiHangHoa.setBackground(new java.awt.Color(153, 153, 153));
        jMnNhapLoaiHangHoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMnNhapLoaiHangHoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bar chart.png"))); // NOI18N
        jMnNhapLoaiHangHoa.setText("Nhập loại hàng hóa");
        jMnNhapLoaiHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnNhapLoaiHangHoaActionPerformed(evt);
            }
        });
        jMnHangHoa.add(jMnNhapLoaiHangHoa);

        jMnDSHangHoa.setBackground(new java.awt.Color(204, 204, 204));
        jMnDSHangHoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMnDSHangHoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add to basket.png"))); // NOI18N
        jMnDSHangHoa.setText("Danh sách hàng hóa");
        jMnDSHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnDSHangHoaActionPerformed(evt);
            }
        });
        jMnHangHoa.add(jMnDSHangHoa);

        jMenuBar1.add(jMnHangHoa);

        jMenu1.setForeground(new java.awt.Color(255, 102, 0));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Statistics.png"))); // NOI18N
        jMenu1.setText("Báo cáo");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Best.png"))); // NOI18N
        jMenuItem1.setText("Báo cáo chung");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search.png"))); // NOI18N
        jMenuItem2.setText("Báo cáo chi tiết");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMnNhanVien.setForeground(new java.awt.Color(255, 102, 0));
        jMnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/khachHang.png"))); // NOI18N
        jMnNhanVien.setText("Quản lý nhân viên");
        jMnNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(jMnNhanVien);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void VisiblePanel(JPanel pn){
        jMainPanel.removeAll();
        jMainPanel.add(pn);
        jMainPanel.repaint();
        jMainPanel.revalidate();
    }
    private void jMnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnBanHangActionPerformed
        // TODO add your handling code here:
        VisiblePanel(jPanelBanHang);
    }//GEN-LAST:event_jMnBanHangActionPerformed

    private void JMnNhapHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMnNhapHoaDonActionPerformed
        // TODO add your handling code here:
        VisiblePanel(jPanelBanHang);
    }//GEN-LAST:event_JMnNhapHoaDonActionPerformed

    private void jMnNhapThanhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnNhapThanhVienActionPerformed
        // TODO add your handling code here:
        jMainPanel.removeAll();
        jMainPanel.add(jPanelKhachHang);
        jMainPanel.repaint();
        jMainPanel.revalidate();
    }//GEN-LAST:event_jMnNhapThanhVienActionPerformed

    private void jMnNhapHangHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnNhapHangHoaActionPerformed
        
        jMainPanel.removeAll();
        jMainPanel.add(JPanelNhapHangHoa);
        jMainPanel.repaint();
        jMainPanel.revalidate();
    }//GEN-LAST:event_jMnNhapHangHoaActionPerformed

    private void jMnHangHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnHangHoaActionPerformed
        // TODO add your handling code here:
        jMainPanel.removeAll();
        jMainPanel.add(JPanelNhapHangHoa);
        jMainPanel.repaint();
        jMainPanel.revalidate();
    }//GEN-LAST:event_jMnHangHoaActionPerformed

    private void jMnNhapLoaiHangHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnNhapLoaiHangHoaActionPerformed
        // TODO add your handling code here:
        JDialogNhapLoaiHang j = new JDialogNhapLoaiHang(this, true);
                j.setLocationRelativeTo(null);
        j.setVisible(true);
        
    }//GEN-LAST:event_jMnNhapLoaiHangHoaActionPerformed

    private void jMnDSHangHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnDSHangHoaActionPerformed
        // TODO add your handling code here:
        VisiblePanel(jPanelDSHH);
        
    }//GEN-LAST:event_jMnDSHangHoaActionPerformed

    private void btnNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapActionPerformed
        SanPham sp = new SanPham();
        if (CheckForm() == true) {
            
            if (spDAO.themSanPham(sp) == 0) {
                JOptionPane.showMessageDialog(this, "Thêm dữ liệu thất lại");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm dữ liệu thành công");
            }
        }
    }//GEN-LAST:event_btnNhapActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        SanPham sp = new SanPham();
        if (CheckForm() == true) {
            sp.setMaHang(Integer.parseInt(txtMaSP.getText()));
            sp.setLoHang(Integer.parseInt(txtMaLo.getText()));
            sp.setMaLoai(Integer.parseInt(txtMaLoai.getText()));
            sp.setTenHang(txtTenSanPham.getText());
            sp.setGiaNhap(Double.parseDouble(txtGiaNhap.getText()));
            sp.setGiaBan(Double.parseDouble(txtGiaBan.getText()));
            sp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
            sp.setSoLuongMin(Integer.parseInt(txtSoLuongMin.getText()));
            sp.setNSX(txtNSX.getText());
            sp.setHSD(txtHSD.getText());
            sp.setHSDMin(Integer.parseInt(txtHSDMin.getText()));
            if (spDAO.updateSanPham(sp) == 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật dữ liệu thất lại");
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật dữ liệu thành công");
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnLuu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuu1ActionPerformed
        // TODO add your handling code here:
        txtGiaBan.setText("");
        txtGiaNhap.setText("");
        txtHSD.setText("");
        txtHSDMin.setText("");
        txtMaLo.setText("");
        txtMaLoai.setText("");
        txtMaSP.setText("");
        txtNSX.setText("");
        txtSoLuong.setText("");
        txtSoLuongMin.setText("");
        txtTenSanPham.setText("");
    }//GEN-LAST:event_btnLuu1ActionPerformed

    private void txtMaSPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaSPFocusLost
        // TODO add your handling code here:
        int masp=Integer.parseInt(txtMaSP.getText());
        SanPham sp=spDAO.getByID(masp);
        if(sp==null){
            
        }else{
        txtGiaBan.setText(sp.getGiaBan()+"");
        txtGiaNhap.setText(sp.getGiaNhap()+"");
        txtHSD.setText(sp.getHSD());
        txtHSDMin.setText(sp.getHSDMin()+"");
        txtMaLo.setText(sp.getLoHang()+"");
        txtMaLoai.setText(sp.getMaLoai()+"");
        txtNSX.setText(sp.getNSX());
        txtSoLuong.setText(sp.getSoLuong()+"");
        txtSoLuongMin.setText(sp.getSoLuongMin()+"");
        txtTenSanPham.setText(sp.getTenHang());
        }
    }//GEN-LAST:event_txtMaSPFocusLost

    private void btn_ThemSpVaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemSpVaoHoaDonActionPerformed
        // TODO add your handling code here:
        if(maHD.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Chưa tạo hóa đơn");
        }else{
        int check=0;
        if(MaSP.getText().equals("")) check++;
        if(txtSoLuongNhap.getText().equals(""))check++;
        if(check==0){
            HoaDonCT temp= new HoaDonCT();
        temp.setMaHang(Integer.parseInt(MaSP.getText()));
        temp.setSoLuong(Integer.parseInt(txtSoLuongNhap.getText()));
        temp.setMaHoaDon(maHD.getText());
        hdctDAO.addHoaDonCT(temp);
        listHDCT.add(temp);
        hdctDAO.updateSP(temp);
        fillToHoaDon();
        if(!txtTongTien.getText().equals("")){
            double tongTien= Double.parseDouble(txtTongTien.getText());
            double thanhTien=Double.parseDouble(txtThanhTien.getText());
            int ck= Integer.parseInt(txtCK.getText());
            tongTien=tongTien+thanhTien*(100-ck)/100;
            txtTongTien.setText(tongTien+"");
        }else{
            double tongTien=Double.parseDouble(txtThanhTien.getText());
            int ck= Integer.parseInt(txtCK.getText());
            tongTien=tongTien-tongTien*ck/100;
            txtTongTien.setText(tongTien+"");
        }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Nhập đầy đủ các trường");
        }
        }
        
    }//GEN-LAST:event_btn_ThemSpVaoHoaDonActionPerformed

    private void ThemHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemHoaDonActionPerformed
        // TODO add your handling code here:
        if(!maHD.getText().equals("")){
            HoaDon temp = new HoaDon();
        temp.setMaHoaDon(maHD.getText());
        temp.setMaKhachHang(Integer.parseInt(maKH.getText()));
        temp.setMaNV(maNV.getText());
        temp.setTongTien(Double.parseDouble(txtTongTien.getText()));
        int kq= hdDAO.UpdateHoaDon(temp);
        if(kq==1){
            JOptionPane.showMessageDialog(rootPane, "In hóa đơn thành công");
        }else{
            JOptionPane.showMessageDialog(rootPane, kq);
        }
        MaSP.setText("");
        txtSoLuongNhap.setText("");
        txtDonGia.setText("");
        txtThanhTien.setText("");
        maKH1.setText("");
        maNV.setText("");
        maKH.setText("");
        maHD.setText("");
        txtCK.setText("");
        txtTongTien.setText("");
        listHDCT.clear();
        resetTable();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Nhập Hóa đơn !");
        }
        
    }//GEN-LAST:event_ThemHoaDonActionPerformed

    private void new_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_HoaDonActionPerformed
        maHD.setText(java.time.LocalDateTime.now()+"");
        maNV.setText("NV001");
        maKH.setText("0");
        HoaDon temp = new HoaDon();
        temp.setMaHoaDon(maHD.getText());
        temp.setMaKhachHang(Integer.parseInt(maKH.getText()));
        temp.setTongTien(0);
        temp.setMaNV("NV001");
        temp.setMaNV(maNV.getText());
        int kq=hdDAO.ThemHoaDon(temp);
        listHDCT.clear();
    }//GEN-LAST:event_new_HoaDonActionPerformed

    private void MaSPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MaSPFocusLost
        // TODO add your handling code here:
        if(!MaSP.getText().equals("")){
            int maSP = Integer.parseInt(MaSP.getText());
        SanPham temp = new SanPham();
        temp= spDAO.getByID(maSP);
        if(temp==null){
            MaSP.setText("");
        }else{
            txtDonGia.setText(temp.getGiaBan()+"");
            soLuongTemp=temp.getSoLuong();
        }
        }
    }//GEN-LAST:event_MaSPFocusLost

    private void txtSoLuongNhapFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoLuongNhapFocusLost
        // TODO add your handling code here:
        int sl= Integer.parseInt(txtSoLuongNhap.getText());
        if(sl<=soLuongTemp){
        double thanhtien=sl*Double.parseDouble(txtDonGia.getText());
        txtThanhTien.setText(thanhtien+"");
        }else{
            txtSoLuongNhap.setText("");
        }
        
    }//GEN-LAST:event_txtSoLuongNhapFocusLost

    private void maKH1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_maKH1FocusLost
        // TODO add your handling code here:
        if(tblHoaDon.getRowCount()==0){
            maKH.setText(maKH1.getText());
            if(maKH.getText().trim().equals("0")){
                txtCK.setText("0");
            }else{
                txtCK.setText("5");
            }
        }
    }//GEN-LAST:event_maKH1FocusLost

    private void tblHoaDonPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblHoaDonPropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblHoaDonPropertyChange

    private void btnXoaFormKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaFormKHActionPerformed
        txtTenKH.setText("");
        txtSdt.setText("");
        txtNgaySinh.setText("");
        rdbNam.setSelected(true);
        txtDiaChi.setText("");
    }//GEN-LAST:event_btnXoaFormKHActionPerformed

    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        KhachHang kh = new KhachHang();
        if (checkFormKH() == true) {
            //sp.setMaHang(Integer.parseInt(txtMaSP.getText()));
            kh.setNgSinh(txtNgaySinh.getText());
            kh.setPhone(txtSdt.getText());
            kh.setTenKH(txtTenKH.getText());
            kh.setdChi(txtDiaChi.getText());
            if(rdbNam.isSelected() == true){
                kh.setgTinh(rdbNam.isSelected());
            }else if(rdbNu.isSelected() == true){
                kh.setgTinh(rdbNu.isSelected());
            }
            if (khDAO.ThemKhachHang(kh) == 0) {
                JOptionPane.showMessageDialog(this, "Thêm dữ liệu thất lại");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm dữ liệu thành công");
            }
        }
    }//GEN-LAST:event_btnThemKHActionPerformed

    private void btn_reportHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportHDActionPerformed
        // TODO add your handling code here:
        tongMatHang.setText("NULL");
        tongSLHang.setText("NULL");
        String regex = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
        if(dayMin.getText().matches(regex) && dayMax.getText().matches(regex)){
            ReportDAO r = new ReportDAO();
            r.setVector(dayMin.getText(), dayMax.getText(), 1);
            DefaultTableModel model;
            model = new DefaultTableModel(r.data,r.head);
            tblBaoCao.setModel(model);
            tongHoaDon.setText(r.rowCount+"");
            tongDoanhThu.setText(r.tongTien+"");
            if(r.rowCount==0){
                 JOptionPane.showMessageDialog(rootPane,"Không có dữ liệu trong"
                        + " khoảng thời gian này");
                dayMin.setText("");
                dayMax.setText("");
            }
            
        }else 
            JOptionPane.showMessageDialog
        (rootPane,"Nhập đúng định dạng yyyy-MM-dd");
    }//GEN-LAST:event_btn_reportHDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        tongHoaDon.setText("NULL");
        tongDoanhThu.setText("NULL");
        String regex = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
        if(dayMin.getText().matches(regex) && dayMax.getText().matches(regex)){
            ReportDAO r = new ReportDAO();
            r.setVector(dayMin.getText(), dayMax.getText(), 2);
            DefaultTableModel model;
            model = new DefaultTableModel(r.data,r.head);
            tblBaoCao.setModel(model);
            tongMatHang.setText(r.rowCount+"");
            tongSLHang.setText(r.tongSL+"");
            if(r.rowCount==0){
                JOptionPane.showMessageDialog(rootPane,"Không có dữ liệu trong"
                        + " khoảng thời gian này");
                dayMin.setText("");
                dayMax.setText("");
            }
        }else 
            JOptionPane.showMessageDialog
        (rootPane,"Nhập đúng định dạng yyyy-MM-dd");
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        VisiblePanel(PanelBaoCaoHoaDon);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        VisiblePanel(pannelBaoCaoCT);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void BaoCaoNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaoCaoNVActionPerformed
        if(checkBaoCao() == true){
            fillTable();
        }
    }//GEN-LAST:event_BaoCaoNVActionPerformed

    private void tblNhanVienCaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblNhanVienCaPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_tblNhanVienCaPropertyChange

    private void BaoCaoNV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaoCaoNV1ActionPerformed
        // TODO add your handling code here:
        String regex = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
        if(txtTimeStart.getText().matches(regex) &&
                txtTimeEnd.getText().matches(regex)){
            ReportDAO r = new ReportDAO();
            r.setVector(txtTimeStart.getText(), txtTimeEnd.getText(), 3);
            DefaultTableModel model;
            model = new DefaultTableModel(r.data,r.head);
            tblNhanVienCa.setModel(model);
                            txtHDTong.setText(tblNhanVienCa.getRowCount()+"");
                ArrayList<String> listTongTien = new ArrayList();
                for(int i=0;i<tblNhanVienCa.getRowCount();i++){
                    listTongTien.add((String) tblNhanVienCa.getValueAt(i,3));
                }
                double tongT=0;
                for (String l : listTongTien) {
                    tongT+=Double.parseDouble(l);
                }
                txtDT.setText(tongT+"");
            if(tblNhanVienCa.getRowCount()==0){
                 JOptionPane.showMessageDialog(rootPane,"Không có dữ liệu trong"
                        + " khoảng thời gian này");
                txtTimeStart.setText("");
                txtTimeEnd.setText("");
            }
        }else 
            JOptionPane.showMessageDialog
        (rootPane,"Nhập đúng định dạng yyyy-MM-dd");
        
        
    }//GEN-LAST:event_BaoCaoNV1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BaoCaoNV;
    private javax.swing.JButton BaoCaoNV1;
    private javax.swing.JMenuItem JMnNhapHoaDon;
    private javax.swing.JPanel JPanelNhapHangHoa;
    private javax.swing.JTextField MaSP;
    private javax.swing.JPanel PanelBaoCaoHoaDon;
    private javax.swing.JButton ThemHoaDon;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnLuu1;
    private javax.swing.JButton btnNhap;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnXoaFormKH;
    private javax.swing.JButton btn_ThemSpVaoHoaDon;
    private javax.swing.JButton btn_reportHD;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbCaLam;
    private javax.swing.JComboBox<String> cbbMaNV;
    private javax.swing.JTextField dayMax;
    private javax.swing.JTextField dayMin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jMainPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu jMnBanHang;
    private javax.swing.JMenuItem jMnDSHangHoa;
    private javax.swing.JMenu jMnHangHoa;
    private javax.swing.JMenu jMnNhanVien;
    private javax.swing.JMenuItem jMnNhapHangHoa;
    private javax.swing.JMenuItem jMnNhapLoaiHangHoa;
    private javax.swing.JMenuItem jMnNhapThanhVien;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelBanHang;
    private javax.swing.JPanel jPanelBaoCao;
    private javax.swing.JPanel jPanelDSHH;
    private javax.swing.JPanel jPanelKhachHang;
    private javax.swing.JPanel jPanelQLNhanVien;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JLabel lblBaoCao2;
    private javax.swing.JLabel lblBaocao1;
    private javax.swing.JTextField maHD;
    private javax.swing.JTextField maKH;
    private javax.swing.JTextField maKH1;
    private javax.swing.JTextField maNV;
    private javax.swing.JButton new_HoaDon;
    private javax.swing.JPanel pannelBaoCaoCT;
    private javax.swing.JRadioButton rdbNam;
    private javax.swing.JRadioButton rdbNu;
    private javax.swing.JTable tblBaoCao;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblNhanVienCa;
    private javax.swing.JLabel tongDoanhThu;
    private javax.swing.JLabel tongHoaDon;
    private javax.swing.JLabel tongMatHang;
    private javax.swing.JLabel tongSLHang;
    private javax.swing.JTextField txtCK;
    private javax.swing.JLabel txtDT;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JLabel txtHDTong;
    private javax.swing.JTextField txtHSD;
    private javax.swing.JTextField txtHSDMin;
    private javax.swing.JTextField txtMaLo;
    private javax.swing.JTextField txtMaLoai;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNSX;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoLuongMin;
    private javax.swing.JTextField txtSoLuongNhap;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTimeEnd;
    private javax.swing.JTextField txtTimeStart;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

    private void fillToHoaDon() {
        if(listHDCT.size()>0){
            DefaultTableModel model = (DefaultTableModel) tblHoaDon.getModel();
                Object[] row = new Object[]{
               getTenSPbyID(listHDCT.get(listHDCT.size()-1).getMaHang()),
                txtDonGia.getText(),listHDCT.get(listHDCT.size()-1).getSoLuong(),
                Double.parseDouble(txtDonGia.getText())*listHDCT.get(listHDCT.size()-1).getSoLuong()
            };
            model.addRow(row);
        }
    }

    private String getTenSPbyID(int id) {
        for(int i=0;i<listsp.size();i++){
            if(listsp.get(i).getMaHang()==id){
                return listsp.get(i).getTenHang();
            }
        }
        return "0";
    }

    private void resetTable() {
        DefaultTableModel model =(DefaultTableModel)tblHoaDon.getModel();
        model.setRowCount(0);
    }

    private void setIcon() {
     // jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add.png")));  
    }
}
