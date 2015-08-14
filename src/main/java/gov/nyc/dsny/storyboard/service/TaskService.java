package gov.nyc.dsny.storyboard.service;

import gov.nyc.dsny.storyboard.entity.Story;
import gov.nyc.dsny.storyboard.entity.Task;

public interface TaskService {

	Task create(Task task);

	Story reAssign(Long taskId, Long oldStoryId, Long newStoryId);

	Story assignToStory(Long taskId, Long storyId);
}
