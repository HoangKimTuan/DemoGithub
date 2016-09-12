package quanlydoibong;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HuanLuyenVien {
	private String maHuanLuyenVien, tenHuanLuyenVien, ngaySinh, gioiTinh, chucVu;
	
	private Scanner print;
	
	public HuanLuyenVien(){}
	
	public HuanLuyenVien(String maHuanLuyenVien, String tenHuanLuyenVien, String ngaySinh, String gioiTinh, String chucVu)
	{
		this.maHuanLuyenVien = maHuanLuyenVien;
		this.tenHuanLuyenVien = tenHuanLuyenVien;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.chucVu = chucVu;
	}
	
	public String getMaHuanLuyenVien() {
        return this.maHuanLuyenVien;
    }
    public void setMaHuanLuyenVien(String maHuanLuyenVien) {
        this.maHuanLuyenVien = maHuanLuyenVien;
    }
    
    public String getTenHuanLuyenVien() {
        return this.tenHuanLuyenVien;
    }
    public void setTenHuanLuyenVien(String tenHuanLuyenVien) {
        this.tenHuanLuyenVien = tenHuanLuyenVien;
    }
	
    public String getNgaySinh() {
        return this.ngaySinh;
    }
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    public String getGioiTinh() {
        return this.gioiTinh;
    }
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    public String getChucVu() {
        return this.chucVu;
    }
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    
	public void nhap() throws IOException{
		print = new Scanner(System.in);
		System.out.print("Nhap ma huan luyen vien: ");
		this.maHuanLuyenVien = print.nextLine();
		System.out.print("Nhap ten huan luyen vien: ");
		this.tenHuanLuyenVien = print.nextLine();
		System.out.print("Nhap ngay sinh huan luyen vien: ");
		this.ngaySinh = print.nextLine();
		System.out.print("Nhap gioi tinh huan luyen vien: ");
		this.gioiTinh = print.nextLine();
		System.out.print("Nhap chuc vu huan luyen vien: ");
		this.chucVu = print.nextLine();
	}
	
	public void xuat(){
		System.out.print(this.maHuanLuyenVien);
		System.out.print("\t\t" +this.tenHuanLuyenVien);
		System.out.print("\t\t" +this.ngaySinh);
		System.out.print("\t\t" +this.gioiTinh);
		System.out.println("\t\t" +this.chucVu);
	}	
	
	public ArrayList<HuanLuyenVien> docDuLieu(String duongDanFile) throws IOException{
		ArrayList<HuanLuyenVien> arrSB = new ArrayList<>();
		try (FileReader fr = new FileReader(duongDanFile)) {
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
            	String[] s1 = s.split(":");
            	HuanLuyenVien hlv = new HuanLuyenVien(s1[0], s1[1], s1[2], s1[3], s1[4]);
            	arrSB.add(hlv);
            }
        }catch(IOException e){
            System.out.println("Loi doc file!");
        }
		return arrSB;
	}
}