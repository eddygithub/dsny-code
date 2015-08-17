package gov.nyc.dsny.storyboard.service;

import gov.nyc.dsny.storyboard.entity.Sprint;
import gov.nyc.dsny.storyboard.entity.Story;
import gov.nyc.dsny.storyboard.persistence.repository.SprintRepository;
import gov.nyc.dsny.storyboard.persistence.repository.StoryRepository;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SprintServiceImpl implements SprintService {

	@Autowired
	private SprintRepository sprintRepository;
	
	@Autowired
	private StoryRepository storyRepository;

	@Override
	public Sprint assignStory(Long sprintId, Long storyId) {
		Sprint sprint = sprintRepository.findOne(sprintId);
		if(sprint!=null){
			Set<Long> stories = sprint.getStories();
			stories.add(storyId);
			sprint.setStories(stories);
		}
		return sprint;
	}
	
	@Override
	public Sprint reAssignStory(Long oldSprintId, Long newSprintId, Long storyId) {
		Sprint oldSprint = sprintRepository.findOne(oldSprintId);
		if(oldSprint!=null){
			Set<Long> stories = oldSprint.getStories();
			stories.remove(storyId);
			oldSprint.setStories(stories);
			sprintRepository.save(oldSprint);
		}
		
		Sprint newSprint = sprintRepository.findOne(newSprintId);
		if(newSprint!=null){
			Set<Long> stories = newSprint.getStories();
			stories.add(storyId);
			newSprint.setStories(stories);
			sprintRepository.save(newSprint);
		}
		return newSprint;
	}

	@Override
	public List<Story> findStories(Long sprintId) {
		List<Story> stories = null;
		Sprint sprint = sprintRepository.findOne(sprintId);
		if(sprint!=null){
			stories =storyRepository.findAll(sprint.getStories());
		}
		return stories;
	}

	@Override
	public Sprint unassign(Long sprintId, Long storyId) {
		Sprint sprint = sprintRepository.findOne(sprintId);
		if(sprint!=null){
			Set<Long> stories = sprint.getStories();
			stories.remove(storyId);
			sprint.setStories(stories);
			sprintRepository.save(sprint);
		}
		return sprint;
	}

	@Override
	public Sprint create(Sprint sprint) {
		return sprintRepository.save(sprint);
	}
}
