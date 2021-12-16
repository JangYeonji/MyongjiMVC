package vo;

public class Coin {
	private int cid;
	private String uid;
	private int mid;
	private String score;
	private String likes;

	public Coin(int cid, String uid, int mid, String score, String likes) {
		this.cid = cid;
		this.uid = uid;
		this.mid = mid;
		this.score = score;
		this.likes = likes;
	}
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}
	
	
		
}
