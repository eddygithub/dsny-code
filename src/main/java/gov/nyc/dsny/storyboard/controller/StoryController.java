package gov.nyc.dsny.storyboard.controller;

import gov.nyc.dsny.storyboard.entity.Story;
import gov.nyc.dsny.storyboard.entity.Task;
import gov.nyc.dsny.storyboard.service.StoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/story")
public class StoryController {

	@Autowired
	private StoryService storyService;
	
	@RequestMapping("/list/task/{id}")
	public List<Task> listTasksByStoryId(@PathVariable Long id){
		return storyService.getTaskByStoryId(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Story create(@RequestBody Story story){
		return storyService.create(story);
	}
}
