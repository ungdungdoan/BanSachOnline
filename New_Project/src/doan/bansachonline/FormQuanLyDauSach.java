package doan.bansachonline;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import doan.bansachonline.DanhMucSach;
import doan.bansachonline.DulieuDB;
import doan.bansachonline.DbUtils;


public class FormQuanLyDauSach extends JFrame implements ActionListener {
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
	@SuppressWarnings("unused")
	private JTextField txtSoLuongS;
	@SuppressWarnings("unused")
	private JLabel lblSoLuongS;
	@SuppressWarnings("unused")
	private JLabel lblTinhTrangS;
	private JButton btnXemListSach;
	private SachHeper napsach;
	private DanhMucSach dms;
	private DanhMucSach DanhMucSach;

	
	
	public FormQuanLyDauSach(){
		setTitle("Quản Lý Sách");
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

		
		Box b,b1,b2,b3,b4,b5,b6,b7;
		add(b=Box.createVerticalBox());
		b.add(Box.createVerticalStrut(50));
		b.add(b1= Box.createHorizontalBox());b.add(Box.createVerticalStrut(50));
		b.add(b2= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		b.add(b3= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		b.add(b4= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		b.add(b5= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		b.add(b6= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		b.add(b7= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		
		
		JLabel lbltieude;
		b1.add(lbltieude= new JLabel("Quản Lý Thông Tin Sách"));
		lbltieude.setFont(new Font("Arial",Font.BOLD,35));
		lbltieude.setForeground(Color.RED);
		
		
		JLabel lblMaS,lblTenS,lblGiaS;
		b2.add(lblMaS=new JLabel("Mã Sách:"));b2.add(txtMaS= new JTextField());	
		lblMaS.setForeground(Color.blue);
		b3.add(lblTenS=new JLabel("Tên Sách:"));b3.add(txtTenS= new JTextField());	
		lblTenS.setForeground(Color.blue);
		b4.add(lblGiaS=new JLabel("Giá Sách:"));b4.add(txtGiaS= new JTextField());
		lblGiaS.setForeground(Color.blue);
		
		
		
		
		lblMaS.setPreferredSize(lblGiaS.getPreferredSize());
		lblTenS.setPreferredSize(lblGiaS.getPreferredSize());
		lblGiaS.setPreferredSize(lblGiaS.getPreferredSize());
	
		
		b5.add(Box.createHorizontalStrut(50));
		b5.add(btnThem = new JButton("Thêm Sách"));btnThem.setForeground(Color.blue);
		b5.add(btnLuu = new JButton("Lưu Sách"));btnLuu.setForeground(Color.blue);
		b5.add(btnXoa = new JButton("Xoá Sách"));btnXoa.setForeground(Color.blue);
		b5.add(btnCapnhat = new JButton("Cập Nhật"));btnCapnhat.setForeground(Color.blue);
		
		String[] headers = {"Mã Sách", "Tên Sách", "Giá Sách"};
		dataModel = new DefaultTableModel(headers , 0);
		JScrollPane scroll;
		b6.add(scroll = new JScrollPane(table = new JTable(dataModel){
			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return false;
			}
		}));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh Sách Đầu Sách"));
		
		b7.add(Box.createHorizontalStrut(0));
		b7.add(btnXemListSach = new JButton("Xem List Sách"));
		btnXemListSach.setForeground(Color.RED);
		btnXemListSach.setFont(new Font("Arial",Font.ITALIC,15));
		

		
		moKhoaTextfields(false);
		moKhoaControls(true);
		btnLuu.setEnabled(false);
		
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if(row >= 0){
					napDanhSachTextfields();
				}
			}
		});
		napsach = new SachHeper();
		table.setRowHeight(25);
		for(DanhMucSach lh : napsach.getAllDanhMucSach()){
			Object[] rowData = {lh.getMaS(), lh.getTenS(), lh.getGiaS()};
			dataModel.addRow(rowData);
		}

		

	
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnXoa.addActionListener(this);
		btnCapnhat.addActionListener(this);
		btnXemListSach.addActionListener(this);
		
	}


	private void moKhoaControls(boolean b) {
	
		btnThem.setEnabled(b);
		btnLuu.setEnabled(b);
		btnCapnhat.setEnabled(b);
		btnXoa.setEnabled(b);
		btnXemListSach.setEnabled(b);
	}
	private void moKhoaTextfields(boolean b) {
		txtMaS.setEditable(b);
		txtTenS.setEditable(b);
		txtGiaS.setEditable(b);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)){
			if(btnThem.getText().equalsIgnoreCase("Thêm Sách")){
				moKhoaTextfields(true);
				moKhoaControls(false);
				btnLuu.setEnabled(true);
				btnThem.setEnabled(true);
				btnThem.setText("Huỷ");
				xoaRongTextfields();
			}else if(btnThem.getText().equalsIgnoreCase("Huỷ")){
				moKhoaTextfields(false);
				moKhoaControls(true);
				btnLuu.setEnabled(false);
				btnThem.setText("Thêm Sách");
				napDanhSachTextfields();
			}
		}else if(o.equals(btnCapnhat)){
			if(btnCapnhat.getText().equalsIgnoreCase("Cập Nhật")){
				moKhoaTextfields(true);
				txtMaS.setEditable(false);
				moKhoaControls(false);
				btnLuu.setEnabled(true);
				btnCapnhat.setEnabled(true);
				btnCapnhat.setText("Hủy");
			}
			else if(btnCapnhat.getText().equalsIgnoreCase("Hủy")){
				moKhoaTextfields(false);
				moKhoaControls(true);
				btnLuu.setEnabled(false);
				btnCapnhat.setText("Cập Nhật");
				napDanhSachTextfields();
			}
		}else if(o.equals(btnXoa)){
			int row = table.getSelectedRow();
			if(row >= 0){
				String MaS = (String) table.getValueAt(row, 0);
				DanhMucSach dms = new DanhMucSach(MaS);
				if(dms.delete()){
					dataModel.removeRow(row);
					xoaRongTextfields();
				}
			}
		}else if(o.equals(btnLuu)){
			if(btnThem.getText().equalsIgnoreCase("Hủy")){
				DanhMucSach dms = new DanhMucSach(txtMaS.getText(), txtTenS.getText(), txtGiaS.getText());
				if(dms.create()){
					Object[] rowData =  {txtMaS.getText(), txtTenS.getText(), txtGiaS.getText()};
					dataModel.addRow(rowData);
						
					moKhoaTextfields(false);
					moKhoaControls(true);
					btnLuu.setEnabled(false);
					btnThem.setText("Thêm Sách");
					}
				}
			else if(btnCapnhat.getText().equalsIgnoreCase("Hủy")){
				int row = table.getSelectedRow();
				if(row >= 0){
					DanhMucSach dms = new DanhMucSach(txtMaS.getText(), txtTenS.getText(), txtGiaS.getText());
					if(dms.update()){
						table.setValueAt(dms.getTenS(), row, 1);
						table.setValueAt(dms.getGiaS(), row, 2);
						moKhoaTextfields(false);
						moKhoaControls(true);
						btnLuu.setEnabled(false);
						btnCapnhat.setText("Cập Nhật");
					}
				}
			}
		}else if(o.equals(btnXemListSach)){
				DanhMucSach = new DanhMucSach(txtMaS.getText(),txtTenS.getText(),txtGiaS.getText());
				new FormDatHang().setVisible(true);
			}
		
	}
	private void napDanhSachTextfields() {
		int row = table.getSelectedRow();
		if(row >= 0){
			txtMaS.setText((String) table.getValueAt(row, 0));
			txtTenS.setText((String) table.getValueAt(row, 1));
			txtGiaS.setText((String) table.getValueAt(row, 2));
		}
	}	
private void xoaRongTextfields() {
	txtMaS.setText("");
	txtTenS.setText("");
	txtGiaS.setText("");
	txtMaS.requestFocus();
	}


public DanhMucSach getDms() {
	return dms;
}


public void setDms(DanhMucSach dms) {
	this.dms = dms;
}
}







