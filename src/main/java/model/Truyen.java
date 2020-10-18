package model;

import java.util.ArrayList;

public class Truyen {
	private String tenTruyen;
	private String linkTruyen;
	private ArrayList<Chuong> Chuong;
	
	public Truyen(String tenTruyen, String linkTruyen, ArrayList<Chuong> chuong) {
		super();
		this.tenTruyen = tenTruyen;
		this.linkTruyen = linkTruyen;
		Chuong =  chuong;
	}

	public String getTenTruyen() {
		return tenTruyen;
	}

	public void setTenTruyen(String tenTruyen) {
		this.tenTruyen = tenTruyen;
	}

	public String getLinkTruyen() {
		return linkTruyen;
	}

	public void setLinkTruyen(String linkTruyen) {
		this.linkTruyen = linkTruyen;
	}

	public ArrayList<Chuong> getChuong() {
		return Chuong;
	}

	public void setChuong(ArrayList<Chuong> chuong) {
		Chuong = chuong;
	}

	@Override
	public String toString() {
		return "Truyen [tenTruyen=" + tenTruyen + ", linkTruyen=" + linkTruyen + ", Chuong=" + Chuong + "]";
	}
	
	
}
