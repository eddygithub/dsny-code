package gov.nyc.dsny.storyboard.service;

import java.util.List;

import gov.nyc.dsny.storyboard.entity.Sprint;
import gov.nyc.dsny.storyboard.entity.Story;

public interface SprintService {

	Sprint assignStory(Long sprintId, Long storyId);

	List<Story> findStories(Long sprintId);

	Object unassign(Long sprintId, Long storyId);

	Sprint create(Sprint sprint);

	Sprint reAssignStory(Long oldSprintId, Long newSprintId, Long storyId);
}
