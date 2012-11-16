package me.victorhernandez.hellospring.dao.jpa;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.victorhernandez.hellospring.dao.UserDao;
import me.victorhernandez.hellospring.domain.Task;
import me.victorhernandez.hellospring.domain.Usuario;
import me.victorhernandez.hellospring.exception.AuthenticationException;
import me.victorhernandez.hellospring.exception.EntityNotFoundException;

@Repository("userDao")
public class UserDaoJpa extends GenericDaoJpa<Usuario> implements UserDao {
	/* User domain object fields
	 * private String nombre;
	 * private String direccion;
	 * private String email;
	 * private Date birthdate;
	 * private String password;
	 * private Set<Task> tasks;
	 * private Long id;
	 * private Integer version;
	 */
	public UserDaoJpa() {
		super(Usuario.class);
	}

	@Override
	public Usuario getUsuarioByName(String username)
			throws DataAccessException, EntityNotFoundException {
		List<Usuario> results = null;
		Query query = entityManager
				.createQuery("from Usuario as p where p.nombre = :username");
		query.setParameter("username", username);
		results = query.getResultList();
		if (results == null || results.size() <= 0) {
			throw new EntityNotFoundException(username + " not found");
		} else {
			return results.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario authenticatePerson(String username, String password)
			throws DataAccessException, AuthenticationException {
		List<Usuario> results = null;
		Query query = entityManager
				.createQuery("from Usuario as p where p.nombre = :username and p.password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		results = query.getResultList();
		if (results == null || results.size() <= 0) {
			throw new AuthenticationException("No users found");
		} else {
			return results.get(0);
		}
	}

}
