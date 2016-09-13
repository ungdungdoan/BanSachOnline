package demo.bansach;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FormQuanLy extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaS;
	private JTextField txtTenS;
	private JButton btnThem;
	private JButton btnLuu;
	private JButton btnXoa;
	private JButton btnCapnhat;
	private DefaultTableModel dataModel;
	private JTable table;
	private JTextField txtGiaS;
	private JRadioButton txtConS;
	private JRadioButton txtHetS;
	private JButton btnXemDanhMucS;
	public FormQuanLy(){
		setTitle("Quản Lý");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				DbUtils.close(DulieuDB.getConnection());
				System.exit(0);
			}
		});

		
		Box b,b1,b2,b3,b4,b5,b6,b7,b8;
		add(b=Box.createVerticalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b1= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		b.add(b2= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		b.add(b3= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		b.add(b4= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		b.add(b5= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		b.add(b6= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		b.add(b7= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		b.add(b8= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		
		
		JLabel lbltieude;
		b1.add(lbltieude= new JLabel("Quản Lý Thông Tin Đầu Sách"));
		lbltieude.setFont(new Font("Arial",Font.BOLD,25));
		
		
		JLabel lblMaS,lblTenS,lblGiaS,lblTinhTrangS;
		b2.add(lblMaS=new JLabel("Mã Sách:"));b2.add(txtMaS= new JTextField());	
		b3.add(lblTenS=new JLabel("Tên Sách:"));b3.add(txtTenS= new JTextField());	
		b4.add(lblGiaS=new JLabel("Giá Sách:"));b4.add(txtGiaS= new JTextField());	
		b5.add(lblTinhTrangS=new JLabel("Tình Trạng Sách:"),JLabel.LEFT_ALIGNMENT);
		b5.add(txtConS= new JRadioButton("Còn Hàng"));	
		b5.add(txtHetS= new JRadioButton("Hết Hàng"));	
		
		
		
		lblMaS.setPreferredSize(lblTenS.getPreferredSize());
		lblTenS.setPreferredSize(lblTenS.getPreferredSize());
		lblGiaS.setPreferredSize(lblTenS.getPreferredSize());
		
		b6.add(Box.createHorizontalStrut(70));
		b6.add(btnThem = new JButton("Thêm Sách"));
		b6.add(btnLuu = new JButton("Lưu Sách"));
		b6.add(btnXoa = new JButton("Xoá Sách"));
		b6.add(btnCapnhat = new JButton("Cập Nhật"));
		
		String[] headers = {"Mã Sách", "Tên Sách", "Giá Sách","Còn Hàng","Hết Hàng"};
		dataModel = new DefaultTableModel(headers , 0);
		JScrollPane scroll;
		b7.add(scroll = new JScrollPane(table = new JTable(dataModel)));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh Sách Các Đầu Sách"));
		
		b8.add(Box.createHorizontalStrut(600));
		b8.add(btnXemDanhMucS = new JButton("Xem Danh Mục Sách"));
		btnXemDanhMucS.setForeground(Color.BLUE);

		
		
	}
public static void main(String[] args) {
	new FormQuanLy().setVisible(true);
}
}
