package vo; //컨트롤러에서 비지니스 로직을 처리하고 뷰 페이지로 포워딩할 때 포워딩에 필요한 정보를 저장하는 클래스

public class ActionForward { //ActionForward에 따라서 프론트가 어디로 포워드할지 달라짐
	
	private String path;
	private boolean redirect;

	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public boolean isRedirect() {
		return redirect;
	}
	
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
	public ActionForward(String path, boolean redirect) {
		this.path = path;
		this.redirect = redirect;
	}
	
}