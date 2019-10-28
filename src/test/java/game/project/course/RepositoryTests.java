package game.project.course;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import game.project.course.domain.Comment;
import game.project.course.domain.CommentRepository;
import game.project.course.domain.Score;
import game.project.course.domain.ScoreRepository;
import game.project.course.domain.User;
import game.project.course.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTests {
	@Autowired
	UserRepository usr;
	@Autowired
	ScoreRepository scr;
	@Autowired
	CommentRepository cmt;

	@Test
	public void createUser() throws Exception {
		User testuser = new User("TestUser", "passworder", "USER","user@email.com");
		usr.save(testuser);
		assertThat(testuser.getId()).isNotNull();
		
	}
	@Test
	public void createScore()throws Exception {
		Score testscore = new Score("Testname",700);
		scr.save(testscore);
		assertThat(testscore.getId()).isNotNull();
	}
	@Test
	public void createComment() throws Exception{
		Comment testcomment = new Comment(null,"Blaa", "testuser");
		cmt.save(testcomment);
		assertThat(testcomment.getCommentid()).isNotNull();
	}
}
