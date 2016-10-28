Create Database BanSachOnline
Go
Use BanSachOnline
Go
--Dang Nhap
Create table DangNhap
(
	Id varchar(50) primary key,
	Pass varchar(50)
)
insert into DangNhap values('ad','ad')
insert into DangNhap values('ad1','ad1')
insert into DangNhap values('ad2','ad2')

select *from DangNhap
--Danh muc sach

Create Table DanhMucSach
(
	MaS varchar(20) not null primary key,
	TenS varchar(50) not null,
	GiaS varchar(50)
)
select *from DanhMucSach
/*drop table DanhMucSach*/

Create Table KhachHang
(
	CMaS varchar(20) not null primary key,
	CTenS varchar(50) not null,
	CGiaS varchar(50) not null,
)
select *from KhachHang

