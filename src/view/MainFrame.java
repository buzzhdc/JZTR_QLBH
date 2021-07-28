/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.SanPham;
import model.SanPhamDAO;



/**
 *
 * @author ductr
 */
public class MainFrame extends javax.swing.JFrame {
    SanPhamDAO spDAO = new SanPhamDAO();
    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);
        VisiblePanel(jPanelBanHang);
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
            if (Integer.parseInt(txtMaLo.getText()) == 0) {
                sb.append("Mã lô không được để trống\n");
                 kt = false;
            }
            if (Integer.parseInt(txtMaLoai.getText()) == 0) {
                sb.append("Mã loại không được để trống\n");
                 kt = false;
            }
            if (Integer.parseInt(txtSoLuong.getText()) == 0) {
                sb.append("Số lượng không được để trống\n");
                 kt = false;
            }
            if (Integer.parseInt(txtSoLuongMin.getText()) == 0) {
                sb.append("Số lượng Min không được để trống\n");
                 kt = false;
            }
            if (Double.parseDouble(txtGiaNhap.getText()) == 0) {
                sb.append("Giá nhập không được để trống\n");
                 kt = false;
            }
            if (Double.parseDouble(txtGiaBan.getText()) == 0) {
                sb.append("Giá bán không được để trống\n");
                 kt = false;
            }
            if (Integer.parseInt(txtHSDMin.getText()) == 0) {
                sb.append("Hạn sử dụng Min không được để trống\n");
                 kt = false;
            }
        } catch (NumberFormatException e) {
            sb.append("Vui lòng nhập đúng định dạng (number)\n");
             kt = false;
        }
        try {
            if(txtNSX.getText().length() == 0) {
                Date d = new SimpleDateFormat("yyyy-MM-dd").parse(txtNSX.getText());
                sb.append("NSX không được để trống\n");
                 kt = false;
            }
        } catch (ParseException ex) {
            sb.append("NSX không đúng định dạng (yyyy-MM-dd)\n");
             kt = false;
        }
        try {
            if(txtHSD.getText().length() == 0) {
                Date d = new SimpleDateFormat("yyyy-MM-dd").parse(txtNSX.getText());
                sb.append("HSD không được để trống\n");
                 kt = false;
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMainPanel = new javax.swing.JPanel();
        jPanelBaoCao = new javax.swing.JPanel();
        jPanelQLNhanVien = new javax.swing.JPanel();
        jPanelKhachHang = new javax.swing.JPanel();
        jPanelBanHang = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanelNhapLoaiHang = new javax.swing.JPanel();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMnBanHang = new javax.swing.JMenu();
        JMnNhapHoaDon = new javax.swing.JMenuItem();
        jMnNhapThanhVien = new javax.swing.JMenuItem();
        jMnHangHoa = new javax.swing.JMenu();
        jMnNhapHangHoa = new javax.swing.JMenuItem();
        jMnNhapLoaiHangHoa = new javax.swing.JMenuItem();
        jMnDSHangHoa = new javax.swing.JMenuItem();
        JMnBaoCao = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMnNhanVien = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Bán Hàng");

        jMainPanel.setLayout(new java.awt.CardLayout());

        jPanelBaoCao.setBackground(new java.awt.Color(204, 204, 0));

        javax.swing.GroupLayout jPanelBaoCaoLayout = new javax.swing.GroupLayout(jPanelBaoCao);
        jPanelBaoCao.setLayout(jPanelBaoCaoLayout);
        jPanelBaoCaoLayout.setHorizontalGroup(
            jPanelBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        jPanelBaoCaoLayout.setVerticalGroup(
            jPanelBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );

        jMainPanel.add(jPanelBaoCao, "card4");

        jPanelQLNhanVien.setBackground(new java.awt.Color(102, 102, 0));

        javax.swing.GroupLayout jPanelQLNhanVienLayout = new javax.swing.GroupLayout(jPanelQLNhanVien);
        jPanelQLNhanVien.setLayout(jPanelQLNhanVienLayout);
        jPanelQLNhanVienLayout.setHorizontalGroup(
            jPanelQLNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        jPanelQLNhanVienLayout.setVerticalGroup(
            jPanelQLNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );

        jMainPanel.add(jPanelQLNhanVien, "card5");

        javax.swing.GroupLayout jPanelKhachHangLayout = new javax.swing.GroupLayout(jPanelKhachHang);
        jPanelKhachHang.setLayout(jPanelKhachHangLayout);
        jPanelKhachHangLayout.setHorizontalGroup(
            jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        jPanelKhachHangLayout.setVerticalGroup(
            jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );

        jMainPanel.add(jPanelKhachHang, "card6");

        jPanelBanHang.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã SP:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Số Lượng:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Thành Tiền");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Đơn Giá");

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Thêm");

        jButton2.setBackground(new java.awt.Color(153, 153, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Hủy");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("NHÂN VIÊN: ABC - CA:XYZ");

        jTextField3.setEditable(false);

        jTextField4.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Khách hàng:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel12))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField1)
                                .addComponent(jTextField2)
                                .addComponent(jTextField3)
                                .addComponent(jTextField4)
                                .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jButton1)
                        .addGap(63, 63, 63)
                        .addComponent(jButton2)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(22, 22, 22))
        );

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

        jLabel10.setText("Ngày bán:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mặt Hàng", "Đơn Giá", "Số Lượng", "Thành Tiền"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Tổng tiền phải thanh toán:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Tổng tiền chiết khấu:");

        jButton3.setBackground(new java.awt.Color(153, 153, 255));
        jButton3.setText("In");

        jButton4.setBackground(new java.awt.Color(153, 153, 255));
        jButton4.setText("Xóa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel9))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(93, 93, 93))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(66, 66, 66)))
                        .addComponent(jButton4)))
                .addGap(0, 28, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)))
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
                .addGap(3, 3, 3)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanelBanHangLayout = new javax.swing.GroupLayout(jPanelBanHang);
        jPanelBanHang.setLayout(jPanelBanHangLayout);
        jPanelBanHangLayout.setHorizontalGroup(
            jPanelBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBanHangLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanelBanHangLayout.setVerticalGroup(
            jPanelBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBanHangLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jMainPanel.add(jPanelBanHang, "card2");

        javax.swing.GroupLayout jPanelNhapLoaiHangLayout = new javax.swing.GroupLayout(jPanelNhapLoaiHang);
        jPanelNhapLoaiHang.setLayout(jPanelNhapLoaiHangLayout);
        jPanelNhapLoaiHangLayout.setHorizontalGroup(
            jPanelNhapLoaiHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        jPanelNhapLoaiHangLayout.setVerticalGroup(
            jPanelNhapLoaiHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );

        jMainPanel.add(jPanelNhapLoaiHang, "card7");

        jPanelDSHH.setBackground(new java.awt.Color(255, 255, 204));

        jButton7.setBackground(new java.awt.Color(153, 153, 255));
        jButton7.setText("Tìm kiếm");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không", "Hàng sắp hết HSD", "Hàng có số lượng thấp" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", ".", ".", ".", " " }));

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
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDSHHLayout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanelDSHHLayout.setVerticalGroup(
            jPanelDSHHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDSHHLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelDSHHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jTextField17))
                .addGap(18, 18, 18)
                .addGroup(jPanelDSHHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        jMainPanel.add(jPanelDSHH, "card8");

        JPanelNhapHangHoa.setBackground(new java.awt.Color(255, 255, 204));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
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
        txtGiaBan.setText("0");

        txtNSX.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtHSD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtHSDMin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHSDMin.setText("0");

        txtGiaNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtGiaNhap.setText("0");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Giá Nhập:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Mã Loại:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Số Lượng:");

        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSoLuong.setText("0");

        txtMaLo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMaLo.setText("0");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Mã Lô:");

        txtMaSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMaSP.setText("0");

        txtTenSanPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Tên Sản Phâm:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Mã Sản Phẩm:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Số Lượng Min:");

        txtSoLuongMin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSoLuongMin.setText("0");

        btnNhap.setBackground(new java.awt.Color(153, 153, 255));
        btnNhap.setText("Nhập Lại");
        btnNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapActionPerformed(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(153, 153, 255));
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        txtMaLoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMaLoai.setText("0");

        javax.swing.GroupLayout JPanelNhapHangHoaLayout = new javax.swing.GroupLayout(JPanelNhapHangHoa);
        JPanelNhapHangHoa.setLayout(JPanelNhapHangHoaLayout);
        JPanelNhapHangHoaLayout.setHorizontalGroup(
            JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addGap(62, 62, 62)
                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(jLabel25)
                            .addComponent(jLabel22))
                        .addGap(60, 60, 60)
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMaLo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(txtSoLuongMin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(txtMaLoai, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(111, 111, 111)
                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel15))
                        .addGap(62, 62, 62)
                        .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(2, 2, 2)))
                        .addGap(60, 60, 60)
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNSX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHSDMin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(60, 60, 60)
                        .addComponent(txtHSD, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 130, Short.MAX_VALUE))
            .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(jLabel14))
                    .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addGap(343, 343, 343)
                        .addComponent(btnNhap)
                        .addGap(49, 49, 49)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPanelNhapHangHoaLayout.setVerticalGroup(
            JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel14)
                .addGap(52, 52, 52)
                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(25, 25, 25)
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(txtMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(txtHSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(JPanelNhapHangHoaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtMaLo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtHSDMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18))
                    .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtSoLuongMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(JPanelNhapHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jMainPanel.add(JPanelNhapHangHoa, "card3");

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.setMaximumSize(new java.awt.Dimension(500, 32769));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(438, 35));

        jMnBanHang.setText("Quản lý bán hàng");
        jMnBanHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMnBanHang.setMinimumSize(new java.awt.Dimension(35, 30));
        jMnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnBanHangActionPerformed(evt);
            }
        });

        JMnNhapHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JMnNhapHoaDon.setText("Nhập hóa đơn");
        JMnNhapHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMnNhapHoaDonActionPerformed(evt);
            }
        });
        jMnBanHang.add(JMnNhapHoaDon);

        jMnNhapThanhVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMnNhapThanhVien.setText("Nhập thẻ thành viên");
        jMnNhapThanhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnNhapThanhVienActionPerformed(evt);
            }
        });
        jMnBanHang.add(jMnNhapThanhVien);

        jMenuBar1.add(jMnBanHang);

        jMnHangHoa.setText("Quản lý hàng hóa");
        jMnHangHoa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMnHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnHangHoaActionPerformed(evt);
            }
        });

        jMnNhapHangHoa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMnNhapHangHoa.setText("Nhập hàng hóa");
        jMnNhapHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnNhapHangHoaActionPerformed(evt);
            }
        });
        jMnHangHoa.add(jMnNhapHangHoa);

        jMnNhapLoaiHangHoa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMnNhapLoaiHangHoa.setText("Nhập loại hàng hóa");
        jMnNhapLoaiHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnNhapLoaiHangHoaActionPerformed(evt);
            }
        });
        jMnHangHoa.add(jMnNhapLoaiHangHoa);

        jMnDSHangHoa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMnDSHangHoa.setText("Danh sách hàng hóa");
        jMnDSHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnDSHangHoaActionPerformed(evt);
            }
        });
        jMnHangHoa.add(jMnDSHangHoa);

        jMenuBar1.add(jMnHangHoa);

        JMnBaoCao.setText("Báo cáo");
        JMnBaoCao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem1.setText("Báo cáo theo ca");
        JMnBaoCao.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem2.setText("Báo cáo theo ngày");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        JMnBaoCao.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem3.setText("Báo cáo theo tuần");
        JMnBaoCao.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem4.setText("Báo cáo theo tháng");
        JMnBaoCao.add(jMenuItem4);

        jMenuBar1.add(JMnBaoCao);

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

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed
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
        VisiblePanel(jPanelNhapLoaiHang);
    }//GEN-LAST:event_jMnNhapLoaiHangHoaActionPerformed

    private void jMnDSHangHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnDSHangHoaActionPerformed
        // TODO add your handling code here:
        VisiblePanel(jPanelDSHH);
        
    }//GEN-LAST:event_jMnDSHangHoaActionPerformed

    private void btnNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapActionPerformed
        SanPham sp = new SanPham();
        if (CheckForm() == true) {
            //sp.setMaHang(Integer.parseInt(txtMaSP.getText()));
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
    private javax.swing.JMenu JMnBaoCao;
    private javax.swing.JMenuItem JMnNhapHoaDon;
    private javax.swing.JPanel JPanelNhapHangHoa;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNhap;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jMainPanel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
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
    private javax.swing.JPanel jPanelNhapLoaiHang;
    private javax.swing.JPanel jPanelQLNhanVien;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtHSD;
    private javax.swing.JTextField txtHSDMin;
    private javax.swing.JTextField txtMaLo;
    private javax.swing.JTextField txtMaLoai;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNSX;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoLuongMin;
    private javax.swing.JTextField txtTenSanPham;
    // End of variables declaration//GEN-END:variables
}
