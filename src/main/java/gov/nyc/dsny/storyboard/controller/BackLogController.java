package gov.nyc.dsny.storyboard.controller;

import gov.nyc.dsny.storyboard.entity.Story;
import gov.nyc.dsny.storyboard.service.BackLogService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backlog")
public class BackLogController {
	
	@Autowired
	private BackLogService backLogService;

	@RequestMapping("/list/story/{backLogId}")
	public List<Story> listStories(@PathVariable Long backLogId){
		return backLogService.findStories(backLogId);
	}
}
