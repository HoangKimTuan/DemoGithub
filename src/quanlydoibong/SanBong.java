package quanlydoibong;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SanBong {
	private String maSanBong, tenSanBong, thanhPho;
	private Scanner print;
	
	public SanBong(){}
	
	public SanBong(String maSanBong, String tenSanBong, String thanhPho)
	{
		this.maSanBong = maSanBong;
		this.tenSanBong = tenSanBong;
		this.thanhPho = thanhPho;
	}
	
	public String getMaSanBong() {
        return this.maSanBong;   
    }
    public void setMaSanBong(String maSanBong) {
        this.maSanBong = maSanBong;
    }
	
    public String getTenSanBong() {
        return this.tenSanBong;
    }
    public void setTenSanBong(String tenSanBong) {
        this.tenSanBong = tenSanBong;
    }
    
    public String getThanhPho() {
        return this.thanhPho;
    }
    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }
	
	public void nhap() throws IOException{
		print = new Scanner(System.in);
		System.out.print("Nhap ma san bong: ");
		this.maSanBong = print.nextLine();
		System.out.print("Nhap ten san bong: ");
		this.tenSanBong = print.nextLine();
		System.out.print("Nhap thanh pho: ");
		this.thanhPho = print.nextLine();
	}
	
	public void xuat(){
		System.out.print(this.maSanBong);
		System.out.print("\t\t" +this.tenSanBong);
		System.out.println("\t\t" +this.thanhPho);
	}
	
	public ArrayList<SanBong> docDuLieu(String duongDanFile) throws IOException{
		ArrayList<SanBong> arrSB = new ArrayList<>();
		try (FileReader fr = new FileReader(duongDanFile)) {
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
            	String[] s1 = s.split(":");
            	SanBong sb = new SanBong(s1[0], s1[1], s1[2]);
            	arrSB.add(sb);
            }
        }catch(IOException e){
            System.out.println("Loi doc file!");
        }
		return arrSB;
	}
}


