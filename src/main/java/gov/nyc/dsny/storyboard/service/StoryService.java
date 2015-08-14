package gov.nyc.dsny.storyboard.service;

import gov.nyc.dsny.storyboard.entity.Story;
import gov.nyc.dsny.storyboard.entity.Task;

import java.util.List;

public interface StoryService {

	List<Task> getTaskByStoryId(Long id);

	Story create(Story story);
}
