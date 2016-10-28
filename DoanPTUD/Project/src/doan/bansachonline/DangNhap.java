package doan.bansachonline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DangNhap {
	private String Id;
	private String Pass;
	
	public DangNhap(String id, String pass) {
		Id = id;
		Pass = pass;
	}
	public DangNhap(String id){
		Id = id;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	@Override
	public String toString() {
		return "DangNhap [Id=" + Id + ", Pass=" + Pass + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
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
		DangNhap other = (DangNhap) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equalsIgnoreCase(other.Id))
			return false;
		return true;
	}
	public boolean create(){
		 Connection con= DulieuDB.getConnection();
		 PreparedStatement prstmt=null;
		 int n=0;
		 try {
			prstmt= con.prepareStatement("insert into DangNhap values (?,?)");
			prstmt.setString(1,Id);
			prstmt.setString(2,Pass);
			n=prstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0; 
	}

	
	
	
	
}
