package gov.nyc.dsny.storyboard.service;

import gov.nyc.dsny.storyboard.entity.Story;

import java.util.List;

public interface BackLogService {

	List<Story> findStories(Long id);
}
