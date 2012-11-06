package me.victorhernandez.hellojsf.managedbeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.victorhernandez.hellojsf.dao.ImplUserDao;
import me.victorhernandez.hellojsf.model.Usuario;


@ManagedBean(name="registrar")
@ViewScoped
public class RegisterBean implements Serializable {

	private static final long serialVersionUID = -1168169122241878645L;
	
	private Usuario user;
	
	public Usuario getUser() {
		return user;
	}

	public RegisterBean(){
		user = new Usuario();
	}
	
	public void submit() {
		addUser(user);
        FacesMessage message = new FacesMessage("Registro exitoso!");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	private void addUser(Usuario usuario) {
		// obteniendo el contexto
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"dao-beans.xml");
		// inyectando el usuario
		ImplUserDao userDao = (ImplUserDao) ctx.getBean("implUserDao");
		userDao.addUser(usuario);
		
	}

}
