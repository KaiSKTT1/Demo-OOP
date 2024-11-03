
public interface ThongKe {
	void thongKeTheoTacGia();

	void thongKeNhaXuatBan();

	void thongKeTheoNamXuatBan();

	void thongKeTheoTheLoai();

	/**
	 *Thuật toán đơn giản là ta sẽ loop để lấy những cái key 
	 *	- key sẽ đại diện cho TacGia, TheLoai ...
	 *	-- Sau đó ta sẽ loop thêm lần nữa để biết được xem là với mỗi key 
	 *		thì sẽ chứa bao nhiêu cuốn sách. 
	 *	-- Rồi ta xuất tất cả nó ra:))
	 *		Trong một cái menu chọn ... các chức năng rồi xuất ra	
	@Override
	public void thongKe(Sach[] dsSach) {
	    String[] tacGiaArray = new String[dsSach.length];
	    int[] soLuongArray = new int[dsSach.length];
	    int thongKeCount = 0;
	
	    for (Sach sach : dsSach) {
	        boolean found = false;
	        for (int i = 0; i < thongKeCount; i++) {
	            if (tacGiaArray[i].equals(sach.getTacGia())) {
	                soLuongArray[i]++;
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            tacGiaArray[thongKeCount] = sach.getTacGia();
	            soLuongArray[thongKeCount] = 1;
	            thongKeCount++;
	        }
	    }
	
	    // Xuất kết quả thống kê
	    System.out.println("Thống kê theo tác giả:");
	    for (int i = 0; i < thongKeCount; i++) {
	        System.out.println("Tác giả: " + tacGiaArray[i] + " - Số lượng: " + soLuongArray[i]);
	    }
	}
	
	@Override
	public void xuatThongKe() {
	    thongKe(dsSach);
	}
	}
	
	 */
}
