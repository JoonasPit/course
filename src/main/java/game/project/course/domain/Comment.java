package game.project.course.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long commentid;
	@NotNull
	private String usercomment;
	@NotNull
	private String username;
	
	public Comment() {
	}
	
	public Comment(String usercomment, String username) {
		super();
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
