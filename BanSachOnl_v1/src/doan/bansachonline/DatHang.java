package doan.bansachonline;

public class DatHang {
	private String CMaS;
	private String CTenS; 
	private String CGiaS;
	private String CSoLuongS;
	private DanhMucSach danhmucsach;
	
	public DatHang(String cMaS, String cTenS, String cGiaS, String cSoLuongS,DanhMucSach danhMucSach, DanhMucSach danhmucsach) {
		this.CMaS = cMaS;
		this.CTenS = cTenS;
		this.CGiaS = cGiaS;
		this.CSoLuongS = cSoLuongS;
		this.danhmucsach=danhmucsach;
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


	public String getCSoLuongS() {
		return CSoLuongS;
	}


	public void setCSoLuongS(String cSoLuongS) {
		CSoLuongS = cSoLuongS;
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
		return "DatHang [CMaS=" + CMaS + ", CTenS=" + CTenS + ", CGiaS=" + CGiaS + ", CSoLuongS=" + CSoLuongS + "]";
	}
	
	
	
}
