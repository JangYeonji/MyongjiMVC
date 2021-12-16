package svc;

import static db.JdbcUtil.*; //객체 생성, 경로 작성 X
import java.sql.Connection;
import dao.LoginDAO;
import vo.Member;

public class LoginService {
	public Member getLoginMember(String uid, String passwd) {
		Connection con = getConnection(); //static 덕분
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		Member loginMember = loginDAO.selectLoginMember(uid,passwd); 
		close(con); //static 덕분
		return loginMember; 
	}
}