package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil { //연결작업
	public static Connection getConnection() { //3개 클래스에서 수시로 사용. 
		Connection con = null;
		try {
			Context initCtx = new InitialContext(); //JDNI 서버 역할을 하는 객체. 자원요청
			DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/project"); //커넥션 객체 관리
			con = ds.getConnection();
			con.setAutoCommit(false); //자동 반영이 되지 않도록
			System.out.println("connect success"); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con; //호출한 곳으로 return
	}
	public static void close(Connection con) {
		try {
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			stmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
public static void commit(Connection con){
		try {
			con.commit();
			System.out.println("commit success 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void rollback(Connection con){
		try {
			con.rollback();
			System.out.println("rollback success 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}