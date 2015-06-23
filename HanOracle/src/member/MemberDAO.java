package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	
	ArrayList<MemberDTO> list;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.21:1521:XE";
	String userid = "han";
	String passwd = "1234";
	
	public MemberDAO() {
        try {
        	list = new ArrayList<MemberDTO>();
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	public int IdCount(String id) throws Exception{						// ���̵� �ߺ��˻�.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int countId = 0;
		
		try{
			con = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = con.prepareStatement("select count(id) as countId from member where id = ?");

			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if(rs.next()){
				countId = Integer.parseInt(rs.getString("countId"));	// countId�� 0���� ũ�� ���̵� ����, 0�̸� ���̵� ����.
			}else{
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException ex){}
			}
			
			if(pstmt != null){
				try{
					pstmt.close();
				}catch(SQLException ex){}
			}
			
			if(con!=null){
				try{
					con.close();
				}catch(SQLException ex){}
			}
		}
		
		return countId;
	}
	
	public int NickCount(String nick) throws Exception{				//�г��� �ߺ��˻�
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int countNick = 0;
		
		try{
			con = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = con.prepareStatement("select count(nick) as countNick from member where nick = ?");
			
			pstmt.setString(1, nick);
			rs = pstmt.executeQuery();
			System.out.println("������ �����.");
			if(rs.next()){
				countNick = Integer.parseInt(rs.getString("countNick"));
				System.out.println(countNick);							// countId�� 0���� ũ�� ���̵� ����, 0�̸� ���̵� ����.
			}else{
				System.out.println("������ ������� ����..");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException ex){}
			}
			
			if(pstmt != null){
				try{
					pstmt.close();
				}catch(SQLException ex){}
			}
			
			if(con!=null){
				try{
					con.close();
				}catch(SQLException ex){}
			}
		}
		
		return countNick;
	}
	
	public int EmailCount(String email) throws Exception{				// �̸��� �ߺ��˻�
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int countEmail = 0;
		
		try{
			con = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = con.prepareStatement("select count(email) as countEmail from member where email = ?");
			
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				countEmail = Integer.parseInt(rs.getString("countEmail"));
				System.out.println(countEmail);							// countId�� 0���� ũ�� ���̵� ����, 0�̸� ���̵� ����.
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException ex){}
			}
			
			if(pstmt != null){
				try{
					pstmt.close();
				}catch(SQLException ex){}
			}
			
			if(con!=null){
				try{
					con.close();
				}catch(SQLException ex){}
			}
		}
		
		return countEmail;
	}	
	
	public String LoginSelect(String id) throws Exception{				// �̸��� �ߺ��˻�
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String pwd = "";
		try{
			con = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = con.prepareStatement("select pwd from member where id = ?");
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				pwd = rs.getString("pwd");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException ex){}
			}
			
			if(pstmt != null){
				try{
					pstmt.close();
				}catch(SQLException ex){}
			}
			
			if(con!=null){
				try{
					con.close();
				}catch(SQLException ex){}
			}
		}
		
		return pwd;
	}
	
	public String SearchId(String name, String email) throws Exception{				// ���̵� ã�� (�̸�, �̸���)
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String id = "";
		
		try{
			con = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = con.prepareStatement("select id from member where name = ? and email = ?");
			
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				id = rs.getString("id");
				System.out.println(id);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException ex){}
			}
			
			if(pstmt != null){
				try{
					pstmt.close();
				}catch(SQLException ex){}
			}
			
			if(con!=null){
				try{
					con.close();
				}catch(SQLException ex){}
			}
		}
		
		return id;
	}
	
	public String SearchPwd(String id, String name, String email) throws Exception{				//��й�ȣ ã�� (���̵�, �̸�, �̸���)
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String pwd = "";
		
		try{
			con = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = con.prepareStatement("select pwd from member where id = ? and name = ? and email = ?");

			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				pwd = rs.getString("pwd");
				System.out.println(pwd);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException ex){}
			}
			
			if(pstmt != null){
				try{
					pstmt.close();
				}catch(SQLException ex){}
			}
			
			if(con!=null){
				try{
					con.close();
				}catch(SQLException ex){}
			}
		}
		
		return pwd;
	}
	
	public void InsertMember(String id, String pwd, String name, String nick, String email) throws Exception{		// ȸ������
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = con.prepareStatement("insert into member (id, pwd, name, nick, email) values (?,?,?,?,?)");

			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, nick);
			pstmt.setString(5, email);
			pstmt.executeUpdate();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			
			if(pstmt != null){
				try{
					pstmt.close();
				}catch(SQLException ex){}
			}
			
			if(con!=null){
				try{
					con.close();
				}catch(SQLException ex){}
			}
		}
	}
	
	public void UpdatePwd(String id, String pass) throws Exception{			// �н����� ����
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = con.prepareStatement("update member set pwd = ? where id = ?");

			pstmt.setString(1, pass);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			
			if(pstmt != null){
				try{
					pstmt.close();
				}catch(SQLException ex){}
			}
			
			if(con!=null){
				try{
					con.close();
				}catch(SQLException ex){}
			}
		}
	}
	
	public void UpdateName(String id, String name) throws Exception{			// �̸� ����
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = con.prepareStatement("update member set name = ? where id = ?");

			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			
			if(pstmt != null){
				try{
					pstmt.close();
				}catch(SQLException ex){}
			}
			
			if(con!=null){
				try{
					con.close();
				}catch(SQLException ex){}
			}
		}
	}
	
	public void UpdateNick(String id, String nick) throws Exception{				// �г��� ����
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = con.prepareStatement("update member set nick = ? where id = ?");

			pstmt.setString(1, nick);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			
			if(pstmt != null){
				try{
					pstmt.close();
				}catch(SQLException ex){}
			}
			
			if(con!=null){
				try{
					con.close();
				}catch(SQLException ex){}
			}
		}
	}
	
	public void UpdateEmail(String id, String email) throws Exception{				// �г��� ����
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = con.prepareStatement("update member set email = ? where id = ?");

			pstmt.setString(1, email);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			
			if(pstmt != null){
				try{
					pstmt.close();
				}catch(SQLException ex){}
			}
			
			if(con!=null){
				try{
					con.close();
				}catch(SQLException ex){}
			}
		}
	}
	
	public void DeleteMember(String id) throws Exception{				// �г��� ����
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DriverManager.getConnection(url, userid, passwd);
			
			pstmt = con.prepareStatement("delete from member where id = ?");

			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			
			if(pstmt != null){
				try{
					pstmt.close();
				}catch(SQLException ex){}
			}
			
			if(con!=null){
				try{
					con.close();
				}catch(SQLException ex){}
			}
		}
	}
}
