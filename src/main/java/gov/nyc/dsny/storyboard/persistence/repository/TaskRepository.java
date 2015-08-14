package gov.nyc.dsny.storyboard.persistence.repository;

import gov.nyc.dsny.storyboard.entity.Task;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, Long> {

	@Override
	public List<Task> findAll(Iterable<Long> ids);
}
