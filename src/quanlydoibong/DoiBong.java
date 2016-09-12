package quanlydoibong;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DoiBong {
	private String maDoiBong, tenDoiBong, maSanBong;
	private int soLuongHuanLuyenVien, soLuongCauThu;
	ArrayList<String> dsMaHuanLuyenVien = new ArrayList<>();
	ArrayList<String> dsMaCauThu = new ArrayList<>();
	
	private Scanner print;
	String x = new String();
	int i = 1;
	
	boolean thoat = false;
	
	public DoiBong(){}
	
	public DoiBong(String maDoiBong, String tenDoiBong, String maSanBong, int soLuongHuanLuyenVien, ArrayList<String> dsMaHuanLuyenVien, int soLuongCauThu, ArrayList<String> dsMaCauThu)
	{
		this.maDoiBong = maDoiBong;
		this.tenDoiBong = tenDoiBong;
		this.maSanBong = maSanBong;
		this.soLuongHuanLuyenVien = soLuongHuanLuyenVien;
		this.dsMaHuanLuyenVien = dsMaHuanLuyenVien;
		this.soLuongCauThu = soLuongCauThu;
		this.dsMaCauThu = dsMaCauThu;
	}
	
	public String getMaDoiBong() {
        return this.maDoiBong;
    }
    public void setMaDoiBong(String maDoiBong) {
        this.maDoiBong = maDoiBong;
    }
    
    public String getTenDoiBong() {
        return this.tenDoiBong;
    }
    public void setTenDoiBong(String tenDoiBong) {
        this.tenDoiBong = tenDoiBong;
    }
	
    public String getMaSanBong() {
        return this.maSanBong;
    }
    public void setMaSanBong(String maSanBong) {
        this.maSanBong = maSanBong;
    }
    
    public int getSoLuongHuanLuyenVien() {
        return this.soLuongHuanLuyenVien;
    }
    public void setSoLuongHuanLuyenVien(int soLuongHuanLuyenVien) {
        this.soLuongHuanLuyenVien = soLuongHuanLuyenVien;
    }
    
    public ArrayList<String> getDsMaHuanLuyenVien() {
		return this.dsMaHuanLuyenVien;
	}
    
    public int getSoLuongCauThu() {
        return this.soLuongCauThu;
    }
    public void setSoLuongCauThu(int soLuongCauThu) {
        this.soLuongCauThu = soLuongCauThu;
    }
    
    public ArrayList<String> getDsMaCauThu() {
		return this.dsMaCauThu;
	}
    
	public void nhap(ArrayList<SanBong> arrSB, ArrayList<HuanLuyenVien> arrHLV, ArrayList<CauThu> arrCT, ArrayList<LoaiCauThu> arrLCT, String duongDanFile) throws IOException{
		print = new Scanner(System.in);
		String str;
		FileWriter fw;
        
        try {
            fw = new FileWriter(duongDanFile);
        } catch (IOException exc) {
            System.out.println("Có lỗi xảy ra");
            return;
        }
        
        do{
			System.out.println("Nhap thong tin doi bong thu " +i);
			
			System.out.print("-Nhap ma doi bong: ");
			this.maDoiBong = print.nextLine();
			str = this.maDoiBong;
			fw.write(str);
			fw.write(":");
			System.out.print("-Nhap ten doi bong: ");
			this.tenDoiBong = print.nextLine();
			str = this.tenDoiBong;
			fw.write(str);
			fw.write(":");
			boolean kt = false;
			do
			{
				System.out.println("Danh sach san bong");
				for(SanBong sb : arrSB)
					sb.xuat();
				System.out.print("-Nhap ma san bong: ");
				this.maSanBong = print.nextLine();
				for(SanBong sb : arrSB)
					if(sb.getMaSanBong().trim().equals(this.maSanBong.trim()))
					{
						kt = true;
						break;
					}				
			}while(kt == false);
			str = this.maSanBong;
			fw.write(str);
			fw.write(":");
			System.out.print("-Nhap so luong huan luyen vien: ");
	   		this.soLuongHuanLuyenVien = print.nextInt();
			str = Integer.toString(this.soLuongHuanLuyenVien);
			fw.write(str);
			fw.write(":");
			print.nextLine();
			
			boolean[] bool = new boolean[this.soLuongHuanLuyenVien];
			for(boolean b : bool)
				b = false;
			do
			{
				System.out.println("Danh sach huan luyen vien");
				for(HuanLuyenVien hlv : arrHLV)
					hlv.xuat();
				for(int i = 0; i < this.soLuongHuanLuyenVien; i++)
				{
					System.out.print("-Nhap ma huan luyen vien thu " +(i+1) +": ");
					String x = print.nextLine();
					this.dsMaHuanLuyenVien.add(x);
					for(HuanLuyenVien hlv : arrHLV)
						if(hlv.getMaHuanLuyenVien().trim().equals(this.dsMaHuanLuyenVien.get(i).trim()))
						{
							bool[i] = true;
							break;
						}
						else
							bool[i] = false;
							
				}
				for(boolean b : bool)
					if(b == false)
					{
						for(int i = 0; i < this.soLuongHuanLuyenVien; i++)
							this.dsMaHuanLuyenVien.remove(0);
						thoat = true;
						break;
					}
					else
						thoat = false;
			}while(thoat);
			for(int i = 0; i < this.soLuongHuanLuyenVien; i++){
				str = this.dsMaHuanLuyenVien.get(0);
				fw.write(str);
				this.dsMaHuanLuyenVien.remove(0);
				if(i == (this.soLuongHuanLuyenVien-1))
					fw.write(":");
				else
					fw.write("-");
			}
			System.out.print("-Nhap so luong cau thu: ");
			this.soLuongCauThu = print.nextInt();
			str = Integer.toString(this.soLuongCauThu);
			fw.write(str);
			fw.write(":");
			print.nextLine();
			
			bool = new boolean[this.soLuongCauThu];
			for(boolean b : bool)
				b = false;
			do
			{
				System.out.println("Danh sach cau thu");
				for(CauThu ct : arrCT)
					ct.xuat(arrLCT);
				for(int i = 0; i < this.soLuongCauThu; i++)
				{
					System.out.print("-Nhap ma cau thu thu " +(i+1) +": ");
					String x = print.nextLine();
					this.dsMaCauThu.add(x);
					for(CauThu ct : arrCT)
						if(ct.getMaCauThu().trim().equals(this.dsMaCauThu.get(i).trim()))
						{
							bool[i] = true;
							break;
						}
						else
							bool[i] = false;
							
				}	
				for(boolean b : bool)
					if(b == false)
					{
						for(int i = 0; i < this.soLuongCauThu; i++)
							this.dsMaCauThu.remove(0);
						thoat = true;
						break;
					}
					else
						thoat = false;
			}while(thoat);
			for(int i = 0; i < this.soLuongCauThu; i++){
				str = this.dsMaCauThu.get(0);
				fw.write(str);
				this.dsMaCauThu.remove(0);
				if(i == (this.soLuongCauThu - 1))
					fw.write("\r\n");
				else
					fw.write("-");
			}
			
			System.out.print("Nhap 'stop' de dung nhap thong tin doi bong hoac gia tri bat ky de tiep tuc? ");
			x = print.nextLine();
			i++;
		}
		while(!x.trim().equals("stop"));
        
		fw.close();
	}
	
	public void xuat(ArrayList<SanBong> arrSB, ArrayList<HuanLuyenVien> arrHLV, ArrayList<CauThu> arrCT, ArrayList<LoaiCauThu> arrLCT){
		System.out.println("-Ma doi bong: " +this.maDoiBong);
		System.out.println("-Ten doi bong: " +this.tenDoiBong);
		System.out.println("-Ma san bong: " +this.maSanBong);				
		System.out.println("-So luong huan luyen vien: " +this.soLuongHuanLuyenVien);
		System.out.print("Danh sach ma huan luyen vien: ");
		for(int i = 0; i < this.soLuongHuanLuyenVien; i++)
			System.out.print(this.dsMaHuanLuyenVien.get(i) +"\t\t");
		System.out.println();
		System.out.println("-So luong cau thu: " +this.soLuongCauThu);
		System.out.print("Danh sach ma cau thu: ");
		for(int i = 0; i < this.soLuongCauThu; i++)
			System.out.print(this.dsMaCauThu.get(i) +"\t\t");
		System.out.println();
	}	
	
	public void xuatthongtin(ArrayList<SanBong> arrSB, ArrayList<HuanLuyenVien> arrHLV, ArrayList<CauThu> arrCT, ArrayList<LoaiCauThu> arrLCT) throws IOException{
		print = new Scanner(System.in);
		ArrayList<DoiBong> arrDB = new ArrayList<>();
		arrDB = this.docDuLieu("D:\\Save\\doibong.txt");
		System.out.print("Chon doi bong muon hien thi thong tin (tu 1 den " +arrDB.size() +")? ");
		int i = print.nextInt();
		print.nextLine();
		System.out.println("Thong tin doi bong thu " +i);
		arrDB.get(i-1).xuat(arrSB, arrHLV, arrCT, arrLCT);
	}
	
	public ArrayList<DoiBong> docDuLieu(String duongDanFile) throws IOException{
		ArrayList<DoiBong> arrDB = new ArrayList<>();
		try (FileReader fr = new FileReader(duongDanFile)) {
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
            	String[] s1 = s.split(":");
            	int i = Integer.parseInt(s1[3]);
            	int j = Integer.parseInt(s1[5]);
            	String[] x = s1[4].split("-");
            	ArrayList<String> a = new ArrayList<>();
            	for(String y : x)
            		a.add(y);
            	x = s1[6].split("-");
            	ArrayList<String> b = new ArrayList<>();
            	for(String y : x)
            		b.add(y);
            	DoiBong hlv = new DoiBong(s1[0], s1[1], s1[2], i, a, j, b);
            	arrDB.add(hlv);
            }
        }catch(IOException e){
            System.out.println("Loi doc file!");
        }
		return arrDB;
	}
}
