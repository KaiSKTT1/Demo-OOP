
public interface Search {

	Sach[] timKiemTheoTenSach(String tenSach);

	Sach[] timKiemTheoMaSach(String maSach);

	Sach[] timKiemTheoTacGia(String tacGia);

	Sach[] timKiemTheoNhaXuatBan(String nhaXuatBan);

	Sach[] timKiemTheoTheLoai(String theLoai);

	void xuatDanhSachSearch();

	void menuSearch();

}
