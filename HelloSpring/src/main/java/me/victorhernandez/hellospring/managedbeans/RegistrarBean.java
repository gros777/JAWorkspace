package me.victorhernandez.hellospring.managedbeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import me.victorhernandez.hellospring.dao.jpa.UserDaoJpa;
import me.victorhernandez.hellospring.domain.Usuario;

@ManagedBean(name = "register")
@ViewScoped
public class RegistrarBean implements Serializable {

	private Usuario user;

	
	public RegistrarBean() {
		
		user = new Usuario();
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	private static final long serialVersionUID = -6236373110062737899L;

	public void submit() {
		UserDaoJpa userDao = new UserDaoJpa();
		userDao.save(user);
		FacesMessage message = new FacesMessage("Registro exitoso!");
		FacesContext.getCurrentInstance().addMessage(null, message);
		clearForm();
	}

	private void clearForm() {
		user.setBirthdate(null);
		user.setEmail(null);
		user.setPassword("");
		user.setNombre("");
	}

}
