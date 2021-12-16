package vo;

public class Member {
	private String uid;
	private String passwd;
	private String name;
	private int money;
	private int music;
	
	public Member(String uid, String passwd, String name, int money, int music) {
		this.uid = uid;
		this.passwd = passwd;
		this.name = name;
		this.money = money;
		this.music = music;
	}
	public Member() {
		
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getMusic() {
		return music;
	}
	public void setMusic(int music) {
		this.music = music;
	}
	
}