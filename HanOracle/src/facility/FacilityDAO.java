package facility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class FacilityDAO {
	ArrayList<FacilityDTO> list;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.21:1521:XE";
	String userid = "han";
	String passwd = "1234";

	public FacilityDAO() {
		try {
			list = new ArrayList<FacilityDTO>();
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<FacilityDTO> select(int p_number,int f_number) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, userid, passwd);

			String query = "SELECT * FROM LOCATION where p_number=? and f_number=?";

			stmt = con.prepareStatement(query);
			stmt.setInt(1, p_number);
			stmt.setInt(2, f_number);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				int pnumber = rs.getInt("p_number");
				int fnumber = rs.getInt("f_number");
				double lat=rs.getDouble("lat");
				double lon=rs.getDouble("lon");

				list.add(new FacilityDTO(pnumber, fnumber, lat, lon));
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
