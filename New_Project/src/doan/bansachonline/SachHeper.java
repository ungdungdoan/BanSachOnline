package doan.bansachonline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachHeper {
	public List<DanhMucSach> getAllDanhMucSach() {
		List<DanhMucSach> listds = new ArrayList<DanhMucSach>();
		
		Connection con = DulieuDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("select * from DanhMucSach");
			rs = stmt.executeQuery();
			while(rs.next()){
				listds.add(new DanhMucSach(rs.getString("MaS"), rs.getString("TenS"), rs.getString("GiaS")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(rs, stmt);
		}
		
		
		return listds;
	}
}
