package game.project.course.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Score {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private int score;
	
	public Score() {
		super();
		this.score = 0;
		this.name = "";
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	
	public Score(String name, int score) {
		this.score = score;
		this.name = name;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}

}
