package demo.bansach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuanLy implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String MaQL;
	private String TenQL;
	private String  EmailQl; 
	private String DiaChiQL;
	
	public QuanLy(String maql, String tenql, String emailql, String diachiql) {
		this.MaQL = maql;
		this.TenQL = tenql;
		this.EmailQl = emailql;
		this.DiaChiQL = diachiql;
	}
	public QuanLy(String maql) {
		this(maql,"Tên ĐG","Email","Địa Chỉ");
	}
	public QuanLy() {
		this("Mã ĐG");
	}
	public String getMadg() {
		return MaQL;
	}
	public void setMadg(String maql) {
		this.MaQL = maql;
	}
	public String getTendg() {
		return TenQL;
	}
	public void setTendg(String tenql) {
		this.TenQL = tenql;
	}
	public String getEmaildg() {
		return EmailQl;
	}
	public void setEmaildg(String emailql) {
		this.EmailQl = emailql;
	}
	public String getDiachidg() {
		return DiaChiQL;
	}
	public void setDiachidg(String diachiql) {
		this.DiaChiQL = diachiql;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MaQL == null) ? 0 : MaQL.hashCode());
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
		QuanLy other = (QuanLy) obj;
		if (MaQL == null) {
			if (other.MaQL != null)
				return false;
		} else if (!MaQL.equalsIgnoreCase(other.MaQL))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "QuanLy [MaQL=" + MaQL + ", TenQL=" + TenQL + ", EmailQl=" + EmailQl + ", DiaChiQL=" + DiaChiQL + "]";
	}
	public boolean create(){
		Connection con = DulieuDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
		stmt = con.prepareStatement("insert into QuanLy values(?,?,?,?)");
		stmt.setString(1, MaQL);
		stmt.setString(2, TenQL);
		stmt.setString(3, EmailQl);
		stmt.setString(4, DiaChiQL);
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
