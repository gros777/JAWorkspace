package me.victorhernandez.hellojsf.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.victorhernandez.hellojsf.dao.ImplUserDao;
import me.victorhernandez.hellojsf.model.Usuario;

@ManagedBean(name = "registrados")
@ViewScoped
public class RegisteredUsersBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5354619065235413950L;

	public List<Usuario> getRegisteredUsers() {
		// obteniendo el contexto
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"dao-beans.xml");
		// inyectando el usuario
		ImplUserDao userDao = (ImplUserDao) ctx.getBean("implUserDao");
		//return userDao.getUsuarios();
		return userDao.getAll();

		
	}

	

}
