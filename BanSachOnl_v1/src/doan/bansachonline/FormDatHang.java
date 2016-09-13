package doan.bansachonline;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import doan.bansachonline.DulieuDB;
import doan.bansachonline.DbUtils;
import doan.bansachonline.DanhMucSach;
import doan.bansachonline.SachHeper;


public class FormDatHang extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private JTextField txtMaS;
	@SuppressWarnings("unused")
	private JTextField txtTenS;
	private DefaultTableModel dataModel;
	private JTable table;
	@SuppressWarnings("unused")
	private JTextField txtGiaS;
	@SuppressWarnings("unused")
	private JButton btnMua;
	@SuppressWarnings("unused")
	private JButton btnThanhToan;
	@SuppressWarnings("unused")
	private JButton btnThoat;
	private SachHeper ssachheper;
	@SuppressWarnings("unused")
	private DanhMucSach dms;
	
	public FormDatHang(){
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
	
		
		
		String[] headers = {"Mã Sách", "Tên Sách", "Giá Sách"};
		dataModel = new DefaultTableModel(headers , 0);
		JScrollPane scroll;
		b1.add(scroll = new JScrollPane(table = new JTable(dataModel)));
		scroll.setBorder(BorderFactory.createTitledBorder("Thông Tin Sách"));
		
		b2.add(Box.createHorizontalStrut(70));
		b2.add(btnMua = new JButton("Mua Sách"));
		b2.add(btnThanhToan = new JButton("Thanh Toán"));
		b2.add(btnThoat = new JButton("Thoát"));

		
		
		table.setRowHeight(25);
		ssachheper = new SachHeper();
		for(DanhMucSach dms : ssachheper.getAllDanhMucSach()){
			Object[] rowData = {dms.getMaS(), dms.getTenS(), dms.getGiaS(),dms.getGiaS()};
			dataModel.addRow(rowData);
		}
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				napDanhSachTextfields();
			}

			private void napDanhSachTextfields() {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
public static void main(String[] args) {
	new FormDatHang().setVisible(true);
}
}


