package me.victorhernandez.hellospring.dao;


import me.victorhernandez.hellospring.domain.Usuario;
import me.victorhernandez.hellospring.exception.AuthenticationException;
import me.victorhernandez.hellospring.exception.EntityNotFoundException;

public interface UserDao extends GenericDao<Usuario> {
	public Usuario getUsuarioByName(String username) throws EntityNotFoundException;

	public Usuario authenticatePerson(String username, String password)
			throws AuthenticationException;
}
