package game.project.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import game.project.course.domain.Comment;
import game.project.course.domain.CommentRepository;
import game.project.course.domain.Score;
import game.project.course.domain.ScoreRepository;
import game.project.course.domain.User;
import game.project.course.domain.UserRepository;
@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookDemo(ScoreRepository scoreRepo, UserRepository urep, CommentRepository crep) {
		return (args) -> {
			scoreRepo.save(new Score("Käyttäjä1",100));
			scoreRepo.save(new Score("Käyttäjä2",300));
			// admin -> password: newsalasana | bcrypt 10-rounds
			urep.save(new User("admin","$2a$10$Tte.IU8Uvq4S/Zkf76R9nOx1S.fCs91uDW8C2We2WC.3zA8cbzbqG","ADMIN","e2@mail.com"));
			crep.save(new Comment("Kiva peli hermanni","Kayttaja10"));
		};
		}

}
