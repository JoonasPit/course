package game.project.course;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import game.project.course.controller.PageController;
import game.project.course.controller.SiteErrorController;
import game.project.course.controller.UserController;
import game.project.course.controller.UserDetailServiceImpl;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseApplicationTests {
	@Autowired
	PageController pgCtrl;
	@Autowired
	SiteErrorController errCtrl;
	@Autowired
	UserController usrCtrl;
	@Autowired 
	UserDetailServiceImpl usrDtlCrtl;

	@Test
	public void contextLoads() throws Exception {
		assertThat(pgCtrl).isNotNull();
		assertThat(errCtrl).isNotNull();
		assertThat(usrCtrl).isNotNull();
		assertThat(usrDtlCrtl).isNotNull();				
	}

}
