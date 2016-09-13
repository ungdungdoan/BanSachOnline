package doan.bansachonline;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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



import doan.bansachonline.DulieuDB;
import doan.bansachonline.DbUtils;
import doan.bansachonline.DanhMucSach;


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
		b.add(Box.createVerticalStrut(10));
		b.add(b1= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		b.add(b2= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		b.add(b3= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		b.add(b4= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		b.add(b5= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		b.add(b6= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		b.add(b7= Box.createHorizontalBox());b.add(Box.createVerticalStrut(10));
		
		
		JLabel lbltieude;
		b1.add(lbltieude= new JLabel("Quản Lý Thông Tin Sách"));
		lbltieude.setFont(new Font("Arial",Font.BOLD,25));
		
		
		JLabel lblMaS,lblTenS,lblGiaS;
		b2.add(lblMaS=new JLabel("Mã Sách:"));b2.add(txtMaS= new JTextField());	
		b3.add(lblTenS=new JLabel("Tên Sách:"));b3.add(txtTenS= new JTextField());	
		b4.add(lblGiaS=new JLabel("Giá Sách:"));b4.add(txtGiaS= new JTextField());	
		
		
		
		
		lblMaS.setPreferredSize(lblGiaS.getPreferredSize());
		lblTenS.setPreferredSize(lblGiaS.getPreferredSize());
		lblGiaS.setPreferredSize(lblGiaS.getPreferredSize());
	
		
		b5.add(Box.createHorizontalStrut(70));
		b5.add(btnThem = new JButton("Thêm Sách"));
		b5.add(btnLuu = new JButton("Lưu Sách"));
		b5.add(btnXoa = new JButton("Xoá Sách"));
		b5.add(btnCapnhat = new JButton("Cập Nhật"));
		
		String[] headers = {"Mã Sách", "Tên Sách", "Giá Sách"};
		dataModel = new DefaultTableModel(headers , 0);
		JScrollPane scroll;
		b6.add(scroll = new JScrollPane(table = new JTable(dataModel)));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh Sách Đầu Sách"));
		
		b7.add(Box.createHorizontalStrut(600));
		b7.add(btnXemListSach = new JButton("Xem List Sách"));
		btnXemListSach.setForeground(Color.BLUE);

		
		moKhoaTextfields(false);
		moKhoaControls(true);
		btnLuu.setEnabled(false);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				napDanhSachTextfields();
			}

			private void napDanhSachTextfields() {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				if(row >= 0){
					txtMaS.setText((String) table.getValueAt(row, 0));
					txtTenS.setText((String) table.getValueAt(row, 1));
					txtGiaS.setText((String) table.getValueAt(row, 2));
				}
			}
		});
		
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
		// TODO Auto-generated method stub
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
			}
		}else if(o.equals(btnLuu)){
			if(btnThem.getText().equalsIgnoreCase("Huỷ")){
				DanhMucSach dms = new DanhMucSach(txtMaS.getText(), txtTenS.getText(), txtGiaS.getText());
				if(dms.create()){
					Object[] rowData =  {txtMaS.getText(), txtTenS.getText(), txtGiaS.getText()};
					dataModel.addRow(rowData);
						
					moKhoaTextfields(false);
					moKhoaControls(true);
					btnLuu.setEnabled(false);
					btnThem.setText("Thêm Sách");
				}
				else if(btnCapnhat.getText().equalsIgnoreCase("Huỷ")){
					int row = table.getSelectedRow();
					if(row >= 0){
						DanhMucSach d = new DanhMucSach(txtMaS.getText(), txtTenS.getText(), txtGiaS.getText());
						if(d.update()){
							table.setValueAt(d.getTenS(), row, 1);
							table.setValueAt(d.getMaS(), row, 2);
							table.setValueAt(d.getGiaS(), row, 3);
							moKhoaTextfields(false);
							moKhoaControls(true);
							btnLuu.setEnabled(false);
							btnCapnhat.setText("Cập Nhật");
						}
					}
				}
		}else if(o.equals(btnCapnhat)){
			if(btnCapnhat.getText().equalsIgnoreCase("Cập Nhật")){
				moKhoaTextfields(true);
				txtMaS.setEditable(false);
				moKhoaControls(false);
				btnLuu.setEnabled(true);
				btnCapnhat.setEnabled(true);
				btnCapnhat.setText("Cập Nhật");
			}else if(btnCapnhat.getText().equalsIgnoreCase("Huỷ")){
				moKhoaTextfields(false);
				moKhoaControls(true);
				btnLuu.setEnabled(false);
				btnCapnhat.setText("Cập Nhật");
			}
		}else if(o.equals(btnXoa)){
			int row = table.getSelectedRow();
			if(row >= 0){
				String MaS = (String) table.getValueAt(row, 0);
				DanhMucSach dms = new DanhMucSach(MaS);
				if(dms.delete()){
					dataModel.removeRow(row);
				}
			}
		}
		else if(o.equals(btnXemListSach)){
			int row = table.getSelectedRow();
			if(row >= 0){
				String MaS = (String) table.getValueAt(row, 0);
				DanhMucSach dms = new DanhMucSach(MaS);
				FormDatHang frm = new FormDatHang();
				frm.setVisible(true);
			}
		}
		}
	}
private void xoaRongTextfields() {
	txtMaS.setText("");
	txtTenS.setText("");
	txtGiaS.setText("");
}
}
