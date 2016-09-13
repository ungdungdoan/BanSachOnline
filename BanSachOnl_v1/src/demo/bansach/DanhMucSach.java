package demo.bansach;

public class DanhMucSach implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String MaS;
	private String TenS; 
	private String GiaS;
	private  QuanLy Quanly;
	public DanhMucSach(String maS, String tenS,String giaS, QuanLy quanly) {
		this.MaS = maS;
		this.TenS = tenS;
		this.GiaS=giaS;
		this.Quanly = quanly;
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
	public QuanLy getQuanly() {
		return Quanly;
	}
	public void setQuanly(QuanLy quanly) {
		Quanly = quanly;
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
		return "DanhMucSach [MaS=" + MaS + ", TenS=" + TenS + ", GiaS=" + GiaS + ", Quanly=" + Quanly + "]";
	}

}
