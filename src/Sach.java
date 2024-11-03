import java.util.Scanner;

public class Sach {
	//1.Attributes
	private String tenSach;
	private String maSach;
	private String tacGia;
	private String nhaXuatBan;
	private String theLoai;
	private int namXuatBan;
	private double giaTien;
	private int trangThai; //true có sẵn, false không có sẵn
	//2.Get, Set

	/**
	 * @return the tenSach
	 */
	public String getTenSach() {
		return tenSach;
	}

	/**
	 * @param tenSach the tenSach to set
	 */
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	/**
	 * @return the maSach
	 */
	public String getMaSach() {
		return maSach;
	}

	/**
	 * @param maSach the maSach to set
	 */
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	/**
	 * @return the tacGia
	 */
	public String getTacGia() {
		return tacGia;
	}

	/**
	 * @param tacGia the tacGia to set
	 */
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	/**
	 * @return the nhaXuatBan
	 */
	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	/**
	 * @param nhaXuatBan the nhaXuatBan to set
	 */
	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	/**
	 * @return the theLoai
	 */
	public String getTheLoai() {
		return theLoai;
	}

	/**
	 * @param theLoai the theLoai to set
	 */
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	/**
	 * @return the namXuatBan
	 */
	public int getNamXuatBan() {
		return namXuatBan;
	}

	/**
	 * @param namXuatBan the namXuatBan to set
	 */
	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	/**
	 * @return the giaTien
	 */
	public double getGiaTien() {
		return giaTien;
	}

	/**
	 * @param giaTien the giaTien to set
	 */
	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}

	/**
	 * @return the trangThai
	 */
	public int getTrangThai() {
		return trangThai;
	}

	/**
	 * @param trangThai the trangThai to set
	 */
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	//3. Constructor
	public Sach() {

	}

	/**
	 * @param tenSach
	 * @param maSach
	 * @param tacGia
	 * @param nhaXuatBan
	 * @param theLoai
	 * @param namXuatBan
	 * @param giaTien
	 * @param trangThai
	 */
	public Sach(String tenSach, String maSach, String tacGia, String nhaXuatBan, String theLoai, int namXuatBan,
			double giaTien, int trangThai) {
		this.tenSach = tenSach;
		this.maSach = maSach;
		this.tacGia = tacGia;
		this.nhaXuatBan = nhaXuatBan;
		this.theLoai = theLoai;
		this.namXuatBan = namXuatBan;
		this.giaTien = giaTien;
		this.trangThai = trangThai;
	}

	//4.Input Ouput
	public void nhapThongTinSach(Scanner scan) {
		System.out.print("Nhap ten sach: ");
		this.tenSach = scan.nextLine();
		System.out.print("Nhap ma sach: ");
		this.maSach = scan.nextLine();
		System.out.print("Nhap ho ten tac gia: ");
		this.tacGia = scan.nextLine();
		System.out.print("Nhap nha xuat ban: ");
		this.nhaXuatBan = scan.nextLine();
		kiemTraNamXuatBan(scan);
		System.out.print("Nhap the loai: ");
		this.theLoai = scan.nextLine();
		kiemTraGiaTien(scan);
		kiemTraTrangThai(scan);

	}

	public void xuatThongTinSach() {
		System.out.println("Ten sach: " + this.getTenSach());
		System.out.println("Ma sach: " + this.getMaSach());
		System.out.println("Tac gia: " + this.getTacGia());
		System.out.println("Nha xuat ban: " + this.getNhaXuatBan());
		System.out.println("Nam xuat ban: " + this.getNamXuatBan());
		System.out.println("The loai: " + this.getTheLoai());
		System.out.println("Gia tien: " + this.getGiaTien());
		System.out.println("Trang thai: " + this.getTrangThai());
	}

	//5. Business Other
	private void kiemTraTrangThai(Scanner scan) {
		boolean flag = true;
		do {
			try {
				System.out.print("Nhap trang thai 1(còn) 0(hết): ");
				this.trangThai = Integer.parseInt(scan.nextLine());
				if (this.trangThai == 0 || this.trangThai == 1)
					flag = false;
				else
					System.out.println("Xin moi nhap giá trị 1(còn) hoặc 0(hết): ");
			} catch (NumberFormatException nfe) {
				System.out.println("Nhap sai roi. Hay nhap gia tri so");
			}
		} while (flag);
	}

	private void kiemTraNamXuatBan(Scanner scan) {
		boolean flag = true;
		do {
			try {
				System.out.print("Nhap nam xuat ban: ");
				this.namXuatBan = Integer.parseInt(scan.nextLine());
				flag = false;
			} catch (NumberFormatException nfe) {
				System.out.println("Nhap sai roi. Hay nhap gia tri so");
			}
		} while (flag);
	}

	private void kiemTraGiaTien(Scanner scan) {
		boolean flag = true;
		do {
			try {
				System.out.print("Nhap gia tien: ");
				this.giaTien = Double.parseDouble(scan.nextLine());
				flag = false;
			} catch (NumberFormatException nfe) {
				System.out.println("Nhap sai roi. Hay nhap gia tri so");
			}
		} while (flag);
	}

}
