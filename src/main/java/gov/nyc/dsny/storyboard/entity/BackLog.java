package gov.nyc.dsny.storyboard.entity;

import java.util.List;

public class BackLog {
	private Long id;
	private List<Long> stories;

	public List<Long> getStories() {
		return stories;
	}

	public void setStories(List<Long> stories) {
		this.stories = stories;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
