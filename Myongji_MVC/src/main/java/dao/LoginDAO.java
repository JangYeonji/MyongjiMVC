package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import vo.Member;
import vo.Music;

import static db.JdbcUtil.*;

public class LoginDAO { 
	private static LoginDAO loginDAO; //외부 클래스에서 못쓰게 해야함
	private Connection con;
	
	private LoginDAO() {} 
	
	public static LoginDAO getInstance() {  //singleton 패턴
		if(loginDAO == null) {
			loginDAO = new LoginDAO(); //한 번만 생성
		}
		return loginDAO;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	public Member selectLoginMember(String uid,String passwd) { //로그인 멤버 채워주기
		Member loginMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM user WHERE uid = ? AND passwd = ?");
			pstmt.setString(1, uid);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if(rs.next()) { 
				loginMember = new Member();
				loginMember.setUid(rs.getString("uid"));
				loginMember.setPasswd(rs.getString("passwd"));
				loginMember.setName(rs.getString("name"));
				loginMember.setMoney(rs.getInt("money"));
				loginMember.setMusic(rs.getInt("music"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				close(rs);
				close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return loginMember;
	}

	public int updateMoney(String uid) {  //코인 차감
		PreparedStatement pstmt = null; 
		int count = 0;
		
		try {
			pstmt = con.prepareStatement("UPDATE user SET money = money - 100 WHERE uid=?"); 
			pstmt.setString(1, uid);
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}
	public Member selectLogin(String uid) {
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		Member loginMember = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM user WHERE uid=?"); 
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
			if(rs.next()) { 
				loginMember = new Member(
						rs.getString("uid")
						,rs.getString("passwd")
						,rs.getString("name")
						,rs.getInt("money")
						,rs.getInt("music")
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return loginMember;
	}
	public int updateMoney2(String uid) {  //코인 충전
		PreparedStatement pstmt = null; 
		int count = 0;
		
		try {
			pstmt = con.prepareStatement("UPDATE user SET money = money + 200 WHERE uid=?"); 
			pstmt.setString(1, uid);
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}
}