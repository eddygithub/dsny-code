package gov.nyc.dsny.storyboard.persistence.repository;

import java.util.List;

import gov.nyc.dsny.storyboard.entity.Story;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoryRepository extends MongoRepository<Story, Long> {

	@Override
	public List<Story> findAll();
	
	@Override
	public List<Story> findAll(Iterable<Long> arg0);
}
