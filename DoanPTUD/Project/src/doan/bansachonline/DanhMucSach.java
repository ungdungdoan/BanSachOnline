package doan.bansachonline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import doan.bansachonline.DulieuDB;
import doan.bansachonline.DbUtils;
import doan.bansachonline.DatHang;



public class DanhMucSach implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String MaS;
	private String TenS; 
	private String GiaS;
	private List<DatHang> dsSach;
	
	
	public DanhMucSach(String maS, String tenS,String giaS) {
		this.MaS = maS;
		this.TenS = tenS;
		this.GiaS=giaS;
		dsSach = new ArrayList<DatHang>();
	}
	
	public DanhMucSach(String MaS) {
		this(MaS,"TenS","GiaS");
	}

	public DanhMucSach() {
		this("MaS");
	}

	public String getMaS() {
		return MaS;
	}

	public void setMaS(String maS) {
		MaS = maS;
	}

	public String getTenS() {
		return TenS;
	}

	public void setTenS(String tenS) {
		TenS = tenS;
	}

	public String getGiaS() {
		return GiaS;
	}

	public void setGiaS(String giaS) {
		GiaS = giaS;
	}

	
	public List<DatHang> getDsSach() {
		return dsSach;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MaS == null) ? 0 : MaS.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DanhMucSach other = (DanhMucSach) obj;
		if (MaS == null) {
			if (other.MaS != null)
				return false;
		} else if (!MaS.equalsIgnoreCase(other.MaS))
			return false;
		return true;
	}

	
	

	@Override
	public String toString() {
		return "DanhMucSach [TenS=" + TenS + "]";
	}
	public boolean create(){
		Connection con = DulieuDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
		stmt = con.prepareStatement("insert into DanhMucSach values(?,?,?)");
		stmt.setString(1, MaS);
		stmt.setString(2, TenS);
		stmt.setString(3, GiaS);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtils.close(stmt);
		}
		return n>0;
}


	public boolean update() {
		Connection con = DulieuDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update DanhMucSach "
					+ "set TenS = ?,"
					+ "GiaS = ? "
					+ "where MaS = ?");
			stmt.setString(1, TenS);
			stmt.setString(2, GiaS);
			stmt.setString(3, MaS);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(stmt);
		}
		return n > 0;		
	}
	public boolean delete() {
		Connection con = DulieuDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from DanhMucSach where MaS = ?");
			stmt.setString(1, MaS);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(stmt);
		}
		return n > 0;	
	}
	public void read() {
		Connection con = DulieuDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("Select * from KhachHang where Mas = ?");
			stmt.setString(1, MaS);
			rs = stmt.executeQuery();
			while(rs.next()){
				DatHang sv  = new DatHang(rs.getString("CMaS"), rs.getString("CTenS"),rs.getString("CGiaS"));
				dsSach.add(sv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(stmt);
		}
	}



	
}
