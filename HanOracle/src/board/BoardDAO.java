package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class BoardDAO {

	ArrayList<BoardDTO> list;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.21:1521:XE";
	String userid = "han";
	String passwd = "1234";

	public BoardDAO() {
		try {
			list = new ArrayList<BoardDTO>();
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<BoardDTO> select() {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, userid, passwd);

			String query = "SELECT * FROM board ORDER BY b_number desc";

			stmt = con.prepareStatement(query);

			rs = stmt.executeQuery();

			while (rs.next()) {
				int b_number = rs.getInt("b_number");
				String b_subject = rs.getString("b_subject");
				String b_writer = rs.getString("b_writer");
				Date b_regdate = rs.getDate("b_regdate");
				String b_content = rs.getString("b_content");
				int b_count = rs.getInt("b_count");
				int p_number = rs.getInt("p_number");

				list.add(new BoardDTO(b_number, b_subject, b_writer, b_regdate,
						b_content, b_count, p_number));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<BoardDTO> select_one(String bnum) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, userid, passwd);

			String query = "SELECT * FROM board where b_number=?";

			stmt = con.prepareStatement(query);
			stmt.setInt(1, Integer.parseInt(bnum));

			rs = stmt.executeQuery();

			while (rs.next()) {
				int b_number = rs.getInt("b_number");
				String b_subject = rs.getString("b_subject");
				String b_writer = rs.getString("b_writer");
				Date b_regdate = rs.getDate("b_regdate");
				String b_content = rs.getString("b_content");
				int b_count = rs.getInt("b_count");
				int p_number = rs.getInt("p_number");

				list.add(new BoardDTO(b_number, b_subject, b_writer, b_regdate,
						b_content, b_count, p_number));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return list;
	}
	

	public ArrayList<BoardDTO> select_park(String parkNum) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, userid, passwd);

			String query = "select * from board where p_number=? order by b_number desc";

			stmt = con.prepareStatement(query);

			stmt.setInt(1, Integer.parseInt(parkNum));

			rs = stmt.executeQuery();

			while (rs.next()) {
				int b_number = rs.getInt("b_number");
				String b_subject = rs.getString("b_subject");
				String b_writer = rs.getString("b_writer");
				Date b_regdate = rs.getDate("b_regdate");
				String b_content = rs.getString("b_content");
				int b_count = rs.getInt("b_count");
				int p_number = rs.getInt("p_number");

				list.add(new BoardDTO(b_number, b_subject, b_writer, b_regdate,
						b_content, b_count, p_number));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return list;
	}

	public void delete(String parkNum2) {

		BoardDTO dto = new BoardDTO();
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(url, userid, passwd);
			String sql = "delete from board where b_number=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(parkNum2));
			int n = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}
		}
	}

	public void delete_comment(String parkNum2) {

		BoardDTO dto = new BoardDTO();
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(url, userid, passwd);
			String sql = "delete from comments where b_number=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(parkNum2));
			int n = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}
		}
	}
	
	public void insert(String subject, String writer, String content, String pnumber, String id) {

		BoardDTO dto = new BoardDTO();
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(url, userid, passwd);
			String sql = "insert into board (b_number, b_subject, b_writer, b_regdate, b_content, p_number, b_id)"
					+ "values(seq_b_number.NEXTVAL, ?, ?, sysdate, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, subject);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);
			pstmt.setInt(4, Integer.parseInt(pnumber));
			pstmt.setString(5, id);
			
			
			int n = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}
		}
	}
	
	public void update(String bnumber, String subject, String content, String pnumber) {

		BoardDTO dto = new BoardDTO();
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(url, userid, passwd);
			String sql = "update board set b_subject=?, b_content=?, p_number=? where b_number=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, Integer.parseInt(pnumber));
			pstmt.setInt(4, Integer.parseInt(bnumber));
			
			
			int n = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			}
		}
	}

}
