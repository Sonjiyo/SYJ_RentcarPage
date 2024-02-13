package com.basic.rentcar.vo;

public class Rentcar {
	private int no; 		//렌트카 고유 번호
	private String name;	//차량 이름
	private int category;	//차량 종류
	private int price;		//렌트 가격
	private int usepeople;	//승차 인원
	private int total_qty;	//렌트카 총 수량
	private String company;	//차량 회사 정보
	private String img;		//차량 이미지
	private String info;	//차량 정보
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public void setTotal_qty(int num) {
		this.total_qty += num;
	}
	public int getCategory() {
		return category;
	}
	public int getPrice() {
		return price;
	}
	public int getUsepeople() {
		return usepeople;
	}
	public int getTotal_qty() {
		return total_qty;
	}
	public String getCompany() {
		return company;
	}
	public String getImg() {
		return img;
	}
	public String getInfo() {
		return info;
	}
	public Rentcar(int no, String name, int category, int price, int usepeople, int total_qty, String company,
			String img, String info) {
		this.no = no;
		this.name = name;
		this.category = category;
		this.price = price;
		this.usepeople = usepeople;
		this.total_qty = total_qty;
		this.company = company;
		this.img = img;
		this.info = info;
	}
	
	
}
