import java.util.Scanner;

public class DanhSachSach {
	//1.Attributes
	private Sach[] dsSach;
	private int soLuongSach;
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
	 * @return the soLuongSach
	 */
	public int getSoLuongSach() {
		return soLuongSach;
	}

	/**
	 * @param soLuongSach the soLuongSach to set
	 */
	public void setSoLuongSach(int soLuongSach) {
		this.soLuongSach = soLuongSach;
	}

	//3.Constructor
	DanhSachSach() {
		this.soLuongSach = 0;
		this.dsSach = new Sach[0];
	}

	/**
	 * @param dsSach
	 */
	public DanhSachSach(Sach[] dsSach) {
		this.soLuongSach = 0;
		this.dsSach = new Sach[0];
		this.dsSach = dsSach;
	}
	//4.Input Output
	//n : số lượng sách muốn thêm
	public void nhapDanhSachSach(Scanner scan,int n) { 
		this.dsSach = new Sach[n];
		System.out.println("\t\tNHAP DANH SACH SACH");
		for(int i = 0;i<n;i++) {
			System.out.println("\tNhap thong tin sach thu " + (i + 1) + ": ");
			dsSach[i] = new Sach();
			this.dsSach[i].nhapThongTinSach(scan);
		}
		this.soLuongSach = n;
	}
	public void xuatDanhSachSach() {
		System.out.println("DANH SACH SACH VUA NHAP");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < soLuongSach; i++) {
        	System.out.println("\tSach thu " + (i+1));
            System.out.println("Ten sach: " + this.dsSach[i].getTenSach());
            System.out.println("Ma sach: " + this.dsSach[i].getMaSach());
            System.out.println("Tac gia: " + this.dsSach[i].getTacGia());
            System.out.println("Nam xuat ban: " + this.dsSach[i].getNamXuatBan());
            System.out.println("Nha xuat ban: " + this.dsSach[i].getNhaXuatBan());
            System.out.println("Gia tien: " + this.dsSach[i].getGiaTien());
            System.out.println("---------------------------------------------");
        }
	}
    //5. Business Other
	//c.Thêm mới 1 phần tử, k phần tử
    public void themMoiKPhanTuSach(Scanner scan,int k) {
    	Sach[] temp = new Sach[this.soLuongSach+k];
    	for(int i = 0;i<this.soLuongSach;i++) {
    		temp[i] = this.dsSach[i];
    	}
    	for(int i = 0;i<k;i++) {
    		System.out.println("Them vao sach thu " + (i+1));
    		temp[this.soLuongSach + i] = new Sach();
    		temp[this.soLuongSach + i].nhapThongTinSach(scan);
    	}
    	this.dsSach = temp;
    	this.soLuongSach +=k;
    }
    //d. Sửa phần tử theo mã
    public void suaPhanTuTheoMa(String maSach,Scanner scan) {
        for (int i = 0; i < this.soLuongSach; i++) {
            if (this.dsSach[i].getMaSach().equalsIgnoreCase(maSach)) {
                System.out.println("Sua phan tu thu: "+ (i+1) + ": " + maSach);
                this.dsSach[i].nhapThongTinSach(scan);
                return;
            }
        }
        System.out.println("Khong tim thay ma sach: " + maSach);
    }
    //e. Xóa phần tử theo mã
    public void xoaPhanTuTheoMa(String maSach) {
    	int index = -1;
        for (int i = 0; i < this.soLuongSach; i++) {
            if (this.dsSach[i].getMaSach().equals(maSach)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Khong tim thay ma sach: " + maSach);
        } else {
        	Sach[] temp = new Sach[this.soLuongSach-1];
        	for (int i = 0, j = 0; i < this.soLuongSach; i++) {
                if (i != index) {
                    temp[j++] = this.dsSach[i];
                }
            }
        	this.dsSach = temp;
        	this.soLuongSach--;
        }
    }
}
