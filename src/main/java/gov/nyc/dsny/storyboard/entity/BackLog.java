package gov.nyc.dsny.storyboard.entity;

import java.util.Set;

public class BackLog {
	private Long id;
	private Set<Long> stories;

	public Set<Long> getStories() {
		return stories;
	}

	public void setStories(Set<Long> stories) {
		this.stories = stories;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
