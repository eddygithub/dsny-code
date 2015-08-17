package gov.nyc.dsny.storyboard.service;

import gov.nyc.dsny.storyboard.entity.Story;
import gov.nyc.dsny.storyboard.entity.Task;
import gov.nyc.dsny.storyboard.persistence.repository.StoryRepository;
import gov.nyc.dsny.storyboard.persistence.repository.TaskRepository;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryServiceImpl implements StoryService {
	@Autowired
	private StoryRepository storyRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public List<Task> getTaskByStoryId(Long id) {
		Story story = storyRepository.findOne(id);
		List<Task> tasks = null;
		if(story!=null){
			Set<Long> taskIds = story.getTasks();
			tasks = taskRepository.findAll(taskIds);
		}
		return tasks;
	}
	
	@Override
	public Story create(Story story) {
		return storyRepository.save(story);
	}

}
