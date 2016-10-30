package doan.bansachonline;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import doan.bansachonline.DulieuDB;
import doan.bansachonline.DbUtils;
import doan.bansachonline.DanhMucSach;
import doan.bansachonline.SachHeper;


public class FormDatHang extends JFrame implements ActionListener{
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

	private JButton btnMua;

	private JButton btnThoat;
	private SachHeper ssachheper;
	@SuppressWarnings("unused")
	private DanhMucSach dms;
	private JButton btnQuayLai;


	
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
		b1.add(scroll = new JScrollPane(table = new JTable(dataModel){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return false;
			}
		}));
		scroll.setBorder(BorderFactory.createTitledBorder("Thông Tin Sách"));
		
		b2.add(Box.createHorizontalStrut(70));
		b2.add(btnQuayLai = new JButton("Quay Lại"));
		b2.add(btnMua = new JButton("Mua Sách"));
		b2.add(btnThoat = new JButton("Thoát"));

	
		table.setRowHeight(25);
		ssachheper = new SachHeper();
		for(DanhMucSach dms : ssachheper.getAllDanhMucSach()){
			Object[] rowData = {dms.getMaS(), dms.getTenS(), dms.getGiaS(),dms.getGiaS()};
			dataModel.addRow(rowData);
		}
		
		btnQuayLai.addActionListener(this);
		btnThoat.addActionListener(this);
		btnMua.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnMua)){
				int row = table.getSelectedRow();
					if(row >= 0){
					DatHang dh = new DatHang(table.getValueAt(row, 0).toString(),table.getValueAt(row, 1).toString(),table.getValueAt(row, 2).toString());
					if(dh.create()){
						JOptionPane.showMessageDialog(FormDatHang.this, "Mua sách thành công !");
					}else{
					
						JOptionPane.showMessageDialog(FormDatHang.this, "Mua sách không thành công !");
					}
			}
		}if(o.equals(btnThoat)){
			int n = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát khỏi hệ thống !", "Thông Báo ",
					JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		 if(o.equals(btnQuayLai)){
			this.setVisible(false);
		}
	}
}


