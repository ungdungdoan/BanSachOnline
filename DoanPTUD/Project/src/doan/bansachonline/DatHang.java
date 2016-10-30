package doan.bansachonline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import doan.bansachonline.DbUtils;
import doan.bansachonline.DulieuDB;

public class DatHang {
	private String CMaS;
	private String CTenS; 
	private String CGiaS;
	
	private DanhMucSach danhmucsach;
	
	public DatHang(String cMaS, String cTenS, String cGiaS) {
		this.CMaS = cMaS;
		this.CTenS = cTenS;
		this.CGiaS = cGiaS;
	}
	

	public DatHang(String cMaS) {
		this(cMaS ,"Tên Sách", "Giá Sách");
	}
	
	public DatHang() {
		this("Mã Sách");
	}

	public String getCMaS() {
		return CMaS;
	}


	public void setCMaS(String cMaS) {
		CMaS = cMaS;
	}


	public String getCTenS() {
		return CTenS;
	}


	public void setCTenS(String cTenS) {
		CTenS = cTenS;
	}


	public String getCGiaS() {
		return CGiaS;
	}


	public void setCGiaS(String cGiaS) {
		CGiaS = cGiaS;
	}


	public DanhMucSach getDanhmucsach() {
		return danhmucsach;
	}


	public void setDanhmucsach(DanhMucSach danhmucsach) {
		this.danhmucsach = danhmucsach;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CMaS == null) ? 0 : CMaS.hashCode());
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
		DatHang other = (DatHang) obj;
		if (CMaS == null) {
			if (other.CMaS != null)
				return false;
		} else if (!CMaS.equalsIgnoreCase(other.CMaS))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "DatHang [CMaS=" + CMaS + ", CTenS=" + CTenS + ", CGiaS=" + CGiaS + ", danhmucsach=" + danhmucsach + "]";
	}	
	public boolean create(){
		Connection con = DulieuDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
		stmt = con.prepareStatement("insert into KhachHang values(?,?,?)");
		stmt.setString(1, CMaS);
		stmt.setString(2, CTenS);
		stmt.setString(3, CGiaS);
		n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtils.close(stmt);
		}
		return n>0;
}
	
}
