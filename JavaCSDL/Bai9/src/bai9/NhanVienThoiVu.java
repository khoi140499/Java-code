package bai9;
public class NhanVienThoiVu extends NhanVien{

    @Override
    public int xuatLuong() {
        return 400;
    }

	@Override
	public String toString() {
		return super.toString() + " là nhân viên thời vụ";
	}
    
}
