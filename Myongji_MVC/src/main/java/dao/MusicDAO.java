package dao;

import static db.JdbcUtil.*;
import java.sql.*;
import java.util.ArrayList;

import vo.Music;

public class MusicDAO { 
	
	Connection con;
	private static MusicDAO boardDAO;
	
	private MusicDAO() {}
	
	public void setConnection(Connection con){
		this.con = con;
	}
	
	public static MusicDAO getInstance(){
		
		if(boardDAO ==null){
			boardDAO = new MusicDAO();
		}
		
		return boardDAO; 
	}
	
	public ArrayList<Music> selectMusicList() {  //모든 노래 Select
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		ArrayList<Music> musicList = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM music"); 
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				musicList = new ArrayList<Music>();
				
				do {
					musicList.add(new Music(
							rs.getInt("mid")
							,rs.getString("singer")
							,rs.getString("title")
							,rs.getString("lyrics")));
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return musicList;
	}
	
	public Music selectMusic(int mid) {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		Music music = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM music WHERE mid=?"); 
			pstmt.setInt(1, mid);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				music = new Music(
						rs.getInt("mid")
						,rs.getString("singer")
						,rs.getString("title")
						,rs.getString("lyrics"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return music;
	}
	
}