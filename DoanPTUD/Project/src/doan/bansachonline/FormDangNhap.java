package doan.bansachonline;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.Box;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPasswordField;
import javax.swing.JTextField;


import doan.bansachonline.DulieuDB;

import doan.bansachonline.FormQuanLyDauSach;



public class FormDangNhap extends JFrame implements ActionListener{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnDangNhap;
	private JButton btnThoat;
	private JPasswordField txtPass;
	Connection con;
	private JTextField txtId;
	private FormQuanLyDauSach fq;

	public FormDangNhap(){
		setTitle("Login Quản Lý");
		setSize(500,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		Box b, b1,b2,b3,b4;
		add(b = Box.createVerticalBox());
		b.add(Box.createVerticalStrut(25));b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(25));b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(25));b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(25));b.add(b4 = Box.createHorizontalBox());
	
		
		JLabel lblTieuDe, lblId;
		JLabel lblPass;
		b1.add(lblTieuDe = new JLabel("ĐĂNG NHẬP TAI KHOẢN", JLabel.CENTER));
		lblTieuDe.setFont(new Font("Arila", Font.BOLD, 26));
		lblTieuDe.setForeground(Color.RED);
		b2.add(lblId = new JLabel("ID:", JLabel.RIGHT));b2.add(txtId = new JTextField());
		b3.add(lblPass = new JLabel("PASSWORD:"));b3.add(txtPass = new JPasswordField());
		lblId.setForeground(Color.BLUE);
		lblPass.setForeground(Color.BLUE);
		
		lblId.setPreferredSize(lblPass.getPreferredSize());
		lblPass.setPreferredSize(lblPass.getPreferredSize());
		
		b4.add(Box.createHorizontalStrut(70));
		b4.add(btnDangNhap = new JButton("Đăng Nhập"));btnDangNhap.setForeground(Color.BLUE);
		b4.add(btnThoat = new JButton("Thoát"));btnThoat.setForeground(Color.BLUE);

		btnDangNhap.addActionListener(this);
		btnThoat.addActionListener(this);	
}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnDangNhap))
		{
			java.sql.Statement stmt=null;
			Connection con = DulieuDB.getConnection();
			if (txtId.getText().equals("") || new String(((JPasswordField) txtPass).getPassword()).equals("")) {
                JOptionPane.showMessageDialog(FormDangNhap.this, "Id và Pass không được để trống", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
            	String query = "select * from DangNhap where Id = '" + txtId.getText() + "' and Pass = '" + new String(((JPasswordField) txtPass).getPassword()) + "'";
                stmt = con.createStatement();
                ResultSet res =  stmt.executeQuery(query);
                if (res != null) {
                    if (res.next()) {
                        if (res.getString("Pass").equals(new String(((JPasswordField) txtPass).getPassword()))) {
                             this.hide();
                             fq = new FormQuanLyDauSach();
                             fq.show();
                        } else {
                            JOptionPane.showMessageDialog(FormDangNhap.this, "Mật khẩu không tồn tại!", "Lỗi đăng nhập!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(FormDangNhap.this, "Id hoặc Pass trống!", "Lỗi đăng nhập!", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }else if(o.equals(btnThoat))
		{
			System.out.println("Kết thúc");	
			System.exit(0);
		}
}
	public static void main(String[] args) {
		new FormDangNhap().setVisible(true);
	}
}
