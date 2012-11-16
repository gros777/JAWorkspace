package me.victorhernandez.hellospring.dao.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import me.victorhernandez.hellospring.dao.TaskDao;
import me.victorhernandez.hellospring.domain.Task;
import me.victorhernandez.hellospring.exception.EntityNotFoundException;
@Repository("taskDao")
public class TaskDaoJpa extends GenericDaoJpa<Task> implements TaskDao {

	public TaskDaoJpa(){
		super(Task.class);
	}
	@Override
	public Task getTaskByDescription(String description)
			throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task getTaskByDate(Date date) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
