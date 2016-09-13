package doan.bansachonline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DanhMucSach implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String MaS;
	private String TenS; 
	private String GiaS;
	
	
	public DanhMucSach(String maS, String tenS,String giaS) {
		this.MaS = maS;
		this.TenS = tenS;
		this.GiaS=giaS;
	}
	public DanhMucSach() {
		this("MaS");
	}
	public DanhMucSach(String MaS) {
		this.MaS = MaS;
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

	

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		} else if (!MaS.equals(other.MaS))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "DanhMucSach [MaS=" + MaS + ", TenS=" + TenS + ", GiaS=" + GiaS +  "]";
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
					+ "set TenS = ?, "
					+ "Gia = ? "
					+ "where MaS = ?");
			stmt.setString(1, TenS);
			stmt.setString(2, GiaS);
			stmt.setString(3, MaS);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
}
