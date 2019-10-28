package game.project.course.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long commentid;
	@NotNull
	private String usercomment;
	@NotNull
	private String username;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name ="id")
	private User user;
	
	public Comment() {
	}
	
	public Comment(Long commentid ,String usercomment, String username) {
		super();
		this.commentid = commentid;
		this.usercomment = usercomment;
		this.username = username;
	}
	
	public void setCommentid(Long commentid) {
		this.commentid = commentid;
	}
	public Long getCommentid() {
		return commentid;
	}
	public void setUsercomment(String usercomment) {
		this.usercomment = usercomment;
	}
	public String getUsercomment() {
		return usercomment;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}

}
