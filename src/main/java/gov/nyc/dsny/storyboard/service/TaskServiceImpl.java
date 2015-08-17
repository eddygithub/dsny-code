package gov.nyc.dsny.storyboard.service;

import gov.nyc.dsny.storyboard.entity.Story;
import gov.nyc.dsny.storyboard.entity.Task;
import gov.nyc.dsny.storyboard.persistence.repository.StoryRepository;
import gov.nyc.dsny.storyboard.persistence.repository.TaskRepository;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
				Set<Long> tasks = story.getTasks();
				tasks.add(taskId);
				story.setTasks(tasks);
				storyRepository.save(story);
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
				Set<Long> tasks = oldStory.getTasks();
				tasks.remove(taskId);
				oldStory.setTasks(tasks);
				storyRepository.save(oldStory);
			}
			
			if(newStory!=null){
				Set<Long> tasks = newStory.getTasks();
				tasks.add(taskId);
				newStory.setTasks(tasks);
				storyRepository.save(newStory);
			}
		}
		return newStory;
	}

}
