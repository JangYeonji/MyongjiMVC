package svc;

import static db.JdbcUtil.*; 
import java.sql.Connection;

import dao.CoinDAO;
import dao.LoginDAO;
import vo.Coin;
import vo.Member;

public class MoneyDownService {
	
	public Member getMoney(String uid) {
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);	
		int count = loginDAO.updateMoney(uid); //DogDAO에서 읽어옴  @중요@ 무슨 값이 들어가는지
		
		if(count>0){ //jdbcUtil로 가서 본다...
			commit(con); //0 이상이면 처리 완로돼가지고 하드디스크에 처리완료를 하고
			System.out.println("update"); 
		}else{
			rollback(con); //아니면 처리완료되기전까지 복구를 한다.
		}
		
		Member loginMember = loginDAO.selectLogin(uid); //불독에 대한 정보를 select 해오는걸 dao에서 한다.
		//리스트가 아니라 하나다.. 도그 객체..
		close(con);
		return loginMember;
	}
}