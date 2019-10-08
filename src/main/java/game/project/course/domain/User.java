package game.project.course.domain;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	private String passwordhash;
	private String userrole;
	private String useremail;
	
	public User() {
	}
	
	public User(String username, String passwordhash, String userrole, String useremail) {
		super();
		this.username = username;
		this.passwordhash = passwordhash;
		this.userrole = userrole;
		this.useremail = useremail;
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPasswordHash(String passwordhash) {
		this.passwordhash = passwordhash;
	}
	
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	
	public void setUserEmail(String useremail) {
		this.useremail = useremail;
	}
	
	public String getUsername() {
		return username;
	}
	public String getPasswordhash() {
		return passwordhash;
	}
	
	public String getUserRole() {
		return userrole;
	}
	
	public String getUserEmail() {
		return useremail;
	}
	
}
