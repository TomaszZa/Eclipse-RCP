package com.starterkit2.view.model;

public class Task extends ModelObject{
	private String taskName;
	
	public Task(){
	}
	
	public Task(String taskName){
		this.taskName = taskName;
	}
	
	public String getTaskName(){
		return taskName;
	}
	public void setTaskName(String taskName){
		firePropertyChange("taskName", this.taskName, this.taskName = taskName);
	}

}
