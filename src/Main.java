import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//		DanhSachSach listBook = new DanhSachSach();
		//		listBook.nhapDanhSachSach(scan, 5);
		//		listBook.data();
		//		listBook.xoaPhanTuTheoMa("P3");
		//		listBook.xuatDanhSachSach();
		//		System.out.println("-------------------");
		//		listBook.thongKeAll(scan);
		Sach sach = new Sach();
		sach.nhapThongTinSach(scan);
	}

}
