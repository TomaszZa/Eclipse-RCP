package com.starterkit2.view.model;

import java.util.ArrayList;
import java.util.List;

public class Tasks extends ModelObject{
	private List<Task> actualTasks = new ArrayList<Task>();
	private List<Task> madeTasks = new ArrayList<Task>();
	private Task toEditOrDelete;
	
	public Task getToEditOrDelete(){
		return toEditOrDelete;
	}
	public void setToEditOrDelete(Task toEditOrDelete){
		this.toEditOrDelete = toEditOrDelete;
	}
	
	public List<Task> getActualTasks(){
		return actualTasks;
	}
	public void setActualTasks(List<Task> actualTasks){
		this.actualTasks = actualTasks;
	}
	public void addTaskToActualTasks(Task task){
		actualTasks.add(task);
	}
	public void removeTaskFromActualTasks(Task task){
		actualTasks.remove(task);
	}
	public List<Task> getMadeTasks(){
		return madeTasks;
	}
	public void setMadeTasks(List<Task> madeTasks){
		this.madeTasks = madeTasks;
	}
	public void addTaskToMadeTasks(Task task){
		madeTasks.add(task);
	}
	public void removeTaskFromMadeTasks(Task task){
		madeTasks.remove(task);
	}

}
