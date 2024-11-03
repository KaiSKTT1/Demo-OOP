import java.util.Arrays;
import java.util.Scanner;

public class DanhSachSach implements Search, ThongKe {
	//1.Attributes
	private Sach[] dsSach;
	private Sach[] dsSearch;
	//	private int soLuongSach;

	//2.Get Set
	/**
	 * @return the dsSach
	 */
	public Sach[] getDsSach() {
		return dsSach;
	}

	/**
	 * @param dsSach the dsSach to set
	 */
	public void setDsSach(Sach[] dsSach) {
		this.dsSach = dsSach;
	}

	/**
	 * @return the search
	 */
	public Sach[] getSearch() {
		return dsSearch;
	}

	/**
	 * @param search the search to set
	 */
	public void setSearch(Sach[] dsSearch) {
		this.dsSearch = dsSearch;
	}

	//3.Constructor
	DanhSachSach() {
		this.dsSach = new Sach[0];
		this.dsSearch = new Sach[0];
	}

	/**
	 * @param dsSach
	 */
	public DanhSachSach(Sach[] dsSach, Sach[] dsSearch) {
		this.dsSearch = new Sach[0];
		this.dsSach = new Sach[0];
		this.dsSach = dsSach;
		this.dsSearch = dsSearch;
	}

	//4.Input Output
	//n : số lượng sách muốn thêm
	public void nhapDanhSachSach(Scanner scan, int n) {
		this.dsSach = new Sach[n];
		System.out.println("\t\tNHAP DANH SACH SACH");
		for (int i = 0; i < n; i++) {
			System.out.println("\tNhap thong tin sach thu " + (i + 1) + ": ");
			dsSach[i] = new Sach();
			this.dsSach[i].nhapThongTinSach(scan);
		}
	}

	public void xuatDanhSachSach() {
		System.out.println("\t\tDANH SACH SACH VUA NHAP");
		System.out.println("---------------------------------------------");
		for (int i = 0; i < this.dsSach.length; i++) {
			System.out.println("\tSach thu " + (i + 1));
			this.dsSach[i].xuatThongTinSach();
			System.out.println("---------------------------------------------");
		}
	}
	//5. Business Other

	public void data() {
		int n = 5;
		this.dsSach = new Sach[n];
		this.dsSach[0] = new Sach("Hello1", "P1", "HP1", "CM1", "HCM1", 2005, 2005, 1);
		this.dsSach[1] = new Sach("Hello2", "P2", "HP2", "CM2", "HCM2", 2006, 2006, 0);
		this.dsSach[2] = new Sach("Hello3", "P3", "HP3", "CM3", "HCM3", 2007, 2007, 1);
		this.dsSach[3] = new Sach("Hello4", "P4", "HP4", "CM4", "HCM4", 2008, 2008, 0);
		this.dsSach[4] = new Sach("Hello5", "P5", "HP5", "CM5", "HCM5", 2009, 2009, 1);
	}

	//c.Thêm mới 1 phần tử, k phần tử
	public void themMoiKPhanTuSach(Scanner scan, int k) {
		this.dsSach = Arrays.copyOf(this.dsSach, this.dsSach.length + k);
		for (int i = 0; i < k; i++) {
			int length = this.dsSach.length;
			System.out.println("Them vao sach thu " + (i + 1));
			this.dsSach[length + i] = new Sach();
			this.dsSach[length + i].nhapThongTinSach(scan);
		}
	}

	//d. Sửa phần tử theo mã
	public void suaPhanTuTheoMa(String maSach, Scanner scan) {
		for (int i = 0; i < this.dsSach.length; i++) {
			if (this.dsSach[i].getMaSach().equalsIgnoreCase(maSach)) {
				System.out.println("Sua phan tu thu: " + (i + 1) + ": " + maSach);
				this.dsSach[i].nhapThongTinSach(scan);
				return;
			}
		}
		System.out.println("Khong tim thay ma sach: " + maSach);
	}

	//e. Xóa phần tử theo mã
	public void xoaPhanTuTheoMa(String maSach) {
		int index = -1;
		for (int i = 0; i < this.dsSach.length; i++) {
			if (this.dsSach[i].getMaSach().equals(maSach)) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			System.out.println("Khong tim thay ma sach: " + maSach);
		} else {
			Sach[] temp = new Sach[this.dsSach.length - 1];
			for (int i = 0, j = 0; i < this.dsSach.length; i++) {
				if (i != index) {
					temp[j++] = this.dsSach[i];
				}
			}
			this.dsSach = temp;
		}
	}

	//start interface Search
	@Override
	public Sach[] timKiemTheoTenSach(String tenSach) {
		Sach[] temp = new Sach[this.dsSearch.length];
		int j = 0;// Đếm số lượng số sách đã search được
		for (int i = 0; i < this.dsSearch.length; i++)
			if (this.dsSearch[i].getTenSach().equalsIgnoreCase(tenSach)
					|| this.dsSearch[i].getTenSach().toLowerCase().contains(tenSach.toLowerCase()))
				temp[j++] = this.dsSearch[i];
		this.dsSearch = Arrays.copyOf(temp, j);
		return this.dsSearch;
	}

	@Override
	public Sach[] timKiemTheoMaSach(String maSach) {
		Sach[] temp = new Sach[this.dsSearch.length];
		int j = 0;// Đếm số lượng số sách đã search được
		for (int i = 0; i < this.dsSearch.length; i++)
			if (this.dsSearch[i].getMaSach().equalsIgnoreCase(maSach)
					|| this.dsSearch[i].getMaSach().toLowerCase().contains(maSach.toLowerCase()))
				temp[j++] = this.dsSearch[i];
		this.dsSearch = Arrays.copyOf(temp, j);
		return this.dsSearch;
	}

	@Override
	public Sach[] timKiemTheoTacGia(String tacGia) {
		Sach[] temp = new Sach[this.dsSearch.length];
		int j = 0;// Đếm số lượng số sách đã search được
		for (int i = 0; i < this.dsSearch.length; i++)
			if (this.dsSearch[i].getTacGia().equalsIgnoreCase(tacGia)
					|| this.dsSearch[i].getTacGia().toLowerCase().contains(tacGia.toLowerCase()))
				temp[j++] = this.dsSearch[i];
		this.dsSearch = Arrays.copyOf(temp, j);
		return this.dsSearch;
	}

	@Override
	public Sach[] timKiemTheoNhaXuatBan(String nhaXuatBan) {
		Sach[] temp = new Sach[this.dsSearch.length];
		int j = 0;// Đếm số lượng số sách đã search được
		for (int i = 0; i < this.dsSearch.length; i++)
			if (this.dsSearch[i].getNhaXuatBan().equalsIgnoreCase(nhaXuatBan)
					|| this.dsSearch[i].getNhaXuatBan().toLowerCase().contains(nhaXuatBan.toLowerCase()))
				temp[j++] = this.dsSearch[i];
		this.dsSearch = Arrays.copyOf(temp, j);
		return this.dsSearch;
	}

	@Override
	public Sach[] timKiemTheoTheLoai(String theLoai) {
		Sach[] temp = new Sach[this.dsSearch.length];
		int j = 0;// Đếm số lượng số sách đã search được
		for (int i = 0; i < this.dsSearch.length; i++)
			if (this.dsSearch[i].getTheLoai().equalsIgnoreCase(theLoai)
					|| this.dsSearch[i].getTheLoai().toLowerCase().contains(theLoai.toLowerCase()))
				temp[j++] = this.dsSearch[i];
		this.dsSearch = Arrays.copyOf(temp, j);
		return this.dsSearch;
	}

	@Override
	public void xuatDanhSachSearch() {
		System.out.println("\t\tDANH SACH VUA TIM DUOC");
		System.out.println("---------------------------------------------");
		for (int i = 0; i < this.dsSearch.length; i++) {
			System.out.println("\tSach thu " + (i + 1));
			this.dsSearch[i].xuatThongTinSach();
			System.out.println("---------------------------------------------");
		}
	}

	@Override
	public void menuSearch() {
		System.out.println("\t\tMENU SEARCH");
		System.out.println("1. Tiem kiem theo ten sach.");
		System.out.println("2. Tiem kiem theo ma sach.");
		System.out.println("3. Tiem kiem theo tac gia.");
		System.out.println("4. Tiem kiem theo nha xuat ban.");
		System.out.println("5. Tiem kiem theo the loai.");
		System.out.println("0. Ket thuc");
	}
	//end interface Search

	//Xử lý tất cả các tìm kiếm
	public void timKiemAll(Scanner scan) {
		this.dsSearch = Arrays.copyOf(this.dsSach, this.dsSach.length);
		boolean flag = true;
		do {
			menuSearch();
			int choice = kiemTraLuaChon(scan);
			switch (choice) {
			case 1:
				System.out.print("Nhap ten sach muon tim: ");
				String tenSachSearch = scan.nextLine();
				this.dsSearch = timKiemTheoTenSach(tenSachSearch);
				xuatDanhSachSearch();
				break;
			case 2:
				System.out.print("Nhap ma sach muon tim: ");
				String maSachSearch = scan.nextLine();
				this.dsSearch = timKiemTheoMaSach(maSachSearch);
				xuatDanhSachSearch();
				break;
			case 3:
				System.out.print("Nhap tac gia muon tim: ");
				String tacGiaSearch = scan.nextLine();
				this.dsSearch = timKiemTheoTacGia(tacGiaSearch);
				xuatDanhSachSearch();
				break;
			case 4:
				System.out.print("Nhap nha xuat ban muon tim: ");
				String nhaXuatBanSearch = scan.nextLine();
				this.dsSearch = timKiemTheoNhaXuatBan(nhaXuatBanSearch);
				xuatDanhSachSearch();
				break;
			case 5:
				System.out.print("Nhap the loai muon tim: ");
				String theLoaiSearch = scan.nextLine();
				this.dsSach = timKiemTheoTheLoai(theLoaiSearch);
				xuatDanhSachSearch();
				break;
			case 0:
				flag = false;
				break;
			default:
				System.out.println("Xin vui long nhap tu 0 - 5");
			}

			if (this.dsSearch.length == 0) {
				System.out.println("Khong tim thay ket qua phu hop. Vui long thu lai.");
				this.dsSearch = Arrays.copyOf(this.dsSach, this.dsSach.length);
			}

		} while (flag);
	}

	private int kiemTraLuaChon(Scanner scan) {
		boolean flag = true;
		int choice = 0;
		do {
			try {
				System.out.print("Xin moi lua chon: ");
				choice = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Nhap sai roi. Hay nhap gia tri so");
			}
		} while (flag);
		return choice;
	}

	//Xử lý các hàm thống kê
	@Override
	public void thongKeTheoTacGia() {
		String[] key = new String[this.dsSach.length];
		int[] soLuong = new int[this.dsSach.length];
		int count = 0;//Đếm số lượng tác giả
		//for đầu để duyệt danh sách
		/*for 2 để duyệt lại danh sách đã xét xem có trùng không
			- Nếu trùng thì cộng vô
			- Không thì thêm mới
		*/
		for (int i = 0; i < this.dsSach.length; i++) {
			boolean flag = true;
			for (int j = 0; j < count; j++) {
				if (key[j].equalsIgnoreCase(this.dsSach[i].getTacGia())) {
					soLuong[j]++;
					flag = false;
					break;
				}
			}
			if (flag) {
				key[count] = this.dsSach[i].getTacGia();
				soLuong[count] = 1;
				count++;
			}
		}
		System.out.println("\t\tTHONG KE THEO TAC GIA");
		for (int i = 0; i < count; i++) {
			System.out.println("Tac gia: " + key[i] + " : " + soLuong[i] + " quyen sach.");
		}
	}

	@Override
	public void thongKeNhaXuatBan() {
		String[] key = new String[this.dsSach.length];
		int[] soLuong = new int[this.dsSach.length];
		int count = 0;
		for (int i = 0; i < this.dsSach.length; i++) {
			boolean flag = true;
			for (int j = 0; j < count; j++) {
				if (key[j].equalsIgnoreCase(this.dsSach[i].getNhaXuatBan())) {
					soLuong[j]++;
					flag = false;
					break;
				}
			}
			if (flag) {
				key[count] = this.dsSach[i].getNhaXuatBan();
				soLuong[count] = 1;
				count++;
			}
		}
		System.out.println("\t\tTHONG KE THEO NHA XUAT BAN");
		for (int i = 0; i < count; i++) {
			System.out.println("Nha xuat ban : " + key[i] + " : " + soLuong[i] + " quyen sach.");
		}
	}

	@Override
	public void thongKeTheoNamXuatBan() {
		int[] key = new int[this.dsSach.length];
		int[] soLuong = new int[this.dsSach.length];
		int count = 0;
		for (int i = 0; i < this.dsSach.length; i++) {
			boolean flag = true;
			for (int j = 0; j < count; j++) {
				if (key[j] == this.dsSach[i].getNamXuatBan()) {
					soLuong[j]++;
					flag = false;
					break;
				}
			}
			if (flag) {
				key[count] = this.dsSach[i].getNamXuatBan();
				soLuong[count] = 1;
				count++;
			}
		}
		System.out.println("\t\tTHONG KE THEO NAM XUAT BAN");
		for (int i = 0; i < count; i++) {
			System.out.println("Nam xuat ban : " + key[i] + " : " + soLuong[i] + " quyen sach.");
		}
	}

	@Override
	public void thongKeTheoTheLoai() {
		String[] key = new String[this.dsSach.length];
		int[] soLuong = new int[this.dsSach.length];
		int count = 0;
		for (int i = 0; i < this.dsSach.length; i++) {
			boolean flag = true;
			for (int j = 0; j < count; j++) {
				if (key[j].equalsIgnoreCase(this.dsSach[i].getTheLoai())) {
					soLuong[j]++;
					flag = false;
					break;
				}
			}
			if (flag) {
				key[count] = this.dsSach[i].getTheLoai();
				soLuong[count] = 1;
				count++;
			}
		}
		System.out.println("\t\tTHONG KE THEO THE LOAI");
		for (int i = 0; i < count; i++) {
			System.out.println("The loai : " + key[i] + " : " + soLuong[i] + " quyen sach.");
		}
	}

	public void thongKeAll(Scanner scan) {
		boolean flag = true;
		do {
			menuThongKe();
			int choice = kiemTraLuaChon(scan);
			switch (choice) {
			case 1:
				thongKeTheoTacGia();
				break;
			case 2:
				thongKeNhaXuatBan();
				break;
			case 3:
				thongKeTheoNamXuatBan();
				break;
			case 4:
				thongKeTheoTheLoai();
				break;
			case 0:
				flag = false;
				break;
			default:
				System.out.println("Xin vui long nhap tu 0 - 5");
			}
		} while (flag);
	}

	private void menuThongKe() {
		System.out.println("\t\tMENU THONG KE");
		System.out.println("1. Thong ke theo tac gia.");
		System.out.println("2. Thong ke theo nha xuat ban.");
		System.out.println("3. Thong ke theo nam xuat ban.");
		System.out.println("4. Thong ke theo the loai.");
		System.out.println("0. Ket thuc");
	}

	//Sắp xếp
	public void sapXepTheoGiaTien() {
		for (int i = 0; i < this.dsSach.length - 1; i++) {
			for (int j = i + 1; j < this.dsSach.length; j++) {
				if (dsSach[i].getGiaTien() > dsSach[j].getGiaTien()) {
					// Hoán đổi vị trí
					Sach temp = dsSach[i];
					dsSach[i] = dsSach[j];
					dsSach[j] = temp;
				}
			}
		}
	}

}
