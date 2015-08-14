package gov.nyc.dsny.storyboard.controller;

import gov.nyc.dsny.storyboard.entity.Story;
import gov.nyc.dsny.storyboard.entity.Task;
import gov.nyc.dsny.storyboard.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="/create", method=RequestMethod.PUT)
	public Task create(@RequestBody Task task){
		return taskService.create(task);
	}
	
	@RequestMapping(value="/assign/{taskId}/{storyId}", method=RequestMethod.POST)
	public Story assignToStory(@PathVariable  Long taskId, @PathVariable Long storyId){
		return taskService.assignToStory(taskId, storyId);
	}
	
	@RequestMapping(value="/reassign/{taskId}/{oldstoryId}/{newstoryId}", method=RequestMethod.POST)
	public Story reAssign(@PathVariable Long taskId, @PathVariable Long oldstoryId, @PathVariable Long newstoryId){
		return taskService.reAssign(taskId, oldstoryId, newstoryId);
	}
}
