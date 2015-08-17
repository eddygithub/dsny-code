package gov.nyc.dsny.storyboard.entity;

import java.util.LinkedHashSet;
import java.util.Set;

public class Sprint {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Long> getStories() {
		return stories;
	}
	public void setStories(Set<Long> stories) {
		this.stories = stories;
	}
	private Long id;
	private Set<Long> stories = new LinkedHashSet<Long>();
}
