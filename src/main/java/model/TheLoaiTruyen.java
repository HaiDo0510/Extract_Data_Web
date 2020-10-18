package model;

import java.util.ArrayList;

public class TheLoaiTruyen {
	private String tenTheLoai;
	private String linkTheLoai;
	private ArrayList<Truyen> Truyen;
	
	
	public TheLoaiTruyen(String tenTheLoai, String linkTheLoai, ArrayList<Truyen> truyen) {
		super();
		this.tenTheLoai = tenTheLoai;
		this.linkTheLoai = linkTheLoai;
		Truyen = truyen;
	}
	public String getTenTheLoai() {
		return tenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}
	public String getLinkTheLoai() {
		return linkTheLoai;
	}
	public void setLinkTheLoai(String linkTheLoai) {
		this.linkTheLoai = linkTheLoai;
	}
	public ArrayList<Truyen> getTruyen() {
		return Truyen;
	}
	public void setTruyen(ArrayList<Truyen> truyen) {
		Truyen = truyen;
	}
	@Override
	public String toString() {
		return "TheLoaiTruyen [tenTheLoai=" + tenTheLoai + ", linkTheLoai=" + linkTheLoai + ", Truyen=" + Truyen + "]";
	}
	
	
}
