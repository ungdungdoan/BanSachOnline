package doan.bansachonline;

public class TestconnectSql {
	public static void main(String[] args) {
		DanhMucSach dms = new DanhMucSach("013","Conan","100ngd");
		dms.create();
		System.out.println("Connect");
	}
}
