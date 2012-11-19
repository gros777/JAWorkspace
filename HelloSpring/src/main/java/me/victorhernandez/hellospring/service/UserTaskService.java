package me.victorhernandez.hellospring.service;

import java.util.List;

import javax.annotation.Resource;

import me.victorhernandez.hellospring.dao.TaskDao;
import me.victorhernandez.hellospring.dao.UserDao;
import me.victorhernandez.hellospring.domain.Task;
import me.victorhernandez.hellospring.domain.Usuario;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserTaskService {

	@Resource(name="userDao")
	public UserDao userDao;
	@Resource(name="taskDao")
	public TaskDao taskDao;
	
	@Transactional
	public void addNewUser(Usuario usuario) {
		userDao.save(usuario);
	}
	
	@Transactional
	public void addNewTask(Task task){
		taskDao.save(task);
	}
	
	@Transactional
	public void assignTaskToUser(long userId, long taskId) {
		//1.0 obtener los objetos a relacionar.
		Usuario user = userDao.get(userId);
		Task task = taskDao.get(taskId);
		//2. relacionarlos
		user.getTasks().add(task);
		task.getAsignedUser().add(user);
		//3. será que necesito salvar
		userDao.save(user);
		taskDao.save(task);
	}
	
	@Transactional
	public void removeTaskFromUser(long taskId, long userId){
		//1.0 obtener los objetos a relacionar.
		Usuario user = userDao.get(userId);
		Task task = taskDao.get(taskId);
		user.getTasks().remove(task);
		task.getAsignedUser().remove(user);
		userDao.save(user);
		taskDao.save(task);
	}
	
	public List<Usuario> getAllUsers() {
		
		return userDao.getAll();
		
	}
	
	public List<Task> getAllTasks(){
		return taskDao.getAll();
	}
}
