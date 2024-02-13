package com.basic.rentcar.vo;

public class Reservation{
	private int reserve_seq; //차량 예약 정보 번호
	private int no;			//렌트카 고유 번호	
	private String id;		//고객 id
	private int qty;		//렌트한 수량
	private int dday;		//대여기간
	private String rday;	//대여일
	private int usein; 		//운전자 보험 여부
	private int usewifi;	//인터넷 여부
	private int usenavi;	//네비게이션 대여 여부
	private int useseat;	//베이비시트 적용 여부
	public int getReserve_seq() {
		return reserve_seq;
	}
	public int getNo() {
		return no;
	}
	public String getId() {
		return id;
	}
	public int getQty() {
		return qty;
	}
	public int getDday() {
		return dday;
	}
	public String getRday() {
		return rday;
	}
	public int getUsein() {
		return usein;
	}
	public int getUsewifi() {
		return usewifi;
	}
	public int getUsenavi() {
		return usenavi;
	}
	public int getUseseat() {
		return useseat;
	}
	public Reservation(int reserve_seq, int no, String id, int qty, int dday, String rday, int usein, int usewifi,
			int usenavi, int useseat) {
		this.reserve_seq = reserve_seq;
		this.no = no;
		this.id = id;
		this.qty = qty;
		this.dday = dday;
		this.rday = rday;
		this.usein = usein;
		this.usewifi = usewifi;
		this.usenavi = usenavi;
		this.useseat = useseat;
	}
	
	
}
