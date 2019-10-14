package game.project.course;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpTests {
	
	@LocalServerPort
    private int port;
	
    @Autowired
    private TestRestTemplate restTemplate;
	
	@Test
	public void testIndexPage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains("Welcome");
    }
	
	@Test 
	public void testLogin() throws Exception{
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/login",
				String.class)).contains("Log In");
		
	}
	
	@Test
	public void testSign() throws Exception{
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/sign",
				String.class)).contains("Submit");
	}
	
	@Test
	public void testleaderBoard() throws Exception{
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/leaderboard",
				String.class)).contains("Leaderboard");
	}
	
	@Test
	public void testGamePage() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/game",
				String.class)).contains("Game");
	}
	@Test
	public void testCommentPage() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/game",
				String.class)).contains("Comments");
	}
	
	
}
