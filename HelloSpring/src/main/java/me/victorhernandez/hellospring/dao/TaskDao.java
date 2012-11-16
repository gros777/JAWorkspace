package me.victorhernandez.hellospring.dao;

import java.util.Date;

import me.victorhernandez.hellospring.domain.Task;
import me.victorhernandez.hellospring.exception.EntityNotFoundException;

public interface TaskDao extends GenericDao<Task>{
	
	public Task getTaskByDescription(String description) throws EntityNotFoundException;
	public Task getTaskByDate(Date date) throws EntityNotFoundException;
}
