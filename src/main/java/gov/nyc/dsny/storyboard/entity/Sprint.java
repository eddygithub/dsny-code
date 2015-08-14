package gov.nyc.dsny.storyboard.entity;

import java.util.LinkedList;
import java.util.List;

public class Sprint {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Long> getStories() {
		return stories;
	}
	public void setStories(List<Long> stories) {
		this.stories = stories;
	}
	private Long id;
	private List<Long> stories = new LinkedList<Long>();
}
