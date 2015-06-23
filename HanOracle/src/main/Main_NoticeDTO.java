package main;

import java.util.Date;

public class Main_NoticeDTO {
	
	int n_number;
	String n_subject;
	Date n_regdate;
	
	public Main_NoticeDTO(){}
	public Main_NoticeDTO(int num, String sub, Date date ){
		n_number = num;
		n_subject = sub;
		n_regdate = date ;
	}
	
	public int getN_number() {
		return n_number;
	}
	public void setN_number(int n_number) {
		this.n_number = n_number;
	}
	public String getN_subject() {
		return n_subject;
	}
	public void setN_subject(String n_subject) {
		this.n_subject = n_subject;
	}
	public Date getN_regdate() {
		return n_regdate;
	}
	public void setN_regdate(Date n_regdate) {
		this.n_regdate = n_regdate;
	}
	
	

}
