package game.project.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import game.project.course.domain.Score;
import game.project.course.domain.ScoreRepository;
@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookDemo(ScoreRepository scoreRepo) {
		return (args) -> {
			scoreRepo.save(new Score("Käyttäjä1",100));
			scoreRepo.save(new Score("Käyttäjä2",300));
		};
		}

}
