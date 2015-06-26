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
	ArrayList<Board_CommentDTO> clist;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.21:1521:XE";
	String userid = "han";
	String passwd = "1234";

	public BoardDAO() {
		try {
			clist = new ArrayList<Board_CommentDTO>();
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
				String b_id = rs.getString("b_id");

				list.add(new BoardDTO(b_number, b_subject, b_writer, b_regdate,
						b_content, b_count, p_number, b_id));
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
				String b_id = rs.getString("b_id");

				list.add(new BoardDTO(b_number, b_subject, b_writer, b_regdate,
						b_content, b_count, p_number, b_id));
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
				String b_id = rs.getString("b_id");

				list.add(new BoardDTO(b_number, b_subject, b_writer, b_regdate,
						b_content, b_count, p_number, b_id));
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
	
	public int count_comment(String bnum) {
		
		System.out.println("bnum::::"+bnum);
		
		int a = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, userid, passwd);

			String query = "SELECT count(*) FROM comments where b_number=?";

			stmt = con.prepareStatement(query);
			
			stmt.setInt(1, Integer.parseInt(bnum));

			rs = stmt.executeQuery();
			
			if(rs.next()){
				a = rs.getInt(1);
			} else {
				a = 0;
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
		return a;
	}
	
	
	
	public ArrayList<Board_CommentDTO> select_comment(String bnum) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, userid, passwd);

			String query = "SELECT * FROM comments where b_number=? order by c_number desc";

			stmt = con.prepareStatement(query);
			stmt.setInt(1, Integer.parseInt(bnum));

			rs = stmt.executeQuery();
			while (rs.next()) {
				int c_number = rs.getInt("c_number");
				int b_number = rs.getInt("b_number");
				String c_writer = rs.getString("c_writer");
				Date c_regdate = rs.getDate("c_regdate");
				String c_content = rs.getString("c_content");
				String c_id = rs.getString("c_id");

				clist.add(new Board_CommentDTO(c_number, b_number, c_writer, c_regdate, c_content, c_id));
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
		return clist;
	}
	
	
	
	public void delete_comment_one(String cnum) {

		Connection con = null;
		PreparedStatement pstmt = null;
		System.out.println("cnum:::"+cnum);
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			String sql = "delete from comments where c_number=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cnum));
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
	
	public void insert_comment(String c_number, String b_number, String c_writer, String c_content, String c_id) {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		System.out.println("C_writer:::"+c_writer);

		try {
			con = DriverManager.getConnection(url, userid, passwd);
			String sql = "insert into comments (c_number, b_number, c_writer, c_regdate, c_content, c_id)"
					+ "values(seq_c_number.NEXTVAL, ?, ?, sysdate, ?, ?)";

			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(b_number));
			pstmt.setString(2, c_writer);
			pstmt.setString(3, c_content);
			pstmt.setString(4, c_id);
			
			
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
