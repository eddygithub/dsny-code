package gov.nyc.dsny.storyboard.entity;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class Story {
	private Long id;
	private Set<Long> tasks = new LinkedHashSet<Long>();
	private String productName;
	private boolean isGroomed;
	private int priority;
	private LocalDate estimatedCompletionDate;
	private String sprintValue;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public boolean isGroomed() {
		return isGroomed;
	}
	public void setGroomed(boolean isGroomed) {
		this.isGroomed = isGroomed;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public LocalDate getEstimatedCompletionDate() {
		return estimatedCompletionDate;
	}
	public void setEstimatedCompletionDate(LocalDate estimatedCompletionDate) {
		this.estimatedCompletionDate = estimatedCompletionDate;
	}
	public String getSprintValue() {
		return sprintValue;
	}
	public void setSprintValue(String sprintValue) {
		this.sprintValue = sprintValue;
	}
	public Set<Long> getTasks() {
		return tasks;
	}
	public void setTasks(Set<Long> tasks) {
		this.tasks = tasks;
	}
}
