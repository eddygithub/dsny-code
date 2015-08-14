package gov.nyc.dsny.storyboard.controller;

import gov.nyc.dsny.storyboard.entity.Sprint;
import gov.nyc.dsny.storyboard.entity.Story;
import gov.nyc.dsny.storyboard.service.SprintService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sprint")
public class SprintController {

	@Autowired
	private SprintService sprintService;
	
	@RequestMapping(method=RequestMethod.PUT)
	public Sprint create(@RequestBody Sprint sprint){
		return sprintService.create(sprint);
	}
	
	@RequestMapping(value="/reassign/{oldsprintId}/{newsprintId}/{storyId}", method=RequestMethod.POST)
	public Sprint reAssignStory(@PathVariable Long oldsprintId, @PathVariable Long newsprintId, @PathVariable Long storyId){
		return sprintService.reAssignStory(oldsprintId, newsprintId, storyId);
	}
	
	@RequestMapping("/list/{sprintId}")
	public List<Story> findStories(@PathVariable Long sprintId){
		return sprintService.findStories(sprintId);
	}
	
	@RequestMapping("/unassign/{sprintId}/{storyId}")
	public void unassignStory(@PathVariable Long sprintId, @PathVariable Long storyId){
		sprintService.unassign(sprintId, storyId);
	}
}
