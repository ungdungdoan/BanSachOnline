package demo.bansach;



import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FormDmSach extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaS;
	private JTextField txtTenS;
	private DefaultTableModel dataModel;
	private JTable table;
	private JTextField txtGiaS;
	private JButton btnMua;
	private JButton btnThanhToan;
	private JButton btnThoat;
	public FormDmSach(){
		setTitle("Đặt Sách");
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

		
		Box b,b1,b2;
		add(b=Box.createVerticalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b1= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		b.add(b2= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
	
		
		
		String[] headers = {"Mã Sách", "Tên Sách", "Giá Sách","Còn Hàng","Hết Hàng"};
		dataModel = new DefaultTableModel(headers , 0);
		JScrollPane scroll;
		b1.add(scroll = new JScrollPane(table = new JTable(dataModel)));
		scroll.setBorder(BorderFactory.createTitledBorder("Thông Tin Sách"));
		
		b2.add(Box.createHorizontalStrut(70));
		b2.add(btnMua = new JButton("Mua Sách"));
		b2.add(btnThanhToan = new JButton("Thanh Toán"));
		b2.add(btnThoat = new JButton("Thoát"));

		
	}
public static void main(String[] args) {
	new FormDmSach().setVisible(true);
}
}
