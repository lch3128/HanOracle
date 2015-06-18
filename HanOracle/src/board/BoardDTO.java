package board;

import java.util.Date;

public class BoardDTO {
	
	int b_number;
	String b_subject;
	String b_writer;
	Date b_regdate;
	String b_content;
	int b_count;
	int p_number;
	
	public BoardDTO(){
		super();
	}
	
	public BoardDTO(int b_number, String b_subject, String b_writer, Date b_regdate,
			String b_content, int b_count, int p_number) {
		
		this.b_number = b_number;
		this.b_subject = b_subject;
		this.b_writer = b_writer;
		this.b_regdate = b_regdate;
		this.b_content = b_content;
		this.b_count = b_count;
		this.p_number = p_number;
		
	}
	
	public int getB_number() {
		return b_number;
	}

	public void setB_number(int b_number) {
		this.b_number = b_number;
	}

	public String getB_subject() {
		return b_subject;
	}
	public void setB_subject(String b_subject) {
		this.b_subject = b_subject;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public Date getB_regdate() {
		return b_regdate;
	}
	public void setB_regdate(Date b_regdate) {
		this.b_regdate = b_regdate;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public int getB_count() {
		return b_count;
	}
	public void setB_count(int b_count) {
		this.b_count = b_count;
	}
	public int getP_number() {
		return p_number;
	}
	public void setP_number(int p_number) {
		this.p_number = p_number;
	}
	

}
