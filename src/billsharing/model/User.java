package billsharing.model;
public class User {
	private String username;
	private String emailId;
	public User(String username2, String emailId2) {
		this.username=username2;
		this.emailId=emailId2;
		// TODO Auto-generated constructor stub
	}
	//will act as primary key to identify user
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

}
