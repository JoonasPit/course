package game.project.course.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ScoreRepository extends CrudRepository<Score, Long>{
	
	// Sort by scores
	//@Query("Select * FROM score ORDER BY score desc")
	List<Score> findByOrderByScoreDesc();
	// List<Score> findByusername(String username);
}
