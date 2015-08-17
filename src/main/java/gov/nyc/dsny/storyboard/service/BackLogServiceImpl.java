package gov.nyc.dsny.storyboard.service;

import gov.nyc.dsny.storyboard.entity.BackLog;
import gov.nyc.dsny.storyboard.entity.Story;
import gov.nyc.dsny.storyboard.persistence.repository.BackLogRepository;
import gov.nyc.dsny.storyboard.persistence.repository.StoryRepository;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackLogServiceImpl implements BackLogService {
	
	@Autowired
	private BackLogRepository backLogRepository;
	
	@Autowired
	private StoryRepository storyRepository;
	
	@Override
	public List<Story> findStories(Long id) {
		List<Story> stories = null;
		BackLog backLog = backLogRepository.findOne(id);
		if(backLog!=null){
			Set<Long> backLogIds = backLog.getStories();
			stories = storyRepository.findAll(backLogIds);
		}
		return stories;
	}

}
