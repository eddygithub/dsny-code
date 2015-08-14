package gov.nyc.dsny.storyboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.nyc.dsny.storyboard.entity.Story;
import gov.nyc.dsny.storyboard.entity.Task;
import gov.nyc.dsny.storyboard.persistence.repository.StoryRepository;
import gov.nyc.dsny.storyboard.persistence.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private StoryRepository storyRepository;
	
	@Override
	public Task create(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Story assignToStory(Long taskId, Long storyId) {
		Task task = taskRepository.findOne(taskId);
		Story story = storyRepository.findOne(storyId);
		if(task!=null){
			if(story!=null){
				List<Long> tasks = story.getTasks();
				tasks.add(taskId);
				story.setTasks(tasks);
			}
		}
		return story;
	}
	
	@Override
	public Story reAssign(Long taskId, Long oldStoryId, Long newStoryId) {
		Task task = taskRepository.findOne(taskId);
		Story oldStory = storyRepository.findOne(oldStoryId);
		Story newStory = storyRepository.findOne(newStoryId);
		if(task!=null){
			if(oldStory!=null){
				List<Long> tasks = oldStory.getTasks();
				tasks.remove(taskId);
				oldStory.setTasks(tasks);
			}
			
			if(newStory!=null){
				List<Long> tasks = newStory.getTasks();
				tasks.add(taskId);
				newStory.setTasks(tasks);
			}
		}
		return newStory;
	}

}
