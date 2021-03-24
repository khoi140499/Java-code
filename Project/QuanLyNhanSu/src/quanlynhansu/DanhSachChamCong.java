package quanlynhansu;
public class DanhSachChamCong {
   private int maDS;
   private String tenNV;
   private String tenPhong;
   private int ngayLV;

    public DanhSachChamCong() {
    }

    public DanhSachChamCong(int maDS, String tenNV, String tenPhong, int ngayLV) {
        this.maDS = maDS;
        this.tenNV = tenNV;
        this.tenPhong = tenPhong;
        this.ngayLV = ngayLV;
    }

    public int getMaDS() {
        return maDS;
    }

    public void setMaDS(int maDS) {
        this.maDS = maDS;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public int getNgayLV() {
        return ngayLV;
    }

    public void setNgayLV(int ngayLV) {
        this.ngayLV = ngayLV;
    }
     
}
