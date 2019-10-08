package game.project.course.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ScoreRepository extends CrudRepository<Score, Long>{
	// List<Score> findByusername(String username);
}
