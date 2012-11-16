package me.victorhernandez.hellospring.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import me.victorhernandez.hellospring.dao.jpa.UserDaoJpa;
import me.victorhernandez.hellospring.domain.Usuario;

@ManagedBean(name = "registrados")
@ViewScoped
public class RegisteredUsersBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5354619065235413950L;

	public List<Usuario> getRegisteredUsers() {
		
		UserDaoJpa userDao = new UserDaoJpa();
		return userDao.getAll();
		
	}

	

}
