package quanlydoibong;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CauThu {
	private String maCauThu, tenCauThu, ngaySinh, maLoaiCauThu, ghiChu;
	private int soAo;
	
	private Scanner print;
	String x = new String();
	int i = 1;
	
	public CauThu(){}
	
	public CauThu(String maCauThu, String tenCauThu, String ngaySinh, String maLoaiCauThu, int soAo, String ghiChu)
	{
		this.maCauThu = maCauThu;
		this.tenCauThu = tenCauThu;
		this.ngaySinh = ngaySinh;
		this.maLoaiCauThu = maLoaiCauThu;
		this.soAo = soAo;
		this.ghiChu = ghiChu;
	}
	
	public String getMaCauThu() {
        return this.maCauThu;
    }
    public void setMaCauThu(String maCauThu) {
        this.maCauThu = maCauThu;
    }
    
    public String getTenCauThu() {
        return this.tenCauThu;
    }
    public void setTenCauThu(String tenCauThu) {
        this.tenCauThu = tenCauThu;
    }
	
    public String getNgaySinh() {
        return this.ngaySinh;
    }
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    public String getLoaiCauThu() {
        return this.maLoaiCauThu;
    }
    public void setLoaiCauThu(String maLoaiCauThu) {
        this.maLoaiCauThu = maLoaiCauThu;
    }
    
    public int getSoAo() {
        return this.soAo;
    }
    public void setSoAo(int soAo) {
        this.soAo= soAo;
    }
    
    public String getGhiChu() {
        return this.ghiChu;
    }
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    public void nhap(ArrayList<LoaiCauThu> arrLCT, String duongDanFile) throws IOException{
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
			System.out.println("Nhap thong tin cau thu thu " +i);
			
			System.out.print("-Nhap ma cau thu: ");
			this.maCauThu = print.nextLine();
			str = this.maCauThu;
			fw.write(str);
			fw.write(":");
			System.out.print("-Nhap ten cau thu: ");
			this.tenCauThu = print.nextLine();
			str = this.tenCauThu;
			fw.write(str);
			fw.write(":");
			System.out.print("-Nhap ngay sinh cau thu: ");
			this.ngaySinh = print.nextLine();
			str = this.ngaySinh;
			fw.write(str);
			fw.write(":");
			boolean kt = false;
			do
			{
	 			System.out.println("Danh sach loai cau thu");
				for(LoaiCauThu lct : arrLCT)
					lct.xuat();
				System.out.print("-Nhap ma loai cau thu: ");
	 			this.maLoaiCauThu = print.nextLine();
	  			for(LoaiCauThu lct : arrLCT)
	  			{
					if(lct.getMaLoaiCauThu().trim().equals(this.maLoaiCauThu.trim()))
					{
						kt = true;
						break;
					}
	  			}		
			}while(kt == false);
			str = this.maLoaiCauThu;
			fw.write(str);
			fw.write(":");
			System.out.print("-Nhap so ao: ");
			this.soAo = print.nextInt();
			str = Integer.toString(this.soAo);
			fw.write(str);
			fw.write(":");
			System.out.print("-Nhap ghi chu: ");
			print.nextLine();
			this.ghiChu = print.nextLine();	
			str = this.ghiChu + "\r\n";
			fw.write(str);
			
			System.out.print("Nhap 'stop' de dung nhap thong tin cau thu hoac gia tri bat ky de tiep tuc? ");
			x = print.nextLine();
			i++;
		}
		while(!x.trim().equals("stop"));
 
        fw.close();
	}
    
	public void xuat(ArrayList<LoaiCauThu> arrLCT){
		System.out.print(this.maCauThu);
		System.out.print("\t\t" +this.tenCauThu);
		System.out.print("\t\t" +this.ngaySinh);
		for(LoaiCauThu ds : arrLCT)
			if(this.maLoaiCauThu == ds.getMaLoaiCauThu())
			{
				System.out.print("\t\t" +ds.getMaLoaiCauThu() +"\t\t" +ds.getTenLoaiCauThu());
				break;
			}				
		System.out.print("\t\t" +this.soAo);
		System.out.println("\t\t" +this.ghiChu);
	}	
	
	public ArrayList<CauThu> docDuLieu(String duongDanFile) throws IOException{
		ArrayList<CauThu> arrCT = new ArrayList<>();
		try (FileReader fr = new FileReader(duongDanFile)) {
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
            	String[] s1 = s.split(":");
            	int i = Integer.parseInt(s1[4]);
            	CauThu ct = new CauThu(s1[0], s1[1], s1[2], s1[3], i, s1[5]);
            	arrCT.add(ct);
            }
        }catch(IOException e){
            System.out.println("Loi doc file!");
        }
		return arrCT;
	}
}
