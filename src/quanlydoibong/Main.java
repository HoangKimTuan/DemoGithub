package quanlydoibong;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException{
		SanBong sb = new SanBong();
		ArrayList<SanBong> arrSB = new ArrayList<SanBong>();
		arrSB = sb.docDuLieu("D:\\Save\\sanbong.txt");
		
		LoaiCauThu lct = new LoaiCauThu();
		ArrayList<LoaiCauThu> arrLCT = new ArrayList<LoaiCauThu>();
		arrLCT = lct.docDuLieu("D:\\Save\\loaicauthu.txt");
		
		HuanLuyenVien hlv = new HuanLuyenVien();
		ArrayList<HuanLuyenVien> arrHLV = new ArrayList<HuanLuyenVien>();
		arrHLV = hlv.docDuLieu("D:\\Save\\huanluyenvien.txt");
		
		CauThu ct = new CauThu();
		ArrayList<CauThu> arrCT = new ArrayList<CauThu>();	
		ct.nhap(arrLCT, "D:\\Save\\cauthu.txt");
		System.out.println();
		System.out.println();
		
		DoiBong db = new DoiBong();
		arrCT = ct.docDuLieu("D:\\Save\\cauthu.txt");
		db.nhap(arrSB, arrHLV, arrCT, arrLCT, "D:\\Save\\doibong.txt");
		System.out.println();
		System.out.println();
		db.xuatthongtin(arrSB, arrHLV, arrCT, arrLCT);
	}
}
