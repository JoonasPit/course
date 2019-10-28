package game.project.course.domain;

import java.util.List;

import javax.persistence.*;

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
	
	@OneToMany(cascade = CascadeType.ALL)
	public List<Comment> comment;
	
	public User() {
	}
	
	public User(String username, String passwordhash, String userrole, String useremail) {
		super();
		this.username = username;
		this.passwordhash = passwordhash;
		this.userrole = userrole;
		this.useremail = useremail;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
