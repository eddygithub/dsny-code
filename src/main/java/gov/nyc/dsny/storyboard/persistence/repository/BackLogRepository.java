package gov.nyc.dsny.storyboard.persistence.repository;

import gov.nyc.dsny.storyboard.entity.BackLog;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BackLogRepository extends MongoRepository<BackLog, Long> {

}
