Create Database BanSachOnline
Go
Use BanSachOnline
Go
--Dang nhap
Create Table DangNhap
(
	Ten varchar(40) not null,
	MKhau varchar(40) not null
)
/*drop table DangNhap*/
select *from DangNhap

--Quanly
Create Table QuanLy
(
	MaQL varchar(20) not null primary key,
	TenQL varchar(50),
	DiaChiQL nvarchar(50),
	EmailQL nvarchar(50)
)

/*drop table QuanLy*/
select *from QuanLy

--Don gia
/*Create Table DocGia
(
	MaDG varchar(20),
	TenDG varchar(50),
	DiaChiDG nvarchar(50),
	EmailDG varchar(50)
)*/


--Danh muc sach
Create Table DanhMucSach
(
	MaS varchar(20) primary key,
	TenS varchar(50),
)
/*drop table DanhMucSach*/

--Chitiethoadonsach
Create Table ChiTietHoaDonSach
(
	MaChiTietS varchar(20) not null primary key,
	MaS varchar(50),
	TheLoaiS nvarchar(50),
	DonGiaS varchar(50),
	SoLuong varchar(100)
)
/*drop table ChiTietHoaDonSach*/
