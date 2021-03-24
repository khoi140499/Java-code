package bai9;
public class NhanVienChinhThuc extends NhanVien{
    @Override
	public String toString() {
		return super.toString() + " là nhân viên chính thức";
	}

	@Override
    public int xuatLuong() {
        return 5000;
    }
    
    
}
