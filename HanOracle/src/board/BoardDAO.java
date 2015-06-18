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
                
                String query = 
            "SELECT * FROM board ORDER BY b_number ";
                 
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
                	
                    list.add(new BoardDTO(b_number,b_subject,b_writer,b_regdate,b_content,b_count,p_number));
                }//end while
                 
            } catch (Exception e) { e.printStackTrace();
} //end try~catch
             
            finally {
                 
                //8.    자원 반납
                try {
                    rs.close();
                    stmt.close();
                    con.close();
                     
                } catch (SQLException se) {
                    se.printStackTrace();
                }
                 
            }
        //db 연동 끝
        return list;
    }//end select()
	

}
