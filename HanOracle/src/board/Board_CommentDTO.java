package board;

import java.util.Date;

public class Board_CommentDTO {

	private int c_number;
	private int b_number;
	private String c_writer;
	private Date c_regdate;
	private String c_content;
	private String c_id;

	public Board_CommentDTO() {
		super();
	}

	public Board_CommentDTO(int c_number, int b_number, String c_writer,
			Date c_regdate, String c_content, String c_id) {

		this.c_number = c_number;
		this.b_number = b_number;
		this.c_writer = c_writer;
		this.c_regdate = c_regdate;
		this.c_content = c_content;
		this.c_id = c_id;
	}
	
	public int getC_number() {
		return c_number;
	}

	public void setC_number(int c_number) {
		this.c_number = c_number;
	}

	public int getB_number() {
		return b_number;
	}

	public void setB_number(int b_number) {
		this.b_number = b_number;
	}

	public String getC_writer() {
		return c_writer;
	}

	public void setC_writer(String c_writer) {
		this.c_writer = c_writer;
	}

	public Date getC_regdate() {
		return c_regdate;
	}

	public void setC_regdate(Date c_regdate) {
		this.c_regdate = c_regdate;
	}

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

}
