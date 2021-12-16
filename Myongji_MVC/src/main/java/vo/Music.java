package vo;

public class Music {
	private int mid;
	private String singer;
	private String title;
	private String lyrics;
	
	public Music(int mid, String singer, String title, String lyrics) {
		this.mid = mid;
		this.singer = singer;
		this.title = title;
		this.lyrics = lyrics;
	}
	public Music() {
		
	}

	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLyrics() {
		return lyrics;
	}
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
	
	
}
