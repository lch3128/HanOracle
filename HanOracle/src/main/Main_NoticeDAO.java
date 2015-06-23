package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Main_NoticeDAO {
	
	ArrayList<Main_NoticeDTO> list;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.21:1521:XE";
	String userid = "han";
	String passwd = "1234";

	public Main_NoticeDAO() {
		try {
			list = new ArrayList<Main_NoticeDTO>();
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Main_NoticeDTO> select() {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, userid, passwd);

			String query = "SELECT * FROM notice ORDER BY n_number desc";

			stmt = con.prepareStatement(query);

			rs = stmt.executeQuery();

			while (rs.next()) {
				int n_number = rs.getInt("n_number");
				String n_subject = rs.getString("n_subject");
				Date n_regdate = rs.getDate("n_regdate");
				
				list.add(new Main_NoticeDTO(n_number, n_subject, n_regdate));
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
	
}
