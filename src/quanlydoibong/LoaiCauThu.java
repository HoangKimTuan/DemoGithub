package quanlydoibong;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoaiCauThu {
	private String maLoaiCauThu, tenLoaiCauThu;
	private Scanner print;
	
	public LoaiCauThu(){}
	
	public LoaiCauThu(String maLoaiCauThu, String tenLoaiCauThu)
	{
		this.maLoaiCauThu = maLoaiCauThu;
		this.tenLoaiCauThu = tenLoaiCauThu;
	}
	
	public String getMaLoaiCauThu() {
        return this.maLoaiCauThu;
    }
    public void setMaLoaiCauThu(String maLoaiCauThu) {
        this.maLoaiCauThu = maLoaiCauThu;
    }
	
    public String getTenLoaiCauThu() {
        return this.tenLoaiCauThu;
    }
    public void setTenLoaiCauThu(String tenLoaiCauThu) {
        this.tenLoaiCauThu = tenLoaiCauThu;
    }
	
	public void nhap() throws IOException{
		print = new Scanner(System.in);
		System.out.print("Nhap ma loai cau thu: ");
		this.maLoaiCauThu = print.nextLine();
		System.out.print("Nhap ten loai cau thu: ");
		this.tenLoaiCauThu = print.nextLine();
	}
	
	public void xuat(){
		System.out.print(this.maLoaiCauThu);
		System.out.println("\t\t" +this.tenLoaiCauThu);
	}	
	
	public ArrayList<LoaiCauThu> docDuLieu(String duongDanFile) throws IOException{
		ArrayList<LoaiCauThu> arrSB = new ArrayList<>();
		try (FileReader fr = new FileReader(duongDanFile)) {
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
            	String[] s1 = s.split(":");
            	LoaiCauThu lct = new LoaiCauThu(s1[0], s1[1]);
            	arrSB.add(lct);
            }
        }catch(IOException e){
            System.out.println("Loi doc file!");
        }
		return arrSB;
	}
}


