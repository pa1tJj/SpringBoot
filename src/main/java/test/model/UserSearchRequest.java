package test.model;

public class UserSearchRequest extends AbstractDTO{

	private String username;
	private String passwork;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswork() {
		return passwork;
	}
	public void setPasswork(String passwork) {
		this.passwork = passwork;
	}
	
	
}
