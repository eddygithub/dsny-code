package gov.nyc.dsny.storyboard.persistence.repository;

import gov.nyc.dsny.storyboard.entity.Sprint;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SprintRepository extends MongoRepository<Sprint, Long> {

}
