package me.victorhernandez.hellojsf.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import me.victorhernandez.hellojsf.model.Usuario;
import me.victorhernandez.hellojsf.util.HibernateUtil;


public class ImplUserDao implements InterfaceUserDao {
	
	private List<Usuario> usuarios;
	

	public ImplUserDao() {
		
	}
	
	public List<Usuario> getUsuarios() {
		if(usuarios == null){
			usuarios = new ArrayList<Usuario>();
		}
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}




	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Usuario> result = session.createQuery("from Usuario").list();
		session.getTransaction().commit();
		return result;
		
	}


	@Override
	public void addUser(Usuario usuario) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Long eventId = (Long) session.save(usuario);
		
		session.getTransaction().commit();
	}

}
